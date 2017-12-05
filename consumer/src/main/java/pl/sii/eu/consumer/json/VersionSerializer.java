package pl.sii.eu.consumer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pl.sii.eu.contracts.Version;

import java.io.IOException;

public class VersionSerializer extends StdSerializer<Version> {
    public VersionSerializer() {
        super(Version.class);
    }

    @Override
    public void serialize(Version value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.toString());
    }
}
