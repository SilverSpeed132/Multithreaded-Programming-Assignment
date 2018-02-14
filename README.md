# Multithreaded-Programming-Assignment

What is this project?

This project is a multithreaded program to show how shared memory works.  In one Server class, two producers and two consumers are made and
paired up to produce and consume.

Why was this project made?

I made this project (although a portion was given to me by my professor) as an assignment for my Fundamentals of Computer Operating Systems
course.  

Software used for this project:
- Java JDK 1.8.0_162

Main Program Explanation:
- Server.java
  - The main method creates two BoundedBuffer objects called server1 and server2, which will be used by the producers and consumers
  - Then, the first producer/consumer combo is made and named, and after that, the second combo is made and named
  - Finally, the threads are started
- Producer.java
  - The producer class creates a random number between 8000 and 50000 and puts it into the buffer for the consumer, and then sleeps for a
  random amount of time between 1 and 7 seconds
- Consumer.java
  - The consumer class consumes whatever the producer has put into the buffer (assuming something is in there in the first place), and
  also determines whether or not the item consumed is prime or not.
  - The consumer also falls asleep for a random amount of time between 1 and 12.
- BoundedBuffer.java
  - This class handles entering (using the enter method) what the producer makes and removing (using the remove method) what 
  the consumer takes.
  - It also handles outputting messages should the Buffer be full or empty.
