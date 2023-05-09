import javax.swing.JButton;
import javax.swing.JLabel;

public class Etiqueta extends JLabel implements Runnable{

    JButton btn1;
    int time;
    
    public Etiqueta(String txt1){
        setText(txt1);
    }

    public void setTime(int time) {
        this.time = time;
    }
    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                Thread.sleep(time);
                System.out.println(i);
                setText(Integer.toString(i));
            } catch (Exception e) {
                System.out.println("Error"+ e);
            }        
        }
        btn1.setEnabled(true);
    }//end run
    
}
