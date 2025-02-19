package org.tasktracker;

import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TaskCLI {
    public static void main(String[] args) throws IOException {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        String command = args[0].toLowerCase();

        switch (command){
            case "add":
                System.out.println("Enter task name:");
                String name = scanner.nextLine();
                System.out.println("Enter task description:");
                String description = scanner.nextLine();
                System.out.println("Enter task priority (low, medium, high):");
                String priority = scanner.nextLine();
                taskManager.addTask(name, description, priority);
                break;
            case "update":
                System.out.println("Enter task ID:");
                int id = Integer.parseInt(scanner.nextLine());
                Map<String, String> updates = new HashMap<>();
                System.out.println("Enter attributes to update (leave blank to skip):");
                System.out.println("New name:");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) updates.put("name", newName);
                System.out.println("New description:");
                String newDescription = scanner.nextLine();
                if (!newDescription.isEmpty()) updates.put("description", newDescription);
                System.out.println("New priority (low, medium, high):");
                String newPriority = scanner.nextLine();
                if (!newPriority.isEmpty()) updates.put("priority", newPriority);
                System.out.println("New status (todo, in-progress, done):");
                String newStatus = scanner.nextLine();
                if (!newStatus.isEmpty()) updates.put("status", newStatus);

                taskManager.updateTask(id, updates);
                break;
            case "list":
                taskManager.listTasks();
                break;
            case "delete":
                System.out.println("Enter task ID to delete:");
                int deleteId = Integer.parseInt(scanner.nextLine());
                taskManager.deleteTask(deleteId);
                break;
            case "mark":
                System.out.println("Enter task ID to mark");
                int markId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter status");
                String status = scanner.nextLine();
                taskManager.markTask(markId, status);
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    public static void menu (){

    }
}