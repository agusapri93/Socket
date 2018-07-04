import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;

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
	
	
	public InfoPraktikum upload(String filePath, String serverName, int serverPort) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket(serverName, serverPort);
		File fileToBeSent = new File(filePath);
		byte[] fileContent = Files.readAllBytes(fileToBeSent.toPath());
		
		String fileName = fileToBeSent.getName();
		
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		
		
		
		InfoPraktikum returnMessage = (InfoPraktikum) objectInputStream.readObject();
		
		
		objectOutputStream.writeObject(fileContent);
		objectOutputStream.writeObject(fileName);
		
		socket.close();
		
		return returnMessage;
}
}
	

