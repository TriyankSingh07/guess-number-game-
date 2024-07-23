package guessnumber;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
public class mode {

    static int selectedChances;
    private static JRadioButton r1, r2, r3;
    private static JButton b1,b2;

    // Mapping between radio buttons and the number of chances
    private static Map<JRadioButton, Integer> chancesMap;

    public void mode() {
        JFrame frame = new JFrame("Select Game Mode");
       

        r1 = new JRadioButton("Easy");
        r2 = new JRadioButton("Medium");
        r3 = new JRadioButton("Hard");
        b1 = new JButton("Start");
        b2=new JButton("Back");

        // Set bounds for the radio buttons
        r1.setBounds(100, 20, 100, 20);
        r2.setBounds(100, 60, 100, 20);
        r3.setBounds(100, 100, 100, 20);

       
        b1.setBounds(190, 150, 80, 30);
        b2.setBounds(40, 150, 80, 30);
        

        // Initialize chances mapping
        chancesMap = new HashMap<>();
        chancesMap.put(r1, 11);
        chancesMap.put(r2, 7);
        chancesMap.put(r3, 5);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        frame.getContentPane().setBackground(new Color(129,122,198));
        b2.setBackground(new Color(87, 59, 105)); 
        b2.setForeground(new Color(255, 255, 255)); 
        b1.setBackground(new Color(87, 59, 105)); 
          b1.setForeground(new Color(255, 255, 255));
          r1.setBackground(new Color(129,122,198)); 
          r1.setForeground(new Color(255, 255, 255)); 
       r2.setBackground(new Color(129,122,198)); 
        r2.setForeground(new Color(255, 255, 255)); 
        r3.setBackground(new Color(129,122,198)); 
          r3.setForeground(new Color(255, 255, 255)); 
        frame.getContentPane().add(r1);
        frame.getContentPane().add(r2);
        frame.getContentPane().add(r3);
        frame.getContentPane().add(b1);
        frame.getContentPane().add(b2);

        // Set null layout for content pane
        frame.getContentPane().setLayout(null);

        // Set frame visible after adding components
        frame.setVisible(true);

        
        r1.setSelected(true);
      
       
       
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedChances = chancesMap.get(getSelectedRadioButton());
                guess.startGuessingGame(selectedChances);
                System.out.println("Selected Chances: " + selectedChances);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              frame.dispose();
            }
        });
      
        frame.setVisible(true);
    }

    private static JRadioButton getSelectedRadioButton() {
        if (r1.isSelected()) {
            return r1;
        } else if (r2.isSelected()) {
            return r2;
        } else if (r3.isSelected()) {
            return r3;
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new mode().mode());
    }

    public int getSelectedModeChances() {
        return selectedChances;
    }
}
