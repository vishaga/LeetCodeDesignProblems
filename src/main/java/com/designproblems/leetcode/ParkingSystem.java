package com.designproblems.leetcode;

/**
 * 1603. Design Parking System
 * <p>
 * Question Link: https://leetcode.com/problems/design-parking-system/description/
 * <p>
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces:
 * big, medium, and small, with a fixed number of slots for each size.
 * <p>
 * Implement the ParkingSystem class:
 * <p>
 * ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The
 * number of slots for each parking space are given as part of the constructor. bool addCar(int
 * carType) Checks whether there is a parking space of carType for the car that wants to get into
 * the parking lot. carType can be of three kinds: big, medium, or small, which are represented by
 * 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no
 * space available, return false, else park the car in that size space and return true.
 *
 * <ul>
 *  Example 1:
 * <p>
 *      Input
 *            ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 *            [[1, 1, 0], [1], [2], [3], [1]]
 *      Output
 *            [null, true, true, false, false]
 * <p>
 *  Explanation
 *    ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 *    parkingSystem.addCar(1); // return true because there is 1 available slot for a big car
 *    parkingSystem.addCar(2); // return true because there is 1 available slot for a medium car
 *    parkingSystem.addCar(3); // return false because there is no available slot for a small car
 *    parkingSystem.addCar(1); // return false because there is no available slot for a big car. It is already occupied.
 * <p>
 * <p>
 *  Constraints:
 * <p>
 *    0 <= big, medium, small <= 1000
 *    carType is 1, 2, or 3
 *    At most 1000 calls will be made to addCar
 * <ul/>
 */
public class ParkingSystem {

  //size of 3 coz there are only 3 types of parking/cars.
  int spaces[] = new int[3];

  public ParkingSystem(int big, int medium, int small) {
    spaces[0] = big;
    spaces[1] = medium;
    spaces[2] = small;
  }

  public boolean addCar(int carType) {
    spaces[carType - 1] -= 1;
    return spaces[carType - 1] >= 0;
  }

  public static void main(String[] args) {
    ParkingSystem ps = new ParkingSystem(2, 1, 0);
    System.out.println("Park Big Car: " + ps.addCar(1));
    System.out.println("Park Big Car: " + ps.addCar(1));
    System.out.println("Park Big Car: " + ps.addCar(1));
    System.out.println("Park Medium Car: " + ps.addCar(2));
    System.out.println("Park Small Car: " + ps.addCar(3));
  }

}
