package chess;

public class Position {  //坐标
	private int x,y;
	public Position(int px,int py) {
		// TODO Auto-generated constructor stub
		x = px;
		y = py;
	}
	public boolean equals(Position a,Position b) {  //判断位置是否相同
		 if(a.getX()==b.getX() && a.getY()==b.getY()) {
			 return true;
		 }
		 else {
			 return false;
		 }
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}
