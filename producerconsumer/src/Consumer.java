import java.util.concurrent.*;

public class Consumer implements Runnable {
	Thread t;
	RingBuffer rb;
	Semaphore buf = null;
	Semaphore s1 = null;

        Consumer(RingBuffer r, Semaphore t1, Semaphore t2) {
		rb=r;
		buf = t1;
		s1 = t2;
                t = new Thread(this, "Consumer");
                t.start();
        }


        public void run() {
		int iter=0;
		byte value=0;
		boolean running=true;

		System.out.println("Consumer: starts");
		while (running) {
			try {
				s1.acquire();
					value = rb.consume();
					System.out.printf("%d - %c\n", iter++, value);
					try {Thread.sleep(100);} catch (Exception e){}
				buf.release();
			} catch (Exception e) {e.printStackTrace(System.out);}
		}
		System.out.println("Consumer: ends");

	}
}
                      
