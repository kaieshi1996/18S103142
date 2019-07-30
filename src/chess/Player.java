package chess;

import java.util.Set;
import java.util.function.Predicate;

public class Player {  //玩家类，注意一个玩家所拥有的棋子中包含许多相同类型名称的棋子
	private String playerName;  //玩家名称
	private String gameHistorySB = "";  //玩家操作历史
	private Set<Piece> playerPieces;  //玩家所拥有的所有棋子
	public Player() {
		// TODO Auto-generated constructor stub
		
	}
	public void addPiece(Piece p) {  //玩家添加棋子
		
	}
	
	public Piece getPieceAtCord(Position pos) {  //获取处于pos位置的棋子piece，如果没有棋子则返回null
		return null;
		
	}
	
	public Boolean isContainPiece(Piece p) {  //判断该玩家是否包含指定棋子
		return null;
	}
	
	public int getNumOfPlayerPiecesInBoard(Player player) {  //获取用户在棋盘上的所有棋子数目，调用gameBoard. getNumOfPlayerPiecesInBoard
		return 0;
		
	}
	
	public Piece getAnyPieceByFilter(Predicate<Piece> predicate) {
		return null;
		
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getGameHistorySB() {
		return gameHistorySB;
	}

	public void setGameHistorySB(String gameHistorySB) {
		this.gameHistorySB = gameHistorySB;
	}

	public Set<Piece> getPlayerPieces() {
		return playerPieces;
	}

	public void setPlayerPieces(Set<Piece> playerPieces) {
		this.playerPieces = playerPieces;
	}
	
	
}