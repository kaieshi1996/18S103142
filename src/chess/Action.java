package chess;

import java.util.Iterator;
public class Action {
	private Board gameBoard;  //游戏中棋盘对象的引用
	private Player PlayerA,PlayerB;  //游戏中玩家对象AB的引用
	public Action() {
		// TODO Auto-generated constructor stub
	}
	public boolean move(Player player, Position position1,Position position2) {  //移动象棋
		String[][] boardSet = getGameBoard().getBoardSet();
		if(position1.getX()==position2.getX()&&position1.getY()==position1.getY()) {
			System.out.println(String.format("前后坐标相同，请重新输入"));
			return false;
		}
		// 判断目标位置的合法性
		if(position2.getX()<0 || position2.getX()>7|| position2.getY()<0||position2.getY()>7) {
			System.out.println(String.format("目标位置超出范围，请重新输入"));
			return false;
		}
		
		if(!boardSet[position2.getX()][position2.getY()].equals("")) {
			System.out.println(String.format("目标位置已被占用，请重新输入"));
			return false;
		}
		// 判断初始位置的合法性
		if(position1.getX()<0 || position1.getX()>7|| position1.getY()<0||position1.getY()>7) {
			System.out.println(String.format("原位置超出范围，请重新输入"));
			return false;
		}
		if(boardSet[position1.getX()][position1.getY()].equals("")) {
			System.out.println(String.format("原位置无棋子，请重新输入"));
			return false;
		}
		String[] originalPiece = boardSet[position1.getX()][position1.getY()].split("_");
		String original = boardSet[position1.getX()][position1.getY()];
		if(!originalPiece[0].equals(player.getPlayerName())) {
			
			System.out.println(String.format("原位置无棋子，请重新输入"));
			return false;
		}
		
		// 如果全部合法，则改变位置
		boardSet[position1.getX()][position1.getY()] = "";
		if(player.getPlayerName().equals(PlayerA.getPlayerName())) {
			
			Iterator<Piece> iterator = getPlayerA().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(original)) {
	            	boardSet[position2.getX()][position2.getY()] = player.getPlayerName() + "_" + originalPiece[1];
	            	getGameBoard().setBoardSet(boardSet);
	            	getPlayerA().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(1);
	            	getPlayerA().getPlayerPieces().add(findpiece);
	            	return true;
	            }
	        }
		}else {
			Iterator<Piece> iterator = getPlayerB().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(original)) {
	            	boardSet[position2.getX()][position2.getY()] = player.getPlayerName() + "_" + originalPiece[1];
	            	getGameBoard().setBoardSet(boardSet);
	            	getPlayerB().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(1);
	            	getPlayerB().getPlayerPieces().add(findpiece);
	            	return true;
	            }
	        }
		}
		return false;
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
	
	public boolean eat(Player player,Position position1,Position position2) {  //象棋吃子,使用用户player的位于棋盘st位置的棋子吃掉到对手的ed位置的棋子。调用edPiece.rmFromBoard，将棋盘ed位置设置为stPiece，将棋盘st位置设置为null，将stPiece坐标设置为ed
		String[][] boardSet = getGameBoard().getBoardSet();
		if(position1.getX()==position2.getX()&&position1.getY()==position1.getY()) {
			System.out.println(String.format("前后坐标相同，请重新输入"));
			return false;
		}
		// 判断目标位置的合法性
		if(position2.getX()<0 || position2.getX()>7|| position2.getY()<0||position2.getY()>7) {
			System.out.println(String.format("目标位置超出范围，请重新输入"));
			return false;
		}
		
		if(boardSet[position2.getX()][position2.getY()].equals("")) {
			System.out.println(String.format("目标位置无棋子，请重新输入"));
			return false;
		}
		// 判断初始位置的合法性
		if(position1.getX()<0 || position1.getX()>7|| position1.getY()<0||position1.getY()>7) {
			System.out.println(String.format("原位置超出范围，请重新输入"));
			return false;
		}
		if(boardSet[position1.getX()][position1.getY()].equals("")) {
			System.out.println(String.format("原位置无棋子，请重新输入"));
			return false;
		}
		
		String[] originalPiece = boardSet[position1.getX()][position1.getY()].split("_");
		String original = boardSet[position1.getX()][position1.getY()];
		String[] targetPiece =  boardSet[position2.getX()][position2.getY()].split("_");
		String target =  boardSet[position2.getX()][position2.getY()];
		if(!originalPiece[0].equals(player.getPlayerName())) {
			System.out.println(String.format("原位置非本方棋子，请重新输入"));
			return false;
		}
		if(targetPiece[0].equals(player.getPlayerName())) {
			System.out.println(String.format("目标位置为本方棋子，请重新输入"));
			return false;
		}
		
		
		// 如果全部合法，则开始吃子
		boardSet[position1.getX()][position1.getY()] = "";
		if(player.getPlayerName().equals(PlayerA.getPlayerName())) {
			Iterator<Piece> iterator = getPlayerB().getPlayerPieces().iterator();  
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(target)) {
	            	boardSet[position2.getX()][position2.getY()] = player.getPlayerName() + "_" + originalPiece[1];
	            	getGameBoard().setBoardSet(boardSet);
	            	getPlayerB().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(2);
	            	getPlayerB().getPlayerPieces().add(findpiece);
	            	return true;
	            }
	        }
		}else {
			Iterator<Piece> iterator = getPlayerA().getPlayerPieces().iterator();
			
	        while (iterator.hasNext()){
	        	Piece findpiece = iterator.next();
	            if(findpiece.getpName().equals(target)) {
	            	boardSet[position2.getX()][position2.getY()] = player.getPlayerName() + "_" + originalPiece[1];
	            	getGameBoard().setBoardSet(boardSet);
	            	getPlayerA().getPlayerPieces().remove(findpiece);
	            	findpiece.setPieceState(2);
	            	getPlayerA().getPlayerPieces().add(findpiece);
	            	return true;
	            }
	        }
		}
		return false;
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

