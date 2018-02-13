/**
 * Server.java
 *
 * This creates the buffer and the producer and consumer threads.
 * @author Christopher Blair
 * @original program creators Greg Gagne, Peter Galvin, Avi Silberschatz
 * 
 * @date 2/10/2018
 * 
 * @problem Your task in this assignment is to create a multithreaded program to
 * do the following: the Server class should create two producer threads 
 * identified as “John” and “Liz”; it should create two consumer threads 
 * identified as “Mary” and “Bert”; John & Mary share a buffer; Liz & Bert 
 * share a different buffer.
 */

public class Server
{
	public static void main(String args[]) {
                //Creates servers for both pairs of producers and consumers
		BoundedBuffer server1 = new BoundedBuffer();
                BoundedBuffer server2 = new BoundedBuffer();
                        
                
      		// now create the producer and consumer threads and set names for each of them

      		Producer producerThreadJohn = new Producer(server1);
                producerThreadJohn.setNme("John");
      		Consumer consumerThreadMary = new Consumer(server1);
                consumerThreadMary.setNme("Mary");
                
                Producer producerThreadLiz = new Producer(server2);
                producerThreadLiz.setNme("Liz");
      		Consumer consumerThreadBert = new Consumer(server2);
                consumerThreadBert.setNme("Bert");

      		producerThreadJohn.start();
      		consumerThreadMary.start();
                
                producerThreadLiz.start();
      		consumerThreadBert.start();

	}//main
}//class
