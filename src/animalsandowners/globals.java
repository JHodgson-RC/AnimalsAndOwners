/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalsandowners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author julie.hodgson
 */
public class globals {

    public static String emailRegEx = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
    private static String host = "jdbc:derby://localhost:1527/AnimalsAndOwners";
    private static String uName = "admin1";
    private static String uPass = "admin";
    private static ResultSet rs = null;

    public static boolean regExCheck(String text, String pattern) {

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(text);
        return m.matches();
    }

    public static ResultSet database(String SQL) {

        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);//execute instead of executeQuery
        } catch (SQLException ex) {
            Logger.getLogger(AnimalsAndOwners.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    //Called method overloading. You call same method name with different number of parameters

    public static ResultSet database(String SQL, String... queryElement) {
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
            PreparedStatement p = con.prepareStatement(SQL);
            System.out.println(queryElement.length);
            for (int i = 0; i < queryElement.length; i++) {
                System.out.println(queryElement[i]);
              p.setString(i+1, queryElement[i]);  
            }       
            
            rs = p.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AnimalsAndOwners.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

}
