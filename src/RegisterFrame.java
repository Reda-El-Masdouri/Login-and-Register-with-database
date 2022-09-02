import java.awt.Color;

import javax.swing.JFrame;

public class RegisterFrame extends JFrame{
	
	
	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 500;
	
	
	RegisterFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setUndecorated(true);// remove title bar
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setVisible(true);
	}
}
