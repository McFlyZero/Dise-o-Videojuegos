import javax.swing.*;
import java.awt.event.*;

public class Imagen extends JLabel implements Runnable, KeyListener {
    ImageIcon icon;
    String url1, url2;
    int speed;
    int posY;
    boolean flag = true;
    boolean flag2 = true;
    int x = speed;
    int limit = 250;
    private boolean runStatus = false, right = false, left = false, shift = false, up = false;

    public Imagen(String url1, String url2, int speed, int posY) {
        this.url1 = url1;
        this.url2 = url2;
        this.speed = speed;
        this.posY = posY;

        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {
        runStatus = true;
        System.out.println("runStatus: " + runStatus);
        while (runStatus) {
            try {
                Thread.sleep(10);
                if (up) {
                    // posY = 40;
                    jump();
                }
                /*
                 * else {
                 * posY = 60;
                 * }
                 */

                if (right) {

                    if (x < limit) {

                        if (shift) {
                            x = x + 20;
                        } else {
                            x = x + 5;
                        }

                        if (flag) {
                            icon = new ImageIcon(this.getClass().getResource(url1));
                        } else {
                            icon = new ImageIcon(this.getClass().getResource(url2));
                        }

                        flag = !flag;
                        setIcon(icon);
                        setBounds(x, posY, 42, 42);
                    }
                }

                if (left) {
                    if (x > 0) {
                        if (shift) {
                            x = x - 20;
                        } else {
                            x = x - 5;
                        }

                        if (flag2) {
                            icon = new ImageIcon(this.getClass().getResource(url1));
                        } else {
                            icon = new ImageIcon(this.getClass().getResource(url2));
                        }

                        flag2 = !flag2;
                        setIcon(icon);
                        setBounds(x, posY, 42, 42);
                    }
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
    }

    private void jump() {
        try {
            System.out.println("Entré a salto");
            for (int i = 0; i < 20; i++) {
                posY = posY - 1;
                setBounds(x, posY, 42, 42);
                Thread.sleep(5);
            }
            for (int i = 0; i < 20; i++) {
                posY = posY + 1;
                setBounds(x, posY, 42, 42);
                Thread.sleep(2);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        System.out.println("Entré a keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (runStatus) {
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                shift = true;
            }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                up = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (runStatus) {
            if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                right = false;
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (ke.getKeyCode() == KeyEvent.VK_SHIFT) {
                shift = false;
            }
            if (ke.getKeyCode() == KeyEvent.VK_UP) {
                up = false;
            }
        }
    }

}
