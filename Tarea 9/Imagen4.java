import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen4 extends JLabel implements Runnable, KeyListener {

    private String url1, url2;
    private ImageIcon icon;
    private int y = 14, posX = 10, posXBack = 0, xblocks = 70;
    private boolean runStatus = false, right = false, up = false, changeImg = false;
    JLabel background, wall1;

    public Imagen4(String url1, String url2) {
        this.url1 = url1;
        this.url2 = url2;
        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {
        runStatus = true;
        while (true) {
            if (right) {
                moveImagen(5, 50);
            }
            if (right && up) {
                saltote(9, 50);
            }
            if (up) {
                saltito(20);
            }
            if (interseccion()) {
                break;
            }
        } // end while
    }// end run

    private void saltito(int time) {
        for (y = 174; y >= 150; y--) {
            moveImage(1, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end for UP
        for (y = getY(); y <= 173; y++) {
            moveImage(0, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end for DOWN
        changeImage(time);
    }

    private void saltote(int power, int time) {
        for (y = 174; y >= 150; y -= power) {
            // posX+=power;
            moveImage(power, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end UP
        for (y = getY(); y <= 173; y += power) {
            // posX+=power;
            moveImage(power, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        }
        // changeImage(time);
    }// end saltote

    private void changeImage(int time) {
        if (changeImg) {
            icon = new ImageIcon(this.getClass().getResource(url1));
            changeImg = false;
        } else {
            icon = new ImageIcon(this.getClass().getResource(url2));
            changeImg = true;
        }
        setIcon(icon);
        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
    }// end moveImage

    private void moveImage(int power, int time) {
        if (posX >= 120 && posXBack >= -3540 && right) {
            if (xblocks < -16) {
                xblocks += 300;
            } else {
                xblocks -= power;
            } // Hace reaparecer el bloque en cuanto sale de pantalla
            posXBack -= power;
            background.setBounds(posXBack, -817, 3840, 1080);
            wall1.setBounds(xblocks, 204, 16, 12);
            setBounds(posX, y, 32, 39);
        } else if (posX <= 263 && right) {
            posX += power;
            setBounds(posX, y, 32, 39);
        }
    }// end moveImage

    private void moveImagen(int power, int time) {
        if (changeImg) {
            icon = new ImageIcon(this.getClass().getResource(url1));
            changeImg = false;
        } else {
            icon = new ImageIcon(this.getClass().getResource(url2));
            changeImg = true;
        }
        posX += power;
        setIcon(icon);
        setBounds(posX, y, 42, 42);
        try {
            Thread.sleep(time);
        } catch (Exception ex) {
        }
    }

    public boolean interseccion() {
        Area areaWall1 = new Area(wall1.getBounds());
        Area areaMario = new Area(getBounds());
        boolean collide = areaWall1.intersects(areaMario.getBounds2D());
        return collide;
    }

    /*
     * private void saltito(int time) {
     * for (int y = 14; y >= 0; y--) {
     * setBounds(getX(), y, 42, 42);
     * try {
     * Thread.sleep(time);
     * } catch (Exception e) {
     * }
     * }
     * for (int y = getY(); y <= 14; y++) {
     * setBounds(getX(), y, 42, 42);
     * try {
     * Thread.sleep(time);
     * } catch (Exception e) {
     * }
     * }
     * }
     * 
     * private void saltote(int time) {
     * for (int y = 14; y >= 0; y--) {
     * setBounds(posX += 5, y, 42, 42);
     * try {
     * Thread.sleep(time);
     * } catch (Exception e) {
     * }
     * }
     * for (int y = getY(); y <= 14; y++) {
     * setBounds(posX += 5, y, 42, 42);
     * try {
     * Thread.sleep(time);
     * } catch (Exception e) {
     * }
     * }
     * }
     */
    public void keyTyped(KeyEvent e) {
    }// end keyTyped

    public void keyPressed(KeyEvent e) {
        if (runStatus) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = true;
            }
        }
    }// end keyPressed

    public void keyReleased(KeyEvent e) {
        if (runStatus) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = false;
            }
        }
    }// end keyReleased
}
