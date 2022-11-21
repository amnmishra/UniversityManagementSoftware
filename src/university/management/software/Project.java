package university.management.software;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import university.management.software.fee.*;

public class Project extends JFrame implements ActionListener{
    Project(){
        
//      Background
        ImageIcon backgroundimage = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image resizeimage = backgroundimage.getImage().getScaledInstance(1340, 660, Image.SCALE_DEFAULT);
        ImageIcon newimage = new ImageIcon(resizeimage);
        JLabel bgimage = new JLabel(newimage);
        add(bgimage);
        //Menu Bar
        JMenuBar jmenubar = new JMenuBar(); 
        
        
//      Add Menu
        JMenu addnew = new JMenu("       Add       "); 
//      addnew.setBackground(Color.red);
//      addnew.setForeground(Color.red);
        jmenubar.add(addnew);
//      Menu Item
        JMenuItem studentdetails = new JMenuItem("New Student");
        studentdetails.addActionListener(this);
        studentdetails.setBackground(Color.WHITE);
        addnew.add(studentdetails);
        
        JMenuItem facultydetails = new JMenuItem("New Faculty");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        addnew.add(facultydetails);
        
//        View Details Menu
        JMenu viewdetails = new JMenu("View Details");
        jmenubar.add(viewdetails);
        JMenuItem viewstudent = new JMenuItem("View Student Details");
        viewstudent.setBackground(Color.WHITE);
        viewstudent.addActionListener(this);
        viewdetails.add(viewstudent);
        JMenuItem viewfaculty = new JMenuItem("View Faculty Details");
        viewfaculty.setBackground(Color.WHITE);
        viewfaculty.addActionListener(this);
        viewdetails.add(viewfaculty);
        
//      Leave Menu
        JMenu leave = new JMenu("Apply Leave");
        jmenubar.add(leave);
        JMenuItem leavestudent = new JMenuItem("Student Leave");
        leavestudent.setBackground(Color.WHITE);
        leavestudent.addActionListener(this);
        leave.add(leavestudent);
        JMenuItem leavefaculty = new JMenuItem("Faculty Leave");
        leavefaculty.setBackground(Color.WHITE);
        leavefaculty.addActionListener(this);
        leave.add(leavefaculty);
//      View Leave Details Menu
        JMenu leavedetails = new JMenu("Leave Details");
        jmenubar.add(leavedetails);
        JMenuItem viewleavestudent = new JMenuItem("Student Leave Details");
        viewleavestudent.setBackground(Color.WHITE);
        viewleavestudent.addActionListener(this);
        leavedetails.add(viewleavestudent);
        JMenuItem viewleavefaculty = new JMenuItem("Faculty Leave Details");
        viewleavefaculty.setBackground(Color.WHITE);
        viewleavefaculty.addActionListener(this);
        leavedetails.add(viewleavefaculty);
//      Exam
        JMenu exam = new JMenu("Examination");
        jmenubar.add(exam);
        JMenuItem examresult = new JMenuItem("Exam Result");
        examresult.addActionListener(this);
        examresult.setBackground(Color.WHITE);
        exam.add(examresult);
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.addActionListener(this);
        entermarks.setBackground(Color.WHITE);
        exam.add(entermarks);
//      Update Info
        JMenu update = new JMenu("Update Info");
        jmenubar.add(update);
        JMenuItem updatestudent = new JMenuItem("Student");
        updatestudent.addActionListener(this);
        updatestudent.setBackground(Color.WHITE);
        update.add(updatestudent);
        JMenuItem updatefaculty = new JMenuItem("Faculty");
        updatefaculty.addActionListener(this);
        updatefaculty.setBackground(Color.WHITE);
        update.add(updatefaculty);
//      Fee
        JMenu fee = new JMenu("Fee");
        jmenubar.add(fee);
        JMenuItem feestructure = new JMenuItem("Fee Structure");        
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);
        JMenuItem feesumbit = new JMenuItem("Fee Submition");
        feesumbit.setBackground(Color.WHITE);
        fee.add(feesumbit);        
        
//      Utility
        JMenu utility = new JMenu(" Utility ");
        jmenubar.add(utility);
        JMenuItem calc = new JMenuItem("Calculater");
        calc.addActionListener(this);
        calc.setBackground(Color.WHITE);
        utility.add(calc);
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.addActionListener(this);
        notepad.setBackground(Color.WHITE);
        utility.add(notepad);
        
        
        //About 
        
        JMenu about = new JMenu("About");
        jmenubar.add(about);
        JMenuItem aboutus = new JMenuItem("About Us");
        aboutus.addActionListener(this);
        aboutus.setBackground(Color.WHITE);
        about.add(aboutus);
//      Exit
        JMenu exit = new JMenu("Exit");
        jmenubar.add(exit);
        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(this);
        ex.setBackground(Color.WHITE);
        exit.add(ex);
        
        
        
        setJMenuBar(jmenubar);        
        setSize(1366 , 720);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent actioneventobj){
        String msg = actioneventobj.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("New Student")){
            setVisible(false);
            new AddStudent();
        }
        else if(msg.equals("New Faculty")){
            setVisible(false);
            new AddTeacher();
        }
        else if(msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("View Faculty Details")){
            setVisible(false);
            new TeacherDetails();
        }
        else if(msg.equals("Student Leave")){
            setVisible(false);
            new StudentLeave();
        }
        else if(msg.equals("Faculty Leave")){
            setVisible(false);
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave Details")){
            setVisible(false);
            new StudentLeaveDetails();
        }
        else if(msg.equals("Faculty Leave Details")){
            setVisible(false);
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Student")){
            setVisible(false);
            new UpdateStudent();
        }
        else if(msg.equals("Faculty")){
            setVisible(false);
            new UpdateTeacher();
        }
        else if(msg.equals("Enter Marks")){
            setVisible(false);
            new UploadResult();
        }
        else if(msg.equals("Exam Result")){
            setVisible(false);
            new ViewResult();
        }
        else if(msg.equals("About Us")){
            new About();
        }
        
        
        
        else if(msg.equals("Calculater")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch(Exception e){
        
            }
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch(Exception e){
        
            }
        }
        
    }
    
    
    public static void main(String args []){
        new Project();
    }

  
}
