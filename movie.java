import java.awt.Color;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.event.*;


public class movie extends javax.swing.JFrame {

    public movie() {
        initComponents();
    }
    private String[] getResult(String query){
        ArrayList<String> movies=new ArrayList<String>();
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie","root","Brfrkrha05@");
         
        Statement s =conn.createStatement();

          ResultSet r=s.executeQuery(query);
          while(r.next()){
            movies.add(r.getString(1));
          }
          System.out.println(movies);
          System.out.println("success");
          //s.executeUpdate(s1);
          conn.close();
       }
       catch(SQLException e)
       {
           System.out.println(e);
       }
       catch(Exception e){
        System.out.println("exeption "+e);
       }
       String[] m=new String[movies.size()];
       for(int i=0;i<movies.size();i++){
        m[i]=movies.get(i);
       }
       return m;
    }
   
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setFont(new java.awt.Font("Squad", 1, 36)); 
        jPanel1.setBackground(new java.awt.Color(239,84,85));
        
        jLabel1.setFont(new java.awt.Font("Squad", 1, 24)); 
        jLabel1.setText("SELECT MOVIE:");
        jLabel1.setForeground(new java.awt.Color(239,84,85));

        jLabel2.setFont(new java.awt.Font("Squad", 1, 24)); 
        jLabel2.setText("SELECT  THEATRE:");
        jLabel2.setForeground(new java.awt.Color(239,84,85));

        

        jComboBox1.setFont(new java.awt.Font("Squad", 1, 24)); 
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(getResult("select distinct movie from movielist")));

        jComboBox2.setFont(new java.awt.Font("Squad", 1, 24)); 
        //jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "srivishnu", "galaxy", "asscars", "PVR" }));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>());

        jComboBox1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jComboBox2.removeAllItems();
                String movie=(String)jComboBox1.getSelectedItem();
                jComboBox2.setModel(new DefaultComboBoxModel<>(getResult(String.format("select distinct theatre from movielist where movie='%s'",movie))));
            }
        });

        jComboBox2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jComboBox4.removeAllItems();
                String movie=(String)jComboBox1.getSelectedItem();
                String theatre=(String)jComboBox2.getSelectedItem();
                jComboBox4.setModel(new DefaultComboBoxModel<>(getResult(String.format("select distinct date from movielist where movie='%s' and theatre='%s'",movie,theatre))));
            }
        });

        jComboBox4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jComboBox3.removeAllItems();
                String movie=(String)jComboBox1.getSelectedItem();
                String theatre=(String)jComboBox2.getSelectedItem();
                String date=(String)jComboBox4.getSelectedItem();
                jComboBox3.setModel(new DefaultComboBoxModel<>(getResult(String.format("select distinct movielist.show from movielist where movie='%s' and theatre='%s' and date='%s'",movie,theatre,date))));
            }
        });

        jComboBox3.setFont(new java.awt.Font("Squad", 1, 24)); 
        //jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00AM", "11:00AM", "2:00PM", "6:00PM", "9:00PM" }));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>());

        jComboBox4.setFont(new java.awt.Font("Squad", 1, 24)); 
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>());
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Squad", 1, 24)); 
        jLabel5.setText("SELECT DATE:");
        jLabel5.setForeground(new java.awt.Color(239,84,85));

        jLabel3.setFont(new java.awt.Font("Squad", 1, 24)); 
        jLabel3.setText("SELECT TIME:");
        jLabel3.setForeground(new java.awt.Color(239,84,85));

        jTextField1.setFont(new java.awt.Font("Squad", 1, 24)); 

        jButton1.setFont(new java.awt.Font("Squad", 1, 24)); 
        jButton1.setText("SUBMIT");
        jButton1.setForeground(new java.awt.Color(250,215,68));
        jButton1.setBackground(new java.awt.Color(239,84,85));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Squad", 1, 24)); 
        jLabel4.setText("NO OF TICKETS:");
        jLabel4.setForeground(new java.awt.Color(239,84,85));

        jLabel6.setText("MOVIE DETAILS");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, -20, 200, 100);
        jLabel6.setFont(new java.awt.Font("Squad", 1, 24));
        jLabel6.setForeground(new java.awt.Color(239,84,85));


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1.setBackground(new java.awt.Color(250, 215, 68));
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(74, 74, 74)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(206, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        getContentPane().setBackground(new java.awt.Color(239,84,85));
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       
        workWithDatabase();
    }
     public void workWithDatabase()
    {
         String a=(String) jComboBox1.getSelectedItem();
       String b=(String) jComboBox2.getSelectedItem();
        String e=(String) jComboBox3.getSelectedItem();
        String f=(String) jComboBox4.getSelectedItem();
       String d=jTextField1.getText();
       
        
         Connection c=null;
         Statement  s=null;
         
         ResultSet rs=null;
         int flag=0;
     //AMOUNT CACULATION
        //if(!a.equals(""))
         String N=jTextField1.getText();
        int N1=Integer.parseInt(N);
        int N2=N1;
         N1*=100;
       //new recepit(a,b,e,d,N1,f).setVisible(true);
        
      if(N2<20 && N2>0)
        
         {  
             this.setVisible(false);  
             new recepit(a,b,e,d,N1,f).setVisible(true); 
       
         try
   {
       Class.forName("com.mysql.jdbc.Driver");
       c=DriverManager.getConnection("jdbc:mysql://localhost/java_dbmovies","root","");
       s=c.createStatement();
        b=(String) jComboBox2.getSelectedItem();
       e=(String) jComboBox3.getSelectedItem();
      String q1=b;
       String q2=e;
       rs=s.executeQuery("select tickets from table3 where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
      String bid=jTextField1.getText();
      int id=Integer.parseInt(bid);
      rs=s.executeQuery("select tickets from table3 where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
       while(rs.next())
     {
    String id1=rs.getString("tickets");
     int id2=Integer.parseInt(id1);
     
     id2=id2-N2;
     
     s.executeUpdate("Update table3 set tickets="+id2+" where theatre="+"'"+q1+"'"+" and shows="+"'"+q2+"'");
    }
    //new recepit(a,b,e,d).setVisible(true);
       while(rs.next())
       {
               String tickets1=rs.getString("tickets");
               String q3 = tickets1;
               
               //jLabel5 = new javax.swing.JLabel("tickets available:"+"  "+q3);
               
         }
              
     
      //rs.close;
      //s.close;
      //c.close;
   }    
         catch(SQLException | ClassNotFoundException e1)
         {
             System.out.println(e1);
         }          
         }   
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
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
            java.util.logging.Logger.getLogger(movie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(movie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(movie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(movie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new movie().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
}