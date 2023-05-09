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

        LabelKey lkey = new LabelKey("0");
        //lkey.texto1 = texto1;
        //lkey.jframe1 = Ventana.this;

        texto1.setBounds(10, 10, 50, 30);
        btnStart.setBounds(10, 40, 75, 25);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //MyThread t = new MyThread();
                Thread tkey = new Thread(lkey);
                tkey.start();
                //t.run();
            }//end actionPerformed
        };

        add(texto1);
        add(btnStart);
        add(lkey);

        //Especificaciones de la ventana
        setTitle("Ventana 2");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnStart.addActionListener(listener);
    }//end initValues
}