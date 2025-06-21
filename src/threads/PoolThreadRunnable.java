package threads;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable{

    private Thread thread = null;
    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    @Override
    public void run() {

    }
}
