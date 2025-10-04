
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class paytm extends JFrame implements ActionListener{
    String meter;
    JButton back;
    paytm(String meter){
        this.meter = meter;
        setSize(800,600);
        setLocation(400,150);
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try{
            j.setPage("https://paytm.com/");
        }catch(Exception e){
           
           j.setText("<html>Could not Load<html>");
            
        }
        JScrollPane pane = new JScrollPane(j);
        add(pane);
        
        
        back = new JButton("Back");
        back.setBounds(640,20,80,30);
        back.addActionListener(this);
        j.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new paybill(meter);
    }
    
    public static void main(String[] args){
        new paytm("");
    }
}
