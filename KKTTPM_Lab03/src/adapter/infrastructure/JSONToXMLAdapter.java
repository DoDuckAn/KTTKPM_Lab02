package adapter.infrastructure;

import adapter.entity.JSONService;
import adapter.entity.XMLService;

public class JSONToXMLAdapter implements XMLService {
    private final JSONService jsonService;
    private String xml;

    public JSONToXMLAdapter(JSONService jsonService) {
        this.jsonService = jsonService;
        this.xml = "<root></root>";
    }

    @Override
    public String toXML() {
        String json = jsonService.toJSON().trim();
        xml = json
            .replace("{", "")
            .replace("}", "")
            .replace("\"", "")
            .replace(" ", "")
            .replace("\n", "");

        String[] parts = xml.split(":", 2);
        if (parts.length < 2) {
            return "<root></root>";
        }

        String root = parts[0];
        String body = parts[1]
            .replace(",", "</field><field>")
            .replace(":", ":");

        return "<" + root + "><field>" + body + "</field></" + root + ">";
    }

    @Override
    public void setRaw(String raw) {
        xml = raw == null ? "<root></root>" : raw.trim();
    }
}