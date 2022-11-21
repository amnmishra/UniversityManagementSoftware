package university.management.software;
    
import javax.swing.*;
import java.awt.*;

public class About extends JFrame{
    
    About(){
        
        
        JLabel heading = new JLabel("About Us");
        heading.setBounds(10 , 20, 200, 30);
        heading.setFont(new Font("",Font.BOLD,30));
        add(heading);
        
        JLabel about = new JLabel("<html><h1>B N College of Engineering and Technology</h1></html>");
        about.setBounds(40 , 60, 550, 50);        
        add(about);
        
        JLabel aboutus = new JLabel("<html><p>B N College of Engineering and TechnologyBNCET is a consortium of leading colleges of International standards has been established under the auspicious aegis of Baij Nath Charitable and Educational Trust in the year 2008 for setting trends and raising standards for management and technical education.<br>The objective of our Techno-Managerial programs is to equip our students with knowledge, skills and confidence needed to develop corporate leaders, strategists and decision makers who can significantly contribute in nation building exercise.</br>An exhaustive, intensive industry and trade related curriculum covers almost all the functional dimensions of techno managerial education. Case studies, live projects, presentations, seminars, symposiums, internships, study trips and industrial visits part and parcel of the program.</p></html>");
        aboutus.setBounds(60 , 100, 400, 260);
        add(aboutus);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icon/background.jpg"));
        Image image = img.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon imgic = new ImageIcon(image);
        JLabel imgadd =  new JLabel(imgic);
        imgadd.setBounds(470, 120, 400, 215);
        add(imgadd);
        
        
        
        
        
        JLabel maquee = new JLabel("<html><h2>Design and Developed by : Aman Mishra</h2><br>Contact : 7408736297</html>");
        maquee.setBounds(100 , 400, 400, 100);        
        add(maquee);
//        JTable table = new JTable();        
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(10, 70, 865, 480);
//        add(jsp);
//        
        setLayout(null);
        setSize(900,600);
        getContentPane().setBackground(Color.white);
        setLocation(250,80);
        setVisible(true);
    }
    
    
    public static void main(String args[]){
        new About();
    }
}


