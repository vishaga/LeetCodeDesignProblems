package com.designproblems.leetcode;

import java.util.stream.IntStream;

/**
 * 604. Design Compressed String Iterator
 * <p>
 * Question Link: https://leetcode.com/problems/design-compressed-string-iterator/description/
 *
 * <p>
 * Design and implement a data structure for a compressed string iterator. The given compressed
 * string will be in the form of each letter followed by a positive integer representing the number
 * of this letter existing in the original uncompressed string.
 *
 * <p>
 * Implement the StringIterator class:
 * <p>
 * next() Returns the next character if the original string still has uncompressed characters,
 * otherwise returns a white space. hasNext() Returns true if there is any letter needs to be
 * uncompressed in the original string, otherwise returns false.
 *
 * <ul>
 *   Example 1:
 * <p>
 *      Input
 *            ["StringIterator", "next", "next", "next", "next", "next", "next", "hasNext", "next", "hasNext"]
 *            [["L1e2t1C1o1d1e1"], [], [], [], [], [], [], [], [], []]
 *      Output
 *            [null, "L", "e", "e", "t", "C", "o", true, "d", true]
 * <p>
 *    Explanation
 *          StringIterator stringIterator = new StringIterator("L1e2t1C1o1d1e1");
 *          stringIterator.next(); // return "L"
 *          stringIterator.next(); // return "e"
 *          stringIterator.next(); // return "e"
 *          stringIterator.next(); // return "t"
 *          stringIterator.next(); // return "C"
 *          stringIterator.next(); // return "o"
 *          stringIterator.hasNext(); // return True
 *          stringIterator.next(); // return "d"
 *          stringIterator.hasNext(); // return True
 * <p>
 * <p>
 *    Constraints:
 * <p>
 *            1 <= compressedString.length <= 1000
 *            compressedString consists of lower-case an upper-case English letters and digits.
 *            The number of a single character repetitions in compressedString is in the range [1, 10^9]
 *            At most 100 calls will be made to next and hasNext.
 * <ul/>
 */
public class CompressedStringIterator {

  String input;
  int index;
  int charIndex;
  int frequency = 0;

  public CompressedStringIterator(String str) {
    this.input = str;
  }

  public char next() {
    if (!hasNext()) {
      return '!';
    }
    if (this.frequency == 0) {
      calculate();
    }
    this.frequency--;
    return this.input.charAt(charIndex);
  }

  public boolean hasNext() {
    return index < this.input.length() || this.frequency > 0;
  }

  private void calculate() {
    this.charIndex = index++;
    while (index < this.input.length() && input.charAt(index) >= '0' && input.charAt(index) <= '9') {
      this.frequency = this.frequency * 10 + input.charAt(index++) - '0';
    }
  }

  public static void main(String[] args) {
    CompressedStringIterator itr = new CompressedStringIterator("L1e2t1C1o1d1e1");
    IntStream.range(1, 10).forEach(s -> System.out.print(itr.next()));
    System.out.println();
    CompressedStringIterator itr2 = new CompressedStringIterator("L3e4t1C1o1d5e1");
    IntStream.range(1, 18).forEach(s -> System.out.print(itr2.next()));
  }

}
