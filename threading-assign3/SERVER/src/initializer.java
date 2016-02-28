import java.io.*;
import java.net.*;

class Initialize {
	public static void main(String[] args){
		try {
			int port = Integer.parseInt(args[0]);
			ServerSocket ss = new ServerSocket(port);
			Socket client = ss.accept();

			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	
			System.out.println("Creating Reader and Writer Threads...");
			Reader reader = new Reader(client, br);
			Writer writer = new Writer(client, bw);
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
