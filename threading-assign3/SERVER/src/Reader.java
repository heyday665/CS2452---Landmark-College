import java.io.*;
import java.net.*;

public class Reader implements Runnable {
	Socket sock;
	BufferedReader br;
	Thread t;

	Reader(Socket s, BufferedReader bread){
		sock = s;
		br = bread;
		t = new Thread(this, "reader");		
		t.start();
	}

	public void run(){
		try {
			String inputLine = "";
			
			while (true){
				inputLine = br.readLine();
				System.out.println("");
				
				System.out.printf("%c[%dA", 27, 1);
				System.out.printf("%c[2K", 27);
				System.out.println(">> " + inputLine);
				System.out.printf("%c[%dB", 27, 1);
			}
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
