package Utiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class EndpointConfigReader {

    private EndpointConfigReader(){}
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Map<String, String> endpoints = new HashMap<>();

    static {
        try {
            JsonNode config = mapper.readTree(new File(FrameworkConstants.getJsonConfigFilePath()));
            parseEndpoints(config, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseEndpoints(JsonNode node, String parentKey) {
        if (node.isObject()) {
            node.fields().forEachRemaining(entry -> {
                String key = parentKey.isEmpty() ? entry.getKey() : parentKey + "." + entry.getKey();
                parseEndpoints(entry.getValue(), key);
            });
        } else if (node.isTextual()) {
            endpoints.put(parentKey, node.asText());
        }
    }

    public static String getEndpoint(String key) {
        return endpoints.get(key);
    }

}
