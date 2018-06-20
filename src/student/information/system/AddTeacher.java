
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AddTeacher
{
    Connection conn=null;
    PreparedStatement pst=null;
    
    
    private String tname;
    private String taddress;
    private String tusername;
    private String tpassword;
    private String tphone;
    private String tnic;
    
    
    public AddTeacher(String teach_name,String teach_address,String teach_username,String teach_password,String teach_phone,String teach_nic)
    {   
            conn=DBconnection.connect();
            
            tname=teach_name;
            taddress=teach_address;
            tusername=teach_username;
            tpassword=teach_password;
            tphone=teach_phone;
            tnic=teach_nic;
            
             
            try
            {
               
                String query1="INSERT INTO teacher (name,username,password,nic,phone,address) values ('"+tname+"','"+tusername+"','"+tpassword+"','"+tnic+"','"+tphone+"','"+taddress+"')";
               
                pst=conn.prepareStatement(query1);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Added Successfully");
                
            }
            catch(NullPointerException e)
            {
               JOptionPane.showMessageDialog(null, "Reference to a null pointer "+e);
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null, "Error "+e);
            }
         
    }

 }
