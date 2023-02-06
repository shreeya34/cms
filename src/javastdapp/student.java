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

public class student {
    public void insertUpdateDeleteCourse(char operation, Integer id, String student_name, 
            Integer phonenumber, Integer age, String course_name){
         
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
        if(operation == 'i') //for insert
        { 
            try 
               {
                   ps = con.prepareStatement("INSERT INTO student(student_name,phonenumber,age,course_name) VALUES (?,?,?)");
                   ps.setString(1, student_name);
                   ps.setInt(2, phonenumber);
                   ps.setInt(3,age);
                   ps.setString(4,course_name);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New student Added");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(student.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
    
        if(operation == 'u') //for update
        { 
            try 
               {
                   ps = con.prepareStatement("UPDATE `student` SET `student_name`= ?,`phonenumber`= ?,`age`=?,`course_name`=? WHERE `id` = ?");
                   ps.setString(1, student_name);
                   ps.setInt(2, phonenumber);
                   ps.setInt(3, age);
                   ps.setString(4, course_name);
                  
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "student Data Updated");
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
                   ps = con.prepareStatement("DELETE FROM `student` WHERE `id`= ?");
                   ps.setInt(1, id);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "student Deleted");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(student.class.getName()).log(Level.SEVERE,null,ex);
                }
        
             }
           
        }
    
    }
      
       public boolean isCourseExist(String studentName){
          boolean isExist= false;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `student` WHERE `name` = ?");
           ps.setString(1, studentName);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               isExist= true;
                }
            } catch (SQLException ex) {
              Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
          }
           return isExist;
       
       }
       
      public void Fill_student_Table(JTable table){
        Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `student`");
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
                row[4] = rs.getString(5);
                model.addRow(row);
              }
          } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
      }
        
      public int getinstructorId(String student_name)
      {
          int studentid =0;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `student` WHERE `name` = ?");
          ps.setString(1,student_name);
          ResultSet rs =ps.executeQuery();        
        
          if(rs.next())
              {
              studentid = rs.getInt("Id");
              }
          } catch (SQLException ex) {
            Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
        }
          return studentid;
      
      }
    
}
