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

        JLabel base = new JLabel();
        ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/base.png"));
        base.setIcon(icon2);

        JLabel negro = new JLabel();
        ImageIcon icon3 = new ImageIcon(this.getClass().getResource("images/negro.png"));
        negro.setIcon(icon3);

        JLabel base2 = new JLabel();
        ImageIcon icon4 = new ImageIcon(this.getClass().getResource("images/base.png"));
        base2.setIcon(icon4);

        img.base = base;
        img.base2 = base2;
        
        JButton btnStart = new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);
        negro.setFocusable(false);

        btnStart.setBounds(10,80,75,25);
        negro.setBounds(0,72,510,72);
        img.setBounds(10,14,42,42);
        background.setBounds(0,0,510,72);
        base.setBounds(0,55,160,17);
        base2.setBounds(220,55,160,17);

		


        ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Thread t = new Thread(img);
				t.start();
			} //end actionPerformed
		};

        btnStart.addActionListener(listener);
        img.addKeyListener(img);

        add(btnStart);
        add(negro);
        add(img);
        add(base);
        add(base2);
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