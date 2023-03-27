import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen4 extends JLabel implements Runnable, KeyListener {

    private String url1, url2;
    private int posX = 10, posXBack = 0, y = 14, xblocks = 70;
    private ImageIcon icon;
    private boolean changeImg = false, runStatus = false, right = false, shift = false, up = false;
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

            if (right && shift) {
                moveImage(6, 20);
            } else if (right) {
                moveImage(2, 50);
            }
            if (right && up) {
                saltote(3, 20);
            } else if (up) {
                saltito(20);
            }
            if (interseccion()) {
                System.out.println("Colision");
                break;
            }
        } // end while
    }// end run

    private boolean interseccion() {
        Area areaWall1 = new Area(wall1.getBounds());
        Area areaMario = new Area(getBounds());
        boolean collide = areaWall1.intersects(areaMario.getBounds2D());

        return collide;
    }

    private void saltito(int time) {
        for (y = 14; y >= -7; y--) {
            moveImage(1, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end for UP
        for (y = getY(); y <= 14; y++) {
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
        for (y = 14; y >= -7; y -= power) {
            // posX+=power;
            moveImage(power + 3, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end UP
        for (y = getY(); y <= 14; y += power) {
            // posX+=power;
            moveImage(power, time);
            setBounds(posX, y, 32, 39);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
            }
        } // end DOWN
        changeImage(time);
    }// end saltote

    // Para cambiar la imagen del Mario
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
    }// end changeImage

    private void moveImage(int power, int time) {
        if (posX >= 120 && right) {
            System.out.println("Entré");
            if (posXBack >= -210) {
                System.out.println("Entré al posXBack");
                if (xblocks < -16) {
                    // Bloque
                    System.out.println("Bloque");
                    xblocks += 300;
                } else {
                    xblocks -= power;
                }
                posXBack -= power;
                background.setBounds(posXBack, 0, 510, 72);
                int backgroundDiff = posXBack - background.getX();
                wall1.setBounds(xblocks + backgroundDiff, 33, 30, 35);
                setBounds(posX, y, 32, 39);
            }else{
                posX += power;
                setBounds(posX, y, 32, 39);
            }
        } else if (posX <= 120 && right) {
            System.out.println("posX:" + posX + " posXBack:" + posXBack);
            posX += power;
            setBounds(posX, y, 32, 39);
        }

        try {
            Thread.sleep(time);
        } catch (Exception e) {
        }
        changeImage(time);
    }// end moveImage

    public void keyTyped(KeyEvent e) {
    }// end keyTyped

    public void keyPressed(KeyEvent e) {
        if (runStatus) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                shift = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                up = true;
            }
        }
    }// end keyPressed

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            shift = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        }
    }// end keyReleased
}