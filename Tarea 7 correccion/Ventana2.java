import javax.swing.*;
import java.awt.event.*;

public class Ventana2 extends JFrame {
    public Ventana2() {
        initValues();
    }

    private void initValues(){

        JLabel background = new JLabel();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/background.png"));
        background.setIcon(icon);

        Imagen3 img = new Imagen3("/images/mario1.png", "/images/mario2.png");
        JButton btnStart = new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);

        img.setBounds(10, 11, 42, 42);
        background.setBounds(0, 0, 510, 72);
        btnStart.setBounds(10, 80, 75, 25);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(img);
                t1.start();
            }
        };

        btnStart.addActionListener(listener);
        img.addKeyListener(img);

        add(img);
        add(background);
        add(btnStart);

        setTitle("Ventana 2");
        setSize(300, 150);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}