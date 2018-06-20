
package student.information.system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class AddNewStudent 
{
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    private String sname;
    private String saddress;
    private String sphone;
    private String sclass;
    
    
    public AddNewStudent(String stu_name,String stu_address,String stu_phone,String stu_class)
    {
        conn=DBconnection.connect();
        
        sname=stu_name;
        saddress=stu_address;
        sphone=stu_phone;
        sclass=stu_class;
        
         try
        {   
            
            String query2="INSERT INTO student (name,address,phone,class) values ('"+sname+"','"+saddress+"','"+sphone+"','"+sclass+"')";
            pst=conn.prepareStatement(query2);
            pst.execute();
            
            
            
            String query4="SELECT sid FROM student WHERE name='"+sname+"' AND address='"+saddress+"' AND phone='"+sphone+"' AND class='"+sclass+"'";
            pst=conn.prepareStatement(query4);
            rs=pst.executeQuery();
            int a_sid=0;
            
            while(rs.next())
            { 
              a_sid = rs.getInt("sid");  
              
            }
            
            String query3="INSERT INTO attendence (sid,name) values ('"+a_sid+"','"+sname+"')";
            pst=conn.prepareStatement(query3);
            pst.execute();
            
            String query5="INSERT INTO results (sid,name) values ('"+a_sid+"','"+sname+"')";
            pst=conn.prepareStatement(query5);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Added Successfully");
            
         
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error "+e);
        }
    }
}
