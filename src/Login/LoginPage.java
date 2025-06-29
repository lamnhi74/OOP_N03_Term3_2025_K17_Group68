package Login;

import Employee.Employee;
import Employee.EmployeeList;
import Employee.ExceptionClass;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;


public class LoginPage extends ExceptionClass {

    public static void main(String args[]) {
        new LoginPage();
    }

    JFrame f;
    JButton login_button;

    LoginPage() {

        f = new JFrame("Login");

        /**** Background ****/
        ImageIcon background_image = new ImageIcon("src\\Login\\chao.jpg");
        Image img = background_image.getImage();
        Image im = img.getScaledInstance(500,500, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(im);

        JLabel background = new JLabel(background_image);
        background.setBounds(0, 0, 500, 500);

        /**** Heading ****/
        JPanel heading = new JPanel();
        heading.setLayout(null);
        heading.setBounds(0, 0, 500, 100);
        heading.setBackground(new Color(0, 0, 0, 60));

        JLabel name = new JLabel("LOGIN PAGE");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setVerticalAlignment(JLabel.CENTER);
        name.setSize(500, 100);
        name.setForeground(Color.orange);
        name.setFont(new Font("Monospaced", Font.BOLD, 40));
        heading.add(name);
        background.add(heading);

        /**** Body ****/
        JLabel uid = new JLabel("ENTER USERID : ");
        uid.setBounds(50,150,200,50);
        uid.setFont(new Font("Monospaced", Font.BOLD,18));
        uid.setBackground(Color.BLACK);
        uid.setForeground(new Color(193,140,0));
        background.add(uid);

        JTextField UserID = new JTextField();
        UserID.setBounds(270,150,150,40);
        UserID.setForeground(Color.BLACK);
        UserID.setBackground(new Color(240, 230,140));
        background.add(UserID);

        JLabel pass = new JLabel("ENTER PASSWORD : ");
        pass.setBounds(50,220,200,50);
        pass.setFont(new Font("Monospaced", Font.BOLD,18));
        pass.setBackground(Color.BLACK);
        pass.setForeground(new Color(193,140,0));
        background.add(pass);

        JPasswordField password = new JPasswordField();
        password.setBounds(270,220,150,40);
        password.setForeground(Color.BLACK);
        password.setBackground(new Color(240, 230,140));
        background.add(password);

        login_button = new JButton("LOGIN");
        login_button.setBounds(300,340,100,40);
        login_button.setBackground(Color.BLACK);
        login_button.setForeground(Color.WHITE);
        login_button.setFont(new Font("Monospaced", Font.BOLD, 18));
        background.add(login_button);

        f.add(background);

        /**** Setting the frame ****/
        f.setSize(500, 500);
        f.setLocation(280,50);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        /**** Handling Events ****/
        login_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                String s1 = UserID.getText();
                String s2 = password.getText();
                String str = "";
                int flag= 0;
                try {
                    BufferedReader b = new BufferedReader(new FileReader("src\\Login\\idPass.txt"));
                    while ((str = b.readLine()) != null) {
                        String[] a = str.split(" , ");
                        if (a[0].equals(s1)) {
                            flag = 1;
                            if (a[1].equals(s2)) {
                                JOptionPane.showMessageDialog(f, "Login Successful");
                                compare(Integer.parseInt(a[0]));
                            } else {
                                throw new ExceptionClass("Incorrect Password");
                            }
                        }
//		            	if (!a[0].equals(s1)) {
//                            throw new ExceptionClass("ID does not exist, Please register yourself first!");                     }
                    }
                    if(flag == 0) {
                        throw new ExceptionClass("ID does not exist, Please register yourself first!");
                    }

                } catch (ExceptionClass ex) {
	                   ex.showMessage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        });

    }

    public void compare(int userId)
    {
         EmployeeList list= new EmployeeList();
         list.getDataFromFile();
         Employee emp = list.searchEmployeeByID(userId);

         if(emp.getDesignation().equalsIgnoreCase("Waiter")) {
             new Attempt().emp.setEnabled(false);
             f.setVisible(false);
         }
         else {
             new Attempt();
             f.setVisible(false);
         }

    }

    public static void remove(int ID) {
         try {
             String filePath = "src/Login/idPass.txt";
             File file = new File(filePath);
             File tempFile = new File("src/Login/temp.txt");

             BufferedReader r = new BufferedReader(new FileReader(file));
             FileWriter w = new FileWriter(tempFile);

             String x;
             while((x = r.readLine()) != null) {
                 if(!x.startsWith(Integer.toString(ID))) {
                     w.write(x + '\n');
                 }
             }
             r.close();
             w.close();

             BufferedReader r2 = new BufferedReader(new FileReader(tempFile));
             FileWriter w2 = new FileWriter(file);

             while((x = r2.readLine()) != null) {
                 w2.write(x + '\n');
             }

             r2.close();
             w2.close();
         }
         catch (IOException ex) {
             ex.printStackTrace();
         }
    }

}

