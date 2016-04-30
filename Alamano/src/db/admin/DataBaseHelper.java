package db.admin;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.PreparedStatement;

public class DataBaseHelper {
	
	/**
	 * SHA1(str)
	 * Calcula una checksum SHA1 de 160-bit para la cadena, como se describe en RFC 3174 (Secure Hash Algorithm). 
	 * El valor se retorna como cadena de 40 ditigos hexadecimales, o NULL si el argumento era NULL. 
	 * Uno de los usos posibles para esta funcion es una clave hash. 
	 * Tambien puede usarlo como funcion criptograficamente segura para almacenar contrasenas.
	 * @param password
	 * @return
	 */
	public String getSHA1FromPassword(String password){
		ConnectionManagement conManagement = new ConnectionManagement();
		String resultado = null;
		Connection con = null;
		try {
			ResultSet rs = null;
			
			con = conManagement.getConnection();            
            PreparedStatement p = con.prepareStatement("SELECT SHA1(?)");
            p.setString(1, password);
            rs = p.executeQuery();
            
            while(rs.next())
            {
                resultado = rs.getString(1);
            }
            
            conManagement.freeConnection();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultado;
	}
}
