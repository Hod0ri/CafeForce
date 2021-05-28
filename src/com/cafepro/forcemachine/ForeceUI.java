package com.cafepro.forcemachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForeceUI extends JFrame {
    private JPanel contentPane;
    private JTextField material;
    private JTextField variable;
    JButton submit = new JButton("전송");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForeceUI frame = new ForeceUI();
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
    public ForeceUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        material = new JTextField();
        contentPane.add(material);
        material.setColumns(10);

        variable = new JTextField();
        contentPane.add(variable);
        variable.setColumns(10);

        contentPane.add(submit);

        submit.addActionListener(new EventHandler());

    }

    class EventHandler implements ActionListener {

        // Edit material Stock
        @Override
        public void actionPerformed(ActionEvent e) {
            DataFile dataFile = new DataFile();
            if(e.getSource()==submit){
                try {
                    dataFile.EditData(material.getText(), dataFile.ReadData(), Integer.parseInt(variable.getText()));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }

}

