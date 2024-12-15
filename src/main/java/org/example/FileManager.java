package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class FileManager {
	// Nazwa pliku, w którym zapisywane są dane.
	private static final String FILE_NAME = "medicine_cabinet.json";

	// Tworzenie obiektu Gson do serializacji i deserializacji obiektów, rejestrujemy adapter LocalDate.
	private static final Gson gson =
			new GsonBuilder()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) // Rejestrujemy adapter LocalDate.
					.setPrettyPrinting()  // Opcjonalnie formatowanie pliku JSON dla czytelności.
					.create();

	// Metoda do zapisywania listy leków do pliku JSON.
	public static void saveFile(List<Medicine> medicines) throws IOException {
		try (FileWriter writer = new FileWriter(FILE_NAME)) {
			// Serializujemy listę obiektów `medicines` do formatu JSON i zapisujemy ją do pliku.
			gson.toJson(medicines, writer);
		}
	}

	// Metoda do odczytywania listy leków z pliku JSON.
	public static List<Medicine> loadFile() throws IOException {
		try (FileReader reader = new FileReader(FILE_NAME)) {
			// Tworzymy typ dla listy obiektów Medicine do deserializacji.
			Type listType = new TypeToken<List<Medicine>>() {}.getType();

			// Deserializujemy dane JSON z pliku do listy obiektów `Medicine`.
			return gson.fromJson(reader, listType);
		} catch (IOException e) {
			return null;  // Jeśli wystąpi błąd podczas odczytu pliku, zwracamy null.
		}
	}
}
