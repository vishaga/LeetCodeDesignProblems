package com.designproblems.leetcode;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 346. Moving Average from Data Stream
 * <p>
 * Question Link: https://leetcode.com/problems/moving-average-from-data-stream/
 *
 * <p>
 * Given a stream of integers and a window size, calculate the moving average of all integers in the
 * sliding window.
 * <p>
 * Implement the MovingAverage class:
 * <p>
 * MovingAverage(int size) Initializes the object with the size of the window size. double next(int
 * val) Returns the moving average of the last size values of the stream.
 *
 * <ul>
 * Example 1:
 * <p>
 * Input
 * ["MovingAverage", "next", "next", "next", "next"]
 * [[3], [1], [10], [3], [5]]
 * Output
 * [null, 1.0, 5.5, 4.66667, 6.0]
 * <p>
 * Explanation
 * MovingAverage movingAverage = new MovingAverage(3);
 * movingAverage.next(1); // return 1.0 = 1 / 1
 * movingAverage.next(10); // return 5.5 = (1 + 10) / 2
 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
 * movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= size <= 1000
 * -105 <= val <= 105
 * At most 104 calls will be made to next.
 * <ul/>
 */
public class MovingAverage {

  int array[];
  double sum = 0;
  int size = 0;
  int index = 0;

  public MovingAverage(int size) {
    this.array = new int[size];
    this.size = size;
  }

  public double next(int val) {
    index++;
    if (index <= this.array.length) {
      this.array[(index - 1) % size] = val;
      sum += val;
      return sum / index;
    } else {
      sum -= this.array[(index - 1) % size];
      this.array[(index - 1) % size] = val;
      sum += val;
      return sum / size;
    }
  }

  public static void main(String[] args) {
    MovingAverage avg = new MovingAverage(3);
    IntStream.range(1, 20).forEach(x -> {
      System.out.println(avg.next(x) + " ->" + Arrays.toString(avg.array));
    });
  }
}
