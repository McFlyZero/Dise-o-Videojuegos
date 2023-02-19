import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    public Ventana() {
        initValues();
    }

    private void initValues() {
        JLabel background = new JLabel(new ImageIcon("images/background.png"));
        JButton btnStart = new JButton("Start");
        Imagen img1 = new Imagen("images/mario1.png", "images/mario2.png", 1, 40);
        
        background.setBounds(0, 0, 500, 100);
        btnStart.setBounds(10, 10, 75, 25);
        img1.setBounds(0, 90, 42, 42);
        
        background.setVisible(true);
        img1.setFocusable(true);
        background.setFocusable(false);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(img1);
                t1.start();
                btnStart.setEnabled(false);
            }
        };

        add(background);
        background.add(btnStart);
        background.add(img1);

        btnStart.addActionListener(listener);
        img1.addKeyListener(img1);

        setTitle("Tarea 7");
        setSize(500, 140);
        setResizable(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }// end initValues

}
