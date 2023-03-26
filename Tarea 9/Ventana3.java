import javax.swing.*;
import java.awt.event.*;

class Ventana3 extends JFrame{

    public Ventana3(){
        initValues();
    }

    private void initValues(){
        JLabel background = new JLabel();
        ImageIcon icon = new ImageIcon(this.getClass().getResource("images/background.png"));
		background.setIcon(icon);

        Imagen4 img = new Imagen4("images/mario1.png", "images/mario2.png");
        img.background=background;

        JLabel wall1 = new JLabel();
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/wall.png"));
        wall1.setIcon(icon2);
        img.wall1 = wall1;
        
        JButton btnStart = new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);

        btnStart.setBounds(10,80,75,25);
        wall1.setBounds(120,44,14,12);
        background.setBounds(0,0,510,72);
        img.setBounds(10,14,42,42);

        ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Thread t = new Thread(img);
				t.start();
			} //end actionPerformed
		};

        btnStart.addActionListener(listener);
        img.addKeyListener(img);

        add(img);
        add(wall1);
        add(btnStart);
        add(background);
        
        setTitle("Ventana 3");
		setSize(300, 150);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
}