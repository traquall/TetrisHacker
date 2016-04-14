
public class Brick {
	private final char brickChar = 'o';
	private int brickPosX;
	private int brickPosY;
	
	public Brick(int brickPosX, int brickPosY) {
		this.brickPosX = brickPosX;
		this.brickPosY = brickPosY;
	}
	
	public int getPosX() {
		return this.brickPosX;
	}
	
	public int getPosY() {
		return this.brickPosY;
	}
	
	public void setPos(int brickPosX, int brickPosY) {
		this.brickPosX = brickPosX;
		this.brickPosY = brickPosY;
	}
	
	public char getChar() {
		return this.brickChar;
	}
}

