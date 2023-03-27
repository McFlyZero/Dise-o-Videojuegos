import javax.swing.*;
import java.awt.event.*;

public class Ventana3 extends JFrame {
    public Ventana3() {
        initValues();
    }

    private void initValues() {
        JLabel background = new JLabel();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("images/background.png"));
        background.setIcon(icon);

        Imagen4 img = new Imagen4("images/mario1.png", "images/mario2.png", "images/mariodeath.png");
        img.background = background;

        JButton btnStart = new JButton("Start");

        JLabel wall1 = new JLabel();
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/wall.png"));
        wall1.setIcon(icon2);
        img.wall1 = wall1;

        JLabel negro = new JLabel();
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("images/negro.png"));
        negro.setIcon(icon3);

        img.setFocusable(true);
        btnStart.setFocusable(false);
        negro.setFocusable(false);

        btnStart.setBounds(10, 80, 75, 25);
        negro.setBounds(0, 72, 510, 72);
        background.setBounds(0, 0, 510, 72);
        img.setBounds(10, 14, 32, 39);
        wall1.setBounds(80, 33, 30, 35);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Thread t = new Thread(img);
                t.start();
            }// end actionPerformed
        };
        btnStart.addActionListener(listener);
        img.addKeyListener(img);

        // Añadir elementos a escena
        add(btnStart);
        add(negro);
        add(img);
        add(wall1);
        add(background);

        setTitle("Ventana3");
        setSize(300, 150);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}