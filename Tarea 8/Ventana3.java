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

        img.base = base;
        
        JButton btnStart = new JButton("Start");

        img.setFocusable(true);
        btnStart.setFocusable(false);

        img.setBounds(10,11,42,42);
        background.setBounds(0,0,510,72);
        base.setBounds(0,55,160,17);
		btnStart.setBounds(10,80,75,25);

        ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Thread t = new Thread(img);
				t.start();
			} //end actionPerformed
		};

        btnStart.addActionListener(listener);
        img.addKeyListener(img);

        add(img);
        add(base);
        add(background);
        add(btnStart);

        setTitle("Ventana 3");
		setSize(300, 150);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
    }
}