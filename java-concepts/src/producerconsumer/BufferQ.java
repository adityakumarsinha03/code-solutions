package producerconsumer;

import java.util.concurrent.Semaphore;

public class BufferQ {

	static Semaphore semConsumer = new Semaphore(0);
	static Semaphore semProducer = new Semaphore(1);

	int item;

	public void get() {
		try {
			// Before consumer can consume an item,
            // it must acquire a permit from semConsumer
			semConsumer.acquire();
		} catch (InterruptedException ex) {
			System.out.println("InterruptedException !!");
		}
		System.out.println("Consumer consumed " + item);
		
		// After consumer consumes the item,
        // it releases semProducer to notify producer
		semProducer.release();
	}

	public void put(int item) {
		try {
			// Before producer can produce an item,
            // it must acquire a permit from semProducer
			semProducer.acquire();
		} catch (InterruptedException ex) {
			System.out.println("InterruptedException !!");
		}
		this.item = item;

		System.out.println("Producer produced " + item);
		
		// After producer produces the item,
        // it releases semConsumer to notify consumer
		semConsumer.release();
	}
}