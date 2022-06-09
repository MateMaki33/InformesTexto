package test;

import java.awt.EventQueue;
import gui.VentanaInformes;


public class TestInformes {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                VentanaInformes frame = new VentanaInformes();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }



}

