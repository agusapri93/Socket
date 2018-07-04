import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static final int PORT = 4444;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Server().runServer();

	}
	
	public void runServer() throws IOException, ClassNotFoundException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Ready to connect.....");
		Socket socket = serverSocket.accept();
		
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

		
		Message message = new Message(500, 7);
		objectOutputStream.writeObject(message);

		byte[]	content = (byte[]) objectInputStream.readObject();
		
	}
	
	public void doSomething(Message message) {
		message.setResult(message.getFirstNumber().intValue() * message.getSecondNumber().intValue());
	}

}
