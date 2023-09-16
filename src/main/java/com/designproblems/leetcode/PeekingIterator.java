package com.designproblems.leetcode;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * 284. Peeking Iterator
 * <p>
 * Question Link: https://leetcode.com/problems/peeking-iterator/description/
 *
 * <p>
 * Design an iterator that supports the peek operation on an existing iterator in addition to the
 * hasNext and the next operations.
 * <p>
 * Implement the PeekingIterator class:
 * <p>
 * PeekingIterator(Iterator<int> nums) Initializes the object with the given integer iterator
 * iterator. int next() Returns the next element in the array and moves the pointer to the next
 * element. boolean hasNext() Returns true if there are still elements in the array. int peek()
 * Returns the next element in the array without moving the pointer. Note: Each language may have a
 * different implementation of the constructor and Iterator, but they all support the int next() and
 * boolean hasNext() functions.
 *
 *
 * <ul>
 *    Example 1:
 *    Input: ["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
 *           [[[1, 2, 3]], [], [], [], [], []]
 *    Output
 *          [null, 1, 2, 2, 3, false]
 * <p>
 *  Explanation
 *      PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
 *      peekingIterator.next();    // return 1, the pointer moves to the next element [1,2,3].
 *      peekingIterator.peek();    // return 2, the pointer does not move [1,2,3].
 *      peekingIterator.next();    // return 2, the pointer moves to the next element [1,2,3]
 *      peekingIterator.next();    // return 3, the pointer moves to the next element [1,2,3]
 *      peekingIterator.hasNext(); // return False
 * <p>
 * <p>
 *  Constraints:
 * <p>
 *    1 <= nums.length <= 1000
 *    1 <= nums[i] <= 1000
 *    All the calls to next and peek are valid.
 *    At most 1000 calls will be made to next, hasNext, and peek.
 * <ul/>
 * <p>
 *  Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class PeekingIterator<T> implements Iterator<T> {

  Iterator<T> iterator = null;
  T peek = null;

  public PeekingIterator(Iterator<T> iterator) {
    this.iterator = iterator;
  }

  // Returns the next element in the iteration without advancing the iterator.
  public T peek() {
    if (peek == null) {
      if (!this.iterator.hasNext()) {
        throw new RuntimeException("No more elements found");
      }
      peek = this.iterator.next();
    }
    return peek;
  }

  @Override
  public boolean hasNext() {
    return this.peek != null || this.iterator.hasNext();
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public T next() {
    if (this.peek != null) {
      T tmp = peek;
      this.peek = null;
      return tmp;
    }
    return this.iterator.next();
  }

  public static void main(String[] args) {
    PeekingIterator peekItr = new PeekingIterator(IntStream.range(1, 15).iterator());
    while (peekItr.hasNext()) {
      System.out.println("Peek: " + peekItr.peek() + " , Next: " + peekItr.next());
    }
  }
}
