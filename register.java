import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class register extends javax.swing.JFrame {
Connection conn=null;

    public register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        //ImageIcon image=new ImageIcon("login_img.jpeg");

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        
        jTextField4 = new javax.swing.JTextField();
    

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(null);
        getContentPane().setBackground(new java.awt.Color(250, 215, 68));
        setResizable(false);

        jLabel7.setIcon(new ImageIcon("locked.png"));
        getContentPane().add(jLabel7);
        
        jLabel7.setBounds(35,-150,500,800);
        jLabel7.setForeground(new java.awt.Color(250, 215, 68));


        jLabel1.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jLabel1.setText("NAME:");
        jLabel1.setForeground(new java.awt.Color(239, 84, 85));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 128, 110, 28);

        jLabel2.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jLabel2.setText("EMAIL ID:");
        jLabel2.setForeground(new java.awt.Color(239, 84, 85));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 195, 140, 28);

        jLabel3.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jLabel3.setText("PASSWORD:");
        jLabel3.setForeground(new java.awt.Color(239, 84, 85));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 315, 150, 28);

        jTextField1.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(300, 160, 190, 34);

        jTextField2.setFont(new java.awt.Font("Squad", 1, 24)); // 
        getContentPane().add(jTextField2);
        jTextField2.setBounds(300, 225, 190, 30);

        jTextField3.setFont(new java.awt.Font("Squad", 1, 24)); // 
        getContentPane().add(jTextField3);
        jTextField3.setBounds(300, 340, 190, 30);

        jButton1.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jButton1.setText("SIGN UP");
        jButton1.setForeground(new java.awt.Color(250, 215, 68));
        jButton1.setBackground(new java.awt.Color(239, 84, 85));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 390, 220, 41);

        jLabel4.setFont(new java.awt.Font("Squad", 1, 36)); // 
        jLabel4.setText("NEW REGISTER");
        jLabel4.setForeground(new java.awt.Color(239, 84, 85));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 30, 300, 47);

        jLabel5.setFont(new java.awt.Font("Squad", 1, 24)); // 
        jLabel5.setText("PHONE NUMBER:");
        jLabel5.setForeground(new java.awt.Color(239, 84, 85));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 255, 210, 28);

        jTextField4.setFont(new java.awt.Font("Squad", 1, 24)); // 
        getContentPane().add(jTextField4);
        jTextField4.setBounds(300, 285, 200, 30);

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       String a=jTextField1.getText();
       String b=jTextField2.getText();
       String c=jTextField3.getText();

       /*if("".equals(a) && "".equals(b) && "".equals(c))
       {
           JOptionPane.showMessageDialog(this,"Please Enter Valid Details");           
       }*/
       /*Statement s;
       ResultSet rs;
      try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie","root","Brfrkrha05@");
          s=conn.createStatement();
          int i=0,y=0,e=0;
          s=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
          rs=executeQuery("select * from register");
          a=jTextField1.getText();
          While (rs.next() && y==0)
                 ; {
                      String p=rs.getString("name");
                      a=jTextField1.getText();
                      System.out.println(p+""+a);
                  }
                  System.out.println(e);
                  s.executeUpdate("insert into register values('"+a+"','"+b+"','"+c+"');");
       }
       catch(Exception e)
       {
           System.out.println(e);
       }*/
       if("".equals(a) && "".equals(b) && "".equals(c))
       {
           JOptionPane.showMessageDialog(this,"please enter valid details");
       }
       else {
           
       
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie","root","Brfrkrha05@");
         
           Statement s =conn.createStatement();
          String s1=("insert into register values('"+a+"','"+b+"','"+c+"');");
          System.out.println("success");
          s.executeUpdate(s1);
       }
       catch(SQLException e)
       {
           Logger.getLogger(register.class.getName()).log(Level.SEVERE,null,e);
       }
       catch(Exception e){
        System.out.println("exeption "+e);
       }
       
      this.setVisible(false);   new login().setVisible(true);
          
    }
}
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;

    private ResultSet executeQuery(String select__from_register) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void While(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}



