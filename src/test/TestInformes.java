package test;

import java.awt.EventQueue;

import gui.InformesTest;



public class TestInformes {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            try {
                InformesTest frame = new InformesTest();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }



}

