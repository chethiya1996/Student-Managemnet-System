
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class EditStudent 
{
     Connection conn=null;
    PreparedStatement pst=null;
    
    
    private String sid;
    private String name;
    private String address;
    private String phone;
    private String sclass;
    
    public EditStudent(String nsid,String nname,String naddress,String nphone,String nclass)
    {
        conn=DBconnection.connect();
        
        sid=nsid;
        name=nname;
        address=naddress;
        phone=nphone;
        sclass=nclass;
        
        try
            {
                String query4="UPDATE student SET name='"+name+"',address='"+address+"',phone='"+phone+"',class='"+sclass+"' WHERE sid='"+sid+"'";
                pst=conn.prepareStatement(query4);
                pst.execute(); 

            }
            catch(Exception e)
            {
                
            }
    }
    
}
