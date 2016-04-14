import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			try {
			    Thread.sleep(100);
			    timeCount++;
			} catch(InterruptedException e) {
				e.printStackTrace();
			    Thread.currentThread().interrupt();
			}
		}
	}
	
	public static void refresh() {
		Map <Integer, String> yBricks = new HashMap<Integer, String>();
		Map <Integer, String> xBricks = new HashMap<Integer, String>();
		
		for(Brick brick : tetrimino.getBricks()) {
			yBricks.put(brick.getPosY(), brick.getChar());
			xBricks.put(brick.getPosX(), brick.getChar());
		}
		
		lines += "\t+==========+\n";
		for(int i = 0 ; i < 20 ; i++) {
			if(yBricks.get(i) == null) {
				lines += "\t|          |\n";
			}
			else {
				lines += "\t|";
				for(int j = 0 ; j < 10 ; j++) {
					if(xBricks.get(j) == null) {
						lines += " ";
					}
					else {
						lines += xBricks.get(j);
					}
				}
				lines += "|\n";
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
}
