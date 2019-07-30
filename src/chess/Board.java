package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Board {  //棋盘类。提供操作棋盘上棋子的接口
	private int boardSize;  //棋盘大小
	private String[][] boardSet;  //存放落子
	private Player playerA,playerB;  //选手
	private String type;  //棋盘类型
	public Board(String type,Player a,Player b) {
		// TODO Auto-generated constructor stub
		if("围棋".equals(type)) {
			boardSize = 18;
			boardSet = new String[boardSize+1][boardSize+1];
			for(int i=0;i<=boardSize;i++) {
				for(int j=0;j<=boardSize;j++) {
					boardSet[i][j] = "";
				}
			}
			playerA = new Player();
			playerB = new Player();
			playerA = a;
			playerB = b;
		}
		else {
			
		}
	}
	public void putPiece(int px,int py,Piece piece) {  //落子，将棋子piece放置在棋盘的(px,py)位置处
		
	}
	public int getNumOfPlayerPiecesInBoard(Player player) {  //获得player在棋盘中的棋子数目
		return boardSize;
		
	}
	public int getBoardSize() {
		return boardSize;
	}
	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	
	public String[][] getBoardSet() {
		return boardSet;
	}
	public void setBoardSet(String[][] boardSet) {
		this.boardSet = boardSet;
	}
	public Player getPlayerA() {
		return playerA;
	}
	public void setPlayerA(Player playerA) {
		this.playerA = playerA;
	}
	public Player getPlayerB() {
		return playerB;
	}
	public void setPlayerB(Player playerB) {
		this.playerB = playerB;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
