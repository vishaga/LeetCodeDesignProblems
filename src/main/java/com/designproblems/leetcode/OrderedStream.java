package com.designproblems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 *
 * <p>
 * Question Link: https://leetcode.com/problems/design-an-ordered-stream/description/
 *
 * <p>
 * There is a stream of n (idKey, value) pairs arriving in an arbitrary order, where idKey is an
 * integer between 1 and n and value is a string. No two pairs have the same id.
 * <p>
 * Design a stream that returns the values in increasing order of their IDs by returning a chunk
 * (list) of values after each insertion. The concatenation of all the chunks should result in a
 * list of the sorted values.
 * <p>
 * Implement the OrderedStream class:
 *
 * <p>
 * OrderedStream(int n) Constructs the stream to take n values. String[] insert(int idKey, String
 * value) Inserts the pair (idKey, value) into the stream, then returns the largest possible chunk
 * of currently inserted values that appear next in the order.
 *
 * <ul>
 *    Example:
 * <p>
 * <p>
 * <p>
 *          Input
 *              ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 *              [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 *          Output
 *              [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 * <p>
 *    Explanation
 *        // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
 *        OrderedStream os = new OrderedStream(5);
 *        os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
 *        os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
 *        os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
 *        os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
 *        os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
 *        // Concatentating all the chunks returned:
 *        // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
 *        // The resulting order is the same as the order above.
 * <p>
 * <p>
 *  Constraints:
 * <p>
 *    1 <= n <= 1000
 *    1 <= id <= n
 *    value.length == 5
 *    value consists only of lowercase letters.
 *    Each call to insert will have a unique id.
 *    Exactly n calls will be made to insert.
 * <p>
 * <ul/>
 */
public class OrderedStream {

  String container[];
  int pointer = 0;

  public OrderedStream(int n) {
    container = new String[n];
  }

  public List<String> insert(int idKey, String value) {
    List<String> result = new ArrayList<>();
    container[idKey - 1] = value;
    while (pointer < container.length && container[pointer] != null) {
      result.add(container[pointer]);
      pointer++;
    }
    return result;
  }

  public static void main(String[] args) {
    OrderedStream os = new OrderedStream(5);
    System.out.println(os.insert(3, "ccccc"));
    System.out.println(os.insert(1, "aaaaa"));
    System.out.println(os.insert(2, "bbbbb"));
    System.out.println(os.insert(5, "eeeee"));
    System.out.println(os.insert(4, "ddddd"));
  }

}
