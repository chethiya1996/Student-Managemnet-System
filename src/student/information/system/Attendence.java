
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Attendence 
{
    Connection conn=null;
    PreparedStatement pst=null;
    
    private String attendence_aid;
    
    public Attendence(String a_aid)
    {
        conn=DBconnection.connect();
        
        attendence_aid=a_aid;
        
        try
            {
                String query9="UPDATE attendence SET prsent_days=prsent_days+1 WHERE aid='"+attendence_aid+"'";
                pst=conn.prepareStatement(query9);
                pst.execute();
                
            }
            catch(SQLException e)
            {
                 JOptionPane.showMessageDialog(null,"ERROR "+e);
            }
    }
}
