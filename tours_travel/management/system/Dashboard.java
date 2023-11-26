package tours_travel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame{
  
    Dashboard() {
        setBounds(0, 0, 1500, 900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel (i3);
        icon.setBounds (5, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 400);
        
        p1.add(heading);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Dashboard();
    }
}
