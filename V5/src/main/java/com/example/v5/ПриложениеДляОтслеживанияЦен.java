package com.example.v5;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Товар {
    private String название;
    private double цена;
    private List<ПодписчикНаИзменениеЦены> подписчики;

    public Товар(String название, double цена) {
        this.название = название;
        this.цена = цена;
        this.подписчики = new ArrayList<>();
    }

    public void добавитьНаблюдателя(ПодписчикНаИзменениеЦены подписчик) {
        подписчики.add(подписчик);
    }

    public void удалитьНаблюдателя(ПодписчикНаИзменениеЦены подписчик) {
        подписчики.remove(подписчик);
    }

    public void установитьЦену(double новаяЦена) {
        if (новаяЦена != цена) {
            double стараяЦена = цена;
            цена = новаяЦена;
            оповеститьНаблюдателей(стараяЦена, новаяЦена);
        }
    }

    private void оповеститьНаблюдателей(double стараяЦена, double новаяЦена) {
        for (ПодписчикНаИзменениеЦены подписчик : подписчики) {
            подписчик.уведомитьОбИзмененииЦены(название, стараяЦена, новаяЦена);
        }
    }
}

interface ПодписчикНаИзменениеЦены {
    void уведомитьОбИзмененииЦены(String названиеТовара, double стараяЦена, double новаяЦена);
}

class Пользователь implements ПодписчикНаИзменениеЦены {
    private String имя;

    public Пользователь(String имя) {
        this.имя = имя;
    }

    @Override
    public void уведомитьОбИзмененииЦены(String названиеТовара, double стараяЦена, double новаяЦена) {
        System.out.println(имя + ": Цена на " + названиеТовара + " изменилась с " + стараяЦена + " на " + новаяЦена);
    }
}

public class ПриложениеДляОтслеживанияЦен {
    public static void main(String[] args) {
        Товар товар = new Товар("Ноутбук", 1000.0);

        JFrame frame = new JFrame("Отслеживание Цен");
        JButton подписатьсяButton = new JButton("Подписаться");
        JButton изменитьЦенуButton = new JButton("Изменить Цену");

        подписатьсяButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String имяПользователя = JOptionPane.showInputDialog(frame, "Введите ваше имя:");
                Пользователь пользователь = new Пользователь(имяПользователя);
                товар.добавитьНаблюдателя(пользователь);
            }
        });

        изменитьЦенуButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String новаяЦенаСтр = JOptionPane.showInputDialog(frame, "Введите новую цену:");
                double новаяЦена = Double.parseDouble(новаяЦенаСтр);
                товар.установитьЦену(новаяЦена);
            }
        });

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(подписатьсяButton);
        frame.add(изменитьЦенуButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
