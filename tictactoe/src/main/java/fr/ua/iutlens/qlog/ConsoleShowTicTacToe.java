/**
 * 
 */
package fr.ua.iutlens.qlog;

import java.util.Scanner;

/**
 * @author hemery
 *
 */
public class ConsoleShowTicTacToe implements ShowTicTacToe {
	final String PIECE_HORIZONTALE = "\u254b";
	final String PIECE_VERTICALE = "\u2503";
	final String PIECE_CROIX = "\u2503";
	final String PIECE_CROIX_BORD = "\u2501";
	final String CLEAR_SCREEN = "\u001B[2J";
	final String CLEAR_LINE = "\u001B[2K";
	final String CLEAR_END_LINE = "\u001B[K";
	final String STORE_POSITION = "\u001B[s";
	final String RETURN_POSITION = "\u001B[u";
	final String SANE = "\u001B[0m";

	Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 */
	public ConsoleShowTicTacToe() {
		// TODO Auto-generated constructor stub
	}
	
	public void clearScreen() {
		System.out.print(CLEAR_SCREEN);
		System.out.flush();
	}

	private void avantShow() {
		System.out.print(STORE_POSITION);

		System.out.flush();
	}

	private void apresShow() {
		System.out.print(RETURN_POSITION + SANE);
		System.out.flush();
	}

	@Override
	public void showState(String[][] board) {
		int nbLigs = board.length;
		int nbCols = board[0].length;
		avantShow();
		for (int i = 0; i <= nbCols; i++) {
			System.out.print(PIECE_CROIX_BORD + PIECE_HORIZONTALE);
		}
		System.out.println(PIECE_CROIX_BORD);
		for (int i = 0; i < nbLigs; i++) {
			System.out.print(" ");
			for (int j = 0; j < nbCols; j++) {
				System.out.print(PIECE_CROIX + board[i][j]);
			}
			System.out.println(PIECE_CROIX);
			for (int j = 0; j <= nbCols; j++) {
				System.out.print(PIECE_CROIX_BORD + PIECE_HORIZONTALE);
			}
			System.out.println(PIECE_CROIX_BORD);
		}
	}

	@Override
	public int[] getShotCoordonnees(String msg) {
		int[] coord = new int[2];
		System.out.print(msg + CLEAR_END_LINE);
		coord[0] = scanner.nextInt();
		coord[1] = scanner.nextInt();
		apresShow();
		return coord;
	}

	@Override
	public void showMsg(String msg) {
		System.out.print(msg);
	}

}
