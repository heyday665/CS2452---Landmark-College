import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Semaphore;
import javax.sound.sampled.*;

public class CALL implements Runnable {
	Socket clientSock;
	Thread t;	

	CALL(Socket s){
		clientSock = s;
		t = new Thread(this, "CallThread");
	}

	public void run(){
		//
	}

	private AudioFormat getFormat() {
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
}
