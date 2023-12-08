package com.example.v11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;


class Report implements Cloneable {
    private String title;
    private Map<String, String> data;

    public Report(String title, Map<String, String> data) {
        this.title = title;
        this.data = data;
    }


    public Report cloneReport() {
        try {

            return (Report) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTitle() {
        return title;
    }

    public Map<String, String> getData() {
        return data;
    }
}


public class ReportCloningApp {
    private static Map<String, String> sampleData = new HashMap<>();

    static {
        sampleData.put("Key1", "Value1");
        sampleData.put("Key2", "Value2");
        sampleData.put("Key3", "Value3");
    }

    public static void main(String[] args) {

        Report prototypeReport = new Report("Sample Report", sampleData);


        JFrame frame = new JFrame("Report Cloning App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);


        JButton cloneButton = new JButton("Clone Report");
        cloneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Report clonedReport = prototypeReport.cloneReport();
                clonedReport.getData().put("Key1", "NewValue1");


                JOptionPane.showMessageDialog(frame,
                        "Cloned Report: " + clonedReport.getTitle() +
                                "\nData: " + clonedReport.getData());
            }
        });


        frame.getContentPane().add(cloneButton);
        frame.setVisible(true);
    }
}
