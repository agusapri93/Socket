import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
		
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//new Server().runServer();

	}
	
	public void runServer(String path, int port, String koordinator, String topik) throws IOException, ClassNotFoundException {
		@SuppressWarnings("resource")
		
		ServerSocket serverSocket = new ServerSocket(port);
		InfoPraktikum infoPraktikum = new InfoPraktikum(koordinator, topik);
		System.out.println("Ready to connect on port " + port);
		
		while (true) {
			Socket socket = serverSocket.accept();
			new ClientHandler(socket, infoPraktikum, path).start();
		}		
		
	}
	
	

}
