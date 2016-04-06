import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;

public class HandShake implements Runnable {
	ServerSocket servSock;
	boolean connected;
	Thread t;
	Semaphore flg1;

	HandShake(ServerSocket ss, boolean cs, Semaphore s1) {
		servSock = ss;
		connected = cs;
		flg1 = s1;

		t = new Thread(this, "HandShake");
		t.start();
	}

	public void run() {
		while (true) {
			try {
				Socket sock;
				sock = servSock.accept();
				System.out.println("got connection");
				//flg1.acquire();
				if (connected) {
					sock.close();
				}
				else {
					connected = true;
					CALL call = new CALL(sock);
				}
				//flg1.release();
			} catch (Exception e) {}
		}
	}
}
