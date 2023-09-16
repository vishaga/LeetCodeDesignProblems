package com.designproblems.leetcode;

import java.util.ArrayList;
import java.util.List;
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

// Bad Design as it creating own object.
public class Flatten2DVector2 {

  List<Integer> list = new ArrayList<>();
  int index = 0;

  public Flatten2DVector2(int[][] vec) {
    for (int array[] : vec) {
      for (int x : array) {
        list.add(x);
      }
    }
  }

  public int next() {
    if (!hasNext()) {
      throw new RuntimeException("No more elements");
    }
    return list.get(index++);
  }

  public boolean hasNext() {
    return index < list.size();
  }

  public static void main(String[] args) {
    int input[][] = {{}, {}, {1, 2, 3, 4}, {5, 6}, {}, {7}, {8, 9, 10}};
    Flatten2DVector2 v2 = new Flatten2DVector2(input);
    IntStream.range(0, 10).forEach(x -> {
      System.out.println("hasNext(): " + v2.hasNext() + ", next(): " + v2.next());
    });
  }
}
