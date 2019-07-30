/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.micheladrianomedeiros.guiaallan.tools;

import br.com.micheladrianomedeiros.guiaallan.model.PdfDarf;
import static br.com.micheladrianomedeiros.guiaallan.tools.Arquivo.PATHSFOLDERS;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author Michel
 */
public class PDFDARF {

    public static List<PdfDarf> readRows() {
        List<PdfDarf> lista = new ArrayList<>();
        try {
            List<File> listFiles = null;
            for (String pasta : PATHSFOLDERS) {
                listFiles = Arquivo.justPDFFiles(pasta);

                for (File f : listFiles) {
                    PDDocument document = PDDocument.load(f);

                    document.getClass();

                    if (!document.isEncrypted()) {

                        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                        stripper.setSortByPosition(true);

                        PDFTextStripper tStripper = new PDFTextStripper();

                        String pdfFileInText = tStripper.getText(document);
                        //System.out.println("Text:" + st);

                        // split by whitespace
                        String lines[] = pdfFileInText.split("\\r?\\n");
                        int i = 0;
                        List<String> conteudoPDF = new ArrayList<>();
                        System.out.println("---------------" + f.getName() + "--------------------");
                        for (String line : lines) {
                            System.out.println(i + " - " + line);
                            conteudoPDF.add(line);
                            i++;
                        }
                        i--;
                        if (i == 82) {
                            System.out.println("82");
                            boolean itsOK = ProcessarPDF.pdfFile82(conteudoPDF);
                            document.close();
                            if (itsOK) {
                                Arquivo.moveFile(f);
                            }
                        } else if (i == 70) {
                            ProcessarPDF.pdfFile70(conteudoPDF);
                        }
                    }
                    System.out.println("-----------------------------------");
                }
            }
            // Arquivo.moveFile(listFiles);
        } catch (IOException e) {
            System.out.println("ERRO readRows " + e.getMessage());
        }
        return lista;
    }

}
