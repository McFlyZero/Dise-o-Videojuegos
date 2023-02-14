import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

    public Ventana(){
        initValues();
    }

    private void initValues(){

        Font font1 = new Font("Arial", Font.BOLD, 20);
        JButton btnStart  = new JButton("Start");

        LabelKey lkey = new LabelKey("0");
        lkey.setFont(font1);

        lkey.setFocusable(true);
        btnStart.setFocusable(false);

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

        //add(texto1);
        add(btnStart);
        add(lkey);

        //Especificaciones de la ventana
        setTitle("Ventana 4");
        setSize(300, 300);
        setResizable(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnStart.addActionListener(listener);
    }//end initValues
}