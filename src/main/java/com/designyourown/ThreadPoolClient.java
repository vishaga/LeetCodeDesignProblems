package com.designyourown;

import java.util.ArrayList;
import java.util.List;

public class ThreadPoolClient {

  public static void main(String[] args) throws Exception {
    List<Runnable> tasks = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      tasks.add(new Runnable() {
        @Override
        public void run() {
          try {
            long d = (long) Math.nextAfter(5, 9);
            Thread.sleep(d * 1000L);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println(Thread.currentThread().getName() + " is executing task.");
        }
      });
    }

    ThreadPool pool = new ThreadPool(4);
    pool.execute(tasks);
    Thread.sleep(100000);
  }
}
