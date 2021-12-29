package fr.ua.iutlens.qlog;

import java.util.Arrays;

public class Tictactoe {
	final String CROIX = "X";
	final String ROND = "O";

	private String[][] board;

	private ShowTicTacToe console;

	private int nbLignes;
	private int nbColonnes;

	private int nbLibres;

	public Tictactoe(String strBoard) {
		String[] rows = strBoard.split(System.lineSeparator());
		nbLignes = rows.length;
		nbColonnes = rows[0].length();
		board = new String[nbLignes][nbColonnes];
		nbLibres = nbLignes * nbColonnes;
		char car;
		for (int y = 0; y < nbLignes; y++) {
			if (rows[y].length() != nbColonnes) {
				throw new IllegalArgumentException("Incorrect textual board game");
			}
			for (int x = 0; x < nbColonnes; x++) {
				car = rows[y].charAt(x);
				if (car != ' ') {
					board[y][x] = Character.toString(car);
					nbLibres--;
				} else {
					board[y][x] = " ";
				}
			}
		}
		console = new ConsoleShowTicTacToe();
	}

	public Tictactoe(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		board = new String[nbLignes][nbColonnes];
		nbLibres = nbLignes * nbColonnes;
		for (int i = 0; i < nbLignes; i++)
			Arrays.fill(board[i], " ");
		console = new ConsoleShowTicTacToe();
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public int getNbLibres() {
		return nbLibres;
	}


	public boolean aLineCompleted() {
		for (String s : new String[] { CROIX, ROND }) {
			for (int i = 0; i < getNbLignes(); i++) {
				int cpt = 0;
				for (int j = 0; j < getNbColonnes(); j++) {
					if (!s.equals(board[i][j]))
						break;
					cpt++;
				}
				if (cpt == getNbColonnes())
					return true;
			}
		}
		return false;
	}

	public boolean aColumnCompleted() {
		for (String s : new String[] { CROIX, ROND }) {
			for (int i = 0; i < getNbColonnes(); i++) {
				int cpt = 0;
				for (int j = 0; j < getNbLignes(); j++) {
					if (!s.equals(board[j][i]))
						break;
					cpt++;
				}
				if (cpt == getNbLignes())
					return true;
			}
		}
		return false;
	}

	public boolean firstDiagonalCompleted() {
		if (getNbLignes() != getNbColonnes())
			return false;
		for (String s : new String[] { CROIX, ROND }) {
			int cpt = 0;
			for (int i = 0; i < getNbLignes(); i++) {
				if (!s.equals(board[i][i]))
					break;
				cpt++;
			}
			if (cpt == getNbLignes())
				return true;
		}
		return false;
	}

	public boolean secondDiagCompleted() {
		if (getNbLignes() != getNbColonnes())
			return false;
		for (String s : new String[] { CROIX, ROND }) {
			int cpt = 0;
			for (int i = getNbColonnes() - 1; i >= 0; i--) {
				if (!s.equals(board[getNbLignes() - 1 - i][i]))
					break;
				cpt++;
			}
			if (cpt == getNbColonnes())
				return true;
		}
		return false;
	}

	private boolean full() {
		return nbLibres == 0;
	}

	public boolean finished() {
		return full() || aLineCompleted() || aColumnCompleted() || firstDiagonalCompleted() || secondDiagCompleted();
	}

	public void play() {
		console.showMsg("Tic Tac Toe\n");
		boolean joueur = false;
		while (!finished()) {
			console.showState(board);
			int[] coord = console.getShotCoordonnees("Coordonnées : ");
			if (" ".equals(board[coord[0]][coord[1]])) {
				if (joueur)
					board[coord[0]][coord[1]] = ROND;
				else
					board[coord[0]][coord[1]] = CROIX;
				joueur = !joueur;
			}
		}
	}

}
