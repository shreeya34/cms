package javastdapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



    
/**
 *
 * @author HP
 */
public class instructors {
       public void insertUpdateDeleteinstructors(char operation, Integer id, String instructor_name, 
            String course_name, String module_name, String email){
         
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
        if(operation == 'i') //for insert
        { 
            try 
               {
                   ps = con.prepareStatement("INSERT INTO Instructor(instructor_name,course_name,module_name,email) VALUES (?,?,?,?)");
                 
                   ps.setString(1, instructor_name);
                   ps.setString(2, course_name);
                   ps.setString(3,module_name);
                   ps.setString(4, email);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New instructor Added");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(course.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
    
        if(operation == 'u') //for update
        { 
            try 
               {
                   ps = con.prepareStatement("UPDATE `instructors` SET `instructor_name`= ?,`course_name`= ?,`module_name`=? WHERE `id` = ?");
                   ps.setString(1, instructor_name);
                   ps.setString(2, course_name);
                   ps.setString(3, module_name);
                  
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "instructor Data Updated");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(course.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
        
         if(operation == 'd') //for delete
        { 
               int yesORno=JOptionPane.showConfirmDialog(null, "The score will be also deleted","Delete instructor",JOptionPane.OK_CANCEL_OPTION,0);
             if(yesORno == JOptionPane.OK_OPTION)
             {
                try 
               {
                   ps = con.prepareStatement("DELETE FROM `instructor` WHERE `id`= ?");
                   ps.setInt(1, id);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "instructor Deleted");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(instructors.class.getName()).log(Level.SEVERE,null,ex);
                }
        
             }
           
        }
    
    }
      
       public boolean isinstructorsExist(String email){
          boolean isExist= false;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `Instructor` WHERE `email` = ?");
           ps.setString(1, email);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               isExist= true;
                }
            } catch (SQLException ex) {
              Logger.getLogger(instructors.class.getName()).log(Level.SEVERE, null, ex);
          }
           return isExist;
       
       }
       
      public void Fill_Course_Table(JTable table){
        Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `instructor`");
          ResultSet rs =ps.executeQuery();        
          DefaultTableModel model =(DefaultTableModel) table.getModel();
          Object[] row;
          while(rs.next())
              {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                model.addRow(row);
              }
          } catch (SQLException ex) {
            Logger.getLogger(instructors.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
      }
        
      public int getinstructorId(String instructor_name)
      {
          int instructorid =0;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `instructor` WHERE `name` = ?");
          ps.setString(1,instructor_name);
          ResultSet rs =ps.executeQuery();        
        
          if(rs.next())
              {
              instructorid = rs.getInt("Id");
              }
          } catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
          return instructorid;
      
      }
        
        
      public void Fill_Course_combo(JComboBox combo){
        Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `course`");
          ResultSet rs = ps.executeQuery();                
          while(rs.next())
              {
              combo.addItem(rs.getString(2));
              }
          } catch (SQLException ex){
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    

