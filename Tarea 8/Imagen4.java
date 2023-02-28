import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Imagen4 extends JLabel implements Runnable, KeyListener {

    private String url1, url2;
    private ImageIcon icon;
    JLabel base;
    private int y = 11;

    public Imagen4(String url1, String url2) {
        this.url1 = url1;
        this.url2 = url2;
        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {

        while (true) {
            if (interseccion()) {
                setBounds(getX(), getY(), 42, 42);
            }else{
                gravedad();
            }
        } // end while

    }// end run

    private void gravedad() {
            y++;
            setBounds(10, y, 42, 42);
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
    }// end gravedad

    public boolean interseccion() {
        Area aBase = new Area(base.getBounds());
        Area aMario = new Area(this.getBounds());

        return aBase.intersects(aMario.getBounds2D());
    }

    public void keyTyped(KeyEvent e) {
    }// end keyTyped

    public void keyPressed(KeyEvent e) {
    }// end keyPressed

    public void keyReleased(KeyEvent e) {
    }// end keyReleased
}
