package com.alura.Modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllBytes;

public class ConversionFile {

    public static void saveJson(Conversion conversion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = null;
        try {
            escritura = new FileWriter(conversion.fileName() + ".json");
            escritura.write(gson.toJson(conversion));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeJson(Conversion conversion) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(conversion.fileName() + ".json");

        List<Conversion> conversions = new ArrayList<>();

        // Si el archivo existe y tiene contenido, leer el contenido existente
        if (file.exists() && file.length() > 0) {
            try (FileReader reader = new FileReader(file)) {
                Type listType = new TypeToken<List<Conversion>>() {}.getType();
                conversions = gson.fromJson(reader, listType);
            } catch (IOException e) {
                throw new RuntimeException("Error al leer el archivo JSON", e);
            }
        }

        // Agregar el nuevo objeto a la lista
        conversions.add(conversion);

        // Escribir la lista actualizada en el archivo
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(gson.toJson(conversions));
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir el archivo JSON", e);
        }
    }


}
