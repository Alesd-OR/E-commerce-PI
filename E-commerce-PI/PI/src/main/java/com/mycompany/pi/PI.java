/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pi;

import java.util.Locale;
import validadores.Validadores;
import telaInicial.TelaInicial;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author angelo.bferreira
 */
public class PI extends Validadores {

    public static void main(String[] args) {
        
        
        

        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                .getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(PI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        new TelaInicial().setVisible(true);

    }
}
