import javax.swing.*;
import java.awt.event.*;

public class LabelKey extends JLabel implements Runnable {

    //JLabel texto1;
    //JFrame jframe1;
    int posX = 112;
    public LabelKey(String texto1){
        setText(texto1);
    }

    public void run() {

        System.out.println("Entré a run");
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent ke) {System.out.println("Entré a keyTyped");
            }

            public void keyPressed(KeyEvent ke) {

                System.out.println("Entré a keyPressed");

                //int jfancho = jframe1.getWidth();
                //int txt1posicion = texto1.getX();
                //int txt1ancho = texto1.getWidth();
                if (ke.getKeyCode() == KeyEvent.VK_RIGHT && posX<= 670){
                    // txt1posicion > 0 + txt1ancho
                    
                    //txt1posicion = txt1posicion + 10;
                    posX = posX + 10;
                    setBounds(posX,200, 50, 25);
                    //texto1.setLocation(txt1posicion, texto1.getY());
                }else if (ke.getKeyCode() == KeyEvent.VK_LEFT && posX>= 10){
                    //txt1posicion < jfancho - txt1ancho
                    posX = posX - 10;
                    setBounds(posX,200, 50, 25);
                    //texto1.setLocation(txt1posicion, texto1.getY());
                };
            }// end of keyPressed

            public void keyReleased(KeyEvent ke){System.out.println("Entré a keyReleased");
            }
        });// end addKeyListener
    }// end run
}
