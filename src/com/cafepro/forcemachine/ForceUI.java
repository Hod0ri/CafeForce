package com.cafepro.forcemachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.FormView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForceUI extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    // Label
    JLabel lblNewLabel = new JLabel("주문 없음");
    // Buttons
    JButton btn_stock = new JButton("재고 관리");
    JButton americano = new JButton("아메리카노");
    JButton essfresso = new JButton("에스프레소");
    JButton choco_latte = new JButton("초코 라떼");
    JButton caramel_latte = new JButton("카라멜 마끼아토");
    JButton vanilla_latte = new JButton("바닐라 라떼");
    JButton afogato = new JButton("아포가토");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
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
    /**
     * Create the frame.
     */
    public ForceUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 746, 407);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(0, 3, 0, 0));

        JButton btn1 = new JButton("1");
        panel.add(btn1);

        JButton btn2 = new JButton("2");

        panel.add(btn2);

        JButton btn3 = new JButton("3");
        panel.add(btn3);

        JButton btn4 = new JButton("4");
        panel.add(btn4);

        JButton btn5 = new JButton("5");
        panel.add(btn5);

        JButton btn6 = new JButton("6");
        panel.add(btn6);

        JButton btn7 = new JButton("7");
        panel.add(btn7);

        JButton btn8 = new JButton("8");
        panel.add(btn8);

        JButton btn9 = new JButton("9");
        panel.add(btn9);

        panel.add(btn_stock);

        JButton btn0 = new JButton("0");
        panel.add(btn0);

        JButton submit = new JButton("등록");
        panel.add(submit);

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

        textField = new JTextField();
        contentPane.add(textField, BorderLayout.NORTH);
        textField.setColumns(10);

        btn_stock.addActionListener(new EventHandler());
        americano.addActionListener(new EventHandler());
        essfresso.addActionListener(new EventHandler());
        caramel_latte.addActionListener(new EventHandler());
        choco_latte.addActionListener(new EventHandler());
        afogato.addActionListener(new EventHandler());
        vanilla_latte.addActionListener(new EventHandler());


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
            } else if(e.getSource() == americano) {
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
        }
    }
}

