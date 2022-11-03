
package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class conexionsql {
  Connection conn = null;
  String url = "jdbc:postgresql://localhost/empresa";
  String usuario = "postgres";
  String clave = "CRR1001506044";
  
  public Connection conectar(){
      try{
          Class.forName("org.postgresql.Driver");
          conn = DriverManager.getConnection(url,usuario,clave);
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"Error al conectar "+e,"Error",JOptionPane.ERROR_MESSAGE); //se muestra que un mensaje diciendo que la conexion fallo
      }
      return conn;
  }
  
}
