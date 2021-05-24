package com.cafepro.forcemachine;

import javax.swing.*;
import java.awt.*;

public class ForeceUI extends JFrame {
    public ForeceUI() {

        Container container = getContentPane();

        setTitle("Pro 카페 포스");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label Position
        JLabel menu = new JLabel();
        menu.setFont(new Font("Gothic", Font.PLAIN, 14));
        menu.setPreferredSize(new Dimension(500,30));
        menu.setText("주문 없음");

        // Button Position
        JButton juice1 = new JButton("아메리카노");
        juice1.setPreferredSize(new Dimension(150, 50));
        JButton juice2 = new JButton("카푸치노");
        juice2.setPreferredSize(new Dimension(150, 50));
        JButton juice3 = new JButton("에스프레소");
        juice3.setPreferredSize(new Dimension(150, 50));
        JButton juice4 = new JButton("바닐라라떼");
        juice4.setPreferredSize(new Dimension(150, 50));
        JButton juice5 = new JButton("카라멜 마끼야토");
        juice5.setPreferredSize(new Dimension(150, 50));
        JButton juice6 = new JButton("아포가토");
        juice6.setPreferredSize(new Dimension(150, 50));
        JButton juice7 = new JButton("초코라떼");
        juice7.setPreferredSize(new Dimension(150, 50));
        JButton juice8 = new JButton("카페모카");
        juice8.setPreferredSize(new Dimension(150, 50));
        JButton juice9 = new JButton("콜드브루");
        juice9.setPreferredSize(new Dimension(150, 50));

        container.add(menu, BorderLayout.NORTH);
        container.add(juice1);
        container.add(juice2);
        container.add(juice3);
        container.add(juice4);
        container.add(juice5);
        container.add(juice6);
        container.add(juice7);
        container.add(juice8);
        container.add(juice9);
        setLayout(new FlowLayout());

        // Event Button
        juice1.addActionListener(event -> {
          menu.setText(juice1.getText());
        });
        juice2.addActionListener(event -> {
            menu.setText(juice2.getText());
        });
        juice3.addActionListener(event -> {
            menu.setText(juice3.getText());
        });
        juice4.addActionListener(event -> {
            menu.setText(juice4.getText());
        });
        juice5.addActionListener(event -> {
            menu.setText(juice5.getText());
        });
        juice6.addActionListener(event -> {
            menu.setText(juice6.getText());
        });
        juice7.addActionListener(event -> {
            menu.setText(juice7.getText());
        });
        juice8.addActionListener(event -> {
            menu.setText(juice8.getText());
        });
        juice9.addActionListener(event -> {
            menu.setText(juice9.getText());
        });



        setVisible(true);
    }

    public static void main(String[] args) {
        ForeceUI foreceUI = new ForeceUI();
    }
}
