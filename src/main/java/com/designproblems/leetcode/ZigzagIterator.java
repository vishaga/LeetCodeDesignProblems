package com.designproblems.leetcode;

import com.sun.tools.javac.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Given two vectors of integers v1 and v2, implement an iterator to return their elements
 * alternately.
 * <p>
 * Implement the ZigzagIterator class:
 * <p>
 * ZigzagIterator(List<int> v1, List<int> v2) initializes the object with the two vectors v1 and v2.
 * boolean hasNext() returns true if the iterator still has elements, and false otherwise. int
 * next() returns the current element of the iterator and moves the iterator to the next element.
 *
 * <ul>
 * Example 1:
 * <p>
 * Input: v1 = [1,2], v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].
 * Example 2:
 * <p>
 * Input: v1 = [1], v2 = []
 * Output: [1]
 * Example 3:
 * <p>
 * Input: v1 = [], v2 = [1]
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= v1.length, v2.length <= 1000
 * 1 <= v1.length + v2.length <= 2000
 * -231 <= v1[i], v2[i] <= 231 - 1
 * <ul/>
 *
 * <ul>
 * Follow up: What if you are given k vectors? How well can your code be extended to such cases?
 * <p>
 * Clarification for the follow-up question:
 * <p>
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 * <p>
 * Follow-up Example:
 * <p>
 * Input: v1 = [1,2,3], v2 = [4,5,6,7], v3 = [8,9]
 * Output: [1,4,8,2,5,9,3,6,7]
 * <p>
 * <ul/>
 */
public class ZigzagIterator {

  List<List<Integer>> inputs;
  LinkedList<Pair<Integer, Integer>> queue;
  int index = 0;

  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    this.inputs = new ArrayList<List<Integer>>();
    this.queue = new LinkedList<Pair<Integer, Integer>>();
    this.inputs.add(v1);
    this.inputs.add(v2);
    for (List<Integer> vec : this.inputs) {
      if (!vec.isEmpty()) {
        this.queue.add(new Pair<Integer, Integer>(index, 0));
      }
      index++;
    }
  }

  public int next() {
    Pair<Integer, Integer> pointer = this.queue.removeFirst();
    int listIndex = pointer.fst;
    int index = pointer.snd;
    if (index + 1 < this.inputs.get(listIndex).size()) {
      this.queue.addLast(new Pair<Integer, Integer>(listIndex, index + 1));
    }
    return this.inputs.get(listIndex).get(index);
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }

  public static void main(String[] args) {
    List<Integer> l1 = Arrays.asList(1, 2);
    List<Integer> l2 = Arrays.asList(3, 4, 5, 6);
    ZigzagIterator obj = new ZigzagIterator(l1, l2);
    for (int i = 0; i < 6; i++) {
      if (obj.hasNext()) {
        System.out.println(obj.next());
      }
    }
  }

}
