public class Uber_14thjune {

}

// Given an array, return the minimum number of operations required to make all
// the elements of the array continuous. In one operation, any element of the
// array can be replaced with any integer.

// Example

// For arr = [6, 4, 1, 7, 10], the output should be
// continuousElementsArray(arr) = 2.

// In this example, the minimum number of operations needed to make all the
// elements of the array continuous is 2. You could replace 1 with 5 and 10 with
// 8 so that array will become arr = [6, 4, 5, 7, 8] which has continuous
// elelements.

// Input/Output

// [execution time limit] 3 seconds (java)

// [input] array.integer arr

// Guaranteed constraints:
// 1 ≤ arr.length ≤ 105,
// 1 ≤ arr[i] ≤ 109,
// All the elements in the array are distinct.

// [output] integer

// The minimum number of operations required to make all the elements of the
// array continuous.

/**
 * task --> 2
 * 
 * You are given an array of integers a, where each element a[i] represents the
 * length of a rope.
 * 
 * Your goal is to obtain k ropes of the same length, by cutting the ropes into
 * as many pieces as you want.
 * 
 * Your task is to calculate the maximum integer length L for which it is
 * possible to obtain at least k ropes of length L by cutting the given ones.
 * 
 * Example
 * 
 * For a = [5, 2, 7, 4, 9] and k = 5, the output should be cutTheRopes(a, k) =
 * 4.
 * 
 * example
 * 
 * Here's a way to achieve 5 ropes of length 4:
 * 
 * Cut the rope of length 5 into one rope of length 1 (which can be discarded)
 * and one rope of length 4. Cut the rope of length 7 into one rope of length 3
 * (which can be discarded) and one rope of length 4. Use the existing rope of
 * length 4 (no need to cut it) Cut the rope of length 9 into two ropes of
 * length 4 (and one of length 1 which can be discarded) Discard the rope of
 * length 2. And since it wouldn't be possible to make 5 ropes of any greater
 * length, the answer is 4.
 * 
 * For a = [1, 2, 3, 4, 9] and k = 6, the output should be cutTheRopes(a, k) =
 * 2.
 * 
 * Here's one way we could make 6 ropes of length 2:
 * 
 * Cut the rope of length 9 into four ropes of length 2 and one rope of length 1
 * (which won't be used). Cut the rope of length 4 into two ropes of length 2.
 * Ignore all other ropes (1, 2, and 3). Even though ropes with lengths 2 and 3
 * can also be used to obtain the rope of length 2, we don't need more than 6
 * ropes of that length. It would technically be possible to make 6 ropes of a
 * length as great as 2.25, but since only integer values are allowed, the
 * answer is 2.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.integer a
 * 
 * An array of the ropes' lengths.
 * 
 * Guaranteed constraints: 1 ≤ a.length ≤ 105, 1 ≤ a[i] ≤ 109.
 * 
 * [input] integer k
 * 
 * The number of equal-length ropes you need to obtain. It is guaranteed that it
 * is possible to obtain this number of ropes from the values in a.
 * 
 * Guaranteed constraints: 1 ≤ k ≤ min(sum(a[i]), 109).
 * 
 * [output] integer
 * 
 * The maximum possible length of the obtained k ropes.
 */

/**
 * 
 * Task --> 3
 * 
 * A vacuum cleaning robot is located at the charging station, which is at the
 * top-left corner of the room.
 * 
 * The robot has a built-in map of the room, which is an m x n grid and a
 * battery with limited capacity.
 * 
 * The floorPlan localizes obstacles and empty spaces, which are marked as 1 and
 * 0 respectively in the grid. Initially, all the cells in the grid are dirty.
 * Whenever the robot moves over a cell, it will clean the cell if it was dirty
 * (It won't do anything if a cell is already cleaned).
 * 
 * Every time the robot executes a move (including leaving the charging station)
 * the battery is reduced by 1. Note that the robot can move only in left,
 * right, up and down. It cannot move diagonally.
 * 
 * The robot should return to the charging station before running out of
 * battery. Write a function that returns the maximum number of cells that can
 * be cleaned by the robot.
 * 
 * Example
 * 
 * Input: floorPlan (grid) 0 0 0 0 1 0 0 0 0
 * 
 * Battery Capacity 6
 * 
 * Output: 3
 * 
 * Here robot can take the following path: (0, 0) -> (0, 1) -> (0, 2) -> (0, 1)
 * -> (0, 0). Here 3 cells ((0, 0), (0, 1), (0, 2)) are cleaned and robot
 * reaches back to (0, 0) before running out of battery.
 * 
 * Note that after (0, 2), if robot moves to (1, 2), it won't be able to reach
 * the starting position before running out of battery, so it cannot clean that
 * cell. Also, here (0, 0) -> (0, 1) -> (1, 1) -> (1, 0) -> (0, 0) is an invalid
 * path because robot can't move on cell (1, 1) as it has obstacle.
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] array.array.boolean floorPlan
 * 
 * [input] integer battery
 * 
 * Capacity of the battery
 * 
 * Guaranteed constraints: 1 ≤ floorPlan.length ≤ 10, 1 ≤ floorPlan[i] ≤ 10, 1 ≤
 * battery ≤ 12, Charging station won't have obstacle
 * 
 * [output] integer
 * 
 * The maximum number of cells that can be cleaned. Note that the robot can't
 * move on the cells having obstacles and should return to the charging station
 * before running out of battery.
 */