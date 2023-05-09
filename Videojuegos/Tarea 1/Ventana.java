import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{
    public Ventana() {
        initValues();
    }//end Ventana
    JButton btn;
    JLabel texto1;

    private void initValues(){
           
        //Font font1 = new Font("Arial",1, 24);
        JLabel texto1 = new JLabel("0");
        texto1.setBounds(10, 10, 50, 25);
        add(texto1);

        JButton btn = new JButton("Start");
        btn.setBounds(10,35, 100, 25);
        btn.addActionListener(this);
        add(btn);

        setTitle("Ventana");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }//end initValues

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            System.out.println(btn);
            HiloHijo h1 = new HiloHijo();
            h1.setNombre("Hilo 1");
            h1.setTime(500);

            Thread t1 = new Thread(h1);
            t1.start();

            System.out.println(h1.getCurrentTime());
            //Cambiar el valor de texto1 al valor del contador
            //for (int i = 0; i < 100000; i++) {
                
                //String txt = h1.getCurrentTime();
                //Cast to string
                //this.texto1 = ((JLabel)txt);
            //}
        }
    }

}//end Ventana