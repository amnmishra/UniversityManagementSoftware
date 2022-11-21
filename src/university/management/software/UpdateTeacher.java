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
import java.sql.ResultSet;
public class UpdateTeacher extends JFrame implements ActionListener{
    
    JTextField teachernamebox,teacherfaternamebox,teacheraddressbox,teachernumberbox,teacheremailbox,teacheradharbox;
    JLabel teacherregistrationnolbl,showdate;
    Random randomno = new Random();
    int year = YearMonth.now().getYear();
    long regno = Math.abs((randomno.nextLong() % 9000L) + 1000L);
    JDateChooser jdcdob;
    JComboBox teachercoursebox,streembox;
    JButton submit , cancel;
    Choice selectregistrationnumber;
    UpdateTeacher(){
        super("Update Teacher Details");
        setLayout(null);
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("serif" , Font.BOLD , 30));
        add(heading);
        
        
        JLabel selectregno = new JLabel("Select Teacher Registration No .");
        selectregno.setBounds(50 , 100 , 200 , 20);
        add(selectregno);
        
        selectregistrationnumber = new Choice();
        selectregistrationnumber.setBounds(300 , 100 , 200 , 20);
        add(selectregistrationnumber);
        try{
            Conn conn = new Conn();
            ResultSet regnodata = conn.s.executeQuery("Select * from tbl_teacher");
            while(regnodata.next()){
                selectregistrationnumber.add(regnodata.getString("registrationno"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        // Teacher  Name
        JLabel teachername = new JLabel("Name");
        teachername.setBounds(50, 150, 100, 20);
        teachername.setFont(new Font("serif" , Font.BOLD , 15));
        add(teachername);         
        teachernamebox = new JTextField();
        teachernamebox.setBounds(200, 150, 150, 20);
        add(teachernamebox);
        
        // Teacher Father Name
        JLabel teacherfatername = new JLabel("Father's Name");
        teacherfatername.setBounds(450, 150, 100, 20);
        teacherfatername.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacherfatername);         
        teacherfaternamebox = new JTextField();
        teacherfaternamebox.setBounds(650, 150, 150, 20);
        add(teacherfaternamebox);
        
        // Teacher Roll No.
        JLabel teacherregistrationno = new JLabel("Registration No.");
        teacherregistrationno.setBounds(50, 200, 150, 20);
        teacherregistrationno.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacherregistrationno);       
//        Date date = new Date();
//        int year = date.getYear()+1900;
//        int year = Year.now().getValue();        
        teacherregistrationnolbl = new JLabel();
        teacherregistrationnolbl.setBounds(200, 200, 100, 20);
        teacherregistrationnolbl.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacherregistrationnolbl);      
        
//      Teacher DoB
        showdate = new JLabel();
        showdate.setBounds(550, 200, 100, 20);
        showdate.setFont(new Font("serif" , Font.BOLD , 15));
        add(showdate);
        JLabel teacherdob = new JLabel("Date of Birth");
        teacherdob.setBounds(450, 200, 100, 20);
        teacherdob.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacherdob); 
         
        jdcdob = new JDateChooser();
        jdcdob.setBounds(650, 200, 150, 20);
        add(jdcdob);
        
        // Teacher Address
        JLabel teacheraddress = new JLabel("Address");
        teacheraddress.setBounds(50, 250, 100, 20);
        teacheraddress.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacheraddress);         
        teacheraddressbox = new JTextField();
        teacheraddressbox.setBounds(200, 250, 150, 20);
        add(teacheraddressbox);
        
        // Teacher Number
        JLabel teachernumber = new JLabel("Mobile Number");
        teachernumber.setBounds(450, 250, 150, 20);
        teachernumber.setFont(new Font("serif" , Font.BOLD , 15));
        add(teachernumber);         
        teachernumberbox = new JTextField();
        teachernumberbox.setBounds(650, 250, 150, 20);
        add(teachernumberbox);
        
        // Teacher Email
        JLabel teacheremail = new JLabel("Email");
        teacheremail.setBounds(50, 300, 100, 20);
        teacheremail.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacheremail);         
        teacheremailbox = new JTextField();
        teacheremailbox.setBounds(200, 300, 150, 20);
        add(teacheremailbox);
        
        
        // Teacher Aadhar No. 
        JLabel teacheradhar = new JLabel("Aadhar");
        teacheradhar.setBounds(450, 300, 150, 20);
        teacheradhar.setFont(new Font("serif" , Font.BOLD , 15));
        add(teacheradhar);         
        teacheradharbox = new JTextField();
        teacheradharbox.setBounds(650, 300, 150, 20);
        add(teacheradharbox);
        
        // Teacher Number
        JLabel teachercourse = new JLabel("Course");
        teachercourse.setBounds(50, 350, 100, 20);
        teachercourse.setFont(new Font("serif" , Font.BOLD , 15));
        add(teachercourse);         
        String course[] = {"Diploma" , "B.Tech" , "M.Tech" , "P.hD "};
        teachercoursebox = new JComboBox(course);
        teachercoursebox.setBounds(200, 350, 150, 20);
        add(teachercoursebox);
        // Teacher Email
        JLabel streem = new JLabel("Streem");
        streem.setBounds(450, 350, 150, 20);
        streem.setFont(new Font("serif" , Font.BOLD , 15));
        add(streem);         
        String coursestreem[] = {"CSE" , "MP" , "MA" , "EC"};
        streembox = new JComboBox(coursestreem);
        streembox.setBounds(650, 350, 150, 20);
        add(streembox);
        
        
        
        try{
            Conn conn = new Conn();
            ResultSet teacherdata = conn.s.executeQuery("Select * from tbl_teacher where registrationno = '"+selectregistrationnumber.getSelectedItem()+"'");
            while(teacherdata.next()){
                
                teacherregistrationnolbl.setText(teacherdata.getString("registrationno"));  
                teachernamebox.setText(teacherdata.getString("name"));  
                teacherfaternamebox.setText(teacherdata.getString("fathername"));  
                teacheraddressbox.setText(teacherdata.getString("address"));  
                teachernumberbox.setText(teacherdata.getString("number"));  
                teacheremailbox.setText(teacherdata.getString("email"));  
                teacheradharbox.setText(teacherdata.getString("aadharno"));
                showdate.setText(teacherdata.getString("dob"));
               
                
                teachercoursebox.setSelectedItem(teacherdata.getString("course"));  
                streembox.setSelectedItem(teacherdata.getString("streem"));
                
                
//                name, fathername, address, number, email, aadharno, dob, course, streem, registrationno
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        selectregistrationnumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent itemevent){
                try{
                    Conn conn = new Conn();
                    ResultSet teacherdata = conn.s.executeQuery("Select * from tbl_teacher where registrationno = '"+selectregistrationnumber.getSelectedItem()+"'");
                    while(teacherdata.next()){

                        teacherregistrationnolbl.setText(teacherdata.getString("registrationno"));  
                        teachernamebox.setText(teacherdata.getString("name"));  
                        teacherfaternamebox.setText(teacherdata.getString("fathername"));  
                        teacheraddressbox.setText(teacherdata.getString("address"));  
                        teachernumberbox.setText(teacherdata.getString("number"));  
                        teacheremailbox.setText(teacherdata.getString("email"));  
                        teacheradharbox.setText(teacherdata.getString("aadharno"));
                        showdate.setText(teacherdata.getString("dob"));


                        teachercoursebox.setSelectedItem(teacherdata.getString("course"));  
                        streembox.setSelectedItem(teacherdata.getString("streem"));


        //                
                    }


                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        
        });
        
        // Button
        submit =  new JButton("Update");
        submit.setBounds(300, 450, 100, 30);
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
            String name = teachernamebox.getText();
            String fathername = teacherfaternamebox.getText();
            String address = teacheraddressbox.getText();
            String number = teachernumberbox.getText();
            String email =  teacheremailbox.getText();
            String aadharno = teacheradharbox.getText();
            String dob = ((JTextField) jdcdob.getDateEditor().getUiComponent()).getText();
            String course = (String)teachercoursebox.getSelectedItem();
            String streem = (String)streembox.getSelectedItem();
            String registrationno = teacherregistrationnolbl.getText();
            try{

                String query = "Update tbl_teacher set name = '"+name+"', fathername = '"+fathername+"', address = '"+address+"',number = '"+number+"',email = '"+email+"', aadharno = '"+aadharno+"', dob = '"+dob+"', course = '"+course+"', streem = '"+streem+"' where registrationno = '"+registrationno+"' ";
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
        new UpdateTeacher();
    }
}
