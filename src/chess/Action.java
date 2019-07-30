package chess;

import java.util.Iterator;
public class Action {
	private Board gameBoard;  //游戏中棋盘对象的引用
	private Player PlayerA,PlayerB;  //游戏中玩家对象AB的引用
	public Action() {
		// TODO Auto-generated constructor stub
	}
	private void move() {  //移动象棋
		
	}
	public void putPiece(Player player,Piece piece,Position position) {  //放置围棋
		getGameBoard().getBoardSet()[position.getX()][position.getY()] = piece.getpName();
		if(player.getPlayerName().equals(PlayerA.getPlayerName())) {
			Iterator<Piece> iterator = getPlayerA().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(piece.getpName())) {
	            	getPlayerA().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(1);
	            	getPlayerA().getPlayerPieces().add(findpiece);
	            	getPlayerA().setGameHistorySB(getPlayerA().getGameHistorySB() + String.format("put %s to ( %d , %d )\n", piece.getpName(),position.getX(),position.getY()));
	            	break;
	            }
	        }
		}
		else {
			Iterator<Piece> iterator = getPlayerB().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(piece.getpName())) {
	            	getPlayerB().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(1);
	            	getPlayerB().getPlayerPieces().add(findpiece);
	            	getPlayerB().setGameHistorySB(getPlayerB().getGameHistorySB() + String.format("put %s to ( %d , %d )\n", piece.getpName(),position.getX(),position.getY()));
	            	break;
	            }
	        }
		}
	}
	public void removePiece(Player player,Position position) {  //围棋提子,将用户player的位于棋盘上pos的棋子移出棋盘。调用piece.rmFromBoard，将棋盘上pos位置设置为null
		String pName = getGameBoard().getBoardSet()[position.getX()][position.getY()];
		getGameBoard().getBoardSet()[position.getX()][position.getY()] = "";
		if(player.getPlayerName().equals(PlayerB.getPlayerName())) {
			Iterator<Piece> iterator = getPlayerA().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(pName)) {
	            	getPlayerA().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(2);
	            	getPlayerA().getPlayerPieces().add(findpiece);
	            	getPlayerB().setGameHistorySB(getPlayerB().getGameHistorySB() + String.format("remove %s from ( %d , %d )\n", pName,position.getX(),position.getY()));
	            	break;
	            }
	        }
		}
		else {
			Iterator<Piece> iterator = getPlayerB().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(pName)) {
	            	getPlayerB().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(2);
	            	getPlayerB().getPlayerPieces().add(findpiece);
	            	getPlayerA().setGameHistorySB(getPlayerA().getGameHistorySB() + String.format("remove %s from ( %d , %d )\n", pName,position.getX(),position.getY()));
	            	break;
	            }
	        }
		}
	}
	
	public String getGameHistoryString(Player player) {
		// TODO Auto-generated method stub
		String res = "";
		if(player.getPlayerName().equals(PlayerA.getPlayerName())) {
			res = getPlayerA().getGameHistorySB();
		}
		else {
			res = getPlayerB().getGameHistorySB();
		}
		return res;
	}
	
	public int getNumOfPlayerPiecesInBoard(Player player) {
		int res = 0;
		if(player.getPlayerName().equals(getPlayerA().getPlayerName())) {
			Iterator<Piece> iterator = getPlayerA().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getPieceState() == 1) {
	            	res++;
	            }
	        }
		}
		else {
			Iterator<Piece> iterator = getPlayerB().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getPieceState() == 1) {
	            	res++;
	            }
	        }
		}
		return res;
	}
	
	public void eat() {  //象棋吃子,使用用户player的位于棋盘st位置的棋子吃掉到对手的ed位置的棋子。调用edPiece.rmFromBoard，将棋盘ed位置设置为stPiece，将棋盘st位置设置为null，将stPiece坐标设置为ed
		
	}
	public Board getGameBoard() {
		return gameBoard;
	}
	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
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

