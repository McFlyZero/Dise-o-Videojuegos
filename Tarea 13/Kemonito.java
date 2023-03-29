import javax.swing.*;
import java.awt.event.*;

public class Kemonito extends JLabel implements Runnable, KeyListener {

    private String url1, url2;
    private ImageIcon icon;
    private boolean moveStatus = false, pausar = false, stop = false, runStatus = false, bandera = true;
    Circulo1 c1;

    public Kemonito(String url1, String url2) {
        this.url1 = url1;
        this.url2 = url2;
        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {
        runStatus = true;
        stop = false;
        for (int x = 10; x <= 1000; x += 3) {
            if (moveStatus) {
                icon = new ImageIcon(this.getClass().getResource(url1));
                moveStatus = false;
            } else {
                icon = new ImageIcon(this.getClass().getResource(url2));
                moveStatus = true;
            }
            setIcon(icon);
            setBounds(x, 10, 42, 42);

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }

            try {
                synchronized (this) {
                    while (pausar) {
                        wait();
                    }
                    if (stop) {
                        break;
                    }
                } // end synchronized
            } catch (Exception e) {
            }
            c1.moverCirculo();
            c1.moverLinea();
            c1.repaint();
        } // end for
    }// end run

    synchronized public void pausarHilo() {
        pausar = true;
    }

    synchronized public void reanudarHilo() {
        pausar = false;
        notify();
    }

    synchronized public void stopHilo() {
        stop = true;
        pausar = false;
        notify();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (runStatus) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (bandera) {
                    pausarHilo();
                    bandera = false;
                } else {
                    reanudarHilo();
                    bandera = true;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                stopHilo();
                bandera = true;
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
