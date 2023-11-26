package tours_travel.management.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Agent extends JFrame {

    private JPanel contentPane;
    private JTextField a1,a2,a3,a4,a5,a6;
    JComboBox cb;
    JRadioButton r1,r2;
    ButtonGroup g1;
    Choice c1;
    public static void main(String[] args){

            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Agent frame = new Agent();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

    }
public Agent() throws SQLException{
    setBounds(450, 145, 880, 600);
    contentPane = new JPanel();
    setContentPane(contentPane);
    contentPane.setLayout(null);

    ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/guide1.png"));
    Image i3 = i1.getImage().getScaledInstance(450, 500,Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(i3);
    JLabel l1 = new JLabel(i2);
    l1.setBounds(440,40,430,455);
    add(l1);

    JLabel lblName = new JLabel("NEW AGENT FORM");
    lblName.setFont(new Font("Yu Mincho", Font.BOLD, 25));
    lblName.setBounds(110, 11, 260, 53);
    contentPane.add(lblName);

    JLabel lblId = new JLabel("ID :");
    lblId.setBounds(35, 70, 200, 14);
    contentPane.add(lblId);

    cb = new JComboBox(new String[] {"Passport", "Aadhar Card", "Voter Id", "Driving license"});
    cb.setBounds(271, 70, 150, 20);
    contentPane.add(cb);

    JLabel l2 = new JLabel("Number :");
    l2.setBounds(35, 110, 200, 14);
    contentPane.add(l2);

    a1 = new JTextField();
    a1.setBounds(271, 110, 150, 20);
    contentPane.add(a1);
    a1.setColumns(10);

    JLabel lblName_1 = new JLabel("Name :");
    lblName_1.setBounds(35, 160, 200, 14);
    contentPane.add(lblName_1);

    a2 = new JTextField();
    a2.setBounds(271, 160, 150, 20);
    contentPane.add(a2);
    a2.setColumns(10);


    JLabel lblGender = new JLabel("Gender :");
    lblGender.setBounds(35, 190, 200, 14);
    contentPane.add(lblGender);

    r1 = new JRadioButton("Male");
    r1.setFont(new Font("Raleway", Font.BOLD, 14));
    r1.setBackground(Color.WHITE);
    r1.setBounds(271, 190, 80, 12);
    add(r1);

    r2 = new JRadioButton("Female");
    r2.setFont(new Font("Raleway", Font.BOLD, 14));
    r2.setBackground(Color.WHITE);
    r2.setBounds(350, 190, 100, 12);
    add(r2);
    g1 = new ButtonGroup();
    g1.add(r1);
    g1.add(r2);

    JLabel lblCountry = new JLabel("Country :");
    lblCountry.setBounds(35, 230, 200, 14);
    contentPane.add(lblCountry);

    a3 = new JTextField();
    a3.setBounds(271, 230, 150, 20);
    contentPane.add(a3);
    a3.setColumns(10);

    JLabel lblofficeAddress = new JLabel("OFFICE Address :");
    lblofficeAddress.setBounds(35, 270, 200, 14);
    contentPane.add(lblofficeAddress);

    a4 = new JTextField();
    a4.setBounds(271, 270, 150, 20);
    contentPane.add(a4);
    a4.setColumns(10);

    JLabel lblCheckInStatus = new JLabel("Phone :");
    lblCheckInStatus.setBounds(35, 310, 200, 14);
    contentPane.add(lblCheckInStatus);

    a5 = new JTextField();
    a5.setBounds(271, 310, 150, 20);
    contentPane.add(a5);
    a5.setColumns(10);

    JLabel lblDeposite = new JLabel("Email :");
    lblDeposite.setBounds(35, 350, 200, 14);
    contentPane.add(lblDeposite);

    a6 = new JTextField();
    a6.setBounds(271, 350, 150, 20);
    contentPane.add(a6);
    a6.setColumns(10);

    JButton btnNewButton = new JButton("Add");
    btnNewButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Conn c = new Conn();
            String radio = null;
            radio= r1.isSelected()? "Male":"Female";

            try{
                String s1 = (String)cb.getSelectedItem();
                String s2 =  a1.getText();
                String s3 =  a2.getText();
                String s4 =  radio;
                String s5 =  a3.getText();
                String s7 =  a4.getText();  //address
                String s8 =  a5.getText();
                String s10 = a6.getText(); //email

                String q1 = "insert into agent values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s7+"','"+s8+"','"+s10+"')";
                c.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Agent Added Successfully");
                setVisible(false);
            }catch(SQLException e1){
                System.out.println(e1.getMessage());
            }
            catch(NumberFormatException s){
                JOptionPane.showMessageDialog(null, "Please enter a valid Number");
            }
        }
    });
    btnNewButton.setBounds(100, 430, 120, 30);
    btnNewButton.setBackground(Color.BLACK);
    btnNewButton.setForeground(Color.WHITE);
    contentPane.add(btnNewButton);

    JButton btnSearchButton = new JButton("Search");
    btnSearchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Conn c = new Conn();
            try {
                c = new Conn();
                String s = a2.getText();
                ResultSet rs = c.s.executeQuery("select * from agent where name = '" + s + "'");
                if (rs.next()) {

                    a1.setText(rs.getString(2));
                    a3.setText(rs.getString(5));
                    a4.setText(rs.getString(6));
                    a5.setText(rs.getString(7));
                    a6.setText(rs.getString(8));

                }}catch(SQLException ex){
                    ex.printStackTrace();
                }
        }});
    btnSearchButton.setBounds(248, 430, 120, 30);
    btnSearchButton.setBackground(Color.BLACK);
    btnSearchButton.setForeground(Color.WHITE);
    contentPane.add(btnSearchButton);

    JButton btnUpdateButton = new JButton("Update");
    btnUpdateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Conn c = new Conn();
            String radio = null;
            radio= r1.isSelected()? "Female":"Male";

            try{
                String s1 = (String)cb.getSelectedItem();
                String s2 = a1.getText();
                String s3 =  a2.getText();
                String s4 =  radio;
                String s5 =  a3.getText();
                String s6 =  a4.getText();
                String s7 =  a5.getText();
                String s8 =  a6.getText();

                String q1 = "update agent set id = '"+s1+"', number = '"+s2+"', name = '"+s3+"', gender = '"+s4+"', country = '"+s5+"', address = '"+s6+"', phone = '"+s7+"', email = '"+s8+"' where name = '"+s3+"'";
                c.s.executeUpdate(q1);

                JOptionPane.showMessageDialog(null, "Agent Detail Updated Successfully");
                setVisible(false);
            }catch(SQLException e1){
                System.out.println(e1.getMessage());
            }
            catch(NumberFormatException s){
                JOptionPane.showMessageDialog(null, "Please enter a valid Number");
            }
        }
    });
    btnUpdateButton.setBounds(400, 430, 120, 30);
    btnUpdateButton.setBackground(Color.BLACK);
    btnUpdateButton.setForeground(Color.WHITE);
    contentPane.add(btnUpdateButton);

    JButton btnExit = new JButton("Back");
    btnExit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    });
    btnExit.setBounds(260, 470, 120, 30);
    btnExit.setBackground(Color.BLACK);
    btnExit.setForeground(Color.WHITE);
    contentPane.add(btnExit);

    getContentPane().setBackground(Color.WHITE);
}
}