import javax.swing.*;
import java.awt.event.*;

public class Background extends JLabel implements Runnable, KeyListener{
    private ImageIcon icon;
    private JLabel avatar;
    private int PosX, PosXAvatar;
    boolean runStatus = false, right = false, left = false, move = true;

    public Background(String url, JLabel avatar){
        this.avatar = avatar;        
        icon = new ImageIcon(this.getClass().getResource(url));
        setIcon(icon);
    }

    
    public void run() {
        try {
            runStatus = true;
            while(runStatus){                
                Thread.sleep(30);                
                if (right) {
                    System.out.println("Entré a right de bg");
                    Avanzar_BG(5);
                }else if (left) {
                    Retroceder_BG(5);
                } 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }        
    }
    public void Avanzar_BG(int move){     
        System.out.println("Entré a avanzar");   
        PosXAvatar = avatar.getX();
        System.out.println("PosXAvatar: "+ PosXAvatar);
            if ( PosXAvatar > 250) {
                PosX = PosX - move;
                setBounds(PosX,-817,3840,1080);
            }
    }
    public void Retroceder_BG(int move){     
        System.out.println("Entré a retroceder");   
        PosXAvatar = avatar.getX();
        System.out.println("PosXAvatar: "+ PosXAvatar);
            if ( PosXAvatar <= 10) {
                PosX = PosX + move;
                setBounds(PosX,-817,3840,1080);
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
                System.out.println("Background derecha");
                right = true;
            }
            if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                System.out.println("Background izquierda6");
                left = true;
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
        }
    }
}