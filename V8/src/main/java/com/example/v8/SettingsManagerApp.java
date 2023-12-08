package com.example.v8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class SettingsManagerApp extends JFrame {

    private JTextField textField;
    private JTextArea textArea;

    public SettingsManagerApp() {
        super("Settings Manager");


        textField = new JTextField(20);
        textArea = new JTextArea(10, 20);
        JButton saveButton = new JButton("Сохранить");
        JButton loadButton = new JButton("Загрузить");


        setLayout(new BorderLayout());


        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Имя пользователя:"));
        inputPanel.add(textField);
        inputPanel.add(saveButton);
        inputPanel.add(loadButton);


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSettings();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSettings();
            }
        });


        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);


        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void saveSettings() {
        String username = textField.getText();
        String settingsText = textArea.getText();

        Properties properties = new Properties();
        properties.setProperty("username", username);
        properties.setProperty("customSettings", settingsText);

        try (OutputStream output = new FileOutputStream("settings.properties")) {
            properties.store(output, "User Settings");
            JOptionPane.showMessageDialog(this, "Настройки сохранены успешно");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении настроек");
        }
    }

    private void loadSettings() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("settings.properties")) {
            properties.load(input);

            String username = properties.getProperty("username");
            String settingsText = properties.getProperty("customSettings");

            textField.setText(username);
            textArea.setText(settingsText);

            JOptionPane.showMessageDialog(this, "Настройки загружены успешно");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при загрузке настроек");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SettingsManagerApp().setVisible(true);
            }
        });
    }
}
