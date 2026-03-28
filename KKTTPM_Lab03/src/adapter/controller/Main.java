package adapter.controller;

import javax.swing.SwingUtilities;

import adapter.entity.JSONService;
import adapter.entity.XMLService;
import adapter.infrastructure.JSONToXMLAdapter;
import adapter.infrastructure.LegacyXMLProvider;
import adapter.infrastructure.ModernJSONProvider;
import adapter.infrastructure.XMLToJSONAdapter;
import adapter.service.AdapterService;

public class Main {
    public static void main(String[] args) {
        XMLService legacyXMLProvider = new LegacyXMLProvider();
        JSONService modernJSONProvider = new ModernJSONProvider();
        JSONService xmlToJSONAdapter = new XMLToJSONAdapter(legacyXMLProvider);
        XMLService jsonToXMLAdapter = new JSONToXMLAdapter(modernJSONProvider);

        AdapterService adapterService = new AdapterService(
            legacyXMLProvider,
            modernJSONProvider,
            xmlToJSONAdapter,
            jsonToXMLAdapter
        );

        SwingUtilities.invokeLater(() -> new AdapterController(adapterService).setVisible(true));
    }
}