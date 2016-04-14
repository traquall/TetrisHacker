
public class Brick {
	private final String brickChar = "o";
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
	
	public String getChar() {
		return this.brickChar;
	}
}

