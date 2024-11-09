package io.github.xxyopen.novel.core.json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.springframework.boot.jackson.JsonComponent;


/**
 * Global JSON Deserializer
         */
@JsonComponent
public class GlobalJsonDeserializer {

    /**
     * String Deserializer: Filters special characters to prevent XSS attacks
     */
    public static class StringDeserializer extends JsonDeserializer<String> {

        @Override
        public String deserialize(JsonParser jsonParser,
                                  DeserializationContext deserializationContext) throws IOException {
            return jsonParser.getValueAsString()
                    .replace("<", "&lt;")
                    .replace(">", "&gt;");
        }
    }
}
