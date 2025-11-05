package com.threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class StockQuantity {

	public static void main(String[] args) {
		Stock stock = new Stock(10, "BWL");
		int threadCount = 10;
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		for(int i = 0; i<threadCount; i++) {
			int taskId = i;
			executor.submit(()->{
				int qty = ThreadLocalRandom.current().nextInt(1, 6);
				boolean status = stock.buyStock(qty);
				System.out.println("Thread no "+taskId + "with quantity: "+qty+" with status: "+ status);
			});
		}
		
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
	}

}
