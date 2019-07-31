package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ActionTest {
	Game game = new Game("chess");
	public ArrayList<Player> players = new ArrayList<Player>();
	@Test
	public void testMove() {
		game.iniGameWithPlayerName("aa","bb");
		players.add(game.getPlayerA());
		players.add(game.getPlayerB());
		boolean result = game.getGameAction().move(game.getPlayerA(), new Position(0,1), new Position(2,2));
		System.out.println(result);
		//fail("Not yet implemented");
	}

	@Test
	public void testEat() {
		game.iniGameWithPlayerName("aa","bb");
		players.add(game.getPlayerA());
		players.add(game.getPlayerB());
		boolean result = game.getGameAction().eat(game.getPlayerA(), new Position(0,1), new Position(2,2));
		System.out.println(result);
		//fail("Not yet implemented");
	}

}
