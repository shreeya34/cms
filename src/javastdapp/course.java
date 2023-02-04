
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
public class course {
       public void insertUpdateDeleteCourse(char operation, Integer id, String course_name, 
            Integer batch, Integer seats, Integer noofyear){
         
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
        if(operation == 'i') //for insert
        { 
            try 
               {
                   ps = con.prepareStatement("INSERT INTO course(course_name,batch,seats,noofyear) VALUES (?,?)");
                   ps.setString(1, course_name);
                   ps.setInt(2, batch);
                   ps.setInt(3,seats);
                   ps.setInt(4,noofyear);
                 
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New Course Added");
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
                   ps = con.prepareStatement("UPDATE `course` SET `course_name`= ?,`batch`= ?,`seat`=?, `noofyear`=? WHERE `id` = ?");
                   ps.setString(1, course_name);
                   ps.setInt(2, batch);
                   ps.setInt(3, seats);
                   ps.setInt(4, noofyear);
                   ps.setInt(5, id);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "Cours Data Updated");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(course.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
        
         if(operation == 'd') //for delete
        { 
               int yesORno=JOptionPane.showConfirmDialog(null, "The score will be also deleted","Delete Course",JOptionPane.OK_CANCEL_OPTION,0);
             if(yesORno == JOptionPane.OK_OPTION)
             {
                try 
               {
                   ps = con.prepareStatement("DELETE FROM `course` WHERE `id`= ?");
                   ps.setInt(1, id);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "Course Deleted");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(student.class.getName()).log(Level.SEVERE,null,ex);
                }
        
             }
           
        }
    
    }
      
       public boolean isCourseExist(String courseName){
           boolean isExist= false;
             Connection con = MyConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_name` = ?");
           ps.setString(1,courseName);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               isExist= true;
                }
            } catch (SQLException ex) {
              Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
          }
           return isExist;
       
       }
       
        public void Fill_Course_Table(JTable table){
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `course`");
           ResultSet rs =ps.executeQuery();        
           DefaultTableModel model =(DefaultTableModel) table.getModel();
           Object[] row;
           while(rs.next())
                {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                row[3] = rs.getInt(4);
                row[4] = rs.getInt(5);
                model.addRow(row);
                }
            } catch (SQLException ex) {
              Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
        
        public int getCourseId(String course_name)
        {
           int courseid =0;
           Connection con = MyConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `course` WHERE `course_name` = ?");
           ps.setString(1,course_name);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               courseid = rs.getInt("Id");
                }
            } catch (SQLException ex) {
              Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
          }
           return courseid;
        
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
