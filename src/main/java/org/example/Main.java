package org.example;

import javax.swing.*;

public class Main extends JPanel{
        public static void main(String[] args){
        JFrame frame = new JFrame("Parchís");
        Game game = new Game();

        frame.add(game);
        frame.setSize(game.WIDTH, game.HEIGHT);

        frame.setLocationRelativeTo(null);                          //Abril la ventana en el medio de la pantalla
        frame.setResizable(false);                                  //No cambiar el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Al cerrar la ventana se acaba el programa
        frame.setVisible(true);
    }
}
