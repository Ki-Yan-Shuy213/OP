package com.example.v6;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

interface Document {
    void open();

    void save();
}

class TextDocument implements Document {
    private JTextArea textArea;

    public TextDocument() {
        textArea = new JTextArea();
    }

    @Override
    public void open() {
        System.out.println("Открытие текстового документа");

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                textArea.setText(content.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save() {
        System.out.println("Сохранение текстового документа");

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текстовые файлы", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(textArea.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JTextArea getEditor() {
        return textArea;
    }
}

public class DocumentEditorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Document Editor");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            JButton openButton = new JButton("Открыть");
            JButton saveButton = new JButton("Сохранить");


            openButton.addActionListener(e -> openDocument());
            saveButton.addActionListener(e -> saveDocument());

            panel.add(openButton);
            panel.add(saveButton);

            frame.getContentPane().add(BorderLayout.NORTH, panel);


            TextDocument textDocument = new TextDocument();
            frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane(textDocument.getEditor()));

            frame.setVisible(true);
        });
    }

    private static void openDocument() {
        Document document = getDocument();
        document.open();
    }

    private static void saveDocument() {
        Document document = getDocument();
        document.save();
    }

    private static Document getDocument() {
        return new TextDocument();
    }
}
