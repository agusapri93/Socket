import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket("localhost", 4444);
		File f = new File("C:\\Users\\AGUS\\Documents\\script.rb");
		byte[] content = Files.readAllBytes(f.toPath());
		
		
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		
		//objectOutputStream.writeObject(message);
		
		
		
		
		Message returnMessage = (Message) objectInputStream.readObject();
		System.out.println(returnMessage.getFirstNumber());
		
		objectOutputStream.writeObject(content);
		socket.close();

	}

}
