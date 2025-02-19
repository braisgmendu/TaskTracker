package org.tasktracker;
import java.util.Map;
import java.time.LocalDateTime;

public class Task {

    private int id;
    private String name;
    private String description;
    private String priority;
    private String status;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Task(int id, String name, String description, String priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = "";
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDateTime getCreted() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    //Setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStatus(int status) {
        this.status = String.valueOf(status);
    }
    public void updateTimestamp(){
        this.updated = LocalDateTime.now();
    }
    public void updateAttributes(Map<String, String> updates) {
        if (updates.containsKey("name")) this.name = updates.get("name");
        if (updates.containsKey("description")) this.description = updates.get("description");
        if (updates.containsKey("priority")) this.priority = updates.get("priority");
        if (updates.containsKey("status")) this.status = updates.get("status");
        this.updateTimestamp();
    }
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", creted=" + created +
                ", updated=" + updated +
                '}';
    }

}
