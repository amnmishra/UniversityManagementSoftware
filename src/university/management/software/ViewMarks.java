package university.management.software;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;


public class ViewMarks extends JFrame implements ActionListener{
    
    String regno; 
    JButton cancel;
    ViewMarks(String regno){
    
        this.regno = regno;
        setLayout(null);
        
        JLabel heading = new JLabel("BNCET");
        heading.setBounds(190,20,150,30);
        heading.setFont(new Font("",Font.BOLD,30));
        add(heading);
        JLabel subheading = new JLabel("Result of Examination 2022");
        subheading.setBounds(120,50,300,30);
        subheading.setFont(new Font("",Font.PLAIN,20));
        add(subheading);
        
        
        
        
        
        JLabel registrationno = new JLabel("Registration Number  :  " + regno);
        registrationno.setBounds(60,100,400,25);
        add(registrationno);
        JLabel semester = new JLabel("Semester  :  ");
        semester.setBounds(60,120,400,30);
        add(semester);
        
        
        JLabel subject1 = new JLabel();
        subject1.setBounds(100,200,150,25);
        add(subject1);
        JLabel subject2 = new JLabel();
        subject2.setBounds(100,220,150,25);
        add(subject2);
        JLabel subject3 = new JLabel();
        subject3.setBounds(100,240,150,25);
        add(subject3);
        JLabel subject4 = new JLabel();
        subject4.setBounds(100,260,150,25);
        add(subject4);
        JLabel subject5 = new JLabel();
        subject5.setBounds(100,280,150,25);
        add(subject5);
        JLabel subject6 = new JLabel();
        subject6.setBounds(100,300,150,25);
        add(subject6);
        
        JLabel subject1marks = new JLabel();
        subject1marks.setBounds(300,200,150,25);
        add(subject1marks);
        JLabel subject2marks = new JLabel();
        subject2marks.setBounds(300,220,150,25);
        add(subject2marks);
        JLabel subject3marks = new JLabel();
        subject3marks.setBounds(300,240,150,25);
        add(subject3marks);
        JLabel subject4marks = new JLabel();
        subject4marks.setBounds(300,260,150,25);
        add(subject4marks);
        JLabel subject5marks = new JLabel();
        subject5marks.setBounds(300,280,150,25);
        add(subject5marks);
        JLabel subject6marks = new JLabel();
        subject6marks.setBounds(300,300,150,25);
        add(subject6marks);
        try{
            Conn conn = new Conn();
            ResultSet rset = conn.s.executeQuery("select * from tbl_subject where registrationno = '"+regno+"'");
            
            while(rset.next()){
                subject1.setText(rset.getString("subject1"));
                subject2.setText(rset.getString("subject2"));
                subject3.setText(rset.getString("subject3"));
                subject4.setText(rset.getString("subject4"));
                subject5.setText(rset.getString("subject5"));
                subject6.setText(rset.getString("subject6"));
            }
            
            ResultSet rsetmarks = conn.s.executeQuery("select * from tbl_marks where registrationno = '"+regno+"'");
            
            while(rsetmarks.next()){
                subject1marks.setText(rsetmarks.getString("subject1marks"));
                subject2marks.setText(rsetmarks.getString("subject2marks"));
                subject3marks.setText(rsetmarks.getString("subject3marks"));
                subject4marks.setText(rsetmarks.getString("subject4marks"));
                subject5marks.setText(rsetmarks.getString("subject5marks"));
                subject6marks.setText(rsetmarks.getString("subject6marks"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Back");
        cancel.addActionListener(this);
        cancel.setBounds(170, 350, 120, 25);
        add(cancel);
        
        
        getContentPane().setBackground(Color.white);
        setSize(500,450);
        setLocation(450 , 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new ViewResult();
        }
    }
    
    public static void main(String args[]){
        new ViewMarks("");
    }
}
