/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pebblegame;

/**
 * Represents the players in the Pebble Game.
 * This enum defines the possible players or combinations of players 
 * that can participate in the game. It includes PLAYER1 and PLAYER2 for 
 * individual players, and BOTH_PLAYERS for scenarios where actions or 
 * conditions apply to both players simultaneously.
 * 
 * Usage examples include determining the current player's turn, 
 * assigning scores, or setting game rules specific to one or both players.
 * 
 * @author rakib
 */
public enum Players {
    PLAYER1,       // Represents Player 1 in the game.
    PLAYER2,       // Represents Player 2 in the game.
    BOTH_PLAYERS;  // Represents both players, typically used for joint actions or conditions.
}
