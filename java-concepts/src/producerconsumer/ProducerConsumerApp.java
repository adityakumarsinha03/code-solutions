package producerconsumer;

public class ProducerConsumerApp {

	public static void main(String args[]) {
		// creating buffer queue
		BufferQ bufferQ = new BufferQ();

		// starting consumer thread
		new Consumer(bufferQ);

		// starting producer thread
		new Producer(bufferQ);
	}
}