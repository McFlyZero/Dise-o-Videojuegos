import javax.swing.*;
import java.awt.event.*;

public class LabelKey extends JLabel implements Runnable {

    int posX = 10;
    public LabelKey(String texto1){
        setText(texto1);
    }

    public void run() {

        System.out.println("Entré a run");

        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent ke) {
                System.out.println("keyTyped");
            }

            public void keyPressed(KeyEvent ke) {

                System.out.println("keyPressed");

                if (ke.getKeyCode() == KeyEvent.VK_RIGHT && posX < 270) {

                    System.out.println("posX: " + posX);
                    posX = posX + 10;
                    setBounds(posX,10, 20, 25);

                }else if (ke.getKeyCode() == KeyEvent.VK_LEFT && posX >= 10){

                    System.out.println("posX: " + posX);
                    posX = posX - 10;
                    setBounds(posX,10, 20, 25);

                }else{
                    System.out.println("No se puede mover");
                }
            }// end of keyPressed

            public void keyReleased(KeyEvent ke){
                System.out.println("keyReleased");
            }
        });// end addKeyListener
    }// end run
}
