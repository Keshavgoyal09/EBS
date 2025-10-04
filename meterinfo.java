package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class meterinfo extends JFrame implements ActionListener{
    
    JButton Next;
    Choice meterlocation,metertype, phasecode, billtype;
    String meternumber;
    meterinfo(String meternumber){
        this.meternumber= meternumber;
        setSize(700,500);
        setLocation(400,200);


        JPanel p= new JPanel();
        p.setLayout(null);
        p.setBackground((new Color(173, 216, 230)));
        add(p);
        JLabel heading= new JLabel("Meter Information");
        heading.setBounds(180, 30, 200, 25);
        heading.setFont(new Font("Tahoma",Font.PLAIN, 24 ));
        p.add(heading);

        JLabel lblname= new JLabel("Meter No.");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);
        JLabel lblmeternumber= new JLabel(meternumber);
        lblmeternumber.setBounds(240, 80, 100, 20);
        p.add(lblmeternumber);

        JLabel lblmeterloc= new JLabel("Meter Location");
        lblmeterloc.setBounds(100, 120, 100, 20);
        p.add(lblmeterloc);
        meterlocation= new Choice();
        meterlocation.add("outside");
        meterlocation.add("Inside");
        meterlocation.setBounds(240, 120, 200, 20);
        p.add(meterlocation);
       
        JLabel lbladd= new JLabel("Meter Type");
        lbladd.setBounds(100, 160, 100, 20);
        p.add(lbladd);
        metertype= new Choice();
        metertype.add("Electric Meter ");
        metertype.add("Solar Meter");
        metertype.add("Smart Meter");
        metertype.setBounds(240, 160, 200, 20);
        p.add(metertype);
       

        JLabel lblstate= new JLabel("Phase Code");
        lblstate.setBounds(100, 200, 100, 20);
        p.add(lblstate);
        phasecode= new Choice();
        phasecode.add(" 011 ");
        phasecode.add(" 022");
        phasecode.add(" 033");
        phasecode.add(" 044");
        phasecode.add(" 055");
        phasecode.add(" 066");
        phasecode.add(" 077");
        phasecode.add(" 088");
        phasecode.add(" 099");
        phasecode.setBounds(240, 200, 200, 20);
        p.add(phasecode);
       

        JLabel lblcity= new JLabel("Bill Type");
        lblcity.setBounds(100, 240, 100, 20);
        p.add(lblcity);
        billtype= new Choice();
        billtype.add("Normal");
        billtype.add("Industrial");
        billtype.setBounds(240, 240, 200, 20);
        p.add(billtype);
        
        JLabel lblemail= new JLabel("Days");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
         JLabel lblemails= new JLabel("30 Days");
        lblemails.setBounds(240, 280, 100, 20);
        p.add(lblemails);
        
        JLabel lblphn= new JLabel("Note");
        lblphn.setBounds(100, 320, 100, 20);
        p.add(lblphn);
        JLabel lblphns= new JLabel("By Default Bill is Calculated 30 Days only");
        lblphns.setBounds(240, 320, 500, 20);
        p.add(lblphns);
       

        Next = new JButton("Subit");
        Next.setBounds(220,390,100,25);
        Next.addActionListener(this);
        p.add(Next);

       

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
            String meter= meternumber;
            String location= meterlocation.getSelectedItem();
            String type= metertype.getSelectedItem();
            String code = phasecode.getSelectedItem();
            String typebill= billtype.getSelectedItem();
            String days= "30";
            
            
            String query= "insert into meter_info values('"+meter+"', '"+location+"', '"+type+"', '"+code+"', '"+typebill+"', '"+days+"')";
           
            try{
                Conn c= new Conn();
                c.s.executeUpdate(query);
                
                
            JOptionPane.showConfirmDialog(null, "Meter Information Added Successfully");
            setVisible(false);
            //frame
            }catch(Exception e){
               e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }


    public static void main (String[] args){
        new meterinfo("");
    }
}
