
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 
public class Login extends JFrame implements ActionListener{
    JButton Login, Cancel, SignUp;
    JTextField Username, Password;
    Choice logininin;
    Login(){
        super("login page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername = new JLabel("username"); // jlabel is used for anything write on frame 
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);
        
        Username = new JTextField();
        Username.setBounds(400, 20, 150, 20);
        add(Username);
        
        JLabel lblpassword = new JLabel("password"); // jlabel is used for anything write on frame 
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);
        
        Password = new JTextField();
        Password.setBounds(400, 60, 150, 20);
        add(Password);
        
        JLabel Logininas = new JLabel("logininas"); // jlabel is used for anything write on frame 
        Logininas.setBounds(300, 100, 100, 20);
        add(Logininas);
        
        logininin= new Choice();
        logininin.add("Admin");
        logininin.add("Customer");
        logininin.setBounds(400,100,150,20);
        add(logininin);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2= i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Login= new JButton("Login", new ImageIcon(i2));
        Login.setBounds(330, 160, 100, 20);
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon i3= new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4= i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        Cancel= new JButton("Cancel", new ImageIcon(i4));
        Cancel.setBounds(450, 160, 100, 20);
        Cancel.addActionListener(this);
        add(Cancel);
        
        ImageIcon i5= new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6= i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        SignUp= new JButton("SignUp", new ImageIcon(i6));
        SignUp.setBounds(380, 200, 100, 20);
        SignUp.addActionListener(this);
        add(SignUp);
        
        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8= i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== Login){       // it helps to find triger from which button
            String susername= Username.getText();
            String spassword= Password.getText();
            String user= logininin.getSelectedItem();
            try{
                Conn c = new Conn();
                String query= "select * from login where username='"+susername+"'and password='"+spassword+"'and user='"+user+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    String meter = rs.getString("meter_no");
                    setVisible(false);
                    new project(user, meter);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    Username.setText("");
                    Password.setText("");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== Cancel){
            setVisible(false);
        }else if(ae.getSource()== SignUp){
             setVisible(false);
             new SignUp();
        }
    }
    public static void main(String[] args){
        new Login();
    }
    
}
