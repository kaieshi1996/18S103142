package chess;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game {
	private String gameType;  //游戏类型
	private Board gameBoard;  //游戏棋盘
	private Action gameAction;  //游戏动作
	private Player PlayerA,PlayerB;  //游戏玩家，playerA为先手
	public Game(String name) {
		// TODO Auto-generated constructor stub
		if("go".equals(name)) {
			PlayerA = new Player();
			PlayerB = new Player();
			gameType = "围棋";
			
		}
		else {
			PlayerA = new Player();
			PlayerB = new Player();
			gameType = "国际象棋";
		}
	}
	//通过传入的两个玩家的名字初始化Game中的各类对象。初始化：从gameType_config.txt文件中读取游戏配置，
	//初始化player，添加拥有的棋子，初始化棋盘，设置大小和类型。
	//将gameBoard,playerA,playerB的引用传入Action新建gameAction对象。
	public void iniGameWithPlayerName(String paName,String pbName) {
		PlayerA.setPlayerName(paName);
		PlayerB.setPlayerName(pbName);
		gameBoard = new Board(gameType,PlayerA,PlayerB);
		gameAction = new Action();
		gameAction.setGameBoard(gameBoard);
		gameAction.setPlayerA(PlayerA);
		gameAction.setPlayerB(PlayerB);
		Set<Piece> playerPieces_b = new HashSet<Piece>();
		Set<Piece> playerPieces_w = new HashSet<Piece>();
		Piece p;
		if("围棋".equals(gameType)) {
			for(int i=1;i<=181;i++) {
				p = new Piece(paName+"_"+i, 0);
				playerPieces_b.add(p);
				if(i!=181) {
					p = new Piece(pbName+"_"+i, 0);
					playerPieces_w.add(p);
				}
			}
			
		}else if("国际象棋".equals(gameType)){
			for(int i=1;i<=16;i++) {
				p = new Piece(paName+"_i"+i, 1);
				playerPieces_b.add(p);
				p = new Piece(pbName+"_i"+i, 1);
				playerPieces_w.add(p);
			}
		}
		PlayerA.setPlayerPieces(playerPieces_b);
		PlayerB.setPlayerPieces(playerPieces_w);
		
	}
	
	public void putPiece(Player player,Piece piece,Position position) {  //调用gameAction
		getGameAction().putPiece(player,piece,position);
		
	}
	
	public boolean movePiece (Player player, Position position1,Position position2) {  //调用gameAction
		return getGameAction().move(player,position1,position2);
	}

	public void removePiece (Player player,Position position) {  //调用gameAction
		getGameAction().removePiece(player,position);
	}
	
	public boolean eatPiece (Player player,Position position1,Position position2) {  //调用gameAction
		return getGameAction().eat(player,position1,position2);
	}
	
	public Player getOwnerAtCord(Position pos) {  //获得处于pos位置的棋子的所有者，获得pos位置的棋子piece，然后调用Player.isContainPiece判断属于playerA还是playerB。
		
		return null;
	}
	
	public Piece getPieceAtCord(Position pos) {  //获取处于pos位置的棋子piece，如果没有棋子则返回null。
		return null;
	}
	
	public int getNumOfPlayerPiecesInBoard(Player player) {  //获取用户在棋盘上的所有棋子数目，调用gameBoard. getNumOfPlayerPiecesInBoard
		return getGameAction().getNumOfPlayerPiecesInBoard(player);
	}
	
	public String getGameHistoryString(Player player) {
		// TODO Auto-generated method stub
		
		return getGameAction().getGameHistoryString(player);
	}
	
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public Board getGameBoard() {
		return gameBoard;
	}
	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}
	public Action getGameAction() {
		return gameAction;
	}
	public void setGameAction(Action gameAction) {
		this.gameAction = gameAction;
	}
	public Player getPlayerA() {
		return PlayerA;
	}
	public void setPlayerA(Player playerA) {
		PlayerA = playerA;
	}
	public Player getPlayerB() {
		return PlayerB;
	}
	public void setPlayerB(Player playerB) {
		PlayerB = playerB;
	}
	
	
}

