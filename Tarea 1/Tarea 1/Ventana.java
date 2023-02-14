import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Ventana extends JFrame{
    public Ventana() {
        initValues();
    }//end Ventana

    private void initValues(){
           
        //Font font1 = new Font("Arial",1, 24);
        JLabel texto1 = new JLabel("0");
        texto1.setBounds(10, 10, 50, 25);
        add(texto1);

        JButton btn1 = new JButton("Start");
        btn1.setBounds(10,35, 100, 25);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintThread(texto1);
            }
        });
        add(btn1);

        setTitle("Ventana");
        setSize(300, 300);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//end initValues

    public HiloHijo StartThread(JLabel texto1){
        HiloHijo h1 = new HiloHijo();
        h1.setName("Hilo 1");
        h1.setTime(1000);
        Thread t1 = new Thread(h1);
        t1.start();

        return h1;
    }//end ThreadTime   

    public void PrintThread(JLabel texto1){
        HiloHijo h1 = StartThread(texto1);
        for(int i = 1; i <= 10; i++){
            try {

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        int time = h1.getCurrentTime();
                        String value = String.valueOf(time);
                        texto1.setText(value);
                    }
                }, 0, 1000);
  
            } catch (Exception e) {
                System.out.println("Error"+ e);
            }        
        }
        
        //System.out.println(time);
       
    }
}//end Ventana