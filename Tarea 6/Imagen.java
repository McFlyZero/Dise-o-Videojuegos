import javax.swing.*;
import java.awt.event.*;

public class Imagen extends JLabel implements Runnable {
    ImageIcon icon;
    String url1, url2;
    int speed;
    int posY;
    boolean flag = true;
    boolean flag2 = true;
    int x = speed;
    int limit = 250;

    public Imagen(String url1, String url2, int speed, int posY) {
        this.url1 = url1;
        this.url2 = url2;
        this.speed = speed;
        this.posY = posY;

        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {

        this.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent ke) {
                System.out.println("Entré a keyTyped");
            }

            public void keyPressed(KeyEvent ke) {
                System.out.println("Entré a keyPressed");

                switch (ke.getKeyCode()) {

                    case KeyEvent.VK_RIGHT:
                        System.out.println("Derecha");
                        if (x < limit) {
                            System.out.println("Shift: " + ke.isShiftDown());
                            if (ke.isShiftDown()) {
                                System.out.println("Shift presionado");
                                x = x + 20;
                            }else{
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
                            break;
                        }

                    case KeyEvent.VK_LEFT:
                        if (x > 0) {
                            System.out.println("Izquierda");
                            if (ke.isShiftDown()) {
                                System.out.println("Shift presionado");
                                x = x - 20;
                            }else{
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
                            break;
                        }

                    default:
                        System.out.println("Otra tecla");
                        break;

                }

            }

            public void keyReleased(KeyEvent ke) {
                System.out.println("Entré a keyReleased");
                speed = 1;
            }
        });
    }// end run
}
