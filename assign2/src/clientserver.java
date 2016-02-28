import java.io.*;
import java.net.*;

class ClientServer {
	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Usage: 'java ClientServer <port>'");
			System.exit(0);
		}
		try {int port = Integer.parseInt(args[0]);
			ServerSocket serverSS = new ServerSocket(port);
			Socket client = serverSS.accept();

			BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	
			String inputline = "";
			String outputline = "";
	
			while (true){
				System.out.print(">> ");
				inputline = br.readLine();
				System.out.println(inputline);
	
				System.out.print("<< ");
				outputline = System.console().readLine();
				bw.write(outputline);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {e.printStackTrace(System.out);}
	}
} 
