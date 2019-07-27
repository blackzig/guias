/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.micheladrianomedeiros.guiaallan;

import br.com.micheladrianomedeiros.guiaallan.tools.Arquivo;
import br.com.micheladrianomedeiros.guiaallan.tools.PDFDARF;
import br.com.micheladrianomedeiros.guiaallan.view.PrincipalView;

/**
 *
 * @author zigui
 */
public class Start {

    public static void main(String[] args) {
        PrincipalView pv = new PrincipalView();
        pv.setVisible(true);
        Arquivo.createFolder();
       // PDFDARF.readRows();
    }

}
