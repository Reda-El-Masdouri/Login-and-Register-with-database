import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Menu extends JFrame{

	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 500;
	
	JLabel welcomeLabel;
	Menu(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setUndecorated(true);// remove title bar
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		welcomeLabel = new JLabel();
		welcomeLabel.setBounds(FRAME_HEIGHT/2, 0, FRAME_WIDTH/2, 50);
		welcomeLabel.setFont(new Font("Ink Free",Font.PLAIN,26));
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		this.add(welcomeLabel);
		this.setVisible(true);
	}
}
