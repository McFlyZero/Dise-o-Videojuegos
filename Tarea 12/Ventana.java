import javax.swing.*;
import java.awt.event.*;

public class Ventana extends JFrame {

	public Ventana() {
		initValues();
	}

	private void initValues() {

		JLabel background = new JLabel();
		// Fondo chilo
		// ImageIcon icon = new
		// ImageIcon(this.getClass().getResource("images/background.jpg"));
		// Fondo clase
		ImageIcon icon = new ImageIcon(this.getClass().getResource("images/background.png"));
		background.setIcon(icon);

		Imagen img = new Imagen("images/mario1.png", "images/mario2.png");
		img.background = background;

		JLabel wall1 = new JLabel();
		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("images/wall.png"));
		wall1.setIcon(icon2);
		img.wall1 = wall1;

		JButton btnStart = new JButton("Start");

		img.setFocusable(true);
		btnStart.setFocusable(false);

		img.setBounds(10, 11, 42, 42);
		wall1.setBounds(100, 35, 26, 26);
		background.setBounds(0, 0, 510, 72);
		btnStart.setBounds(10, 80, 75, 25);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Thread t = new Thread(img);
				t.start();
			} // end actionPerformed
		};

		btnStart.addActionListener(listener);
		img.addKeyListener(img);

		add(img);
		add(wall1);
		add(background);
		add(btnStart);

		setTitle("Tarea 8");
		setSize(300, 150);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	} // end initValues

}