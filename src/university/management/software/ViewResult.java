package university.management.software;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class ViewResult extends JFrame implements ActionListener{
   
    JTextField search;
    JButton submit,cancel;
    JTable table; 
    
    ViewResult(){
        super("");
        setLayout(null);
        JLabel heading = new JLabel("Check Result");
        
        heading.setFont(new Font("", Font.BOLD,24));
        heading.setBounds(80, 15 , 400 , 50);
        add(heading);
        
        search = new JTextField();
        search.setBounds(80, 90, 200, 25);
        add(search);
        
        submit = new JButton("View Result");
        submit.setBounds(350, 90, 120, 25);
        submit.addActionListener(this);
        add(submit);        
        cancel = new JButton("Back");
        cancel.addActionListener(this);
        cancel.setBounds(500, 90, 120, 25);
        add(cancel);
        
        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(10,130,965,420);
        add(jsp);
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from tbl_student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 9).toString());
            }
        });
                
                
        getContentPane().setBackground(Color.white);
        setSize(1000 , 600);
        setLocation(250 , 100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            setVisible(false);
            new ViewMarks(search.getText());
            
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ViewResult();   
    }
}
