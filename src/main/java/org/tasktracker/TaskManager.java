package org.tasktracker;
import java.io.IOException;
import java.util.*;
public class TaskManager {

    private List<Task> tasks;

    public TaskManager() throws IOException {
        //inicializa la lista con las task que estan en el JSON
        this.tasks = FileHandler.readTasksFromFile();
    }

    //añadir una nueva task
    public void addTask(String name, String description, String priority) {
        //el id es un numero secuencial que incrementa cada vez que se añade una task nueva
        int id = tasks.size() + 1;
        //crea un nuevo objeto task, con los parametros
        Task newTask = new Task(id, name, description, priority);
        //añade la newva task a la lista
        tasks.add(newTask);
        try {
            //escribe la nueva lista al JSON
            FileHandler.writeTasksToFile(tasks);
            //manda un menssaje de exito
            System.out.println("Task added successfully " + newTask);
        }catch (IOException e){//excepcion de entrada o salida
            e.printStackTrace();
        }
    }

    //actualiza una Task
    public void updateTask(int id, Map<String, String> updates) throws IOException {
        Task task = findTaskById(id);//busca ina task por el id
        if(task != null){
            task.updateAttributes(updates);
            task.updateTimestamp();
            try {
                FileHandler.writeTasksToFile(tasks);
                System.out.println("Task updated successfully: " + task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Task not found");
        }
    }
    public void deleteTask(int id) throws IOException {
        Task task = findTaskById(id);
        if(task != null){
            tasks.remove(task);
            try {
                FileHandler.writeTasksToFile(tasks);
                System.out.println("Task deleted successfully: " + task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void markTask(int id, String status) throws IOException {
        Task task = findTaskById(id);
        if(task != null){
            task.setStatus(status);
            task.updateTimestamp();
            try {
                FileHandler.writeTasksToFile(tasks);
                System.out.println("Task marked successfully" + task);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public Task findTaskById(int id){
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }
    public void listTasks() {
        for(Task task : tasks){
            System.out.println(task);
        }
    }
}
