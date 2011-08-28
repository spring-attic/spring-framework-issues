package org.springframework.samples.config.basic.account;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GSONTimestampConverter implements JsonSerializer<Timestamp> {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public JsonElement serialize(Timestamp src, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(sdf.format(src));
	}
}

