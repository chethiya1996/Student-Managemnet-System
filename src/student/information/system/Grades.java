
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Grades
{
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    private String ssid;
    private String sg1;
    private String sg2;
    private String sg3;
    private String sg4;
    private String sg5;
    private String sg6;
    
    public Grades(String stu_sid,String stu_g1,String stu_g2,String stu_g3,String stu_g4,String stu_g5,String stu_g6)
    {
        conn=DBconnection.connect();
        
        
        ssid=stu_sid;
        sg1=stu_g1;
        sg2=stu_g2;
        sg3=stu_g3;
        sg4=stu_g4;
        sg5=stu_g5;
        sg6=stu_g6;
        
        try
        {
            int count=0;
            String query8="Select * FROM results WHERE sid='"+ssid+"'";
            pst=conn.prepareStatement(query8);
            rs=pst.executeQuery();
            
            
            while(rs.next())
            {
                count++;
            }
            if(count==0)
            {
                
                
                JOptionPane.showMessageDialog(null, "Invalid SID");
                
            }
            
            else
            {    
                String query12="UPDATE results SET maths='"+sg1+"', it='"+sg2+"', physics='"+sg3+"', commerce='"+sg4+"', bio='"+sg5+"', chemistry='"+sg6+"' WHERE sid='"+ssid+"' ";
                pst=conn.prepareStatement(query12);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Successful");
            }
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null, "Reference to a null pointer "+e);
        }
        catch(SQLException e)
        {
           
            JOptionPane.showMessageDialog(null,"error");
        }
    }
    
}
