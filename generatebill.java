
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class generatebill extends JFrame implements ActionListener{
    String meter;
    Choice cmonth;
    JTextArea area;
    JButton bill;
    generatebill(String meter){
        this.meter = meter;
        setSize(500,700);
        setLocation(500,50);
        
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);
        
        cmonth = new Choice();
        cmonth.setBounds(520, 20, 150, 20);
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
        
        area = new JTextArea(50,15);
        area.setText("\n\n\t--------click on the -------\n\t Generate bill button to get \n\t the bill of selected Month");
        area.setFont(new Font("Senserif",Font.ITALIC, 18));
        JScrollPane pane = new JScrollPane(area);
        
        
         bill = new JButton("Generate Bill");
         bill.addActionListener(this); 
        panel.add(heading);
         panel.add(meternumber);
         panel.add(cmonth);
         add(panel,"North");
         
         add(pane,"Center");
         add(bill,"South");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
            Conn c= new Conn();
            String month = cmonth.getSelectedItem();
            area.setText("\t Reliance Power Limited\n  Generated Electricity Bill Generated For The Month\n\t of '"+month+"',2022 \n\n\n");
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            
            
            if(rs.next()){
                area.append("\n   Customer name: " + rs.getString("name"));
                area.append("\n   meternumber: " + rs.getString("meter"));
                area.append("\n   Address: " + rs.getString("address"));
                area.append("\n   city: " + rs.getString("city"));     
                area.append("\n   state: " + rs.getString("state"));     
                area.append("\n   email: " + rs.getString("email")); 
                area.append("\n   phone: " + rs.getString("phn")); 
                area.append("\n------------------------------------------");
                area.append("\n");
            } 
            rs = c.s.executeQuery("select * from meter_info where meter_no = '"+meter+"'");
            if(rs.next()){
                area.append("\n   meter location: " + rs.getString("meter_location"));
                area.append("\n   meter Type: " + rs.getString("meter_type"));
                area.append("\n   Phase: " + rs.getString("phase_code"));
                area.append("\n   Bill Type: " + rs.getString("bill_type"));     
                area.append("\n   Days: " + rs.getString("days"));     
                area.append("\n----------------------------------------------------"); 
                area.append("\n"); 
               
            }
            
             rs = c.s.executeQuery("select * from tax");
            if(rs.next()){
                area.append("\n");
                area.append("\n Cost Per Unit: " + rs.getString("cost_per_unit"));
                area.append("\n meter Rent : " + rs.getString("meter_rent"));
                area.append("\n service charge: " + rs.getString("service_charge"));     
                area.append("\n service Tax: " + rs.getString("service_tax")); 
                area.append("\n swacch bharat cess: " + rs.getString("swacch_bharat_cess"));  
                area.append("\n Fixed Tax: " + rs.getString("fixed_tax")); 
                area.append("\n");
                area.append("\n"); 
               
            }
             rs = c.s.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+month+"'");
            if(rs.next()){
                area.append("\n");
                area.append("\n  Current month : " + rs.getString("month"));
                area.append("\n  units Consumed : " + rs.getString("units"));
                area.append("\n  Totalbill: " + rs.getString("totalbill"));     
                area.append("\n----------------------------------------------------"); 
                 area.append("\n  TotalPayble: " + rs.getString("totalbill"));
                area.append("\n"); 
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new generatebill("");
    }
}
