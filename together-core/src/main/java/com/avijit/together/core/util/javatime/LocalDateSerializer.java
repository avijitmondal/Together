/**
 *
 */
package com.avijit.together.core.util.javatime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author avijit
 *
 */
public class LocalDateSerializer extends StdSerializer<LocalDate> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public LocalDateSerializer() {
        super(LocalDate.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.fasterxml.jackson.databind.ser.std.StdSerializer#serialize(java.lang.
     * Object, com.fasterxml.jackson.core.JsonGenerator,
     * com.fasterxml.jackson.databind.SerializerProvider)
     */
    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp)
            throws IOException {
        gen.writeString(value.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}