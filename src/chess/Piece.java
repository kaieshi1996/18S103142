package chess;

public class Piece {  //棋子类
	private int pieceState;  //棋子状态，0为未放置，1为已经放置，2为放置之后被拿出棋盘且不可用
	private String pName;  //棋子种类名称
	private int px,py;  //棋子在棋盘中所处的坐标
	public Piece() {
		// TODO Auto-generated constructor stub
	}
	public Piece(String name,int state) {
		// TODO Auto-generated constructor stub
		setpName(name);
		setPieceState(state);
	}
	public void rmFromBoard() {  //将该棋子从棋盘中移出
		
	}
	public int getPieceState() {
		return pieceState;
	}
	public void setPieceState(int pieceState) {
		this.pieceState = pieceState;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
	}
	public int getPy() {
		return py;
	}
	public void setPy(int py) {
		this.py = py;
	}
	
	
}
