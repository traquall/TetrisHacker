import java.io.IOException;
import java.util.Arrays;

public class Screen {
	private static Tetrimino tetrimino;
	private static int timeCount = 0;
	
	private static String lines;
	public static void main(String[] args) throws InterruptedException, IOException {
		Screen.tetrimino = new Tetrimino();
		while(true) {
			if(timeCount%10 == 0) {
				Screen.tetrimino.toBottom();
			}
			clearConsole();
			refresh();
			System.out.println(lines);
			sleep();
		}
	}
	
	public static void refresh() {
		int brickCount = 0;
		lines += "\t+==========+\n";
		for(int i = 0 ; i < 20 ; i++) {
			for(Brick brick : tetrimino.getBricks()) {
				if(brick.getPosY() == i) {
					for(int j = 0 ; j < 10 ; j++) {
						if(brick.getPosX() == j) {
							lines += brick.getChar();
						}
						else {
							lines += " ";
						}
					}
				}
				else {
					lines += "\t|          |\n";
				}
			}
		}
		lines += "\t+==========+";
	}
	
	private static void clearConsole() throws InterruptedException, IOException {
		lines = "";
		char[] newLines = new char[25];
		Arrays.fill(newLines, '\n');
		System.out.print(String.valueOf(newLines));
	}
	
	private static void sleep() {
		try {
		    Thread.sleep(100);
		    timeCount++;
		} catch(InterruptedException e) {
			e.printStackTrace();
		    Thread.currentThread().interrupt();
		}
	}
}
