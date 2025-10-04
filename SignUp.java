
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class SignUp extends JFrame implements ActionListener{
    JButton Create, Back;
    Choice accountType;
    JTextField meter,username,password,name;
    SignUp(){
        
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel Panel = new JPanel();
        Panel.setBounds(30, 30, 650,300);
        Panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230),2), "create-account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        Panel.setBackground(Color.WHITE);
        Panel.setLayout(null);
        Panel.setForeground(new Color(39, 134, 39));
        add(Panel);
        
        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tohma",Font.BOLD,14));
        Panel.add(heading);
        
        accountType = new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        
        Panel.add(accountType);
        
        JLabel lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100,90,140,20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tohma",Font.BOLD,14));
        lblmeter.setVisible(false);
        Panel.add(lblmeter);
        
        meter = new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        Panel.add(meter);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100,130,140,20);
        lblusername.setForeground(Color.GRAY);
        lblusername.setFont(new Font("Tohma",Font.BOLD,14));
        Panel.add(lblusername);
        
        username = new JTextField();
        username.setBounds(260,130,150,20);
        Panel.add(username);
    
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100,170,140,20);
        lblname.setForeground(Color.GRAY);
        lblname.setFont(new Font("Tohma",Font.BOLD,14));
        Panel.add(lblname);
        
        name = new JTextField();
        name.setBounds(260,170,150,20);
        Panel.add(name);
        meter.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){}
            @Override
            public void focusLost(FocusEvent fe) {
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                while(rs.next()){
                    name.setText(rs.getString("name"));
                }
            }
            catch(Exception e ){
                e.printStackTrace();
            }
            }
        });
        // password text lable and field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100,210,140,20);
        lblpassword.setForeground(Color.GRAY);
        lblpassword.setFont(new Font("Tohma",Font.BOLD,14));
        Panel.add(lblpassword);
       
        password = new JTextField();
        password.setBounds(260,210,150,20);
        Panel.add(password);
        
        
        
        accountType.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if(user.equals("Customer")){
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else{
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
            }
            }
           
        });
   
               
        
        
        Create = new JButton("Create");
        Create.setBounds(140,260,120,25);
//        Create.setBackground(Color.BLACK);
//        Create.setForeground(Color.WHITE);
        Create.addActionListener(this);
        Panel.add(Create);
        
        
        Back = new JButton("Back");
        Back.setBounds(300,260,120,25);
//        Create.setBackground(Color.BLACK);
//        Create.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Panel.add(Back);
       
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imagee = new JLabel(i3);
        imagee.setBounds(410, 30, 250, 250);
        Panel.add(imagee);
          
       setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== Create){       // it helps to find triger from which button
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();
            try{
                Conn c = new Conn();
                String query = null;
                if(atype.equals("Admin")){
                    query= "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+atype+"' )";  //if we concat the variable in string so we should use string break using this
                } 
                else{
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', user = '"+atype+"' where meter_no = '"+smeter+"'";
                }
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created successfully");
                setVisible(false);
                new Login();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== Back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new SignUp();
    }
}
