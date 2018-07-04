import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;

public class ClientHandler extends Thread{

	Socket socket;
	InfoPraktikum infoPraktikum;
	String path;
	ClientHandler(Socket socket, InfoPraktikum infoPraktikum, String path){
		this.socket = socket;
		this.infoPraktikum = infoPraktikum;
		this.path = path;
	}
	
	public void run() {
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream.writeObject(infoPraktikum);
			byte[] content = (byte[]) objectInputStream.readObject();
			String fileName = (String) objectInputStream.readObject();
			String dirPath = path;
			String completeFilePath = dirPath + fileName;
			File f = new File(completeFilePath);
			
			Files.write(f.toPath(), content);
			
			socket.close();
			
			System.out.println("Uploaded to : " + dirPath + fileName);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
