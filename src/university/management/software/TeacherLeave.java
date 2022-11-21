package university.management.software;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class TeacherLeave extends JFrame implements ActionListener{
    Choice regnumber,leavetimeduration;
    JDateChooser Teacherleavedate;
    JButton submit, cancel; 
    JTextField leavereasion;
    TeacherLeave(){
        super("Teacher Leave Details");
        setLayout(null);
        JLabel heading = new JLabel("Apply Teacher Leave ");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 20));
        add(heading);
        
        JLabel registrationnumber = new JLabel("Teacher Registration Number ");
        registrationnumber.setBounds(50,120, 200 , 25);
        add(registrationnumber);        
        regnumber = new Choice();
        regnumber.setBounds(250,120, 200 , 25);
        add(regnumber);
        try{
            Conn conn = new Conn();            
            ResultSet regno = conn.s.executeQuery("select * from tbl_teacher");
            while(regno.next()){
                regnumber.add(regno.getString("registrationno"));
            }        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        JLabel leavedate = new JLabel("Date");
        leavedate.setBounds(50,160, 200 , 25);
        add(leavedate);        
        Teacherleavedate = new JDateChooser();
        Teacherleavedate.setBounds(250,160, 200 , 25);
        add(Teacherleavedate);
        JLabel timeduration = new JLabel("Time Duration");
        timeduration.setBounds(50,200, 200 , 25);
        add(timeduration);        
        leavetimeduration = new Choice();
        leavetimeduration.setBounds(250,200, 200 , 25);
        leavetimeduration.add("Full Day");
        leavetimeduration.add("Half Day");
        add(leavetimeduration);
        
        JLabel reasion = new JLabel("Reasion");
        reasion.setBounds(50,240, 200 , 25);
        add(reasion);        
        leavereasion = new JTextField();
        leavereasion.setBounds(250,240, 200 , 25);
        add(leavereasion);
        
        submit = new JButton("Submit");
        submit.setBounds(150 , 300 , 80 , 25);
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.addActionListener(this);        
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250 , 300 , 80 , 25);
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);        
        add(cancel);
        
       
        setLocation(450 ,  100);
        setSize(500 , 400);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent actionevent){
        if(actionevent.getSource() == submit){
             String registrationnumber =  regnumber.getSelectedItem();
             String date = ((JTextField) Teacherleavedate.getDateEditor().getUiComponent()).getText();
             String duration =  leavetimeduration.getSelectedItem();
             String reasion = leavereasion.getText();
             String query =  "insert into tbl_Teacherleave values('"+registrationnumber+"','"+date+"','"+duration+"','"+reasion+"')";
             
             try{
                 Conn conn = new Conn();
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null , "Success");
                 setVisible(false);
                 new Project();
             }catch(Exception e){
                 e.printStackTrace();
             }
             
             
                     

        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new TeacherLeave();
        
    }
}
