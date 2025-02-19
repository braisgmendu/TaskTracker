package org.tasktracker;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
    // formatea para que se vea yyyy-MM-dd'T'HH:mm:ss
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        //convierte un objeto LocalDateTime en su representaccion de texto para Json
        if (value == null) {//si el valor es null, escribe null
            out.nullValue();
        } else {//si no es null utiliza el formateador para convertir el objeto para poder escribir en JSON
            out.value(value.format(formatter)); // Serializa como cadena
        }
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        //convierte el JSON en un objeto LocalDateTime
        String json = in.nextString();
        return LocalDateTime.parse(json, formatter); // Deserializa desde cadena
    }
}
