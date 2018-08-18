package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		List<Integer> buffer=new ArrayList<>();
		Lock lock=new ReentrantLock();
		Condition isEmpty=lock.newCondition();
		Condition isFull=lock.newCondition();
		
		class Consumer implements Callable<String>{
			public String call() throws InterruptedException {
				int count=0;
				while(count++ < 50) {
				try {
					lock.lock();
					while(isEmpty(buffer)) {
						isEmpty.await();
						//isEmpty.await(10, TimeUnit.MILLISECONDS);
						
					}
					buffer.remove(buffer.size()-1);
					isEmpty.signalAll();
				}finally {
					lock.unlock();
				}
				}
				return "Consumed " + (count -1);
			}

			private boolean isEmpty(List<Integer> buffer) {
				// TODO Auto-generated method stub
				return false;
			}
		}
		
		class Producer implements Callable<String>{
			public String call() throws InterruptedException {
				int count=0;
				while(count++ < 50) {
				try {
					lock.lock();
					//int i=10/0;
					while(isFull(buffer)) {
						//wait
						isFull.await();
						
					}
					buffer.add(1);
					//signal
					isEmpty.signalAll();
				}finally {
					lock.unlock();
				}
				}
				return "Produced " + (count -1);
			}

			private boolean isFull(List<Integer> buffer) {
				// TODO Auto-generated method stub
				return false;
			}
		}
		
		List<Producer> producers = new ArrayList<>();
		for(int i=0;i<4;i++) {
			producers.add(new Producer());
		}
		
		List<Consumer> consumers = new ArrayList<>();
		for(int i=0;i<4;i++) {
			consumers.add(new Consumer());
		}
		
		System.out.println("Producer and Consumer Launched");
		
		List<Callable<String>> producersAndConsumers = new ArrayList<>();
		producersAndConsumers.addAll(producers);
		producersAndConsumers.addAll(consumers);
		
		ExecutorService executorService=Executors.newFixedThreadPool(8);
		try {
			List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
			futures.forEach(
						future -> {
							try {
								System.out.println(future.get());
							}catch(InterruptedException | ExecutionException e) {
								System.out.println("Exception:" + e.getMessage());
							}
						});
			}finally {
				executorService.shutdown();
				System.out.println("Executor service shut down");
			}
	}

}
