package fr.ua.iutlens.qlog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TictactoeTest {

	@Test
	void testCreateGame() {
		Tictactoe game = new Tictactoe(3, 3);
		assertThat(game).isInstanceOf(Tictactoe.class);
		assertThat(game.getNbLibres()).isEqualTo(9);
		assertThat(game.getNbColonnes()).isEqualTo(3);
		assertThat(game.getNbLignes()).isEqualTo(3);
	}

	@Test
	void testCreateGameAvecDonnees() {
		String depart = "XOO\nX O\nXOO\n";

		Tictactoe game = new Tictactoe(depart);
		assertThat(game).isInstanceOf(Tictactoe.class);
		assertThat(game.getNbLibres()).isEqualTo(1);
		assertThat(game.getNbColonnes()).isEqualTo(3);
		assertThat(game.getNbLignes()).isEqualTo(3);
	}

	@Test
	void testCreateGameAvecDonneesErreurs() {
		String depart = "XOO\nX OO\nXOO\n";

		assertThatThrownBy(() -> {
			new Tictactoe(depart);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void testFinDepartie() {
		String depart = "XOO\nXXX\nXOO\n";
		Tictactoe game = new Tictactoe(depart);
		assertThat(game.finished()).isEqualTo(true);
		depart = "XOO\nO  \nXOO\n";
		game = new Tictactoe(depart);
		assertThat(game.finished()).isEqualTo(false);
	}

	@Test
	void testLigneComplete() {
		String depart = "XOO\nXXX\nXOO\n";
		Tictactoe game = new Tictactoe(depart);
		assertThat(game.aLineCompleted()).isEqualTo(true);
		depart = "XOO\nX O\nXOO\n";
		game = new Tictactoe(depart);
		assertThat(game.aLineCompleted()).isEqualTo(false);
		depart = "OOO\nX O\nXOO\n";
		game = new Tictactoe(depart);
		assertThat(game.aLineCompleted()).isEqualTo(true);
		depart = "OOOO\nX OX\nXOOX\n";
		game = new Tictactoe(depart);
		assertThat(game.aLineCompleted()).isEqualTo(true);
	}

	@Test
	void testColonneComplete() {
		String depart = "XOO\nXXO\nXOO\n";
		Tictactoe game = new Tictactoe(depart);
		assertThat(game.aColumnCompleted()).isEqualTo(true);
		depart = "XOO\nX X\nOOO\n";
		game = new Tictactoe(depart);
		assertThat(game.aColumnCompleted()).isEqualTo(false);
		depart = "O  \nO  \nOOO\n";
		game = new Tictactoe(depart);
		assertThat(game.aColumnCompleted()).isEqualTo(true);
		depart = "O  \nO  \nOOO\nOOO\n";
		game = new Tictactoe(depart);
		assertThat(game.aColumnCompleted()).isEqualTo(true);
		depart = "O  \nO  \nOOO\nXOX\n";
		game = new Tictactoe(depart);
		assertThat(game.aColumnCompleted()).isEqualTo(false);
	}

	@Test
	void testDiagonaleComplete() {
		String depart = "XOO\nOXO\nOOX\n";
		Tictactoe game = new Tictactoe(depart);
		assertThat(game.firstDiagonalCompleted()).isEqualTo(true);
		depart = " OO\nX X\nOO \n";
		game = new Tictactoe(depart);
		assertThat(game.firstDiagonalCompleted()).isEqualTo(false);
		depart = "XOO\nOXO\nOOX\nXXX\n";
		game = new Tictactoe(depart);
		assertThat(game.firstDiagonalCompleted()).isEqualTo(false);
	}

	@Test
	void testDiagonaleInverseComplete() {
		String depart = "OOX\nOXO\nXOO\n";
		Tictactoe game = new Tictactoe(depart);
		assertThat(game.secondDiagCompleted()).isEqualTo(true);
		depart = " OO\nX X\nOO \n";
		game = new Tictactoe(depart);
		assertThat(game.secondDiagCompleted()).isEqualTo(false);
		depart = "OOX\nOXO\nXOO\nXXX\n";
		game = new Tictactoe(depart);
		assertThat(game.secondDiagCompleted()).isEqualTo(false);
	}
	
	@Test
	void testOneShot() {
		Tictactoe game = new Tictactoe(3, 3);

	}

}
