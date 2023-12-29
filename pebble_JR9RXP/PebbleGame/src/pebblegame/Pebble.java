/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pebblegame;

import java.awt.Color;

/**
 * The `Pebble` class represents a pebble on the game board in the Pebble Game.
 * Each pebble is associated with a player (either Player 1 or Player 2) and has a color.
 * Author: rakib
 */
public class Pebble {
    private final Players player;
    private int positionRow, positionCol;
    private Color pebbleColor;

    /**
     * Constructs a new Pebble instance with the specified row, column, and player.
     *
     * @param row    The row position of the pebble on the game board.
     * @param col    The column position of the pebble on the game board.
     * @param player The player (Player 1 or Player 2) associated with the pebble.
     */
    public Pebble(int row, int col, Players player) {
        this.positionRow = row;
        this.positionCol = col;
        this.player = player;
        determinePebbleColor();
    }

    private void determinePebbleColor() {
        // Sets the color of the pebble based on the associated player.
        if (this.player == Players.PLAYER1) {
            pebbleColor = Color.BLACK;
        } else if (this.player == Players.PLAYER2) {
            pebbleColor = Color.WHITE;
        }
    }

    /**
     * Sets the position (row and column) of the pebble on the game board.
     *
     * @param row The new row position.
     * @param col The new column position.
     */
    public void setPosition(int row, int col) {
        this.positionRow = row;
        this.positionCol = col;
    }

    /**
     * Gets the row position of the pebble on the game board.
     *
     * @return The row position.
     */
    public int getRowPosition() {
        return this.positionRow;
    }

    /**
     * Gets the column position of the pebble on the game board.
     *
     * @return The column position.
     */
    public int getColumnPosition() {
        return this.positionCol;
    }

    /**
     * Gets the player (Player 1 or Player 2) associated with the pebble.
     *
     * @return The player.
     */
    public Players getPlayer() {
        return this.player;
    }

    /**
     * Gets the color of the pebble.
     *
     * @return The color of the pebble.
     */
    public Color getPebbleColor() {
        return this.pebbleColor;
    }
}
