import java.util.concurrent.*;

public class Producer implements Runnable {
	Thread t;
	RingBuffer rb;
	Semaphore buf = null;
	Semaphore s1 = null;
	Semaphore prod = null;

        Producer(RingBuffer r, Semaphore t1, Semaphore t2, Semaphore pro) {
		rb = r;
		buf = t1;
		s1 = t2;
		prod = pro;
                t = new Thread(this, "Producer");
                t.start();
        }


        public void run() {
		byte value=65;
		boolean running=true;

		System.out.println("Producer: starts");
		while (running) {
			try{
				buf.acquire();
					prod.acquire();
						rb.produce(value++);
						if (value == 91) value=65;
					prod.release();
					try {Thread.sleep(10);} catch (Exception e){}
				s1.release();
			} catch (Exception e) {e.printStackTrace(System.out);}
		}
		System.out.println("Producer: ends");

	}
}
                      
