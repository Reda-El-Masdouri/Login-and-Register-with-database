import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;


public class LoginFrame extends JFrame implements MouseListener{
	
	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 500;
	
	JPanel loginPanel;
	JButton loginButton;
	JLabel loginLabel;
	JLabel xLabel;
	JLabel redLabel;
	JLabel usernameLabel;
	JLabel passwordLabel;
	JLabel registerLabel;
	JTextField usernameText;
	JTextField passwordText;
	
	LoginFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setUndecorated(true);// remove title bar
		this.setLocationRelativeTo(null);
		//this.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, FRAME_WIDTH, (int)(FRAME_HEIGHT/8));
		//loginPanel.setPreferredSize(new Dimension(FRAME_WIDTH, (int)(FRAME_HEIGHT/10)));
		loginPanel.setBackground(Color.DARK_GRAY);
		loginPanel.setLayout(null);
		loginPanel.setOpaque(true);
		
		loginLabel = new JLabel("Login");
		loginLabel.setBounds((int)(FRAME_WIDTH/2)-40, (int)(FRAME_HEIGHT/16), 100, (int)(FRAME_HEIGHT/16));
		//loginLabel.setHorizontalAlignment(JLabel.CENTER);
		//loginLabel.setVerticalAlignment(JLabel.CENTER);
		loginLabel.setFont(new Font("Ink Free", Font.BOLD,26));
		//loginLabel.setBackground(Color.red);
		loginLabel.setForeground(Color.white);
		loginLabel.setVerticalAlignment(JLabel.CENTER);
		
		//loginLabel.setOpaque(true);
		//loginLabel.setVerticalTextPosition(JLabel.CENTER);
		
		xLabel = new JLabel("x");
		xLabel.setForeground(Color.black);
		
		xLabel.setBounds(470, 10, 17, 17);
		//xLabel.setHorizontalAlignment(JLabel.RIGHT);
		xLabel.setHorizontalTextPosition(JLabel.CENTER);
		xLabel.setFont(new Font("Tahoma",Font.BOLD,18));
		xLabel.setHorizontalAlignment(JLabel.CENTER);
		xLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

            public void mousePressed(MouseEvent pressed) {

            }

            public void mouseEntered(MouseEvent entered) {
            	xLabel.setForeground(Color.white);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        		xLabel.setBorder(borderLabel);
            }

            public void mouseExited(MouseEvent exited) {
            	xLabel.setForeground(Color.black);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
        		xLabel.setBorder(borderLabel);
            }
        });
		
		redLabel = new JLabel("-");
		redLabel.setForeground(Color.black);
		redLabel.setBounds(450, 10, 17, 17);
		//xLabel.setHorizontalAlignment(JLabel.RIGHT);
		//xLabel.setVerticalAlignment(JLabel.RIGHT);
		redLabel.setFont(new Font("Tahoma",Font.BOLD,24));
		redLabel.setHorizontalAlignment(JLabel.CENTER);
		
		redLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				LoginFrame.this.setState(JFrame.ICONIFIED);
			}

            public void mousePressed(MouseEvent pressed) {

            }

            public void mouseEntered(MouseEvent entered) {
            	redLabel.setForeground(Color.white);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
            	redLabel.setBorder(borderLabel);
            }

            public void mouseExited(MouseEvent exited) {
            	redLabel.setForeground(Color.black);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
            	redLabel.setBorder(borderLabel);
            }
        });

		
		usernameLabel = new JLabel("Username : ");
		usernameLabel.setForeground(Color.blue);
		usernameLabel.setBounds((int)(FRAME_WIDTH/8), (int)(FRAME_HEIGHT/4), 150, 25);
		usernameLabel.setFont(new Font("Ink Free",Font.BOLD,16));
		usernameLabel.setHorizontalAlignment(JLabel.CENTER);
		
		passwordLabel = new JLabel("Password : ");
		passwordLabel.setForeground(Color.blue);
		passwordLabel.setBounds((int)(FRAME_WIDTH/8), (int)(FRAME_HEIGHT/3), 150, 25);
		passwordLabel.setFont(new Font("Ink Free",Font.BOLD,16));
		passwordLabel.setHorizontalAlignment(JLabel.CENTER);
		
		usernameText = new JTextField();
		usernameText.setBounds((int)(FRAME_WIDTH/2.5), (int)(FRAME_HEIGHT/4), 200, 22);
		usernameText.setFont(new Font("Ink Free", Font.PLAIN, 18));
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		
		passwordText = new JTextField();
		passwordText.setBounds((int)(FRAME_WIDTH/2.5), (int)(FRAME_HEIGHT/3), 200, 22);
		passwordText.setHorizontalAlignment(JTextField.CENTER);
		
		loginButton = new JButton("Login");
		loginButton.setForeground(Color.white);
		loginButton.setBackground(Color.green);
		loginButton.setFocusable(false);
		loginButton.setFont(new Font("Ink Free", Font.BOLD,22));
		loginButton.setBounds((int)(FRAME_WIDTH/3.5), (int)(FRAME_HEIGHT/2), 200, 40);
		loginButton.addMouseListener(this);
		
		registerLabel = new JLabel(">> No account ? Create One");
		registerLabel.setForeground(Color.red);
		registerLabel.setBounds((int)(FRAME_WIDTH/3.5)+10, (int)(FRAME_HEIGHT/1.5), 200, 25);
		registerLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				RegisterFrame register = new RegisterFrame();
				LoginFrame.this.dispose();
			}

            public void mousePressed(MouseEvent pressed) {

            }

            public void mouseEntered(MouseEvent entered) {
            	
            }

            public void mouseExited(MouseEvent exited) {
            	
            }
        });
		
		loginPanel.add(xLabel);
		loginPanel.add(redLabel);
		loginPanel.add(loginLabel);
		
		Border borderPanel = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow);
		loginPanel.setBorder(borderPanel);
		
		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		xLabel.setBorder(borderLabel);
		redLabel.setBorder(borderLabel);
		
		Border textFieldBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
		usernameText.setBorder(textFieldBorder);
		passwordText.setBorder(textFieldBorder);
		
		this.add(registerLabel);
		this.add(loginButton);
		this.add(usernameText);
		this.add(passwordText);
		this.add(passwordLabel);
		this.add(usernameLabel);
		this.add(loginPanel);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		loginButton.setBackground(new Color(0,255,204));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		loginButton.setBackground(Color.green);
		
	}

}
