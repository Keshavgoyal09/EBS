package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class newcustomer extends JFrame implements ActionListener{
    JTextField tfname,tfadd, tfstate, tfcity, tfemail, tfphn;
    JButton Next, Cancel;
    JLabel lblmeter;
    newcustomer(){
        setSize(700,500);
        setLocation(400,200);


        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground((new Color(173, 216, 230)));
        add(p);
        JLabel heading= new JLabel("New Customer");
        heading.setBounds(180, 30, 200, 25);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24 ));
        p.add(heading);

        JLabel lblname= new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        tfname = new JTextField();
        tfname.setBounds(240, 80, 200, 20);
        p.add(tfname);

        JLabel lblmeterno= new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        lblmeter= new JLabel("");
        lblmeter.setBounds(240, 120, 100,20);
        p.add(lblmeter);
        Random ran= new Random();
        Long num = ran.nextLong()% 100000;
        lblmeter.setText(""+ Math.abs(num) );


        JLabel lbladd= new JLabel("Address");
        lbladd.setBounds(100, 160, 100, 20);
        p.add(lbladd);
        tfadd = new JTextField();
        tfadd.setBounds(240, 160, 200, 20);
        p.add(tfadd);

        JLabel lblstate= new JLabel("State");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        tfstate = new JTextField();
        tfstate.setBounds(240, 200, 200, 20);
        p.add(tfstate);

        JLabel lblcity= new JLabel("City");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        tfcity = new JTextField();
        tfcity.setBounds(240, 240, 200, 20);
        p.add(tfcity);

        JLabel lblemail= new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(240, 280, 200, 20);
        p.add(tfemail);

        JLabel lblphn= new JLabel("Phone No.");
        lblphn.setBounds(100, 320, 100, 20);
        p.add(lblphn);
        tfphn = new JTextField();
        tfphn.setBounds(240, 320, 200, 20);
        p.add(tfphn);

        Next = new JButton("Next");
        Next.setBounds(120,390,100,25);
        Next.addActionListener(this);
        p.add(Next);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(250,390,100,25);
        Cancel.addActionListener(this);
        p.add(Cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2= i1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        getContentPane().setBackground(Color.WHITE);


         setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==Next){
            String name= tfname.getText();
            String meter= lblmeter.getText();
            String address= tfadd.getText();
            String State = tfstate.getText();
            String city= tfcity.getText();
            String email= tfemail.getText(); 
            String phn= tfphn.getText();
            
            String query1= "insert into customer values('"+name+"', '"+meter+"', '"+address+"', '"+State+"', '"+city+"', '"+email+"', '"+phn+"')";
            String query2= "insert into login values('"+meter+"','','"+name+"','','')";
            try{
                Conn c= new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
            JOptionPane.showConfirmDialog(null, "Customer Details Added Successfully");
            setVisible(false);
            //frame
            new meterinfo(meter);
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }


    public static void main (String[] args){
        new newcustomer();
    }
}
