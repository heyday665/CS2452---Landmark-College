import java.io.*;
import javax.sound.sampled.*;
import java.net.*;

public class MICCATCH implements Runnable{
	Socket clientSock;
	Thread t;

	MICCATCH(Socket s){
		clientSock = s;
		t = new Thread(this, "MICCATCH");
		t.start();
	}
	
	public void run(){
		try {
			final AudioFormat format = getFormat();
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			final TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
			line.open(format);
			line.start();

			int bufferSize = 64;
			byte buffer[] = new byte[bufferSize];

			BufferedOutputStream out = null;
			out = new BufferedOutputStream(clientSock.getOutputStream());
			while (true){
				int count = line.read(buffer, 0, buffer.length);
				if (count > 0){
					out.write(buffer, 0, count);
					out.flush();
				}
			}
		} catch (Exception e) {e.printStackTrace(System.out);}
	}

	static AudioFormat getFormat(){
		float sampleRate = 16000;
		int sampleSizeInBits = 8;
		int channels = 1;
		boolean signed = true;
		boolean bigEndian = false;
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}
}
