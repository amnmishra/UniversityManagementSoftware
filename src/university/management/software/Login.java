package university.management.software;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements  ActionListener{    
    
    
    JButton loginbutton,cancelbutton;
    JTextField passwordbox,useridbox;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        // User Section
        JLabel userid =  new JLabel("User ID");       
        userid.setBounds(40 , 20 , 100 , 20);
        add(userid);
        
        useridbox = new JTextField();
        useridbox.setBounds(140, 20, 100, 20);
        add(useridbox);
        
        // Password Section
        JLabel password =  new JLabel("Password");
        password.setBounds(40, 60, 100, 20);
        add(password);
        passwordbox = new JTextField();
        passwordbox.setBounds(140, 60, 100, 20);
        add(passwordbox);
        // Button
        loginbutton  = new JButton("Login");
        loginbutton.setBounds(40, 140, 80, 30);
        loginbutton.setBackground(Color.BLACK);
        loginbutton.setForeground(Color.WHITE);
        loginbutton.setFont(new Font("Tahoma", Font.BOLD,14));
        loginbutton.addActionListener(this);
        add(loginbutton);
        cancelbutton  = new JButton("Cancel");
        cancelbutton.setBounds(150, 140, 80, 30);
        cancelbutton.setBackground(Color.BLACK);
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.setFont(new Font("Tahoma", Font.BOLD,14));
        cancelbutton.addActionListener(this);
        add(cancelbutton);
        //Image
        ImageIcon usericon =  new ImageIcon(ClassLoader.getSystemResource("icon/userloginpage.png"));
        Image newcustomimage = usericon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon addimage =  new ImageIcon(newcustomimage);
        JLabel confirmImageicon = new JLabel(addimage);
        confirmImageicon.setBounds(300, 0, 200, 200);
        add(confirmImageicon);
        
        setSize(600,300);
        setLocation(350 , 200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent acvtioneventonj){
        if(acvtioneventonj.getSource() == loginbutton){
            String username = useridbox.getText();
            String password = passwordbox.getText();
            String query = "select * from tbl_admin where username ='"+username+"' and password = '"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(acvtioneventonj.getSource() == cancelbutton){
            setVisible(false);
        }   
    }
    public static void main(String [] args){
        new Login();
    }

}