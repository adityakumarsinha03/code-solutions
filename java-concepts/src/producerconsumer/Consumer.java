package producerconsumer;

public class Consumer implements Runnable {

	BufferQ bufferQ;

	Consumer(BufferQ bufferQ) {
		this.bufferQ = bufferQ;
		new Thread(this, "Consumer").start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			bufferQ.get();
		}
	}
}