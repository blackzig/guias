/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.micheladrianomedeiros.guiaallan.tools;

import br.com.micheladrianomedeiros.guiaallan.model.PdfDarf;
import br.com.micheladrianomedeiros.guiaallan.model.dao.PdfDarfDAO;
import java.util.List;

/**
 *
 * @author Michel
 */
public class ProcessarPDF {

    public static boolean pdfFile82(List<String> conteudoPDF) {
        /*
        linhas para ler
        Nome da documentação    3
        Apuracao_Darf           30
        Inscricao_Darf          31
        Receita_Darf            32
        Vencimento_Darf         33
        ValorPrinc_Darf         34
        ValorMulta_Darf         35
        ValorJuros_Darf         36
        ValorTotal_Darf         37
         */
        PdfDarf p = new PdfDarf();
        p.setApuracaoDarf(conteudoPDF.get(30));
        p.setInscricaoDarf(conteudoPDF.get(31));
        p.setReceitaDarf(conteudoPDF.get(32));
        p.setVencimentoDarf(conteudoPDF.get(33));
        p.setValorPrincDarf(conteudoPDF.get(34));
        p.setValorMultaDarf(conteudoPDF.get(35));
        p.setValorJurosDarf(conteudoPDF.get(36));
        p.setValorTotalDarf(conteudoPDF.get(37));

        boolean itsOK = verificarSeJaEstaNoBanco(p);

        if (itsOK) {
            PdfDarfDAO dao = new PdfDarfDAO();
            dao.inserirPdfDARF(p);
        } else {
            System.out.println("Já tem.");
        }
        return itsOK;
    }

    public static void pdfFile70(List<String> conteudoPDF) {
        PdfDarf p = new PdfDarf();
        p.setCompararLinha(conteudoPDF.get(12));
        if (p.getCompararLinha().contains("Documento de Arrecadação de Receitas Federais")) {
            System.out.println("tem na linha 12");
            pdfFile70Linha12(conteudoPDF);
        } else {
            p.setCompararLinha(conteudoPDF.get(13));
            System.out.println("tem na linha 13");
            pdfFile70Linha13(conteudoPDF);
        }

    }

    private static boolean verificarSeJaEstaNoBanco(PdfDarf p) {
        boolean itsOK = false;
        PdfDarfDAO dao = new PdfDarfDAO();
        List<PdfDarf> pdfsdarf = dao.verificarSeArquivoEstaNoBanco(p);
        if (pdfsdarf.isEmpty()) {
            itsOK = true;
        }
        return itsOK;
    }

    private static void pdfFile70Linha12(List<String> conteudoPDF) {
//        PdfDarf p = new PdfDarf();
//        p.setApuracaoDarf(conteudoPDF.get(30));
//        p.setInscricaoDarf(conteudoPDF.get(31));
//        p.setReceitaDarf(conteudoPDF.get(32));
//        p.setVencimentoDarf(conteudoPDF.get(33));
//        p.setValorPrincDarf(conteudoPDF.get(34));
//        p.setValorMultaDarf(conteudoPDF.get(35));
//        p.setValorJurosDarf(conteudoPDF.get(36));
//        p.setValorTotalDarf(conteudoPDF.get(37));
//        
//        boolean itsOK = verificarSeJaEstaNoBanco(p);
//
//        if (itsOK) {
//            PdfDarfDAO dao = new PdfDarfDAO();
//            dao.inserirPdfDARF(p);
//        } else {
//            System.out.println("Já tem.");
//        }
    }

    private static void pdfFile70Linha13(List<String> conteudoPDF) {
//        PdfDarf p = new PdfDarf();
//        p.setApuracaoDarf(conteudoPDF.get(30));
//        p.setInscricaoDarf(conteudoPDF.get(31));
//        p.setReceitaDarf(conteudoPDF.get(32));
//        p.setVencimentoDarf(conteudoPDF.get(33));
//        p.setValorPrincDarf(conteudoPDF.get(34));
//        p.setValorMultaDarf(conteudoPDF.get(35));
//        p.setValorJurosDarf(conteudoPDF.get(36));
//        p.setValorTotalDarf(conteudoPDF.get(37));
//        
//        boolean itsOK = verificarSeJaEstaNoBanco(p);
//
//        if (itsOK) {
//            PdfDarfDAO dao = new PdfDarfDAO();
//            dao.inserirPdfDARF(p);
//        } else {
//            System.out.println("Já tem.");
//        }
    }

}
