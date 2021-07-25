package producerconsumer;

public class Producer implements Runnable {

	BufferQ bufferQ;

	Producer(BufferQ bufferQ) {
		this.bufferQ = bufferQ;
		new Thread(this, "Producer").start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			bufferQ.put(i);
		}
	}
}