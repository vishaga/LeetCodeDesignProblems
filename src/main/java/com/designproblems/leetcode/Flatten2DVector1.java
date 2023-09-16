package com.designproblems.leetcode;

import java.util.stream.IntStream;

/**
 * 251. Flatten 2D Vector
 * <p>
 * Question Link: https://leetcode.com/problems/flatten-2d-vector/description/
 *
 * <p>
 * Design an iterator to flatten a 2D vector. It should support the next and hasNext operations.
 * <p>
 * Implement the Vector2D class:
 * <p>
 * Vector2D(int[][] vec) initializes the object with the 2D vector vec. next() returns the next
 * element from the 2D vector and moves the pointer one step forward. You may assume that all the
 * calls to next are valid. hasNext() returns true if there are still some elements in the vector,
 * and false otherwise.
 *
 * <ul>
 *    Example 1:
 * <p>
 *    Input
 *        ["Vector2D", "next", "next", "next", "hasNext", "hasNext", "next", "hasNext"]
 *        [[[[1, 2], [3], [4]]], [], [], [], [], [], [], []]
 *    Output
 *        [null, 1, 2, 3, true, true, 4, false]
 * <p>
 * Explanation
 * Vector2D vector2D = new Vector2D([[1, 2], [3], [4]]);
 * vector2D.next();    // return 1
 * vector2D.next();    // return 2
 * vector2D.next();    // return 3
 * vector2D.hasNext(); // return True
 * vector2D.hasNext(); // return True
 * vector2D.next();    // return 4
 * vector2D.hasNext(); // return False
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= vec.length <= 200
 * 0 <= vec[i].length <= 500
 * -500 <= vec[i][j] <= 500
 * At most 105 calls will be made to next and hasNext.
 * <ul/>
 * <p>
 * Follow up: As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVector1 {

  int array[][];
  //outer variable tracks current sub-array index
  int outer = 0;
  //inner variable tracks current index within sub-array
  int inner = 0;

  public Flatten2DVector1(int[][] vec) {
    this.array = vec;
  }

  public int next() {
    if (!hasNext()) {
      throw new RuntimeException("No more elements");
    }
    return array[outer][inner++];
  }

  public boolean hasNext() {
    nextValidSubArray();
    return outer < array.length;
  }

  private void nextValidSubArray() {
    while (outer < array.length && inner == array[outer].length) {
      inner = 0;
      outer++;
    }
  }

  public static void main(String[] args) {
    int input[][] = {{}, {}, {1, 2, 3, 4}, {5, 6}, {}, {7}, {8, 9, 10}};
    Flatten2DVector1 v1 = new Flatten2DVector1(input);
    IntStream.range(0, 10).forEach(x -> {
      System.out.println("hasNext(): " + v1.hasNext() + ", next(): " + v1.next());
    });
  }
}
