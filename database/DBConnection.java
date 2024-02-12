package database;

import java.sql.Connection;
import java.sql.DriverManager;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import java.awt.FlowLayout;  

public class DBConnection {
    public static String url = "jdbc:postgresql://localhost:5432/mydb";
    public static String user = "longnguyen";
    public static String password = "1234";

    public static Connection getConnection(){
        Connection cnt = null;
        System.out.println("1");
        try {
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("cnt ok");
            return cnt;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        Connection cnt = getConnection();
        System.out.println("run1");

        // JFrame frame = new JFrame("JFrame Example");  
        // JPanel panel = new JPanel();  
        // panel.setLayout(new FlowLayout());  
        // JLabel label = new JLabel("JFrame By Example");  
        // JButton button = new JButton();  
        // button.setText("Button");  
        // panel.add(label);  
        // panel.add(button);  
        // frame.add(panel);  
        // frame.setSize(200, 300);  
        // frame.setLocationRelativeTo(null);  
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        // frame.setVisible(true);  
    }
}