package adapter.infrastructure;

import adapter.entity.XMLService;

public class LegacyXMLProvider implements XMLService {
    private String xml;

    public LegacyXMLProvider() {
        this(sampleXml());
    }

    public LegacyXMLProvider(String xml) {
        this.xml = normalize(xml);
    }

    public static String sampleXml() {
        return "<user><name>John</name><age>30</age><city>Hanoi</city></user>";
    }

    @Override
    public String toXML() {
        return xml;
    }

    @Override
    public void setRaw(String raw) {
        xml = normalize(raw);
    }

    private String normalize(String value) {
        return value == null || value.isBlank() ? sampleXml() : value.trim();
    }
}