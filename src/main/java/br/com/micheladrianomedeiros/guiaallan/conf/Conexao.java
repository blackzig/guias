/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.micheladrianomedeiros.guiaallan.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Michel
 */
public class Conexao {

    static Connection con = null;

    public static Connection conectar() {
        try {
            //?useTimezone=true&serverTimezone=UTC
            con = DriverManager.getConnection("jdbc:mysql://localhost/guia", "root", "");
           // con = DriverManager.getConnection("jdbc:mysql://localhost/guia?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }

}
