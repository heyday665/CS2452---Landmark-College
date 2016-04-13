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
	ByteArrayOutputStream out;	

	CALL(Socket s){
		clientSock = s;
		//try{clientSock.setSendBufferSize(128);
		//clientSock.setReceiveBufferSize(256);} catch (Exception e){}
		t = new Thread(this, "CALL");
		t.start();
	}

	public void run(){
		System.out.println("starting call thread");
		MICCATCH miccatch = new MICCATCH(clientSock);
		try {
			final AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();

			//int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
			int bufferSize = 16;
			byte buffer[] = new byte[bufferSize];

			final AudioInputStream ais = new AudioInputStream(clientSock.getInputStream(), format, 2000000);
			int count;
			while ((count = ais.read(buffer, 0, buffer.length))!=-1) {
				if (count>0) {
					//for (int i=0; i<count; i++){ 
					//	System.out.print(buffer[i]);
					//}
					//System.out.println("");
					line.write(buffer, 0, count);
				}
			}
			line.drain();
			line.close();
		} catch (Exception e) {e.printStackTrace(System.out); System.exit(1);}
	}

	private AudioFormat getFormat() {
		float sampleRate = 8000;
		int sampleSizeInBits = 8;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
}
