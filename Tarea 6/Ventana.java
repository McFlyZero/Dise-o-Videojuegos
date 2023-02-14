import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    public Ventana() {
        initValues();
    }

    private void initValues() {
        JButton btnStart = new JButton("Start");
        Imagen img1 = new Imagen("images/mario1.png", "images/mario2.png", 1, 40);
        //Imagen img2 = new Imagen("/images/link1.png", "/images/link2.png", 1, 90);

        btnStart.setBounds(10, 10, 75, 25);
        img1.setBounds(0, 40, 42, 42);
        //img2.setBounds(0, 90, 42, 42);
        img1.setFocusable(true);
       //img2.setFocusable(true);
        

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(img1);
                t1.start();
                // Thread t2 = new Thread(img2);
                //  t2.start();
                btnStart.setEnabled(false);
                /*Thread t3 = new Thread() {
                    public void run() {
                        try {
                            t1.join();
                            btnStart.setEnabled(true);
                        } catch (Exception ex) {
                            System.out.println("Error: " + ex.getMessage());
                        }
                    }
                };
                t3.start();*/
            }
        };

        add(btnStart);
        add(img1);
        //add(img2);

        btnStart.addActionListener(listener);
        img1.addKeyListener(img1);

        setTitle("Tarea 5");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }// end initValues

}
