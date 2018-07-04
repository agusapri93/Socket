import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;

public class MyClient {

	private JLabel lblServeripAddress;
	private JFrame frame;
	private JDesktopPane desktopPane;
	private JLabel lblPort;
	private JLabel lblFile;
	private JButton btnUpload;
	private JTextField serverName;
	private JTextField port;
	private JTextField filePath;
	private JButton btnBrowse;
	private JTextField koordinator;
	private JLabel lblKordinator;
	private JTextField topik;
	private JLabel lblTopik;
	
	File fileUpload;
	String svName;
	int svPort;
	String filePathUpload;

	
	
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

	
	public MyClient() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 590, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		lblServeripAddress = new JLabel("IP Address");
		lblServeripAddress.setBounds(10, 11, 129, 14);
		desktopPane.add(lblServeripAddress);
		
		lblPort = new JLabel("Port");
		lblPort.setBounds(10, 39, 46, 14);
		desktopPane.add(lblPort);
		
		lblFile = new JLabel("File");
		lblFile.setBounds(10, 70, 46, 14);
		desktopPane.add(lblFile);
		
		lblKordinator = new JLabel("Kordinator");
		lblKordinator.setBounds(10, 135, 99, 14);
		desktopPane.add(lblKordinator);
		
		lblTopik = new JLabel("Topik");
		lblTopik.setBounds(10, 166, 46, 14);
		desktopPane.add(lblTopik);
		
		serverName = new JTextField();
		serverName.setBounds(149, 8, 266, 20);
		desktopPane.add(serverName);
		serverName.setColumns(10);
		serverName.setText("localhost");
		
		port = new JTextField();
		port.setBounds(149, 36, 266, 20);
		desktopPane.add(port);
		port.setColumns(10);
		port.setText("4444");
		
		filePath = new JTextField();
		filePath.setBounds(149, 67, 266, 20);
		desktopPane.add(filePath);
		filePath.setColumns(10);
		
		btnBrowse = new JButton("Browse...");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				fileUpload = chooser.getSelectedFile();
				filePathUpload = fileUpload.getAbsolutePath();
				filePath.setText(filePathUpload);
			}
		});
		
		koordinator = new JTextField();
		koordinator.setBounds(149, 132, 266, 20);
		desktopPane.add(koordinator);
		koordinator.setColumns(10);
		koordinator.setEditable(false);
		
		topik = new JTextField();
		topik.setBounds(149, 163, 266, 20);
		desktopPane.add(topik);
		topik.setColumns(10);
		topik.setEditable(false);
		
		btnBrowse.setBounds(425, 66, 89, 23);
		desktopPane.add(btnBrowse);
		
		btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				svName = serverName.getText();
				svPort = Integer.parseInt(port.getText());
				
				Uploader uploader = new Uploader();
				
				
				try {
					 InfoPraktikum informasi = uploader.upload(filePathUpload, svName, svPort);
					 koordinator.setText(informasi.getNamaKoordinator());
					 topik.setText(informasi.getTopik());
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnUpload.setBounds(149, 98, 89, 23);
		desktopPane.add(btnUpload);
	}
}
