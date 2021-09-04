package JavaMVCViews;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JavaMVCControllers.*;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;

public class HelloWorldView extends JFrame {
	private HelloWorldController controller = new HelloWorldController();
	private JPanel contentPane;
	JTextArea textArea = new JTextArea("");
	public static void main(String[] args) {
	}
	private String path;
	private void loadDataMouseClicked(ActionEvent e) {
		try {
			JFileChooser seleccionarArchivo=new JFileChooser();
			seleccionarArchivo.showOpenDialog(null);
			String data = controller.getMessage(seleccionarArchivo.getSelectedFile().getPath());
			path=seleccionarArchivo.getSelectedFile().getPath();
			textArea.setText(data);

			
			
		}catch(Exception er) {
			
		}
	}
	private void writeDataMouseClicked(ActionEvent e) {
		try {
			String message = textArea.getText();
			controller.writeMessage(message,path);
			
			
		}catch(Exception er) {
			
		}
	}
	public void initComponents() {
		setIconImage(new ImageIcon(this.getClass().getResource("/icon.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		textArea.setBounds(0, 0, 424, 218);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});

		btnNewButton.setBounds(10, 220, 404, 16);
		panel.add(btnNewButton);
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file=new JMenu("File");
		jmb.add(file);

		

		
		JMenuItem open =new JMenuItem("Open");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadDataMouseClicked(arg0);
			}
		});

		file.add(open);
		file.addSeparator();
		
		JMenuItem nuevo =new JMenuItem("New");
		file.add(nuevo);
		file.addSeparator();
		
	
		
		JMenuItem close =new JMenuItem("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		file.add(close);
		file.addSeparator();
		
		JMenuItem save =new JMenuItem("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeDataMouseClicked(e);
			}
		});
		file.add(save);
		file.addSeparator();
		
		JMenuItem saveas =new JMenuItem("Save as");
		file.add(saveas);
		
		JMenu mnNewMenu = new JMenu("Exit");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});


		jmb.add(mnNewMenu);
	mnNewMenu.setActionCommand("System.exit(0)");
		
	}
	public HelloWorldView() {
		setResizable(false);
		initComponents();

	}
}
