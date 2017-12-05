package pl.sii.eu.consumer.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.sii.eu.contracts.Version;

import java.io.IOException;

public class VersionDeserializer extends StdDeserializer<Version> {

    public VersionDeserializer() {
        super(Version.class);
    }

    @Override
    public Version deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Version.fromString(p.getText());
    }
}
