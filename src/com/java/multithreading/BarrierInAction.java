package com.java.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BarrierInAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Friend implements Callable<String>{
			 
			private CyclicBarrier barrier;
			
			public Friend(CyclicBarrier barrier) {
				this.barrier=barrier;
			}

			@Override
			public String call() throws Exception {
				// TODO Auto-generated method stub
				Random random= new Random();
				Thread.sleep(random.nextInt(20)*100+ 100);
				System.out.println("I just arrived, waiting for others");
				barrier.await();
				System.out.println("Let's go to the cienma!");
				return "ok";
			}			
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		
		CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier Opening..."));
		List<Future<String>> futures = new ArrayList<>();
		
		try 
		{
			for(int i=0;i<4;i++) {
				Friend friend = new Friend(barrier);
				futures.add(executorService.submit(friend));
			}
			
			futures.forEach(
					future -> {
						try {
							future.get();
							//System.out.println(future.get());
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
