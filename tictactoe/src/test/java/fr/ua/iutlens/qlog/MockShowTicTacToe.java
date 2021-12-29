package fr.ua.iutlens.qlog;

public class MockShowTicTacToe implements ShowTicTacToe {

	public MockShowTicTacToe() {
		System.out.println("toto");
	}

	@Override
	public void showState(String[][] board) {
		System.out.println("toto");

	}

	@Override
	public int[] getShotCoordonnees(String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showMsg(String msg) {
		// TODO Auto-generated method stub
	}

}
