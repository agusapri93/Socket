import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Color;

public class MyClient {

	private JFrame frame;
	private JDesktopPane desktopPane;
	private JLabel lblPort;
	private JLabel lblFile;
	private JButton btnUpload;
	private JTextField serverName;
	private JTextField port;
	private JTextField filePath;
	private JButton btnBrowse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyClient window = new MyClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblServeripAddress = new JLabel("Server/IP Address");
		lblServeripAddress.setBounds(10, 11, 129, 14);
		desktopPane.add(lblServeripAddress);
		
		lblPort = new JLabel("Port");
		lblPort.setBounds(10, 39, 46, 14);
		desktopPane.add(lblPort);
		
		lblFile = new JLabel("File");
		lblFile.setBounds(10, 70, 46, 14);
		desktopPane.add(lblFile);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(149, 98, 89, 23);
		desktopPane.add(btnUpload);
		
		serverName = new JTextField();
		serverName.setBounds(149, 8, 266, 20);
		desktopPane.add(serverName);
		serverName.setColumns(10);
		
		port = new JTextField();
		port.setBounds(149, 36, 266, 20);
		desktopPane.add(port);
		port.setColumns(10);
		
		filePath = new JTextField();
		filePath.setBounds(149, 67, 266, 20);
		desktopPane.add(filePath);
		filePath.setColumns(10);
		
		btnBrowse = new JButton("Browse...");
		btnBrowse.setBounds(425, 66, 89, 23);
		desktopPane.add(btnBrowse);
	}
}
