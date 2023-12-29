/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pebblegame;

import java.util.ArrayList;
import java.util.Collections;
import static pebblegame.Directions.EAST;
import static pebblegame.Directions.NORTH;
import static pebblegame.Directions.SOUTH;
import static pebblegame.Directions.WEST;

/**
 * The `PebbleBoard` class represents the game board in the Pebble Game.
 * It manages the game state, including the positions of pebbles and player turns.
 */
public class PebbleBoard {
    private int currentPlayerCounter;
    private Players currentPlayer = Players.PLAYER1;
    private final int boardSize;
    private final ArrayList<Pebble> pebblesList;
    private Pebble selectedPebble;

    /**
     * Constructs a new `PebbleBoard` instance with the specified board length.
     *
     * @param length The length of the game board.
     */
    public PebbleBoard(int length) {
        this.boardSize = length;
        this.currentPlayerCounter = 0;
        pebblesList = new ArrayList<>();

        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i == 0) {
                    pebblesList.add(new Pebble(j, i, Players.PLAYER1));
                } else if (i == boardSize - 1) {
                    pebblesList.add(new Pebble(j, i, Players.PLAYER2));
                } else {
                    pebblesList.add(null);
                }
            }
        }
        Collections.shuffle(pebblesList);
    }

    public void shiftPebbles(Directions dir) {
        if (selectedPebble == null) {
            return;
        }

        int row = selectedPebble.getRowPosition();
        int col = selectedPebble.getColumnPosition();
        pebblesList.set(col + row * boardSize, null);

        while (true) {
            int newRow = row;
            int newCol = col;

            switch (dir) {
                case NORTH:
                    newRow--;
                    break;
                case SOUTH:
                    newRow++;
                    break;
                case EAST:
                    newCol++;
                    break;
                case WEST:
                    newCol--;
                    break;
                default:
                    break;
            }

            if (isValidMove(newRow, newCol)) {
                Pebble tempPebble = getPebble(newRow, newCol);
                selectedPebble.setPosition(newRow, newCol);
                pebblesList.set(newCol + newRow * boardSize, selectedPebble);
                selectedPebble = tempPebble;
                row = newRow;
                col = newCol;
            } else {
                break;
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize && selectedPebble != null;
    }

    public void nextTurn() {
        currentPlayer = (currentPlayer == Players.PLAYER1) ? Players.PLAYER2 : Players.PLAYER1;
        currentPlayerCounter++;
    }

    public Players findWinner() {
        if (currentPlayerCounter >= boardSize * 5) {
            int p1Count = 0;
            int p2Count = 0;

            for (Pebble pebble : pebblesList) {
                if (pebble != null) {
                    if (pebble.getPlayer() == Players.PLAYER1) {
                        p1Count++;
                    } else if (pebble.getPlayer() == Players.PLAYER2) {
                        p2Count++;
                    }
                }
            }

            if (p1Count > p2Count) {
                return Players.PLAYER1;
            } else if (p1Count < p2Count) {
                return Players.PLAYER2;
            } else {
                return Players.BOTH_PLAYERS;
            }
        } else if (currentPlayerCounter < boardSize * 5) {
            int p1Count = 0;
            int p2Count = 0;

            for (Pebble pebble : pebblesList) {
                if (pebble != null) {
                    if (pebble.getPlayer() == Players.PLAYER1) {
                        p1Count++;
                    } else if (pebble.getPlayer() == Players.PLAYER2) {
                        p2Count++;
                    }
                }
            }

            if (p1Count == 0 && p2Count > 0) {
                return Players.PLAYER2;
            } else if (p2Count == 0 && p1Count > 0) {
                return Players.PLAYER1;
            }
        }
        return null;
    }

    public Players getCurrentPlayer() {
        return currentPlayer;
    }

    public Pebble getPebble(int row, int col) {
        return pebblesList.get(col + row * boardSize);
    }

    public Pebble getSelectedPebble() {
        return selectedPebble;
    }

    public void setSelectedPebble(Pebble pebble) {
        selectedPebble = pebble;
    }
}
