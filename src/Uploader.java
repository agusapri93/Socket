import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Uploader {
	
	Socket socket;
	int serverPort;
	boolean isConnected;
	String filePath;
	String serverName;
	
	public void connect() {
		
	}
	
	public void disconnect() {
		
		
	}
	
	public void upload(String filePath, String serverName, int serverPort) throws IOException, IOException {
		
		Socket socket = new Socket(serverName, serverPort);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		System.out.println("server says: " + br.readLine() + filePath);

		
		BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
		String userInput = userInputBR.readLine();

		out.println(userInput);

		System.out.println("server says:" + br.readLine());

		if ("exit".equalsIgnoreCase(userInput)) {
			socket.close();
		}
		
	}
	
}
