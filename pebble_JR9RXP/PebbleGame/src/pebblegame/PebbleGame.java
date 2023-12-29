/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pebblegame;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class PebbleGame {

    private JFrame gameWindow;
    private BoardGUI gameBoardGUI;
    private final int DEFAULT_BOARD_SIZE = 4;

    public PebbleGame() {
        gameWindow = new JFrame("Pebble Game");
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameBoardGUI = new BoardGUI(DEFAULT_BOARD_SIZE);
        gameWindow.getContentPane().add(gameBoardGUI.getPanel(), BorderLayout.CENTER);

        setupMenuBar();

        gameWindow.pack();
        gameWindow.setVisible(true);
    }

    private void setupMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // New Game Menu
        JMenu newGameMenu = new JMenu("New Game");
        int[] boardSizes = new int[]{3, 4, 5};
        for (int boardSize : boardSizes) {
            JMenuItem sizeItem = new JMenuItem(boardSize + "x" + boardSize);
            sizeItem.addActionListener(new BoardSizeActionListener(boardSize));
            newGameMenu.add(sizeItem);
        }
        newGameMenu.addSeparator();
        
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        newGameMenu.add(exitItem);
        menuBar.add(newGameMenu);

        // Game Rules Menu
        JMenu gameRulesMenu = new JMenu("Game Rules");
        JMenuItem showRulesItem = new JMenuItem("Show Rules");
        showRulesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayGameRules();
            }
        });
        gameRulesMenu.add(showRulesItem);
        menuBar.add(gameRulesMenu);

        gameWindow.setJMenuBar(menuBar);
    }

    private void displayGameRules() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("./rules.txt");
                Desktop.getDesktop().open(myFile);
            } catch (IOException e) {
                System.out.println("File Not Found");
            }
        }
    }

    private void updateBoardSize(int boardSize) {
        gameWindow.getContentPane().remove(gameBoardGUI.getPanel());
        gameBoardGUI = new BoardGUI(boardSize);
        gameWindow.getContentPane().add(gameBoardGUI.getPanel(), BorderLayout.CENTER);
        gameBoardGUI.getPanel().requestFocus();
        gameWindow.pack();
    }

    private class BoardSizeActionListener implements ActionListener {
        private final int size;

        public BoardSizeActionListener(int size) {
            this.size = size;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updateBoardSize(size);
        }
    }

    public static void main(String[] args) {
        new PebbleGame();
    }
}
