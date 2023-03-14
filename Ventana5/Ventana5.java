import javax.swing.*;
import java.awt.event.*;

class Ventana5 extends JFrame {

    Sonido sonido;

    public Ventana5() {
        initValues();
    }

    private void initValues() {
        JButton btnStart = new JButton("Start");
        JButton btnPause = new JButton("Pause");
        JButton btnResume = new JButton("Resume");
        JButton btnStop = new JButton("Stop");

        btnStart.setFocusable(false);

        btnStart.setBounds(10, 60, 75, 25);
        btnPause.setBounds(90, 60, 75, 25);
        btnResume.setBounds(170, 60, 75, 25);
        btnStop.setBounds(250, 60, 75, 25);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == btnStart) {
                    sonido = new Sonido("sounds/mario1v2.wav"); //Formato de 8 bits
                    sonido.play();

                } else if (ae.getSource() == btnPause) {
                    sonido.pause();
                } else if (ae.getSource() == btnResume) {
                    sonido.resume();
                } else if (ae.getSource() == btnStop) {
                    sonido.stopAlto();
                }
            } // end actionPerformed
        };

        btnStart.addActionListener(listener);
        btnPause.addActionListener(listener);
        btnResume.addActionListener(listener);
        btnStop.addActionListener(listener);
        
        add(btnStart);
        add(btnPause);
        add(btnResume);
        add(btnStop);

        setTitle("Ventana 5");
        setSize(350, 200);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}