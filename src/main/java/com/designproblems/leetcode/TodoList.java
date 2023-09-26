package com.designproblems.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 2590. Design a Todo List
 *
 * <p>
 * * Question Link: https://leetcode.com/problems/design-a-todo-list/description/
 *
 * <p>
 * Design a Todo List Where users can add tasks, mark them as complete, or get a list of pending
 * tasks. Users can also add tags to tasks and can filter the tasks by certain tags.
 * <p>
 * Implement the TodoList class:
 *
 * <p>
 * TodoList() Initializes the object.
 * <p>
 * int addTask(int userId, String taskDescription, int dueDate, List<String> tags) Adds a task for
 * the user with the ID userId with a due date equal to dueDate and a list of tags attached to the
 * task. The return value is the ID of the task. This ID starts at 1 and is sequentially increasing.
 * That is, the first task's id should be 1, the second task's id should be 2, and so on.
 * <p>
 * <p>
 * List<String> getAllTasks(int userId) Returns a list of all the tasks not marked as complete for
 * the user with ID userId, ordered by the due date. You should return an empty list if the user has
 * no uncompleted tasks.
 *
 * <p>
 * List<String> getTasksForTag(int userId, String tag) Returns a list of all the tasks that are not
 * marked as complete for the user with the ID userId and have tag as one of their tags, ordered by
 * their due date. Return an empty list if no such task exists.
 * <p>
 * void completeTask(int userId, int taskId) Marks the task with the ID taskId as completed only if
 * the task exists and the user with the ID userId has this task, and it is uncompleted.
 *
 *  <ul>
 * <p>
 *    Example 1:
 * <p>
 *        Input
 *            ["TodoList", "addTask", "addTask", "getAllTasks", "getAllTasks", "addTask", "getTasksForTag", "completeTask", "completeTask", "getTasksForTag", "getAllTasks"]
 *            [[], [1, "Task1", 50, []], [1, "Task2", 100, ["P1"]], [1], [5], [1, "Task3", 30, ["P1"]], [1, "P1"], [5, 1], [1, 2], [1, "P1"], [1]]
 *        Output
 *            [null, 1, 2, ["Task1", "Task2"], [], 3, ["Task3", "Task2"], null, null, ["Task3"], ["Task3", "Task1"]]
 * <p>
 *      Explanation
 *          TodoList todoList = new TodoList();
 *          todoList.addTask(1, "Task1", 50, []); // return 1. This adds a new task for the user with id 1.
 *          todoList.addTask(1, "Task2", 100, ["P1"]); // return 2. This adds another task for the user with id 1.
 *          todoList.getAllTasks(1); // return ["Task1", "Task2"]. User 1 has two uncompleted tasks so far.
 *          todoList.getAllTasks(5); // return []. User 5 does not have any tasks so far.
 *          todoList.addTask(1, "Task3", 30, ["P1"]); // return 3. This adds another task for the user with id 1.
 *          todoList.getTasksForTag(1, "P1"); // return ["Task3", "Task2"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
 *          todoList.completeTask(5, 1); // This does nothing, since task 1 does not belong to user 5.
 *          todoList.completeTask(1, 2); // This marks task 2 as completed.
 *          todoList.getTasksForTag(1, "P1"); // return ["Task3"]. This returns the uncompleted tasks that have the tag "P1" for the user with id 1.
 *                                   // Notice that we did not include "Task2" because it is completed now.
 *          todoList.getAllTasks(1); // return ["Task3", "Task1"]. User 1 now has 2 uncompleted tasks.
 * <p>
 * <p>
 * <p>
 *  Constraints:
 *      1 <= userId, taskId, dueDate <= 100
 *      0 <= tags.length <= 100
 *      1 <= taskDescription.length <= 50
 *      1 <= tags[i].length, tag.length <= 20
 *      All dueDate values are unique.
 *      All the strings consist of lowercase and uppercase English letters and digits.
 *      At most 100 calls will be made for each method.
 * <ul/>
 */
public class TodoList {

  class Task {

    String taskDesc;
    int dueDate;
    Set<String> tags;
    int id;
    boolean isCompleted;

    Task(int id, String desc, int dueDate, List<String> tags) {
      this.id = id;
      this.dueDate = dueDate;
      this.tags = new HashSet<>(tags);
      this.taskDesc = desc;
    }
  }


  Map<Integer, Set<Task>> tasks;
  int id;

  public TodoList() {
    this.tasks = new HashMap<>();
    this.id = 0;
  }

  public int addTask(int userId, String taskDescription, int dueDate, List<String> tags) {
    tasks.computeIfAbsent(userId, a -> new TreeSet<>((t1, t2) -> t1.dueDate - t2.dueDate));
    ++id;
    tasks.get(userId).add(new Task(id, taskDescription, dueDate, tags));
    return id;
  }

  public List<String> getAllTasks(int userId) {
    return tasks.getOrDefault(userId, new TreeSet<>()).stream().filter(t -> !t.isCompleted)
        .map(t -> t.taskDesc).collect(Collectors.toList());
  }

  public List<String> getTasksForTag(int userId, String tag) {
    return tasks.get(userId).stream().filter(t -> !t.isCompleted).filter(t -> t.tags.contains(tag))
        .map(t -> t.taskDesc).collect(Collectors.toList());
  }

  public void completeTask(int userId, int taskId) {
    tasks.getOrDefault(userId, new TreeSet<>()).stream().filter(t -> t.id == taskId)
        .forEach(t -> t.isCompleted = true);
  }

  public static void main(String[] args) {
    TodoList todo = new TodoList();
    todo.addTask(1, "TASK1", 50, Arrays.asList("T1"));
    todo.addTask(1, "TASK2", 10, Arrays.asList("T1", "T2"));
    todo.addTask(1, "TASK3", 5, Arrays.asList("T3"));
    todo.addTask(3, "TASK4", 5, Arrays.asList("T5"));
    System.out.println(todo.getAllTasks(2));
    System.out.println(todo.getAllTasks(1));
    System.out.println(todo.getTasksForTag(1, "T2"));
  }

}
