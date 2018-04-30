package mainpack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame {
    private JTextField jTextField;
    private ControlerCalc controler;
    private BorderLayout borderLayout;
    private JPanel buttonsPanel;
    private JButton jButtonPlus;
    private JButton jButtonMinus;
    private JButton jButtonEqual;
    private JButton jButtonRefrash;


    public CalcFrame(ControlerCalc controler){
        super("Kalkulator");
        this.controler = controler;
        setSize(new Dimension(400,300));
        setLocation(400,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        borderLayout = new BorderLayout(1, 1);
        buttonsPanel = new JPanel();
        jTextField = new JTextField("");
        jTextField.setPreferredSize(new Dimension(390,100));
        jTextField.setFont(new Font("Arial",Font.ITALIC,30));
        jTextField.setEditable(false);
        init();
        setVisible(true);
    }

    public void init (){
        createButtonsNum();
        jButtonPlus = new JButton("+");
        jButtonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controler.operationButtonAction(jButtonPlus);
                } catch (CalcsException e1) {
                    showError("Add value!");
                }
            }
        });
        jButtonMinus = new JButton("-");
        jButtonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controler.operationButtonAction(jButtonMinus);
                } catch (CalcsException e1) {
                    showError("Add value!");
                }
            }
        });
        jButtonEqual = new JButton("=");
        jButtonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controler.equalButtonAction();
                } catch (CalcsException e1) {
                    showError("Add value!");
                }
            }
        });
        jButtonRefrash = new JButton("C");
        jButtonRefrash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controler.refrashButtonAction();
            }
        });
        buttonsPanel.add(jButtonPlus);
        buttonsPanel.add(jButtonMinus);
        buttonsPanel.add(jButtonEqual);
        buttonsPanel.add(jButtonRefrash);
        buttonsPanel.setLayout(new GridLayout(5, 3));

        addComponent(jTextField, BorderLayout.NORTH);
        addComponent(buttonsPanel, BorderLayout.CENTER);
        setMinimumSize(new Dimension(400,300));
        setLayout(borderLayout);
        pack();
        setSize(400,300);

    }

    public void createButtonsNum(){
        for (int i = 0; i < 10; i++) {
            JButton jButton = new JButton(""+i);
            jButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    StringBuilder stringBuilder = new StringBuilder(jTextField.getText());
                    stringBuilder.append(jButton.getText());
                    jTextField.setText(stringBuilder.toString());
                }
            });
            buttonsPanel.add(jButton);
        }
    }

    public void addComponent(JComponent component, Object constrains) {
        getContentPane().add(component);
        borderLayout.addLayoutComponent(component, constrains);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getjTextField() {
        return jTextField;
    }
}
