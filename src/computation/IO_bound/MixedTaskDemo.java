package computation.IO_bound;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MixedTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
            // Simulate CPU-bound operation
            for (int i = 0; i < 1_000_000; i++) {
                // Some heavy computation
                Math.sqrt(i);
            }
            System.out.println("CPU-bound task finished");
        }).thenRunAsync(() -> {
            // Simulate I/O-bound operation (e.g., database access)
            try {
                Thread.sleep(2000); // Simulate I/O delay
                System.out.println("I/O-bound task finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        task.get();
    }
}
