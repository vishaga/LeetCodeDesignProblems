package com.designyourown;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

  int numberOfThreads;
  Thread threads[];
  BlockingQueue<Runnable> taskQueue;

  public ThreadPool(int numberOfThreads) {
    this.numberOfThreads = numberOfThreads;
    threads = new Thread[numberOfThreads];
    for (int i = 0; i < numberOfThreads; i++) {
      threads[i] = new Thread(() -> {
        while (!this.taskQueue.isEmpty()) {
          this.taskQueue.poll().run();
        }
      }, "Thread-" + i);
    }
    this.taskQueue = new LinkedBlockingQueue<>();
  }

  public void execute(List<Runnable> tasks) {
    this.taskQueue.addAll(tasks);
    run();

  }

  private void run() {
    for (Thread thread : threads) {
      thread.start();
    }
  }
}
