package Ventana2;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    public Ventana() throws IOException{
        initValues();
    }
    private void initValues() throws IOException{
        //Prueba Imagen
        File file=new File("C://Users//artur//Desktop//Ventana2//img//img_nave.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon=new ImageIcon(bufferedImage);
        JLabel texto1=new JLabel ();
        texto1.setIcon(imageIcon);
        //End Prueba Imagen



        Font font1=new Font("Arial",1,22);
        //JLabel texto1=new JLabel ("Fuimonos");
        texto1.setFont(font1);
        LabelKey lkey=new LabelKey("0");
        lkey.setFont(font1);
        JButton btnStart=new JButton("Start");

        lkey.setFocusable(true);
        btnStart.setFocusable(false);

        texto1.setBounds(1,1,276,168);
        lkey.setBounds(112,200,75,25);
        btnStart.setBounds(112,230,75,25);
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Thread tkey=new Thread(lkey);
                tkey.start();

                /*MyThread t=new MyThread();
                t.btn=btnStart;
                t.texto1=texto1;
                t.start();
                */
            }
        };
        //Agregamos label y button
        add(texto1);
        add(lkey);
        add(btnStart);
        //Especificaciones de mi ventana
        setTitle("Mi Ventana");
        setSize(700,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnStart.addActionListener(listener);
    }//end initValues
    
}
