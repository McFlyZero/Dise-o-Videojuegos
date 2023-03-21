import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen extends JLabel implements Runnable, KeyListener {

	private String url1, url2;
	private ImageIcon icon;
	private boolean changeImg = false, runStatus = false, right = false, shift = false, up = false, left = false;
	private int posX = 10, posXBack = 0;
	JLabel background, wall1;

	public Imagen(String url1, String url2) {
		this.url1 = url1;
		this.url2 = url2;
		icon = new ImageIcon(this.getClass().getResource(url1));
		setIcon(icon);
	}

	public void run() {
		runStatus = true;

		while (runStatus) {
			System.out.println("En el while");
			// Si el Mario está chocando con la pared no se mueve de lugar
			if (interseccion()) {
				System.out.println("Chocando");
				posX = this.getX();
				posXBack = background.getX();
				setBounds(posX, 11, 42, 42);
				background.setBounds(posXBack, 0, 510, 72);
			} else {
				if (right && shift) {
					moveImage(10, 40);
				}
				if (right) {
					moveImage(1, 100);
				}
				if (right && up) {
					saltote(40);
				}
				if (up) {
					saltito(20);
				}
				if (left) {
					moveImage(-1, 100);
				}
				if (left && shift) {
					moveImage(-10, 40);
				}
			}
		} // end while
	} // end run

	private boolean interseccion() {
		Area areaWall1 = new Area(wall1.getBounds());
		Area areaMario = new Area(this.getBounds());

		return areaWall1.intersects(areaMario.getBounds2D());
	}

	private void saltito(int time) {
		for (int y = 11; y >= 0; y--) {
			setBounds(getX(), y, 42, 42);
			try {
				Thread.sleep(time);
			} catch (Exception e) {
			}
		}
		for (int y = getY(); y <= 11; y++) {
			setBounds(getX(), y, 42, 42);
			try {
				Thread.sleep(time);
			} catch (Exception e) {
			}
		}
	}

	private void saltote(int time) {
		for (int y = 11; y >= 0; y--) {
			setBounds(posX += 5, y, 42, 42);
			try {
				Thread.sleep(time);
			} catch (Exception e) {
			}
		}
		for (int y = getY(); y <= 11; y++) {
			setBounds(posX += 5, y, 42, 42);
			try {
				Thread.sleep(time);
			} catch (Exception e) {
			}
		}
	}

	private void moveImage(int power, int time) {
		if (changeImg) {
			icon = new ImageIcon(this.getClass().getResource(url1));
			changeImg = false;
		} else {
			icon = new ImageIcon(this.getClass().getResource(url2));
			changeImg = true;
		}

		if (posX >= 120 && posXBack > -220) {
			posXBack -= power;
			background.setBounds(posXBack, 0, 510, 72);
			setBounds(120, 11, 42, 42);
		} else if (posX <= 250) {
			posX += power;
			setBounds(posX, 11, 42, 42);
		}

		setIcon(icon);
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	} // end moveImage

	public void keyTyped(KeyEvent ke) {
	}

	public void keyPressed(KeyEvent ke) {
		if (runStatus) {
			if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = true;
			}
			if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
				shift = true;
			}
			if (ke.getKeyCode() == KeyEvent.VK_UP) {
				up = true;
			}
			if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
				left = true;
			}
		}
	} // end keyPressed

	public void keyReleased(KeyEvent ke) {
		if (runStatus) {
			if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = false;
			}
			if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
				shift = false;
			}
			if (ke.getKeyCode() == KeyEvent.VK_UP) {
				up = false;
			}
			if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
				left = false;
			}
		}
	} // end keyReleased
}