package com.designproblems.leetcode;


/**
 * 551. Student Attendance Record I
 * <p>
 * Question Link: https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * <p>
 * You are given a string s representing an attendance record for a student where each character
 * signifies whether the student was absent, late, or present on that day. The record only contains
 * the following three characters:
 * <ul>
 * <p>
 *  'A': Absent.
 *  'L': Late.
 *  'P': Present.
 * The student is eligible for an attendance award if they meet both of the following criteria:
 * <p>
 * The student was absent ('A') for strictly fewer than 2 days total.
 * The student was never late ('L') for 3 or more consecutive days.
 * Return true if the student is eligible for an attendance award, or false otherwise.
 * <p>
 * <ul/>
 *
 * <ul>
 * <p>
 *    Example 1:
 *        Input: s = "PPALLP"
 *        Output: true
 *        Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
 * <p>
 *    Example 2:
 *        Input: s = "PPALLL"
 *        Output: false
 *          Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
 * <p>
 * <p>
 *  Constraints:
 *      1 <= s.length <= 1000
 *      s[i] is either 'A', 'L', or 'P'.
 * <p>
 * <ul/>
 */
public class StudentAttendanceRecord1 {

  public boolean checkRecord(String s) {
    int late = 0;
    int abs = 0;
    for (int i = 0; i < s.length(); i++) {
      int l = 0;
      while (i < s.length() && s.charAt(i) == 'L') {
        i++;
        l++;
      }
      late = Math.max(l, late);
      if (i < s.length() && s.charAt(i) == 'A') {
        abs++;
      }
    }
    return abs < 2 && late < 3;
  }

  public static void main(String[] args) {
    StudentAttendanceRecord1 obj = new StudentAttendanceRecord1();
    System.out.println(obj.checkRecord("PPALLP"));
    System.out.println(obj.checkRecord("PPALLL"));
  }

}
