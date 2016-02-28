import java.io.*;
import java.net.*;
import java.util.concurrent.*;

class PC implements Runnable {
	int sz;
	Thread t;
	RingBuffer rb = null;
	Semaphore buf = null;
	Semaphore s1 = null;
	Semaphore prod = null;

        PC(int p) {
		sz=p;
		rb = new RingBuffer(sz);
                t = new Thread(this, "PC");
                t.start();
        	buf = new Semaphore(sz);
		s1 = new Semaphore (0);
		prod = new Semaphore (1);	
	}

        public void run() {
		try {
			Producer p = new Producer(rb, buf, s1, prod);
			Consumer c = new Consumer(rb, buf, s1);
			p.t.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
