import javax.swing.*;

public class MyThread extends Thread{

    JLabel texto1;
    int n = 1;

    public void run(){

        while(true){
            try{
                /*Thread.sleep(1000);
                texto1.setText(Integer.toString(n));
                n++;
                */
                /*if (n > 10){
                    break;
                }*/

            }catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }//end run
    
}
