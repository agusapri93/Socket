import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		InfoPraktikum info = new InfoPraktikum("Saya", "Java");
		
		System.out.println(info.getNamaKoordinator());
		System.out.println(info.getTopik());
		
		byte [] file = new byte[32768];
		
		try {
			ServerSocket s = new ServerSocket(4949);
			Socket sr = s.accept();
			InputStream is = sr.getInputStream();
			FileOutputStream fr = new FileOutputStream("F:\\txtt.txt");
			
			is.read(file, 0, file.length);
			fr.write(file, 0, file.length);
			fr.close();
			
			s.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
