package chess;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	private Player PlayerA,PlayerB;
	@Test
	public void testGetNumOfPlayerPiecesInBoard() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		System.out.println(gameBoard.getNumOfPlayerPiecesInBoard(PlayerA));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBoardSize() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		System.out.println(gameBoard.getBoardSize());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetBoardSize() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.setBoardSize(20);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetBoardSet() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.getBoardSet();
		//fail("Not yet implemented");
	}

	@Test
	public void testSetBoardSet() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.setBoardSet(new String[][]{{"",""},{"",""}});
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerA() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.getPlayerA();
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPlayerA() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.setPlayerA(new Player());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetPlayerB() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.getPlayerB();
		//fail("Not yet implemented");
	}

	@Test
	public void testSetPlayerB() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.setPlayerB(new Player());
		//fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		System.out.println(gameBoard.getType());
		//fail("Not yet implemented");
	}

	@Test
	public void testSetType() {
		PlayerA = new Player();
		PlayerB = new Player();
		String gameType = "围棋";
		Board gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameBoard.setType("国际象棋");
		//fail("Not yet implemented");
	}

}
