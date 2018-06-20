
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class EditTeacher 
{
    Connection conn=null;
    PreparedStatement pst=null;
    
    private String tid;
    private String tname;
    private String tusername;
    private String tnic;
    private String tphone;
    private String taddress;
    
    public EditTeacher(String ntid,String ntname,String ntusername,String ntnic,String ntphone,String ntaddress)
    {
        conn=DBconnection.connect();
        
        tid=ntid;
        tname=ntname;
        tusername=ntusername;
        tnic=ntnic;
        tphone=ntphone;
        taddress=ntaddress;
        
            try
            {
                String query6="UPDATE teacher set name='"+tname+"',username='"+tusername+"',nic='"+tnic+"',phone='"+tphone+"',address='"+taddress+"' WHERE tid='"+tid+"'";
                pst=conn.prepareStatement(query6);
                pst.execute();
               
                
            }
            catch(Exception e)
            {
            
            }   
    }
    
}
