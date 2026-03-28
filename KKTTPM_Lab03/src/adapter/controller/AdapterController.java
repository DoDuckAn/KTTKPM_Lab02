package adapter.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import adapter.service.AdapterService;

public class AdapterController extends JFrame {
    private final AdapterService adapterService;
    private final JTextArea xmlArea;
    private final JTextArea jsonArea;
    private final JLabel statusLabel;

    public AdapterController(AdapterService adapterService) {
        this.adapterService = adapterService;

        setTitle("Adapter Pattern - XML <-> JSON");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(980, 560);
        setLocationRelativeTo(null);

        xmlArea = new JTextArea(adapterService.getSampleXml());
        jsonArea = new JTextArea(adapterService.getSampleJson());
        statusLabel = new JLabel("Nhap du lieu va chuyen doi theo hai chieu.");

        JButton sampleXmlButton = new JButton("Tai XML mau");
        sampleXmlButton.addActionListener(event -> xmlArea.setText(adapterService.getSampleXml()));

        JButton sampleJsonButton = new JButton("Tai JSON mau");
        sampleJsonButton.addActionListener(event -> jsonArea.setText(adapterService.getSampleJson()));

        JButton xmlToJsonButton = new JButton("XML -> JSON");
        xmlToJsonButton.addActionListener(event -> convertXmlToJson());

        JButton jsonToXmlButton = new JButton("JSON -> XML");
        jsonToXmlButton.addActionListener(event -> convertJsonToXml());

        JButton modernJsonButton = new JButton("JSON he thong moi");
        modernJsonButton.addActionListener(event -> showModernJson());

        JPanel actionPanel = new JPanel(new GridLayout(1, 5, 8, 8));
        actionPanel.add(sampleXmlButton);
        actionPanel.add(sampleJsonButton);
        actionPanel.add(xmlToJsonButton);
        actionPanel.add(jsonToXmlButton);
        actionPanel.add(modernJsonButton);

        JPanel xmlPanel = new JPanel(new BorderLayout(8, 8));
        xmlPanel.setBorder(BorderFactory.createTitledBorder("XML"));
        xmlPanel.add(new JScrollPane(xmlArea), BorderLayout.CENTER);

        JPanel jsonPanel = new JPanel(new BorderLayout(8, 8));
        jsonPanel.setBorder(BorderFactory.createTitledBorder("JSON"));
        jsonPanel.add(new JScrollPane(jsonArea), BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, xmlPanel, jsonPanel);
        splitPane.setResizeWeight(0.5);
        splitPane.setPreferredSize(new Dimension(900, 420));

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        root.add(actionPanel, BorderLayout.NORTH);
        root.add(splitPane, BorderLayout.CENTER);
        root.add(statusLabel, BorderLayout.SOUTH);

        setContentPane(root);
    }

    private void convertXmlToJson() {
        try {
            jsonArea.setText(adapterService.convertXmlToJson(xmlArea.getText()));
            statusLabel.setText("Da chuyen XML sang JSON thanh cong.");
        } catch (RuntimeException exception) {
            handleError(exception.getMessage(), "Loi XML");
        }
    }

    private void convertJsonToXml() {
        try {
            xmlArea.setText(adapterService.convertJsonToXml(jsonArea.getText()));
            statusLabel.setText("Da chuyen JSON sang XML thanh cong.");
        } catch (RuntimeException exception) {
            handleError(exception.getMessage(), "Loi JSON");
        }
    }

    private void showModernJson() {
        jsonArea.setText(adapterService.getModernJson());
        statusLabel.setText("Dang hien thi JSON cua he thong moi.");
    }

    private void handleError(String message, String title) {
        statusLabel.setText(message);
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
    }
}