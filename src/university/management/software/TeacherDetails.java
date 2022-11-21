package university.management.software;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener{
    Choice searchteacher;
    JTable table;
    JButton search , print , update , add , cancel;
    
    TeacherDetails(){
        super("Teacher Details");
        
        setLayout(null);
        
        JLabel heading = new JLabel("Search By Registration Number");
        heading.setBounds(20 , 20 , 200 ,20);
        add(heading);
        
        searchteacher = new Choice();
        searchteacher.setBounds(220,20, 150 , 20);
        add(searchteacher);
        try{
            Conn conn = new Conn();
            String qurey =  "Select * from tbl_teacher";
            ResultSet rsdata = conn.s.executeQuery(qurey);
            while(rsdata.next()){
                searchteacher.add(rsdata.getString("registrationno"));          
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        table = new JTable();
        JScrollPane scrolltable = new JScrollPane(table);
        scrolltable.setBounds(0 , 100 , 1080 , 500 );
        add(scrolltable);
        try{
            Conn conn = new Conn();
            String qurey =  "Select * from tbl_teacher";
            ResultSet rsdata = conn.s.executeQuery(qurey);
            table.setModel(DbUtils.resultSetToTableModel(rsdata));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        search =  new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print =  new JButton("Print");
        print.addActionListener(this);
        print.setBounds(120, 70, 80, 20);
        add(print);
        
        update =  new JButton("Update");
        update.addActionListener(this);
        update.setBounds(220, 70, 80, 20);
        add(update);
        
        add =  new JButton("Add");
        add.addActionListener(this);
        add.setBounds(320, 70, 80, 20);
        add(add);
        
        cancel =  new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBounds(420, 70, 80, 20);
        add(cancel);
        
        
        
        setSize(1080, 500);
        setLocation(100, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent actionevent){
        if(actionevent.getSource() ==  search){
            String searchquery =  "Select * from tbl_Teacher where registrationno = '"+searchteacher.getSelectedItem()+"'";
            try{
                Conn conn = new Conn();
                ResultSet rsdata = conn.s.executeQuery(searchquery);
                table.setModel(DbUtils.resultSetToTableModel(rsdata));

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(actionevent.getSource() ==  print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(actionevent.getSource() ==  add){
            setVisible(false);
            new AddTeacher();
        }
        else if(actionevent.getSource() ==  update){
            setVisible(false);
            new UpdateTeacher();
        }
        else{
            setVisible(false);
            new Project();
        }
    }
    public static void main(String [] args){
        new TeacherDetails();
    }
}
