import java.io.*;
import java.net.*;

public class Writer implements Runnable {
	Socket sock;
	BufferedWriter bw;
	Thread t;

	Writer(Socket s, BufferedWriter bwrite){
		sock = s;
		bw = bwrite;
		t = new Thread(this,"writer");
		t.start();
	}

	public void run(){
		try {
			String outputLine = "";
			while (true){
				outputLine = System.console().readLine();
				
				System.out.printf("%c[%dA", 27, 1);
				System.out.printf("%c[2K", 27);
				System.out.print("<< "+ outputLine);
				System.out.printf("%c[%dB", 27, 1);
				
				bw.write(outputLine);
				bw.newLine();
				bw.flush();
				System.out.println("");
			}
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
