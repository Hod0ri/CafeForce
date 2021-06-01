package com.cafepro.forcemachine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForceSub extends JFrame {
    DataFile dataFile = new DataFile();
    private JPanel contentPane;
    private JTextField textField;
    private JTable table;

    // Label
    JLabel viewSelection = new JLabel("지정되지 않음");

    // Panel
    JPanel panel = new JPanel();

    // Button
    JButton milk = new JButton("우유");
    JButton vanila = new JButton("바닐라");
    JButton coffeebean1 = new JButton("원두(콜롬비아)");
    JButton coffeebean2 = new JButton("원두(체코)");
    JButton coffeebean3 = new JButton("원두(에티오피아)");
    JButton choco = new JButton("초코");
    JButton caramel = new JButton("카라멜");
    JButton icecream = new JButton("아이스크림");
    JButton sweatMilk = new JButton("연유");
    JButton submit = new JButton("재고 등록");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ForceSub frame = new ForceSub();
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
    public ForceSub() throws IOException {
        dataFile.ReadData();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 446);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        contentPane.add(panel, BorderLayout.WEST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        String header[] = {"물품 명", "재고량"};
        String contents[][] = {
                {milk.getText(), dataFile.material.get(milk.getText())},
                {vanila.getText(), dataFile.material.get(vanila.getText())},
                {coffeebean1.getText(), dataFile.material.get(coffeebean1.getText())},
                {coffeebean2.getText(), dataFile.material.get(coffeebean2.getText())},
                {coffeebean3.getText(), dataFile.material.get(coffeebean3.getText())},
                {choco.getText(), dataFile.material.get(choco.getText())},
                {caramel.getText(), dataFile.material.get(caramel.getText())},
                {icecream.getText(), dataFile.material.get(icecream.getText())},
                {sweatMilk.getText(), dataFile.material.get(sweatMilk.getText())}
        };
        DefaultTableModel model = new DefaultTableModel(contents, header);
        table = new JTable(contents, header);
        JScrollPane scrollpane = new JScrollPane(table);

        panel.add(scrollpane);

        //viewMaterial.setPreferredSize(new Dimension(200,300));
        //panel.add(viewMaterial);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.EAST);
        panel_1.setPreferredSize(new Dimension(400,300));
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        panel_1.add(milk);
        panel_1.add(vanila);
        panel_1.add(coffeebean1);
        panel_1.add(coffeebean2);
        panel_1.add(coffeebean3);
        panel_1.add(choco);
        panel_1.add(caramel);
        panel_1.add(icecream);
        panel_1.add(sweatMilk);
        panel_1.add(submit);

        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.NORTH);
        panel_2.setLayout(new GridLayout(0, 3, 0, 0));

        viewSelection.setHorizontalAlignment(SwingConstants.CENTER);
        panel_2.add(viewSelection);

        JLabel label = new JLabel("");
        panel_2.add(label);

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        // Event Handler
        milk.addActionListener(new EventHandler());
        vanila.addActionListener(new EventHandler());
        coffeebean1.addActionListener(new EventHandler());
        coffeebean2.addActionListener(new EventHandler());
        coffeebean3.addActionListener(new EventHandler());
        choco.addActionListener(new EventHandler());
        caramel.addActionListener(new EventHandler());
        sweatMilk.addActionListener(new EventHandler());
        icecream.addActionListener(new EventHandler());
        submit.addActionListener(new EventHandler());

    }

    class EventHandler implements ActionListener {
        // Edit material Stock
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource()== milk){
                viewSelection.setText(milk.getText());
            } else if(e.getSource()== vanila){
                viewSelection.setText(vanila.getText());
            } else if(e.getSource()== coffeebean1){
                viewSelection.setText(coffeebean1.getText());
            } else if(e.getSource()== coffeebean2){
                viewSelection.setText(coffeebean2.getText());
            } else if(e.getSource()== coffeebean3){
                viewSelection.setText(coffeebean3.getText());
            } else if(e.getSource()== choco){
                viewSelection.setText(choco.getText());
            } else if(e.getSource()== caramel){
                viewSelection.setText(caramel.getText());
            }else if(e.getSource()== icecream){
                viewSelection.setText(icecream.getText());
            }else if(e.getSource()== sweatMilk){
                viewSelection.setText(sweatMilk.getText());
            }else if(e.getSource()== submit){
                // Error Handling
                if(viewSelection.getText().equals("지정되지 않음") || textField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "값을 지정해주세요!!");
                }else {
                    try {
                        dataFile.EditData(viewSelection.getText(), dataFile.ReadData(), Integer.parseInt(textField.getText()));
                        JOptionPane.showMessageDialog(null, "전송되었습니다!");

                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }

    }

}
