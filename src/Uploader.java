import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class Uploader implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Socket socket;
	int serverPort;
	boolean isConnected;
	String filePath;
	String serverName;
	
	
	public void upload(String filePath, String serverName, int serverPort) {
		byte [] file = new byte[32768];
		
		try {
			Socket socket = new Socket(serverName, serverPort);
	
			FileInputStream fr = new FileInputStream(filePath);
			fr.read(file, 0, file.length);
			OutputStream os = socket.getOutputStream();
			os.write(file, 0, file.length);
			fr.close();
			
			
			
			
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
}
}
	

