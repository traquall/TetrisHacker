import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.*;
import java.awt.event.*;

public class Screen extends java.applet.Applet implements KeyListener {
	private static Tetrimino tetrimino;
	private static int timeCount = 0;
        
        private static int boardX = 10;
        private static int boardY = 20;	
        private static int currentX;
        private static int currentY;
        
	private static String lines;
	public static void main(String[] args) throws InterruptedException, IOException {
		Screen.tetrimino = new Tetrimino();
                currentX = boardX / 2 + 1;
                currentY = boardY - 1;
                
		while(true) {
			if(timeCount%10 == 0) {
                                // il faudrais implenter une méthode 'tryMove' pour vérifier qu'on puisse bien déplacer le tetrimino  dans un sens ou dans l'autre mais faudrais l'ajouter dans la classe tetriminos et qu'elle ai accès à la taille de la map ..
				Screen.tetrimino.toBottom();
			}
			clearConsole();
			refresh();
			System.out.println(lines);
			try {
                            tetrimino.toBottom();
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

    @Override
    public void keyTyped(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                    tetrimino.rotateLeft();
                break;
            case KeyEvent.VK_DOWN:
                    tetrimino.rotateRight();
                break;
            case KeyEvent.VK_LEFT:
                    tetrimino.toLeft();
                break;
            case KeyEvent.VK_RIGHT :
                    tetrimino.toRight();
                break;
            case KeyEvent.VK_SPACE :
                    tetrimino.toBottom();
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
