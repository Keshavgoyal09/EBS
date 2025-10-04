
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class project extends JFrame implements ActionListener{
    String auser, meter;
    project(String auser, String meter){
        this.auser = auser;
        this.meter = meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);   //THIS FUNCTION HELPS TO MAXIMIZE THE LENGTH AND WIDTH
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/ebsmain.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
       
        
        JMenuBar mb = new JMenuBar();
        mb.setPreferredSize(new Dimension(500, 50));
        mb.setOpaque(true); // Needed for custom color
        mb.setBackground(new Color(97,180, 190));   // Background color
//        mb.setForeground(new Color(97,180, 190)); // Text color
        setJMenuBar(mb);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/logoebsmain.png"));

        // Resize image (say 20x20 px)
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);

        // Create new ImageIcon with resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImg);
        // FIRST
        JMenu master = new JMenu("Master");
        master.setFont(new Font("copperplate gothic bold",Font.PLAIN, 20));
        master.setIcon(resizedIcon);
        master.setIconTextGap(8);
        master.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        
        JMenuItem newcustomer = new JMenuItem("new customer");
        newcustomer.setFont(new Font("monospaced",Font.PLAIN, 15));
        newcustomer.setBackground(Color.WHITE);
        ImageIcon icon1= new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image image1= icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newcustomer.setIcon(new ImageIcon(image1));
        newcustomer.setMnemonic('N');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN, 15));
        customerdetails.setBackground(Color.WHITE);
        ImageIcon icon2= new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image image2= icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(image2));
        customerdetails.setMnemonic('A');
        customerdetails.addActionListener(this);
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        master.add(customerdetails);
      
        JMenuItem Depositedetails = new JMenuItem("Deposite Details");
        Depositedetails.setFont(new Font("monospaced",Font.PLAIN, 15));
        Depositedetails.setBackground(Color.WHITE);
        ImageIcon icon3= new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image image3= icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        Depositedetails.setIcon(new ImageIcon(image3));
        Depositedetails.setMnemonic('D');
        Depositedetails.addActionListener(this);
        Depositedetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(Depositedetails);
        
        JMenuItem calculatebill= new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN, 15));
        calculatebill.setBackground(Color.WHITE);
        ImageIcon icon4= new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image image4= icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(image4));
        calculatebill.setMnemonic('C');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(calculatebill);
      
        
        // SECOND
        JMenu info = new JMenu("INFO");
        info.setFont(new Font("copperplate gothic bold",Font.PLAIN, 18));
        
        
        JMenuItem update= new JMenuItem("Update Information");
        update.setFont(new Font("monospaced",Font.PLAIN, 15));
        update.setBackground(Color.WHITE);
        ImageIcon icon5= new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image image5= icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        update.setIcon(new ImageIcon(image5));
        update.setMnemonic('U');
        update.addActionListener(this);
        update.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(update);
        
        JMenuItem view= new JMenuItem("View Information");
        view.setFont(new Font("monospaced",Font.PLAIN, 15));
        view.setBackground(Color.WHITE);
        ImageIcon icon6= new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image image6= icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        view.setIcon(new ImageIcon(image6));
        view.setMnemonic('V');
        view.addActionListener(this);
        view.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        info.add(view);
        
        //THIRD
        JMenu user = new JMenu("USER");
        user.setIcon(resizedIcon);
        user.setFont(new Font("copperplate gothic bold",Font.PLAIN, 18));
        
        
        JMenuItem pay= new JMenuItem("Pay Bill");
        pay.setFont(new Font("monospaced",Font.PLAIN, 15));
        pay.setBackground(Color.WHITE);
        ImageIcon icon7= new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image image7= icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        pay.setIcon(new ImageIcon(image7));
        pay.setMnemonic('P');
        pay.addActionListener(this);
        pay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(pay);
        
        JMenuItem billdetails= new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN, 15));
        billdetails.setBackground(Color.WHITE);
        ImageIcon icon8= new ImageIcon(ClassLoader.getSystemResource("icon/icon8.png"));
        Image image8= icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(image6));
        billdetails.setMnemonic('I');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        //Fourth
        JMenu reciept = new JMenu("RECIEPT");
        reciept.setFont(new Font("copperplate gothic bold",Font.PLAIN, 18));
       
        
        JMenuItem generatebill= new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("monospaced",Font.PLAIN, 15));
        generatebill.setBackground(Color.WHITE);
        ImageIcon icon9= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image9= icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(image9));
        generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        reciept.add(generatebill);
        
         //Fifth
        JMenu utility = new JMenu("UTILITY");
        utility.setFont(new Font("copperplate gothic bold",Font.PLAIN, 18));
       
        
        JMenuItem notepad= new JMenuItem("NotePad");
        notepad.setFont(new Font("monospaced",Font.PLAIN, 15));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10= new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image image10= icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(image10));
        notepad.setMnemonic('B');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem calculator= new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN, 15));
        calculator.setBackground(Color.WHITE);
        ImageIcon icon11= new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image image11= icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(image11));
        calculator.setMnemonic('T');
        calculator.addActionListener(this);
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        utility.add(calculator);
        
        
        //sisth
        JMenu logout = new JMenu("LOGOUT");
        logout.setFont(new Font("copperplate gothic bold",Font.PLAIN, 18));
        logout.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
       
        
        JMenuItem EXIT= new JMenuItem("EXIT");
        EXIT.setFont(new Font("monospaced",Font.PLAIN, 15));
        EXIT.setBackground(Color.WHITE);
        ImageIcon icon12= new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image image12= icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        EXIT.setIcon(new ImageIcon(image12));
        EXIT.setMnemonic('X');
        EXIT.addActionListener(this);
        EXIT.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        logout.add(EXIT);
        setLayout(new FlowLayout());
        if(auser.equals("Admin")){
            mb.add(master);
        }else{
            mb.add(user);
            mb.add(info);
            mb.add(reciept);
        }
       
        mb.add(utility);
        mb.add(Box.createHorizontalGlue());
        mb.add(logout);
       
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("new customer")){
             new newcustomer();
        }
        else if(msg.equals("Customer Details")){
             new customerdetails();
        }else if(msg.equals("Deposite Details")){
            new depositedetails();
            
        }else if(msg.equals("Calculate Bill")){
            new calculatebill();
        }else if(msg.equals("View Information")){
            new viewinformation(meter);
        }else if(msg.equals("Update Information")){
            new updateinfo(meter);
        }else if(msg.equals("Bill Details")){
            new billdetails(meter);
        }else if(msg.equals("NotePad")){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if(msg.equals("Calculator")){
            try{
               Runtime.getRuntime().exec("calc.exe");
           }catch(Exception e){
               e.printStackTrace();
           }
        }else if(msg.equals("EXIT")){
            setVisible(false);
            new Login();
        }else if(msg.equals("Pay Bill")){
            new paybill(meter);
        }else if(msg.equals("Generate Bill")){
            new generatebill(meter);
        }
    }
    
    
    
    
    public static void main(String[] args){
        new project("","");
    }
}
