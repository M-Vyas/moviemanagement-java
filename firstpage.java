import javax.swing.*;
import java.awt.*;
public class firstpage extends javax.swing.JFrame {
    public firstpage() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        //this.setSize(500,500);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("splash.jpg"));
        Image i2=i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        jLabel1=new JLabel(i3);
        //jLabel1.setSize(700,1000);
        //jLabel1.setBounds(0,0,700,1000);
        getContentPane().add(jLabel1);

        pack();
}
public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {   
        }
    });
    firstpage f=new firstpage();
    f.setVisible(true);
    try {
            Thread.sleep(5000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setVisible(false);
    JFrame l=new login();
        l.setVisible(true);
}
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel1;
}