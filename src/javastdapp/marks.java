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

    
public class marks {
    public void insertUpdateDeletemodules(char operation, Integer student_id, String course_name, String module_name, Integer marks, String status)
           {
         
         Connection con = MyConnection.getConnection();
            PreparedStatement ps;
        if(operation == 'i') //for insert
        { 
            try 
               {
                   ps = con.prepareStatement("INSERT INTO marks(student_id, course_name, module_name, marks, status) VALUES (?,?,?,?,?)");
                   ps.setInt(1,student_id);
                   ps.setString(2, module_name);
                   ps.setString(3, course_name);
                   ps.setInt(4, marks);
                   ps.setString(5, status);
                   
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New marks Added");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(modules.class.getName()).log(Level.SEVERE,null,ex);
                }
        
        }
    
        if(operation == 'u') //for update
        { 
            // try 
            //    {
            //        ps = con.prepareStatement("UPDATE `module` SET `module_name`= ? WHERE `course_id` = ?");
            //        ps.setString(1,module_name);
            //        ps.setInt(2, course_id);
                   
                   
            //         if(ps.executeUpdate() > 0){
            //            JOptionPane.showMessageDialog(null, "module Data Updated");
            //          }
            //     } 
            // catch (SQLException ex) 
            //     {
            //          Logger.getLogger(modules.class.getName()).log(Level.SEVERE,null,ex);
            //     }
        
        }
        
         if(operation == 'd') //for delete
        { 
            //    int yesORno=JOptionPane.showConfirmDialog(null, "The score will be also deleted","Delete Course",JOptionPane.OK_CANCEL_OPTION,0);
            //  if(yesORno == JOptionPane.OK_OPTION)
            //  {
            //     try 
            //    {
            //        ps = con.prepareStatement("DELETE FROM `module` WHERE `id`= ?");
            //        ps.setInt(1, id);
                   
            //         if(ps.executeUpdate() > 0){
            //            JOptionPane.showMessageDialog(null, "module Deleted");
            //          }
            //     } 
            // catch (SQLException ex) 
            //     {
            //          Logger.getLogger(modules.class.getName()).log(Level.SEVERE,null,ex);
            //     }
        
            //  }
           
        }
    
    }
      
       public boolean ismodulesExist(String moduleName){
          boolean isExist= false;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `marks` WHERE `name` = ?");
           ps.setString(1,module_name);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               isExist= true;
                }
            } catch (SQLException ex) {
              Logger.getLogger(modules.class.getName()).log(Level.SEVERE, null, ex);
          }
           return isExist;
       
       }
       
      public void Fill_module_Table(JTable table){
        Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `marks`");
          ResultSet rs =ps.executeQuery();        
          DefaultTableModel model =(DefaultTableModel) table.getModel();
          Object[] row;
          while(rs.next())
              {
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getInt(3);
                
                model.addRow(row);
              }
          } catch (SQLException ex) {
            Logger.getLogger(course.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
      }
        
      public int getCourseId(String module_name)
      {
          int course_id =0;
          Connection con = MyConnection.getConnection();
          PreparedStatement ps;
        try{
          ps = con.prepareStatement("SELECT * FROM `module` WHERE `name` = ?");
          ps.setString(1,module_name);
          ResultSet rs =ps.executeQuery();        
        
          if(rs.next())
              {
              course_id = rs.getInt("Id");
              }
          } catch (SQLException ex) {
            Logger.getLogger(modules.class.getName()).log(Level.SEVERE, null, ex);
        }
          return course_id;
      
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

    


