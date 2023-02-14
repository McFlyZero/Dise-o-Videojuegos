import javax.swing.*;

public class Imagen extends JLabel implements Runnable {
    ImageIcon icon;
    String url1, url2;
    int speed;
    int posY;

    public Imagen(String url1, String url2, int speed, int posY) {
        this.url1 = url1;
        this.url2 = url2;
        this.speed = speed;
        this.posY = posY;

        icon = new ImageIcon(this.getClass().getResource(url1));
        setIcon(icon);
    }

    public void run() {
        boolean flag = true;
        boolean flag2 = true;
        int limit = 250;
        while (true) {
            // Loop para que la imagen se mueva hacia la derecha
            for (int x = 10; x <= limit; x += speed) {

                if (flag) {
                    icon = new ImageIcon(this.getClass().getResource(url1));
                } else {
                    icon = new ImageIcon(this.getClass().getResource(url2));
                }
                flag = !flag;
                setIcon(icon);
                setBounds(x, posY, 42, 42);
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } // end for
            // Loop para que la imagen se mueva hacia la izquierda
            for (int x = limit; x >= 10; x -= speed) {
                if (flag2) {
                    icon = new ImageIcon(this.getClass().getResource(url1));
                } else {
                    icon = new ImageIcon(this.getClass().getResource(url2));
                }
                flag2 = !flag2;
                setIcon(icon);
                setBounds(x, posY, 42, 42);
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } // end for
        }

    }// end run
}
