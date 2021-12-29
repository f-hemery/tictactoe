package fr.ua.iutlens.qlog;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		 * ConsoleShowTicTacToe console = new ConsoleShowTicTacToe(); String[][] board =
		 * new String[3][3]; for (int i = 0; i < 3; i++) Arrays.fill(board[i], " ");
		 * console.clearScreen(); console.showMsg("Tic Tac Toe\n"); while (true) {
		 * console.showState(board); int[] coord =
		 * console.getShotCoordonnees("Coordonnées : "); board[coord[0]][coord[1]] =
		 * "X"; }
		 */	
		
		String depart = "XOX\nXOX\nXOX\n";
		
		Tictactoe jeu = new Tictactoe(depart);
		jeu.play();
	}

}
