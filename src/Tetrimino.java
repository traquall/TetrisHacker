import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Tetrimino {
	private char type;
	private List<Brick> bricks = new ArrayList<Brick>();
	
	public Tetrimino(char type) {
		this.type = type;
		
		switch(this.type) {
		case 'I':
			buildI();
		case 'O':
			buildO();
		case 'T':
			buildT();
		case 'L':
			buildL();
		case 'J':
			buildJ();
		case 'Z':
			buildZ();
		case 'S':
			buildS();
		}
	}
	
	public Tetrimino() {
		char[] types = {'I','O','T','L','J','Z','S'};
		this.type = types[randInt(0, 6)];
		
		switch(this.type) {
		case 'I':
			buildI();
		case 'O':
			buildO();
		case 'T':
			buildT();
		case 'L':
			buildL();
		case 'J':
			buildJ();
		case 'Z':
			buildZ();
		case 'S':
			buildS();
		}
		
		for(int i = 0 ; i < this.bricks.size() ; i++) {
			this.bricks.get(i).setPos(this.bricks.get(i).getPosX()+5, this.bricks.get(i).getPosY()+20);
		}
	}
	
	public void toLeft() {
		for(int i = 0 ; i < this.bricks.size() ; i++) {
			this.bricks.get(i).setPos(this.bricks.get(i).getPosX()-1, this.bricks.get(i).getPosY());
		}
	}
	
	public void toRight() {
		for(int i = 0 ; i < this.bricks.size() ; i++) {
			this.bricks.get(i).setPos(this.bricks.get(i).getPosX()+1, this.bricks.get(i).getPosY());
		}
	}
	
	public void toBottom() {
		for(int i = 0 ; i < this.bricks.size() ; i++) {
			this.bricks.get(i).setPos(this.bricks.get(i).getPosX(), this.bricks.get(i).getPosY()+1);
		}
	}
	
	private void addBrick(Brick brick) {
		this.bricks.add(brick);
	}
	
	private void buildI() {
		for(int i = 0 ; i < 4 ; i++) {
			this.addBrick(new Brick(i,0));
		}
	}
	
	private void buildO() {
		for(int i = 0 ; i < 2 ; i++) {
			for(int j = 0 ; j < 2 ; j++) {
				this.addBrick(new Brick(i,j));
			}
		}
	}
	
	private void buildT() {
		for(int i = 0 ; i < 3 ; i++) {
			this.addBrick(new Brick(i, 1));
			if(i == 1) {
				this.addBrick(new Brick(i,0));
			}
		}
	}
	
	private void buildL() {
		for(int i = 0 ; i < 3 ; i++) {
			this.addBrick(new Brick(i, 1));
			if(i == 0) {
				this.addBrick(new Brick(i,0));
			}
		}
	}
	
	private void buildJ() {
		for(int i = 0 ; i < 3 ; i++) {
			this.addBrick(new Brick(i, 1));
			if(i == 2) {
				this.addBrick(new Brick(i,0));
			}
		}
	}
	
	private void buildZ() {
		for(int i = 0 ; i < 3 ; i++) {
			if(i <= 1) {
				this.addBrick(new Brick(i,1));
			}
			if(i >= 1) {
				this.addBrick(new Brick(i,0));
			}
		}
	}
	
	private void buildS() {
		for(int i = 0 ; i < 3 ; i++) {
			if(i <= 1) {
				this.addBrick(new Brick(i,0));
			}
			if(i >= 1) {
				this.addBrick(new Brick(i,1));
			}
		}
	}
	
	public List<Brick> getBricks() {
		return this.bricks;
	}
	
	public int randInt(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
}
