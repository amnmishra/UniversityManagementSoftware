package university.management.software;

import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame implements Runnable{
    Thread thread; 
    SplashScreen(){
        
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/splash.jpg"));
        Image imagesize  = imageicon.getImage().getScaledInstance(720, 520 , Image.SCALE_DEFAULT);
        ImageIcon newimageicon = new ImageIcon(imagesize);
        JLabel image = new JLabel(newimageicon);
        add(image);
        thread = new Thread(this);
        thread.start();
        setLocation(300 , 120 );
        setSize(720 ,520);
        setVisible(true);
        
        
        
    }    
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String args[]){
        new SplashScreen();
    }
}
