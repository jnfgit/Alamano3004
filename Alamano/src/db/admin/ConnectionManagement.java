package db.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.utilities.Properties;

/**
 * @author nfernandez 26/01/2015
 * La persistencia y recuperacion de datos se gestionara a traves de JPA + HIBERNATE pero
 * si deseamos hacer consultas especificas sin usar un objeto JPA podemos gestionar a traves
 * de ConnectionManagement.
 */
public class ConnectionManagement {
	
	private Connection conn;
	
	public Connection getConnection(){
		try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
		
		try {
        	String user = Properties.getParameter(ConnectionManagement.class.getName(), "database_username");
        	String pass = Properties.getParameter(ConnectionManagement.class.getName(), "database_userpassword");
        	
            this.conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/alamano", user, pass);
             
            //De esta forma evitamos que se hagan commits erroneos.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
        return conn;
	}
	
	public void freeConnection(){
        try
        {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * EJEMPLO
	 * GET - EXECUTE - COMMIT - FREE AND ROLLBACK.
	 * @param argv
	 */
    public static void main(String[] argv) {
 
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
                
        try {
        	
        	String user = Properties.getParameter(ConnectionManagement.class.getName(), "database_username");
        	String pass = Properties.getParameter(ConnectionManagement.class.getName(), "database_userpassword");
        	
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/alamano", user, pass);
            System.out.println("SQL Connection to database established!");
 
            //De esta forma evitamos que se hagan commits erroneos.
            connection.setAutoCommit(false);
                        
            Statement selectStmt = null;
            
            selectStmt = connection.createStatement();
            //ResultSet rs = selectStmt.executeQuery("select * FROM usuario");
            ResultSet rs = selectStmt.executeQuery("select SHA1(1234)");
            while(rs.next())
            {
                System.out.println(rs.getString(1));    //First Column
                //System.out.println(rs.getString(2));    //Second Column
            }
                        
            //Si todo salio bien commiteamos
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            try {
            	//Algo salio mal
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        }catch (Exception e) {
			System.out.println("Failed Propertyes");
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
        } finally {
            try
            {
                if(connection != null)
                    connection.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}