/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.micheladrianomedeiros.guiaallan.model.dao;

import br.com.micheladrianomedeiros.guiaallan.conf.Conexao;
import br.com.micheladrianomedeiros.guiaallan.conf.TratamentoConexao;
import br.com.micheladrianomedeiros.guiaallan.model.PdfDarf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michel
 */
public class PdfDarfDAO {

    Connection con = null;

    public PdfDarfDAO() {
        con = Conexao.conectar();
    }

    public List<PdfDarf> verificarSeArquivoEstaNoBanco(PdfDarf p) {
        List<PdfDarf> pdfsdarf = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pdf_darf` "
                    + "where apuracaoDarf = ? "
                    + "and inscricaoDarf = ? "
                    + "and receitaDarf = ? "
                    + "and valorTotalDarf = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getApuracaoDarf());
            ps.setString(2, p.getInscricaoDarf());
            ps.setString(3, p.getReceitaDarf());
            ps.setString(4, p.getValorTotalDarf());
            ResultSet rs = ps.executeQuery();
            pdfsdarf = correrTabela(rs);
        } catch (SQLException e) {
            System.out.println("Erro loadEmpresas " + e.getMessage());
        }
        return pdfsdarf;
    }

    private List<PdfDarf> correrTabela(ResultSet rs) {
        List<PdfDarf> pdfsdarf = new ArrayList<>();
        try {
            while (rs.next()) {

                int idDarf = rs.getInt("idDarf");
                String apuracaoDarf = rs.getString("apuracaoDarf");
                String inscricaoDarf = rs.getString("inscricaoDarf");
                String receitaDarf = rs.getString("receitaDarf");
                String vencimentoDarf = rs.getString("vencimentoDarf");
                String valorPrincDarf = rs.getString("valorPrincDarf");
                String valorMultaDarf = rs.getString("valorMultaDarf");
                String valorJurosDarf = rs.getString("valorJurosDarf");
                String valorTotalDarf = rs.getString("valorTotalDarf");

                PdfDarf p = new PdfDarf();
                p.setIdDarf(idDarf);
                p.setApuracaoDarf(apuracaoDarf);
                p.setInscricaoDarf(inscricaoDarf);
                p.setReceitaDarf(receitaDarf);
                p.setVencimentoDarf(vencimentoDarf);
                p.setValorPrincDarf(valorPrincDarf);
                p.setValorMultaDarf(valorMultaDarf);
                p.setValorJurosDarf(valorJurosDarf);
                p.setValorTotalDarf(valorTotalDarf);

                pdfsdarf.add(p);

            }
        } catch (SQLException e) {
            System.out.println("Erro correrTabela pdfsdarf " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexaoEResultSet(con, rs);
        }
        return pdfsdarf;
    }//correr_tabela

    public boolean inserirPdfDARF(PdfDarf pdfdarf) {
        boolean itsOK = false;
        try {
            String sql = "insert into Pdf_Darf ( apuracaoDarf, inscricaoDarf, "
                    + "receitaDarf, vencimentoDarf,valorPrincDarf,valorMultaDarf,"
                    + "valorJurosDarf,valorTotalDarf) "
                    + "values (?, ?, ?, ?,?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pdfdarf.getApuracaoDarf());
            ps.setString(2, pdfdarf.getInscricaoDarf());
            ps.setString(3, pdfdarf.getReceitaDarf());
            ps.setString(4, pdfdarf.getVencimentoDarf());
            ps.setString(5, pdfdarf.getValorPrincDarf());
            ps.setString(6, pdfdarf.getValorMultaDarf());
            ps.setString(7, pdfdarf.getValorJurosDarf());
            ps.setString(8, pdfdarf.getValorTotalDarf());
            ps.execute();
            itsOK = true;
        } catch (SQLException e) {
            System.out.println("Erro salvar inserirPdfDARF " + e.getMessage());
        } finally {
            TratamentoConexao.fecharConexao(con);
        }
        return itsOK;
    }
}
