
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class calculatebill extends JFrame implements ActionListener{
    JTextField tfname,tfadd, tfunit, tfcity, tfemail, tfphn;
    JButton Next, Cancel;
    JLabel lblname, lbladdress;
    Choice meternumber, cmonth;
    calculatebill(){
        setSize(700,500);
        setLocation(400,150);


        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground((new Color(173, 216, 230)));
        add(p);
        JLabel heading= new JLabel("Calculate Electricity Bill");
        heading.setBounds(150, 30, 300, 25);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24 ));
        p.add(heading);

        
        JLabel lblmeterno= new JLabel("Meter Number");
        lblmeterno.setBounds(100, 80, 100, 20);
        p.add(lblmeterno);
        
        meternumber= new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                meternumber.add(rs.getString("meter"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);
        
        JLabel lblnames= new JLabel(" Name");
        lblnames.setBounds(100, 120, 100, 20);
        p.add(lblnames);
        lblname= new JLabel("");
        lblname.setBounds(240, 120, 100,20);
        p.add(lblname);



        JLabel lbladd= new JLabel("Address");
        lbladd.setBounds(100, 160, 100, 20);
        p.add(lbladd);
        lbladdress= new JLabel("");
        lbladdress.setBounds(240, 160, 100,20);
        p.add(lbladdress);
        try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter= '"+meternumber.getSelectedItem()+"'");
                    while(rs.next()){
                        lblname.setText(rs.getString("Name"));
                        lbladdress.setText(rs.getString("Address"));
                    }

                }
        catch(Exception e){
            e.printStackTrace();
        }
        
        meternumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                 try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter= '"+meternumber.getSelectedItem()+"'");
                    while(rs.next()){
                        lblname.setText(rs.getString("Name"));
                        lbladdress.setText(rs.getString("Address"));
                    }

                }
        catch(Exception e){
            e.printStackTrace();
        }
            }
        });
        
        
        JLabel lblstate= new JLabel("Unit Consumed");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        tfunit = new JTextField();
        tfunit.setBounds(240, 200, 200, 20);
        p.add(tfunit);

        JLabel lblcity= new JLabel("Month");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        cmonth= new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("Feburary");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);
       

        Next = new JButton("Submit");
        Next.setBounds(120,350,100,25);
        Next.addActionListener(this);
        p.add(Next);

        Cancel = new JButton("Cancel");
        Cancel.setBounds(250,350,100,25);
        Cancel.addActionListener(this);
        p.add(Cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
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
            
            String meter= meternumber.getSelectedItem();
            String units= tfunit.getText();
            String month = cmonth.getSelectedItem();
      
            int totalbill = 0;
            int unit_consumed= Integer.parseInt(units);
              String query= "select * from tax";
            try{
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("Cost_Per_Unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                    
                }
         
            }catch(Exception e){
               e.printStackTrace();
            }
            String query2 = "insert into bill values('"+meter+"', '"+month+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }


    public static void main (String[] args){
        new calculatebill();
    }
}
