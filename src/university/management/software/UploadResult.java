package university.management.software;

import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;

public class UploadResult extends JFrame implements ActionListener{
    Choice regbox;
    JComboBox sembox;
    JButton submit,cancel;
    JTextField subject1,subject2,subject3,subject4,subject5,subject6,subject1marks,subject2marks,subject3marks,subject4marks,subject5marks,subject6marks;
    UploadResult(){
        super("Upload Student Marks");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        ImageIcon examimage = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image image = examimage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon newimg = new ImageIcon(image);        
        JLabel addimage = new JLabel(newimg);
        addimage.setBounds(500 , 75 , 400, 300);
        add(addimage);
        
        JLabel heading =  new JLabel("Enter Exam Result");
        heading.setBounds(50, 50, 250, 30);
        heading.setFont(new Font("" , Font.BOLD,20));
        add(heading);
        
        
        JLabel regno =  new JLabel("Select Roll No. ");
        regno.setBounds(50, 100, 100, 20);       
        add(regno);
        regbox = new Choice();
        regbox.setBounds(200, 100, 150, 20);
        add(regbox);
        try{
            
            Conn conn = new Conn();
            String query = "select * from tbl_student";
            ResultSet regdata = conn.s.executeQuery(query);
            while(regdata.next()){
                regbox.add(regdata.getString("registrationno"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel semester =  new JLabel("Select Semester ");
        semester.setBounds(50, 150, 100, 20);       
        add(semester);
        String sem[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        sembox = new JComboBox(sem);
        sembox.setBounds(200, 150, 150, 20);
        add(sembox);
        
        
        
        JLabel subjectlbl =  new JLabel("Subject Name");
        subjectlbl.setBounds(100, 250, 100, 20);       
        add(subjectlbl);
        JLabel markslbl =  new JLabel("Enter Marks");
        markslbl.setBounds(350, 250, 100, 20);       
        add(markslbl);
        
        subject1 = new JTextField();
        subject1.setBounds(70, 270, 150, 20);
        add(subject1); 
        
        subject1marks = new JTextField();
        subject1marks.setBounds(320, 270, 150, 20);
        add(subject1marks); 
        
        subject2 = new JTextField();
        subject2.setBounds(70, 290, 150, 20);
        add(subject2); 
        
        subject2marks = new JTextField();
        subject2marks.setBounds(320, 290, 150, 20);
        add(subject2marks); 
        
        subject3 = new JTextField();
        subject3.setBounds(70, 310, 150, 20);
        add(subject3); 
        
        subject3marks = new JTextField();
        subject3marks.setBounds(320, 310, 150, 20);
        add(subject3marks); 
        
        subject4 = new JTextField();
        subject4.setBounds(70, 330, 150, 20);
        add(subject4); 
        
        subject4marks = new JTextField();
        subject4marks.setBounds(320, 330, 150, 20);
        add(subject4marks); 
        
        subject5 = new JTextField();
        subject5.setBounds(70, 350, 150, 20);
        add(subject5); 
        
        subject5marks = new JTextField();
        subject5marks.setBounds(320, 350, 150, 20);
        add(subject5marks); 
        
        subject6 = new JTextField();
        subject6.setBounds(70, 370, 150, 20);
        add(subject6); 
        
        subject6marks = new JTextField();
        subject6marks.setBounds(320, 370, 150, 20);
        add(subject6marks); 
        
        
        submit = new JButton("Submit");
        submit.setBounds(100, 410, 80, 20);
        submit.addActionListener(this);
        add(submit);
        
        cancel  = new JButton("Cancel");
        cancel.setBounds(350, 410, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900 , 600);
        setLocation(250 , 100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            try{
                Conn conn = new Conn();
                String query1 = "insert into tbl_subject values('"+regbox.getSelectedItem()+"','"+sembox.getSelectedItem()+"','"+subject1.getText()+"','"+subject2.getText()+"','"+subject3.getText()+"','"+subject4.getText()+"','"+subject5.getText()+"','"+subject6.getText()+"')";
                String query2 = "insert into tbl_marks values('"+regbox.getSelectedItem()+"','"+sembox.getSelectedItem()+"','"+subject1marks.getText()+"','"+subject2marks.getText()+"','"+subject3marks.getText()+"','"+subject4marks.getText()+"','"+subject5marks.getText()+"','"+subject6marks.getText()+"')";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showConfirmDialog(null, "Success");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
        
        
        
        
        
        
    }
    public static void main(String args[]){
        new UploadResult();
    }
}
