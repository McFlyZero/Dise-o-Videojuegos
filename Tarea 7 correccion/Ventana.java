import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {
    public Ventana() {
        initValues();
    }

    private void initValues() {
        JButton btnStart = new JButton("Start");
        Imagen img1 = new Imagen("images/mario1.png", "images/mario2.png", 1, 174);
        Background background = new Background("images/background.jpg", img1);
        
        background.setBounds(0,-817,3840,1080);
        btnStart.setBounds(10, 10, 75, 25);
        img1.setBounds(10, 174, 42, 42);
        
        background.setVisible(true);
        btnStart.setVisible(true);

        img1.setFocusable(true);
        btnStart.setFocusable(false);
        background.setFocusable(false);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Hilo con el monito
                Thread t1 = new Thread(img1);
                t1.start();
                //Hilo con el fondo
                Thread t2 = new Thread(background);
                t2.start();
                System.out.println("Empezaron los dos");
                //Desactivo el botón
                btnStart.setEnabled(false);
            }
        };
        //Añadir elementos al frame
        add(btnStart);
        add(img1);
        add(background);
        //KeyListeners y ActionListener
        btnStart.addActionListener(listener);
        img1.addKeyListener(img1);
        background.addKeyListener(background);

        setTitle("Tarea 7");
        setSize(500, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }// end initValues

}
