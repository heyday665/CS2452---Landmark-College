import java.io.*;
import java.net.*;

class Client {
	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Usage: 'java Client <port> <ip address>'");
			System.exit(0);	
		}
		try {
			int port = Integer.parseInt(args[0]);
			InetAddress address = InetAddress.getByName(args[1]);
			System.out.println("Attempting Connection...");
			Socket client = new Socket(address, port);
			System.out.println("Connectioned.\n");
	
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			
			String inputline = "";
			String outputline = "";

			while (true){
				System.out.print("<< ");
				outputline = System.console().readLine();
				bw.write(outputline);
				bw.newLine();
				bw.flush();
				
				System.out.print(">> ");
				inputline = br.readLine();
				System.out.println(inputline);
			}
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
}
			
	
