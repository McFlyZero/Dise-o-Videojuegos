import javax.swing.*;
import java.awt.event.*;

public class Imagen3 extends JLabel implements Runnable, KeyListener {

    private String url1, url2;
    private ImageIcon icon;
    private boolean runStatus = false, right = false, left = false, shift = false, changeImg = false;
    private int posX = 10;

    public Imagen3(String url1, String url2) {
        this.url1 = url1;
        this.url2 = url2;
        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }// end constructor

    public void run() {
        runStatus = true;

        while(true){
            System.out.println("while");
            if(right && shift){
                moveImage(10,40);
            }
            if(left && shift){

            }
            if(right){
                moveImage(1,100);
            }
            if(left){

            }
        }//end while
    }//end run

    private void moveImage(int power, int time){
        if(changeImg){
            changeImg = false;
            icon = new ImageIcon(this.getClass().getResource(url2));
            setIcon(icon);
        }else{
            changeImg = true;
            icon = new ImageIcon(this.getClass().getResource(url1));
            setIcon(icon);
        }

        setIcon(icon);
        posX += power;
        setBounds(posX,11,42,42);
        try { Thread.sleep(time);} catch(Exception e){}
    }

    public void keyTyped(KeyEvent e) {
    }// end keyTyped

    public void keyPressed(KeyEvent e) {
        if (runStatus) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    System.out.println("right");
                    right = true;
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    left = true;
                    break;
            }
        }
    }// end keyPressed

    public void keyReleased(KeyEvent e) {
        if (runStatus) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_RIGHT:
                    System.out.println("right");
                    right = false;
                    break;
                case KeyEvent.VK_LEFT:
                    System.out.println("left");
                    left = false;
                    break;
            }
        }
    }// end keyReleased
}
