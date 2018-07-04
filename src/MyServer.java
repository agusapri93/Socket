import java.awt.EventQueue;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MyServer {

	private JFrame frame;
	private JTextField topik;
	private JTextField koordinator;
	private JTextField port;
	private JTextField ipAddress;
	private JTextField direktori;
	
	String fileSaveDir = "";
    
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyServer window = new MyServer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MyServer() throws UnknownHostException {
		initialize();
	}

	
	private void initialize() throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblKoordinator = new JLabel("Koordinator");
		lblKoordinator.setBounds(10, 11, 100, 14);
		desktopPane.add(lblKoordinator);
		
		JLabel lblTopik = new JLabel("Topik");
		lblTopik.setBounds(10, 42, 46, 14);
		desktopPane.add(lblTopik);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setBounds(10, 73, 77, 14);
		desktopPane.add(lblIpAddress);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(10, 104, 46, 14);
		desktopPane.add(lblPort);
		
		JLabel lblDirektori = new JLabel("Direktori");
		lblDirektori.setBounds(10, 135, 100, 14);
		desktopPane.add(lblDirektori);
		
		koordinator = new JTextField();
		koordinator.setText("Saya Koordinator");
		koordinator.setBounds(137, 8, 202, 20);
		desktopPane.add(koordinator);
		koordinator.setColumns(10);
		
		topik = new JTextField();
		topik.setText("Java");
		topik.setBounds(137, 39, 202, 20);
		desktopPane.add(topik);
		topik.setColumns(10);
		
		ipAddress = new JTextField();
		ipAddress.setBounds(137, 70, 202, 20);
		desktopPane.add(ipAddress);
		ipAddress.setColumns(10);
		ipAddress.setText(inetAddress.getHostAddress());
		ipAddress.setEditable(false);
		
		port = new JTextField();
		port.setText("4444");
		port.setBounds(137, 101, 202, 20);
		desktopPane.add(port);
		port.setColumns(10);
		
		direktori = new JTextField();
		direktori.setBounds(137, 132, 202, 20);
		desktopPane.add(direktori);
		direktori.setColumns(10);
		
		JButton btnNewButton = new JButton("Browse...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    //chooser.setDialogTitle("choosertitle");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    chooser.showOpenDialog(null);
			    File location = chooser.getSelectedFile();
			    fileSaveDir = location.getAbsolutePath();
			    direktori.setText(fileSaveDir);
			    
			    
			    
			}
		});
		
		btnNewButton.setBounds(349, 131, 100, 23);
		desktopPane.add(btnNewButton);
		
		JButton btnStartServer = new JButton("Start Server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String koordinators = koordinator.getText();
				String topiks = topik.getText();
				int svPort = Integer.parseInt(port.getText());
				try {
					new Server().runServer(fileSaveDir, svPort, koordinators, topiks);
				} catch (ClassNotFoundException | IOException e2) {
					e2.printStackTrace();
				}
				
				
			}
		});
		btnStartServer.setBounds(137, 163, 100, 23);
		desktopPane.add(btnStartServer);
	}

}
