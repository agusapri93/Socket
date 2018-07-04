import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Server {
		
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//new Server().runServer();

	}
	
	public void runServer(String path, int port, String koordinator, String topik) throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Ready to connect on port " + port);
		Socket socket = serverSocket.accept();
		
		
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

		
		InfoPraktikum message = new InfoPraktikum(koordinator, topik);
		objectOutputStream.writeObject(message);

		byte[] content = (byte[]) objectInputStream.readObject();
		String fileName = (String) objectInputStream.readObject();
		String dirPath = path;
		
		String completeFilePath = dirPath + fileName;
		
		File f = new File(completeFilePath);
		
		Files.write(f.toPath(), content);
		System.out.println("Uploaded to : " + dirPath + fileName);
		
		serverSocket.close();
	}
	
	

}
