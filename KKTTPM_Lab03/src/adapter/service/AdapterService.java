package adapter.service;

import adapter.entity.JSONService;
import adapter.entity.XMLService;

public class AdapterService {
    private final XMLService legacyXmlProvider;
    private final JSONService modernJsonProvider;
    private final JSONService xmlToJsonAdapter;
    private final XMLService jsonToXmlAdapter;

    public AdapterService(
        XMLService legacyXmlProvider,
        JSONService modernJsonProvider,
        JSONService xmlToJsonAdapter,
        XMLService jsonToXmlAdapter
    ) {
        this.legacyXmlProvider = legacyXmlProvider;
        this.modernJsonProvider = modernJsonProvider;
        this.xmlToJsonAdapter = xmlToJsonAdapter;
        this.jsonToXmlAdapter = jsonToXmlAdapter;
    }

    public String getSampleXml() {
        return legacyXmlProvider.toXML();
    }

    public String getSampleJson() {
        return modernJsonProvider.toJSON();
    }

    public String convertXmlToJson(String xmlInput) {
        legacyXmlProvider.setRaw(xmlInput);
        return xmlToJsonAdapter.toJSON();
    }

    public String convertJsonToXml(String jsonInput) {
        modernJsonProvider.setRaw(jsonInput);
        return jsonToXmlAdapter.toXML();
    }

    public String getModernJson() {
        return modernJsonProvider.toJSON();
    }
}