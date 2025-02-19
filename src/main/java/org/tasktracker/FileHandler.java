package org.tasktracker;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;
public class FileHandler {

    private static final String FILE_NAME = "tasks.json";
    //converte localDateTime para que no de problemas al leer y guardar
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();

    public static List<Task> readTasksFromFile() throws IOException {
        // Verifica si el archivo existe, y lo crea si no.
        if (!Files.exists(Paths.get(FILE_NAME))) {
            Files.createFile(Paths.get(FILE_NAME));
            return new ArrayList<>(); // Devuelve una lista vacía si el archivo no existe.
        }

        try {
            // Lee el contenido del archivo
            String json = new String(Files.readAllBytes(Paths.get(FILE_NAME)));

            // Si el archivo está vacío, devuelve una lista vacía
            if (json.trim().isEmpty()) {
                return new ArrayList<>();
            }

            // Deserializa el contenido del archivo a una lista de tareas
            List<Task> tasks = gson.fromJson(json, new TypeToken<List<Task>>() {}.getType());

            // Maneja el caso en que la deserialización devuelva null
            return tasks != null ? tasks : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Devuelve una lista vacía en caso de error
        }
    }

    public static void writeTasksToFile(List<Task> tasks) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_NAME)){
            gson.toJson(tasks, writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
