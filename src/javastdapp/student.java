package javastdapp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class student {
    public void insertUpdateDeletestudent(char operation, Integer id, String fname, String lname,
            String uname, String pass, String email, Integer phone, String address, String course){
         
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
        if(operation == 'i') //for insert
        { 
            try 
               {
                   ps = con.prepareStatement("INSERT INTO register(`Username`, `Password`, `First name`, `Last name`, `Phone number`, `Address`, `Email`,`role`,`course`) VALUES (?,?,?,?,?,?,?,?,?)");
                   ps.setString(1, uname);
                   ps.setString(2,pass);
                   ps.setString(3,fname);
                   ps.setString(4, lname);
                   ps.setInt(5,phone);
                   ps.setString(6,address);
                   ps.setString(7,email);
                   ps.setString(8,"2");
                   ps.setString(9,course);
                   
                   
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New student Added");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(student.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
    
        // if(operation == 'u') //for update
        // { 
        //     try 
        //        {
        //            ps = con.prepareStatement("UPDATE `students` SET `name`= ?,`course_name`=?,`age`=?,`phonenumber`= ? WHERE `id` = ?");
        //            ps.setString(1,name);
        //            ps.setString(2, course_name);
        //            ps.setString(3, age);
        //            ps.setString(4, phonenumber);
                  
                  
                   
        //             if(ps.executeUpdate() > 0){
        //                JOptionPane.showMessageDialog(null, "student Data Updated");
        //              }
        //         } 
        //     catch (SQLException ex) 
        //         {
        //              Logger.getLogger(course.class.getName()).log(Level.SEVERE,null,ex);
        //         }
        
        // }
        
         if(operation == 'd') //for delete
        { 
               int yesORno=JOptionPane.showConfirmDialog(null, "The score will be also deleted","Delete instructor",JOptionPane.OK_CANCEL_OPTION,0);
             if(yesORno == JOptionPane.OK_OPTION)
             {
                try 
               {
                   ps = con.prepareStatement("DELETE FROM `students` WHERE `id`= ?");
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
      
       public boolean isstudentExist(String email){
          boolean isExist= false;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `register` WHERE `email` = ?");
           ps.setString(1, email);
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
          ps = con.prepareStatement("SELECT * FROM `students`");
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
          ps = con.prepareStatement("SELECT * FROM `students` WHERE `name` = ?");
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
