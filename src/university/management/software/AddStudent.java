package university.management.software;
import java.util.*;
//import java.util.Calendar;
//import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.time.YearMonth;
import javax.swing.*;
import java.awt.AWTError.*;
import java.awt.*;
import java.awt.event.*;
public class AddStudent extends JFrame implements ActionListener{
    
    JTextField studentnamebox,studentfaternamebox,studentaddressbox,studentnumberbox,studentemailbox,studentadharbox;
    JLabel studentregistrationnolbl;
    Random randomno = new Random();
    int year = YearMonth.now().getYear();
    long regno = Math.abs((randomno.nextLong() % 9000L) + 1000L);
    JDateChooser jdcdob;
    JComboBox studentcoursebox,streembox;
    JButton submit , cancel;
    
    AddStudent(){
        super("Add new Student");
        setLayout(null);
        JLabel heading = new JLabel("New Student Addmission");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif" , Font.BOLD , 30));
        add(heading);
        
        // Student Name
        JLabel studentname = new JLabel("Name");
        studentname.setBounds(50, 150, 100, 20);
        studentname.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentname);         
        studentnamebox = new JTextField();
        studentnamebox.setBounds(200, 150, 150, 20);
        add(studentnamebox);
        
        // Student Father Name
        JLabel studentfatername = new JLabel("Father's Name");
        studentfatername.setBounds(450, 150, 100, 20);
        studentfatername.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentfatername);         
        studentfaternamebox = new JTextField();
        studentfaternamebox.setBounds(650, 150, 150, 20);
        add(studentfaternamebox);
        
        // Student Roll No.
        JLabel studentregistrationno = new JLabel("Registration No.");
        studentregistrationno.setBounds(50, 200, 150, 20);
        studentregistrationno.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentregistrationno);       
//        Date date = new Date();
//        int year = date.getYear()+1900;
//        int year = Year.now().getValue();        
        studentregistrationnolbl = new JLabel(year+"403"+regno);
        studentregistrationnolbl.setBounds(200, 200, 100, 20);
        studentregistrationnolbl.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentregistrationnolbl);      
        
//      Student DoB
        JLabel studentdob = new JLabel("Date of Birth");
        studentdob.setBounds(450, 200, 100, 20);
        studentdob.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentdob);         
        jdcdob = new JDateChooser();
        jdcdob.setBounds(650, 200, 150, 20);
        add(jdcdob);
        
        // Student Address
        JLabel studentaddress = new JLabel("Address");
        studentaddress.setBounds(50, 250, 100, 20);
        studentaddress.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentaddress);         
        studentaddressbox = new JTextField();
        studentaddressbox.setBounds(200, 250, 150, 20);
        add(studentaddressbox);
        
        // Student Number
        JLabel studentnumber = new JLabel("Mobile Number");
        studentnumber.setBounds(450, 250, 150, 20);
        studentnumber.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentnumber);         
        studentnumberbox = new JTextField();
        studentnumberbox.setBounds(650, 250, 150, 20);
        add(studentnumberbox);
        
        // Student Email
        JLabel studentemail = new JLabel("Email");
        studentemail.setBounds(50, 300, 100, 20);
        studentemail.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentemail);         
        studentemailbox = new JTextField();
        studentemailbox.setBounds(200, 300, 150, 20);
        add(studentemailbox);
        
        
        // Student Aadhar No. 
        JLabel studentadhar = new JLabel("Aadhar");
        studentadhar.setBounds(450, 300, 150, 20);
        studentadhar.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentadhar);         
        studentadharbox = new JTextField();
        studentadharbox.setBounds(650, 300, 150, 20);
        add(studentadharbox);
        
        // Student Number
        JLabel studentcourse = new JLabel("Course");
        studentcourse.setBounds(50, 350, 100, 20);
        studentcourse.setFont(new Font("serif" , Font.BOLD , 15));
        add(studentcourse);         
        String course[] = {"Diploma" , "B.Tech" , "M.Tech" , "P.hD "};
        studentcoursebox = new JComboBox(course);
        studentcoursebox.setBounds(200, 350, 150, 20);
        add(studentcoursebox);
        // Student Email
        JLabel streem = new JLabel("Streem");
        streem.setBounds(450, 350, 150, 20);
        streem.setFont(new Font("serif" , Font.BOLD , 15));
        add(streem);         
        String coursestreem[] = {"CSE" , "MP" , "MA" , "EC"};
        streembox = new JComboBox(coursestreem);
        streembox.setBounds(650, 350, 150, 20);
        add(streembox);
        
        // Button
        submit =  new JButton("Submit");
        submit.setBounds(300, 450, 80, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("serif" , Font.BOLD , 15));
        add(submit);
        cancel =  new JButton("Cancel");
        cancel.setBounds(450, 450, 80, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif" , Font.BOLD , 15));
        add(cancel);
        
        
        
        
        setSize(900 , 600);
        setLocation(250 , 80);
        setVisible(true);
    }
    
    
    
    public void actionPerformed(ActionEvent actionevent){
        if(actionevent.getSource() == submit){
            String name = studentnamebox.getText();
            String fathername = studentfaternamebox.getText();
            String address = studentaddressbox.getText();
            String number = studentnumberbox.getText();
            String email =  studentemailbox.getText();
            String aadharno = studentadharbox.getText();
            String dob = ((JTextField) jdcdob.getDateEditor().getUiComponent()).getText();
            String course = (String)studentcoursebox.getSelectedItem();
            String streem = (String)streembox.getSelectedItem();
            String registrationno = studentregistrationnolbl.getText();
            try{
                String query = "insert into tbl_student Values('"+name+"', '"+fathername+"', '"+address+"', '"+number+"', '"+email+"', '"+aadharno+"', '"+dob+"', '"+course+"', '"+streem+"', '"+registrationno+"')";
                Conn conn = new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Success");
                setVisible(false);
                new Project();                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new AddStudent();
    }
}
