package JavaMVCViews;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.HelloWorldController;
import JavaMVCControllers.LoginController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Frame;

public class LoginView extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private LoginController lc=new LoginController();
	int intentos=1;

	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}
/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LoginView()  {
		setResizable(false);
		setTitle("Iniciar Sesion");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		textField = new JTextField();
		textField.setBounds(111, 122, 228, 20);
		panel.add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 125, 71, 14);
		panel.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(10, 159, 86, 14);
		panel.add(lblContrasea);
		
		 
		
		
		JButton btnNewButton = new JButton("Iniciar sesi\u00F3n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String user=textField.getText().toString();
					@SuppressWarnings("deprecation")
					String pass=passwordField.getText();
					if(lc.getCredentials(user,pass)) {
						JFrame frame = new JFrame();
						  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JOptionPane.showMessageDialog(frame, "Usted ingresó correctamente\n"+"Bienvenido "+textField.getText(),
					               "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						HelloWorldController controller = new HelloWorldController();
						controller.startApplication();
					}
					else {
						if(intentos==3) {
							JFrame frame = new JFrame();
							  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos\nUsted realizó 3 intentos sin exito\n"+"Este programa se cerrará por seguridad",
						               "3 Retries", JOptionPane.ERROR_MESSAGE);
							System.exit(0);
						}else {
						JFrame frame = new JFrame();
						  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos",
					               "Login Error", JOptionPane.ERROR_MESSAGE);
						intentos++;
						}
					}
					
				}catch(Exception er) {
					JFrame frame = new JFrame();
					  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					JOptionPane.showMessageDialog(frame, "No se encontro el archivo",
				               "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(36, 199, 303, 23);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 156, 228, 20);
		panel.add(passwordField);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Mostrar");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()) {
					passwordField.setEchoChar((char)0);
				}else {
					passwordField.setEchoChar('•');
				}
				
			}
		});
		rdbtnNewRadioButton.setBounds(338, 155, 80, 23);
		panel.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/160.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(139, 0, 138, 122);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(92, 122, 16, 20);
		Image img2 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(92, 159, 21, 14);
		Image img3 = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		panel.add(lblNewLabel_3);
		
		
		


		
		
	}
}
