import java.io.*;
import java.net.*;

class Initialize {
	public static void main(String[] args){
		try {
			int port = Integer.parseInt(args[1]);
			InetAddress address = InetAddress.getByName(args[0]);
	
			Socket client = new Socket(address, port);
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	
			System.out.println("Creating Reader and Writer Threads...");
			Reader reader = new Reader(client, br);
			Writer writer = new Writer(client, bw);
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
