package adapter.infrastructure;

import adapter.entity.JSONService;
import adapter.entity.XMLService;

public class XMLToJSONAdapter implements JSONService {
    private final XMLService xmlService;
    private String json;

    public XMLToJSONAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
        this.json = "{}";
    }

    @Override
    public String toJSON() {
        String xml = xmlService.toXML().trim();
        json = xml
            .replace("<", "\"")
            .replace(">", "\":\"")
            .replace("/\"", "\"")
            .replace("\"\":\"\"", "\"")
            .replace("\":\"\"", "\"")
            .replace("\":\"", "\":")
            .replace("\"\"", "\"")
            .replace("\":\"", "\":")
            .replace("\":", "\":\"")
            .replace("\"\"", "\"");

        if (!json.startsWith("\"")) {
            json = "\"root\":" + json;
        }
        if (!json.startsWith("{")) {
            json = "{" + json;
        }
        if (!json.endsWith("}")) {
            json = json + "}";
        }

        return json
            .replace("\"\":\"", "\":\"")
            .replace("\"\"", "\"")
            .replace("\"/", "\"")
            .replace("\" ", "\"");
    }

    @Override
    public void setRaw(String raw) {
        json = raw == null ? "{}" : raw.trim();
    }
}