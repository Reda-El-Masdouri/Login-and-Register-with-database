import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;


public class RegisterFrame extends JFrame implements ActionListener, MouseListener{
	
	
	static final int FRAME_WIDTH = 500;
	static final int FRAME_HEIGHT = 500;
	
	JLabel[] allLabels;
	JPanel registerPanel;
	JLabel registerLabel;
	JLabel xLabel;
	JLabel minimizeLabel;
	JLabel imagePathLabel;
	JLabel loginLabel;
	
	JTextField nameText;
	JTextField usernameText;
	JTextField phoneText;
	JTextField mailText;
	
	
	JPasswordField confirmPasswordText;
	JPasswordField passwordText;
	JPasswordField[] passwords = {passwordText, confirmPasswordText};
	
	JButton registerButton;
	JButton imageButton;
	JRadioButton maleButton;
	JRadioButton femaleButton;
	
	RegisterFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setResizable(false);
		this.setUndecorated(true);// remove title bar
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, FRAME_WIDTH, (int)(FRAME_HEIGHT/8));
		//loginPanel.setPreferredSize(new Dimension(FRAME_WIDTH, (int)(FRAME_HEIGHT/10)));
		registerPanel.setBackground(Color.DARK_GRAY);
		registerPanel.setLayout(null);
		registerPanel.setOpaque(true);
		
		registerLabel = new JLabel("Register");
		registerLabel.setBounds((int)(FRAME_WIDTH/2)-40, (int)(FRAME_HEIGHT/16), 150, (int)(FRAME_HEIGHT/16));
		//loginLabel.setHorizontalAlignment(JLabel.CENTER);
		//loginLabel.setVerticalAlignment(JLabel.CENTER);
		registerLabel.setFont(new Font("Ink Free", Font.BOLD,26));
		//loginLabel.setBackground(Color.red);
		registerLabel.setForeground(Color.white);
		registerLabel.setVerticalAlignment(JLabel.CENTER);
		
		xLabel = new JLabel("x");
		xLabel.setForeground(Color.black);
		
		xLabel.setBounds(470, 10, 17, 17);
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
		
		minimizeLabel = new JLabel("-");
		minimizeLabel.setForeground(Color.black);
		minimizeLabel.setBounds(450, 10, 17, 17);
		minimizeLabel.setFont(new Font("Tahoma",Font.BOLD,24));
		minimizeLabel.setHorizontalAlignment(JLabel.CENTER);
		minimizeLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				RegisterFrame.this.setState(JFrame.ICONIFIED);
			}

            public void mousePressed(MouseEvent pressed) {

            }

            public void mouseEntered(MouseEvent entered) {
            	minimizeLabel.setForeground(Color.white);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
            	minimizeLabel.setBorder(borderLabel);
            }

            public void mouseExited(MouseEvent exited) {
            	minimizeLabel.setForeground(Color.black);
            	Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
            	minimizeLabel.setBorder(borderLabel);
            }
        });
		Border borderPanel = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.yellow);
		registerPanel.setBorder(borderPanel);
		
		Border borderLabel = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black);
		xLabel.setBorder(borderLabel);
		minimizeLabel.setBorder(borderLabel);
		
		
		registerPanel.add(registerLabel);
		registerPanel.add(minimizeLabel);
		registerPanel.add(xLabel);
		
		allLabels = new JLabel[8];
		allLabels[0] = new JLabel("Name :");
		allLabels[1] = new JLabel("Username :");
		allLabels[2] = new JLabel("Phone :");
		allLabels[3] = new JLabel("Mail :");
		allLabels[4] = new JLabel("Password :");
		allLabels[5] = new JLabel("Confirm password :");
		allLabels[6] = new JLabel("Gender :");
		allLabels[7] = new JLabel("Image :");
		for(int i =0; i<allLabels.length;i++) {
			allLabels[i].setForeground(Color.blue);
			allLabels[i].setBounds((int)(FRAME_WIDTH/8), (int)(FRAME_HEIGHT/6)+i*40, 150, 25);
			allLabels[i].setFont(new Font("Ink Free",Font.BOLD,16));
			allLabels[i].setHorizontalAlignment(JLabel.RIGHT);
			this.add(allLabels[i]);
		}
		JTextField[] allTextFields = {nameText, usernameText, phoneText, mailText};
		for(int i = 0; i<allTextFields.length;i++) {
			allTextFields[i] = new JTextField();
			allTextFields[i].setBounds((int)(FRAME_WIDTH/2), (int)(FRAME_HEIGHT/6)+i*40, 200, 22);
			allTextFields[i].setFont(new Font("Ink Free", Font.PLAIN, 18));
			allTextFields[i].setHorizontalAlignment(JTextField.CENTER);
			Border textFieldBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
			allTextFields[i].setBorder(textFieldBorder);
			this.add(allTextFields[i]);
		}
		for(int i = 0; i<passwords.length;i++) {
			passwords[i] = new JPasswordField(10);
			passwords[i].setBounds((int)(FRAME_WIDTH/2), (int)(FRAME_HEIGHT/6)+160+i*40, 200, 22);
			passwords[i].setFont(new Font("Ink Free", Font.PLAIN, 18));
			passwords[i].setHorizontalAlignment(JTextField.CENTER);
			Border textFieldBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
			passwords[i].setBorder(textFieldBorder);
			this.add(passwords[i]);
		}
		
		maleButton = new JRadioButton("Male");
		maleButton.setBackground(Color.LIGHT_GRAY);
		maleButton.setFocusable(false);
		femaleButton = new JRadioButton("Female");
		femaleButton.setBackground(Color.LIGHT_GRAY);
		femaleButton.setFocusable(false);
		maleButton.setBounds((int)(FRAME_WIDTH/2), (int)(FRAME_HEIGHT/6)+240, 70, 22);
		femaleButton.setBounds((int)(FRAME_WIDTH/2)+70, (int)(FRAME_HEIGHT/6)+240, 100, 22);
		this.add(maleButton);
		this.add(femaleButton);
		ButtonGroup group = new ButtonGroup();
		group.add(maleButton);
		group.add(femaleButton);
		
		imageButton = new JButton("Select Image");
		imageButton.setBounds((int)(FRAME_WIDTH/2), (int)(FRAME_HEIGHT/6)+280, 150, 22);
		imageButton.setFocusable(false);
		imageButton.setVerticalTextPosition(JTextField.CENTER);
		imageButton.addActionListener(this);
		
		imagePathLabel = new JLabel("Image path");
		imagePathLabel.setBounds(0, (int)(FRAME_HEIGHT/6)+300, FRAME_WIDTH, 20);
		imagePathLabel.setVerticalAlignment(JTextField.CENTER);
		imagePathLabel.setHorizontalAlignment(JTextField.CENTER);
		imagePathLabel.setFont(new Font("Consolas", Font.PLAIN,12));
		
		registerButton = new JButton("Register");
		registerButton.setForeground(Color.white);
		registerButton.setBackground(Color.green);
		registerButton.setFocusable(false);
		registerButton.setFont(new Font("Ink Free", Font.BOLD,22));
		registerButton.setBounds((int)(FRAME_WIDTH/3.5), (int)(FRAME_HEIGHT/6)+330, 200, 40);
		registerButton.addMouseListener(this);
		registerButton.addActionListener(this);
		
		loginLabel = new JLabel(">> Already have an account ? Login");
		loginLabel.setForeground(Color.red);
		loginLabel.setBounds((int)(FRAME_WIDTH/3.5), (int)(FRAME_HEIGHT/6)+380, 250, 25);
		loginLabel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				LoginFrame register = new LoginFrame();
				RegisterFrame.this.dispose();
			}

            public void mousePressed(MouseEvent pressed) {

            }

            public void mouseEntered(MouseEvent entered) {
            	
            }

            public void mouseExited(MouseEvent exited) {
            	
            }
        });
		
		this.add(loginLabel);
		this.add(registerButton);
		this.add(imagePathLabel);
		this.add(imageButton);
		this.add(registerPanel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == imageButton) {
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filer = new FileNameExtensionFilter("Images", "jpeg","png", "jpg");// we need to appear just the images 
			chooser.addChoosableFileFilter(filer);
			
			chooser.setDialogTitle("Choose your image"); 
			
			int fileState = chooser.showDialog(null, "OK"); // this method return an integer from what we click
			if(fileState == JFileChooser.APPROVE_OPTION) {// "OK" button is the approve button
				// if we press "OK", we stock the image in a file 
				File selectedImage = chooser.getSelectedFile();
				// we stock also its path:
				String pathSelectedImage = selectedImage.getAbsolutePath();
				// we put it in the text label
				imagePathLabel.setText(pathSelectedImage);
			}
		}
		if(e.getSource()==registerButton) {
			if(checkEmptyFileds()) {
				JOptionPane.showConfirmDialog(null, "Please enter your information", "Missing data", JOptionPane.ERROR_MESSAGE);
			}
			else {
				String name = nameText.getText();
				String username = usernameText.getText();
				String password = String.valueOf(passwordText.getPassword());
				String confirmPassword = String.valueOf(confirmPasswordText.getPassword());
				String phone = phoneText.getText();
				String mail = mailText.getText();
				String gender = "Male";
				if(femaleButton.isSelected()) {
					gender = "Female";
				}
				if(!matchingPasswords(password,confirmPassword)) {
					JOptionPane.showMessageDialog(null, "The passwords doesn't match", "Passwords !", JOptionPane.ERROR_MESSAGE);
				}
				else {
					PreparedStatement ps;
					String query = "INSERT INTO users.users (name, username,password,phone,mail, gender, image) values (?,?,?,?,?,?,?)";
					
					try {
						ps = ConnectionDataBase.getConnection().prepareStatement(query);
						ps.setString(1, name);
						ps.setString(2, username);
						ps.setString(3, password);
						ps.setString(4, phone);
						ps.setString(5, mail);
						ps.setString(6, gender);
						
						InputStream image = new FileInputStream(new File(imagePathLabel.getText()));
						ps.setBlob(7, image);
						if(ps.executeUpdate() != 0) {// the query worked
							JOptionPane.showMessageDialog(null, "Your account has been created", "Success", JOptionPane.PLAIN_MESSAGE);
							}
						else {
							JOptionPane.showMessageDialog(null, "Your account has not been created", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Coonection failed with data base", "ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "The account image has not copied to data base", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		
	}
	private boolean checkEmptyFileds() {
		System.out.println(nameText.getText());
		return (
				nameText.getText().equals("") ||
				usernameText.getText().equals("") ||
				String.valueOf(passwordText.getPassword()).equals("") ||
				String.valueOf(confirmPasswordText.getPassword()).equals("") ||
				mailText.getText().equals("")
				);
	}
	private boolean matchingPasswords(String p1, String p2) {
		return (p1.equals(p2));
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
		registerButton.setBackground(new Color(0,255,204));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		registerButton.setBackground(Color.green);
		
	}
}
