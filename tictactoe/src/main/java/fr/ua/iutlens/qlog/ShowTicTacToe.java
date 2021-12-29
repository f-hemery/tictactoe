package fr.ua.iutlens.qlog;

public interface ShowTicTacToe {
	void showState(String[][] board);
	int[] getShotCoordonnees(String msg);
	void showMsg(String msg);
}
