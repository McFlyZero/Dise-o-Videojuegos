import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

    public Ventana(){
        initValues();
    }

    private void initValues(){

        Font font1 = new Font("Arial", Font.BOLD, 20);
        JLabel texto1 = new JLabel("0");
        texto1.setFont(font1);
        JButton btnStart  = new JButton("Start");

        texto1.setBounds(10, 10, 100, 30);
        btnStart.setBounds(10, 40, 75, 25);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyThread t = new MyThread();
                t.texto1 = texto1;
                t.start();
            }//end actionPerformed
        };

        btnStart.addActionListener(listener);

        add(texto1);
        add(btnStart);

        setTitle("Ventana 2");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues
}