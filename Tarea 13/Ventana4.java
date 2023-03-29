import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

class Ventana4 extends JFrame {

    boolean bandera = true;

    public Ventana4() {
        initValues();
    }

    private void initValues() {
        Kemonito monito = new Kemonito("images/mario1.png", "images/mario2.png");
        JButton btnStart = new JButton("Start");
        //JButton btnPause = new JButton("Pause");
        //JButton btnReanudar = new JButton("Reanudar");
        //JButton btnStop = new JButton("Stop");
        
        Circulo1 c1 = new Circulo1();
        c1.setBackground(Color.green);
        monito.c1 = c1;

        monito.setFocusable(true);
        btnStart.setFocusable(false);

        monito.setBounds(10, 10, 42, 42);
        btnStart.setBounds(10, 60, 75, 25);
        //btnPause.setBounds(90, 60, 75, 25);
        //btnReanudar.setBounds(170, 60, 75, 25);
        //btnStop.setBounds(250, 60, 75, 25);
        c1.setBounds(10, 90, 340, 210);

        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == btnStart) {
                    Thread t = new Thread(monito);
                    t.start();
               /* } else if (ae.getSource() == btnPause) {
                    if (bandera){
                        monito.pausarHilo();
                        bandera = false;
                    }else{
                        monito.reanudarHilo();
                        bandera = true;
                    }
               // } else if (ae.getSource() == btnReanudar) {
               //     monito.reanudarHilo();
                /* } else if (ae.getSource() == btnStop) {
                    monito.stopHilo();
                    bandera = true;
                    */
                }

            } // end actionPerformed
        };

        btnStart.addActionListener(listener);
        //btnPause.addActionListener(listener);
        //btnReanudar.addActionListener(listener);
        //btnStop.addActionListener(listener);
        monito.addKeyListener(monito);

        add(monito);
        add(btnStart);
        //add(btnPause);
        //add(btnReanudar);
        //add(btnStop);
        add(c1);

        setTitle("Circulo");
        setSize(350, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}