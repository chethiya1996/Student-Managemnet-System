
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeleteStudent 
{
    Connection conn=null;
    PreparedStatement pst=null;
    
     private String sid;
    
    public DeleteStudent(String dsid)
    {
        conn=DBconnection.connect();
        
       
        sid=dsid;
        try 
        {
               
            String query70="Delete from student where sid='"+sid+"'"; 
            pst=conn.prepareStatement(query70);
                 
            pst.execute();
          
        }
        catch(Exception e)
        {
               
        }
        
    }
    
}
