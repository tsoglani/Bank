/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author user
 */
public class Fr extends JFrame {

    private boolean toRemoveScreanText;
    private JPanel keyPanel;
    private JButton[] keys = new JButton[10];
    private JTextArea screen;
    private JPanel enterAndSubmitThePasswordPanel = new JPanel();
    private JPasswordField passwordField = new JPasswordField();
    private JButton submitPassword = new JButton("submit");
    private boolean needswAPass = false;
    private JTextArea idField = new JTextArea();
    private int value = 500;
    private boolean enterTheUserANumber = false;
    private JButton homePage = new JButton("home  ");
    private JFrame frame;
    private JButton confirmManualCash = new JButton("confirm");

    public Fr() {
        super();
        frame = this;
        this.setLayout(null);
        this.setSize(800, 900);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        intializeKeyPanel();
        intializeScreen();
        firstPage();
        this.add(enterAndSubmitThePasswordPanel);
        enterAndSubmitThePasswordPanel.setVisible(false);
        this.add(homePage);
        this.add(screen);
        this.add(keyPanel);
        this.setVisible(true);
    }

    public void intializeKeyPanel() {
        keyPanel = new JPanel();
        keyPanel.setSize(250, 300);
        keyPanel.setLocation(20, 500);
        keyPanel.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            keys[i] = new JButton(Integer.toString(i + 1));
            keyPanel.add(keys[i]);
        }

        enterAndSubmitThePasswordPanel.setLayout(new GridLayout(3, 1));
        keys[9] = new JButton("0");
        keys[9].setSize(250, 50);
        keys[9].setLocation(20, 800);
        this.add(keys[9]);
        intializePasswondFields();
    }

    public void intializePasswondFields() {
        homePage.setSize(100, 40);
        homePage.setLocation(500, 400);
        homePage.setVisible(false);
        confirmManualCash.setSize(100, 40);
        confirmManualCash.setLocation(500, 500);
        confirmManualCash.setVisible(false);
        this.add(confirmManualCash);
        this.homePage.addActionListener(home);
        enterAndSubmitThePasswordPanel.add(idField);
        enterAndSubmitThePasswordPanel.add(passwordField);
        this.enterAndSubmitThePasswordPanel.add(submitPassword);
        enterAndSubmitThePasswordPanel.setSize(200, 50);
        enterAndSubmitThePasswordPanel.setLocation(500, 500);


    }

    public void intializeScreen() {
        screen = new JTextArea();
        screen.setSize(800, 400);
        screen.setLocation(0, 0);
        screen.setBackground(Color.yellow);
        screen.setEditable(false);
    }

    public void firstPage() {

        confirmManualCash.removeActionListener(putMoney);
        confirmManualCash.removeActionListener(manualRemoveMoney);
        this.submitPassword.removeActionListener(this.submitButtonListener);
        this.submitPassword.removeActionListener(this.submitButtonListenerOnPuttingMoney);
        toRemoveScreanText = true;
        homePage.setVisible(false);
        this.confirmManualCash.setVisible(false);
        enterAndSubmitThePasswordPanel.setVisible(false);
        screen.setText("press 1 to take money \n press 2 to see your balance");
        screen.append("\n press 3 to put money \n press 4 to exit");
        for (int i = 0; i < 10; i++) {
            this.keys[i].removeActionListener(this.manualRemoveMoney);
            this.keys[i].removeActionListener(this.printOnScreenButtonsText);
            this.keys[i].removeActionListener(this.firstPageListener);
            this.keys[i].removeActionListener(this.home);
            this.keys[i].removeActionListener(this.exit);
            keys[i].removeAll();
        }
        for (int i = 0; i <= 3; i++) {
            this.keys[i].addActionListener(firstPageListener);
        }
    }
    ActionListener firstPageListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {

            JButton pressedButton = (JButton) ae.getSource();
            System.out.println("you pressed number : "+ae.getActionCommand());
            screen.setText("");
            for (int i = 0; i < 4; i++) {
                keys[i].removeActionListener(firstPageListener);

            }
            if (Integer.parseInt(pressedButton.getText()) == 1) {
                screen.setText("enter Code( ID ) and pass");
                enterAndSubmitThePasswordPanel.setVisible(true);
                needswAPass = true;
                submitPassword.addActionListener(submitButtonListener);
                confirmManualCash.addActionListener(manualRemoveMoney);
            }

            if (Integer.parseInt(pressedButton.getText()) == 2) {
                screen.setText("your current account is : " + value);
                screen.append("\n press 1 to continue or 2 to exit");
                keys[0].addActionListener(home);
                keys[1].addActionListener(exit);
            }
            if (Integer.parseInt(pressedButton.getText()) == 3) {
                screen.setText("enter Code( ID ) and pass");
                enterAndSubmitThePasswordPanel.setVisible(true);
                needswAPass = true;
                submitPassword.addActionListener(submitButtonListenerOnPuttingMoney);
                confirmManualCash.addActionListener(putMoney);
            }
            if (Integer.parseInt(pressedButton.getText()) == 4) {
                System.exit(0);
            }
            repaint();
            homePage.setVisible(true);
        }
    };
    ActionListener submitButtonListenerOnPuttingMoney = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            /// ama k kala yparxei o kwdikos k exei ayto to pin
            if (true) {
                screen.setText("correct \n enter the money you want in your card");
                //////// prepei n valw edw tous listeners gia na kanw me ta koumpia 
                toRemoveScreanText = true;
                for (int i = 0; i < keys.length; i++) {
                    keys[i].addActionListener(printOnScreenButtonsText);
                }

            }
            enterTheUserANumber = true;
            submitPassword.removeActionListener(submitButtonListenerOnPuttingMoney);
            enterAndSubmitThePasswordPanel.setVisible(false);
            needswAPass = false;

        }
    };
    ActionListener submitButtonListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            /// ama k kala yparxei o kwdikos k exei ayto to pin
            if (true) {
                screen.setText("press 1 for 20 \n 2 for 40\n ");
                screen.append("3 for 80 \n 4 for 90 \n");
                screen.append("5 for 100 \n 6 for 120 \n 7 for 140 \n 8 for 160 \n9 for 180 \n and 0 to enter a value");
                //////// prepei n valw edw tous listeners gia na kanw me ta koumpia 
                toRemoveScreanText = true;
                for (int i = 0; i < keys.length; i++) {
                    keys[i].addActionListener(printOnScreenButtonsText);
                }
            }
            submitPassword.removeActionListener(submitButtonListener);
            enterAndSubmitThePasswordPanel.setVisible(false);
            needswAPass = false;

        }
    };
    ActionListener printOnScreenButtonsText = new ActionListener() {
        //// otan pigainw pisw preprei na svinw ayton ton listener

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton button = (JButton) ae.getSource();

            if (toRemoveScreanText) {
                toRemoveScreanText = false;
                screen.setText("");
                confirmManualCash.setVisible(true);
                if (button.getText().equals("0")) {
                    // elengxw ama to koumpi p tatithike exei tn timi 0 (exw dwsei ton idio listener s ola t koumpia)
                    enterTheUserANumber = true;
                    homePage.setVisible(true);

                    return;
                }
            }
            if (enterTheUserANumber) {
                screen.append(button.getText());
            } else {

                // ama patithei opoiodipote alo koumpi ektos tou 0 einai false 
                value -= Integer.parseInt(button.getText()) * 20;
                screen.setText("your remaining cash is :" + Integer.toString(value));
                for (int i = 0; i < keys.length; i++) {
                    keys[i].removeActionListener(printOnScreenButtonsText);
                }

            }



        }
    };
    ActionListener putMoney = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            value += Integer.parseInt(screen.getText());
            screen.setText("your remaining cash is :" + Integer.toString(value) + "\n");
            screen.append("press 1 to continue 2 to exit");

            keys[0].addActionListener(home);
            keys[1].addActionListener(exit);
            for (int i = 0; i < keys.length; i++) {
                keys[i].removeActionListener(printOnScreenButtonsText);

            }
        }
    };
    ActionListener home = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            firstPage();

        }
    };
    ActionListener manualRemoveMoney = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {

            value -= Integer.parseInt(screen.getText());
            screen.setText("your remaining cash is :" + Integer.toString(value) + "\n");
            screen.append("press 1 to continue 2 to exit");

            keys[0].addActionListener(home);
            keys[1].addActionListener(exit);
            for (int i = 0; i < keys.length; i++) {
                keys[i].removeActionListener(printOnScreenButtonsText);

            }
            confirmManualCash.setVisible(false);
        }
    };
    ActionListener exit = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    };

    @Override
    public void paint(Graphics gg) {
        super.paint(gg);
        Graphics2D g = (Graphics2D) gg;
        if (needswAPass) {
            g.setColor(Color.BLUE);
            g.drawString("enterID", this.enterAndSubmitThePasswordPanel.getLocation().x - 70, this.enterAndSubmitThePasswordPanel.getLocation().y + 58);
            g.setColor(Color.red);
            g.drawString("enterPassword", this.enterAndSubmitThePasswordPanel.getLocation().x - 100, this.enterAndSubmitThePasswordPanel.getLocation().y + 75);
        }


    }
}
