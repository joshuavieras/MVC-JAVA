import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 404, 195);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
			}
		});
		btnNewButton.setBounds(162, 207, 89, 23);
		panel.add(btnNewButton);
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu file=new JMenu("File");
		jmb.add(file);
		JMenu exit=new JMenu("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jmb.add(exit);
		
		JMenuItem nuevo =new JMenuItem("New");
		file.add(nuevo);
		file.addSeparator();
		
		JMenuItem open =new JMenuItem("Open");
		file.add(open);
		file.addSeparator();
		
		JMenuItem close =new JMenuItem("Close");
		file.add(close);
		file.addSeparator();
		
		JMenuItem save =new JMenuItem("Save");
		file.add(save);
		file.addSeparator();
		
		JMenuItem saveas =new JMenuItem("Save as");
		file.add(saveas);
		
	}
}
