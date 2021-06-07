package com.cafepro.forcemachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForceUI extends JFrame {

    private JPanel contentPane;

    // Label
    JLabel lblNewLabel = new JLabel("<html>");
    JLabel priceView = new JLabel("0");
    // Buttons
    JButton btn_stock = new JButton("재고 관리");
    JButton americano = new JButton("아메리카노");
    JButton essfresso = new JButton("에스프레소");
    JButton choco_latte = new JButton("초코 라떼");
    JButton caramel_latte = new JButton("카라멜 마끼아토");
    JButton vanilla_latte = new JButton("바닐라 라떼");
    JButton afogato = new JButton("아포가토");

    // NumberPad
    JButton btn_1 = new JButton("1");
    JButton btn_2 = new JButton("2");
    JButton btn_3 = new JButton("3");
    JButton btn_4 = new JButton("4");
    JButton btn_5 = new JButton("5");
    JButton btn_6 = new JButton("6");
    JButton btn_7 = new JButton("7");
    JButton btn_8 = new JButton("8");
    JButton btn_9 = new JButton("9");
    JButton btn_0 = new JButton("0");
    JButton submit = new JButton("등록");
    JButton btn_eraseAll = new JButton("전체 삭제");
    JButton btn_erase = new JButton("이전 삭제");

    public void ShowMain() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForceUI frame = new ForceUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ForceUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 746, 407);
        setTitle("카페 Pro 포스 시스템");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(0, 3, 0, 0));

        panel.add(btn_1);
        panel.add(btn_2);
        panel.add(btn_3);
        panel.add(btn_4);
        panel.add(btn_5);
        panel.add(btn_6);
        panel.add(btn_7);
        panel.add(btn_8);
        panel.add(btn_9);
        panel.add(btn_stock);
        panel.add(btn_0);
        panel.add(submit);
        panel.add(btn_eraseAll);
        panel.add(btn_erase);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));


        panel_1.add(americano);
        panel_1.add(essfresso);
        panel_1.add(choco_latte);
        panel_1.add(caramel_latte);
        panel_1.add(vanilla_latte);
        panel_1.add(afogato);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.WEST);

        panel_2.add(lblNewLabel);
        panel_2.setPreferredSize(new Dimension(200,400));

        contentPane.add(priceView, BorderLayout.NORTH);

        btn_stock.addActionListener(new EventHandler());
        americano.addActionListener(new EventHandler());
        essfresso.addActionListener(new EventHandler());
        caramel_latte.addActionListener(new EventHandler());
        choco_latte.addActionListener(new EventHandler());
        afogato.addActionListener(new EventHandler());
        vanilla_latte.addActionListener(new EventHandler());

        // Number Pad Event Handling
        btn_1.addActionListener(new EventHandler());
        btn_2.addActionListener(new EventHandler());
        btn_3.addActionListener(new EventHandler());
        btn_4.addActionListener(new EventHandler());
        btn_5.addActionListener(new EventHandler());
        btn_6.addActionListener(new EventHandler());
        btn_7.addActionListener(new EventHandler());
        btn_8.addActionListener(new EventHandler());
        btn_9.addActionListener(new EventHandler());
        btn_0.addActionListener(new EventHandler());
        btn_eraseAll.addActionListener(new EventHandler());
        btn_erase.addActionListener(new EventHandler());
    }

    class EventHandler implements ActionListener {
        // Edit material Stock
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btn_stock) {
                setVisible(false);
                try {
                    ForceSub forceSub = new ForceSub();
                    forceSub.ShowSub();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            // Select Beverage
            else if(e.getSource() == americano) {
                lblNewLabel.setText(americano.getText());
            }else if(e.getSource() == essfresso) {
                lblNewLabel.setText(essfresso.getText());
            }else if(e.getSource() == choco_latte) {
                lblNewLabel.setText(choco_latte.getText());
            }else if(e.getSource() == caramel_latte) {
                lblNewLabel.setText(caramel_latte.getText());
            }else if(e.getSource() == vanilla_latte) {
                lblNewLabel.setText(vanilla_latte.getText());
            }else if(e.getSource() == afogato) {
                lblNewLabel.setText(afogato.getText());
            }
            // NumberPad
            else if (e.getSource() == btn_1) {
                checkNum(btn_1.getText());
            } else if (e.getSource() == btn_2) {
                checkNum(btn_2.getText());
            } else if (e.getSource() == btn_3) {
                checkNum(btn_3.getText());
            } else if (e.getSource() == btn_4) {
                checkNum(btn_4.getText());
            } else if (e.getSource() == btn_5) {
                checkNum(btn_5.getText());
            } else if (e.getSource() == btn_6) {
                checkNum(btn_6.getText());
            } else if (e.getSource() == btn_7) {
                checkNum(btn_7.getText());
            } else if (e.getSource() == btn_8) {
                checkNum(btn_8.getText());
            } else if (e.getSource() == btn_9) {
                checkNum(btn_9.getText());
            } else if (e.getSource() == btn_0) {
                checkNum(btn_0.getText());
            } else if (e.getSource() == btn_eraseAll) {
                priceView.setText("0");
            } else if (e.getSource() == btn_erase) {
                if(priceView.getText().length() > 1) {
                    String temp = priceView.getText();
                    temp = temp.substring(0, temp.length() - 1);
                    priceView.setText(temp);
                } else {
                    JOptionPane.showMessageDialog(null, "더이상 지울 값이 없습니다!","오류!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void checkNum(String sNumber) {
        if(priceView.getText().isBlank()) {
            priceView.setText(sNumber);
        } else {
            String exValue = priceView.getText();
            priceView.setText(exValue + sNumber);
        }
    }
}

