package adapter.infrastructure;

import adapter.entity.JSONService;

public class ModernJSONProvider implements JSONService {
    private String json;

    public ModernJSONProvider() {
        this(sampleJson());
    }

    public ModernJSONProvider(String json) {
        this.json = normalize(json);
    }

    public static String sampleJson() {
        return "{\n  \"user\": {\n    \"name\": \"John\",\n    \"age\": 30,\n    \"city\": \"Hanoi\"\n  }\n}";
    }

    @Override
    public String toJSON() {
        return json;
    }

    @Override
    public void setRaw(String raw) {
        json = normalize(raw);
    }

    private String normalize(String value) {
        return value == null || value.isBlank() ? sampleJson() : value.trim();
    }
}