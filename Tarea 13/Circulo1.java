import java.awt.*;
import javax.swing.*;

public class Circulo1 extends JPanel {
    private int x = 0, y = 0, xCentro = 50, yCentro = 50, x2 = 110, y2 = 50;

    private double angulo = Math.toRadians(0);
    private int radio = 60; // radio de la circunferencia

    public void moverCirculo() {
        x++;
    }// end moverCirculo

    public void moverLinea() {
        // calcular la nueva posición de la línea en función del ángulo y el radio
        x2 = (int) (xCentro + radio * Math.cos(angulo));
        y2 = (int) (yCentro + radio * Math.sin(angulo));

        // aumentar el ángulo en cada llamada al método
        angulo += Math.toRadians(2);

    }// end moverLinea

    public void paint(Graphics g) {
        super.paint(g);
        this.setOpaque(false);

        Graphics2D g2d = (Graphics2D) g;

        // Circulo
        /*
         * g2d.setColor(Color.BLUE);
         * g2d.fillOval(x, y, 30, 30);
         */

        // Segundero
        g2d.setColor(Color.RED);
        g2d.drawLine(xCentro, yCentro, x2, y2);

        // Radio alrededor de xCentro, yCentro
        g2d.setColor(Color.BLACK);
        g2d.drawOval(xCentro - 50, yCentro - 50, 100, 100);

        // g2d.drawRect(0, 50, 30, 30);
        // g2d.fillRect(0, 50, 30, 30);
        // g2d.fillRoundRect(0, 90, 30, 30, 20, 20);

    }// end paint
}