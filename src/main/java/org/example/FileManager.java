package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Manages the saving and loading of medicine data to and from a JSON file.
 * Handles serialization and deserialization of the list of medicines using the Gson library.
 */
public final class FileManager {
	/**
	 * The name of the file where the medicine data is stored.
	 */
	private static final String FILE_NAME = "medicine_cabinet.json";
	/**
	 * A {@link Gson} instance configured for serializing and deserializing objects.
	 * It includes a custom adapter for the {@link LocalDate} type and pretty-printing for better readability.
	 */
	private static final Gson GSON = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()) //
			// Registers the LocalDate adapter for serialization and deserialization.
			.setPrettyPrinting()  // Formats the JSON output to enhance readability.
			.create();

	private FileManager() {
		throw new AssertionError("FileManager class should not be instantiated");
	}

	/**
	 * Saves the provided list of medicines to a JSON file.
	 *
	 * @param medicines A list of {@link Medicine} objects to be serialized and saved to the file.
	 *
	 * @throws IOException If an error occurs while writing to the file.
	 */
	public static void saveFile(final List<Medicine> medicines) {
		try (final FileWriter writer = new FileWriter(FILE_NAME)) {
			// Serializes the `medicines` list into JSON format and writes it to the file.
			GSON.toJson(medicines, writer);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads and deserializes the list of medicines from a JSON file.
	 *
	 * @return A list of {@link Medicine} objects deserialized from the JSON file, or {@code null} if an error occurs.
	 *
	 * @throws IOException If an error occurs while reading the file.
	 */
	public static List<Medicine> loadFile() {
		try (final FileReader reader = new FileReader(FILE_NAME)) {
			// Defines the type for deserialization of a list of `Medicine` objects.
			final Type listType = TypeToken.getParameterized(List.class, Medicine.class).getType();

			// Reads the JSON data from the file and deserializes it into a list of `Medicine` objects.
			return GSON.fromJson(reader, listType);
		} catch (final IOException e) {
			return Collections.emptyList();  // Returns null if an error occurs while reading the file.
		}
	}
}
