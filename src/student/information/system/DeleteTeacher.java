
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeleteTeacher 
{
    Connection conn=null;
    PreparedStatement pst=null;
    
    private String teacherId;
    
    public DeleteTeacher(String ttid)
    {
        conn=DBconnection.connect();
        
        teacherId=ttid;
        try 
            {
                String query7="DELETE FROM teacher WHERE tid='"+teacherId+"'";
                pst=conn.prepareStatement(query7);
                pst.execute(); 
                
                
            }
            catch(Exception e)
            {
                
            }
    }
    
}
