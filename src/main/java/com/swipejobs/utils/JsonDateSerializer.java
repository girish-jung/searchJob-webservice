package com.swipejobs.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;


/**
 * Custom Json Serializer for parsing date objects in custom format.
 * @author Girish Jung
 *
 */
public class JsonDateSerializer extends JsonSerializer<Date> {
	
	private static final String DATE_FORMAT = "MM-dd-yyyy";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) 
			throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(value);
		jgen.writeString(formattedDate);
	}

}
