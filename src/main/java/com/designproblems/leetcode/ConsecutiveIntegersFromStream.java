package com.designproblems.leetcode;


/**
 * 2526. Find Consecutive Integers from a Data Stream
 * <p>
 * Question Link: https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/description/
 *
 * <p>
 * For a stream of integers, implement a data structure that checks if the last k integers parsed in
 * the stream are equal to value.
 *
 * <p>
 * Implement the DataStream class:
 *
 * <p>
 * DataStream(int value, int k) Initializes the object with an empty integer stream and the two
 * integers value and k. boolean consec(int num) Adds num to the stream of integers. Returns true if
 * the last k integers are equal to value, and false otherwise. If there are less than k integers,
 * the condition does not hold true, so returns false.
 * <ul>
 * <p>
 *    Example 1:
 * <p>
 *        Input
 *              ["DataStream", "consec", "consec", "consec", "consec"]
 *              [[4, 3], [4], [4], [4], [3]]
 *        Output
 *              [null, false, false, true, false]
 * <p>
 *    Explanation
 *        DataStream dataStream = new DataStream(4, 3); //value = 4, k = 3
 *        dataStream.consec(4); // Only 1 integer is parsed, so returns False.
 *        dataStream.consec(4); // Only 2 integers are parsed.
 *                              // Since 2 is less than k, returns False.
 *        dataStream.consec(4); // The 3 integers parsed are all equal to value, so returns True.
 *        dataStream.consec(3); // The last k integers parsed in the stream are [4,4,3].
 *                              // Since 3 is not equal to value, it returns False.
 * <p>
 * <p>
 *  Constraints:
 *      1 <= value, num <= 109
 *      1 <= k <= 105
 *      At most 105 calls will be made to consec.
 * <ul/>
 */
public class ConsecutiveIntegersFromStream {

  int count = 0;
  int val = 0;
  int k = 0;

  public ConsecutiveIntegersFromStream(int value, int k) {
    this.k = k;
    this.val = value;
  }

  public boolean consec(int num) {
    if (num != this.val) {
      count = 0;
      return false;
    }
    return ++count >= this.k;
  }

  public static void main(String[] args) {
    ConsecutiveIntegersFromStream obj = new ConsecutiveIntegersFromStream(3, 3);
    int inputs[] = {3, 3, 3, 4, 5, 3, 3, 2, 3, 3, 3, 3};
    for (int x : inputs) {
      System.out.print(obj.consec(x) + ", ");
    }

  }

}
