
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class paybill extends JFrame implements ActionListener{
    
    Choice cmonth;
    JButton pay,back;
    String meter;
    paybill(String meter){
        this.meter = meter;
        setLayout(null);
        setBounds(300, 150, 900, 600);
        
        JLabel heading = new JLabel("Electricity Bill");
        heading.setBounds(120,5,400,30);
        heading.setFont(new Font("Tohma",Font.PLAIN, 20));
        add(heading);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(35,80,200,20);
        add(lblmeterno);
        
        JLabel meterno = new JLabel("");
        meterno.setBounds(300,80,200,20);
        add(meterno);
        
         JLabel lblname = new JLabel("Name");
        lblname.setBounds(35,140,200,20);
        add(lblname);
        
        JLabel name = new JLabel("");
        name.setBounds(300,140,200,20);
        add(name);
        
         JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35,200,200,20);
        add(lblmonth);
        cmonth= new Choice();
        cmonth.setBounds(300, 200, 200, 20);
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
        add(cmonth);
        
        
         JLabel lblunits = new JLabel("Units");
        lblunits.setBounds(35,260,200,20);
        add(lblunits);
        
         JLabel units = new JLabel("");
        units.setBounds(300,260,200,20);
        add(units);
        
        
         JLabel lbltotalbill = new JLabel("Total Bill");
        lbltotalbill.setBounds(35,320,200,20);
        add(lbltotalbill);
        
        JLabel totalbill = new JLabel("");
        totalbill.setBounds(300,320,200,20);
        add(totalbill);
        
         JLabel lblstatus = new JLabel("Status");
        lblstatus.setBounds(35,380,200,20);
        add(lblstatus);
        
        JLabel status = new JLabel("");
        status.setBounds(300,380,200,20);
        status.setForeground(Color.red);
        add(status);
        
        try{
            Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
             while(rs.next()){
                 meterno.setText(meter);
                 name.setText(rs.getString("name"));
              rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and  month='"+cmonth.getSelectedItem()+"'");
             while(rs.next()){
                 units.setText(rs.getString("units"));
                 totalbill.setText(rs.getString("totalbill"));
                 status.setText(rs.getString("status"));
             }
             }
            
             
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cmonth.addItemListener(new ItemListener(){
            @Override
          public void itemStateChanged(ItemEvent ie){
              try{
            Conn c = new Conn();
           
              ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"'and  month='"+cmonth.getSelectedItem()+"'");
                 while(rs.next()){
                 units.setText(rs.getString("units"));
                 totalbill.setText(rs.getString("totalbill"));
                 status.setText(rs.getString("status"));
             }
        }catch(Exception e){
            e.printStackTrace();
        }
          }
        
        
        });
        
        pay = new JButton("Pay");
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== pay ){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("Update bill set status ='paid' where where meter_no = '"+meter+"' AND month = '"+cmonth.getSelectedItem()+"'");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new paytm(meter);
        }
    }
    
    public static void main(String[] args){
        new paybill("");
    }
}
