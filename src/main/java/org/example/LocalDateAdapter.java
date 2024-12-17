package org.example;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A Gson adapter for serializing and deserializing {@link LocalDate} objects.
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

	/**
	 * Formatter for converting {@link LocalDate} to and from ISO-8601 date strings.
	 */
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;

	/**
	 * Serializes a {@link LocalDate} object to its JSON representation as a string.
	 *
	 * @param src       the {@link LocalDate} to serialize
	 * @param typeOfSrc the type of the source object
	 * @param context   the context for serialization
	 * @return a {@link JsonElement} representing the serialized {@link LocalDate}
	 */
	@Override
	public JsonElement serialize(final LocalDate src, final Type typeOfSrc, final JsonSerializationContext context) {
		return new JsonPrimitive(FORMATTER.format(src));
	}

	/**
	 * Deserializes a JSON string into a {@link LocalDate} object.
	 *
	 * @param json    the JSON element to deserialize
	 * @param typeOfT the type of the target object
	 * @param context the context for deserialization
	 * @return the deserialized {@link LocalDate} object
	 * @throws JsonParseException if the JSON element is not a valid date string
	 */
	@Override
	public LocalDate deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
		return LocalDate.parse(json.getAsString(), FORMATTER);
	}
}
