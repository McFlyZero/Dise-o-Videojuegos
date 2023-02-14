import javax.swing.*;

public class MyThread extends Thread {

    JLabel texto1;
    JFrame jframe1;
    int n = 1;

    public void run() {

        while (true) {
            try {
                //Thread.sleep(1000);
                int jfancho = jframe1.getWidth();
                int txt1posicion = texto1.getX();
                int txt1ancho = texto1.getWidth();
                System.out.println("Posicion: " + txt1posicion);
                // Para hacer que el JLabel se mueva de un lado a otro en horizontal
                boolean bandera = true;

                while (bandera) {
                    Thread.sleep(10);
                    if (txt1posicion > (jfancho - txt1ancho)) {
                        bandera = false;
                    } else {
                        txt1posicion = txt1posicion + 1;
                        //System.out.println("Entré a sumarle a posicion");
                        System.out.println("Posicion: " + txt1posicion);
                        texto1.setLocation(txt1posicion, texto1.getY());
                    }
                }

                while (bandera == false) {
                    Thread.sleep(10);
                    if (txt1posicion < 0 + txt1ancho) {
                        bandera = true;
                    } else {
                        txt1posicion = txt1posicion - 1;
                        //System.out.println("Entré a restarle a posicion");
                        System.out.println("Posicion: " + txt1posicion);
                        texto1.setLocation(txt1posicion, texto1.getY());
                    }
                }

                // Para hacer el contador se usa el setText
                /*
                texto1.setText(Integer.toString(n));
                n++;

                if (n > 10) {
                    break;
                }
                 */

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }// end run

}
