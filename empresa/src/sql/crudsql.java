package sql;

import getset.variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/*
* @autor cristian 
*/

public class crudsql extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();

    public void insertar(String nombre, String apellido, String puesto) {
        try {
            Connection conexion = conectar(); //realiza la conexion de manera directa a la base de datos
            st = conexion.createStatement(); //crea un objeto para poder ejecutar sentencias sql
            String sql = "insert into empleados(nombre,apellido,puesto) values('" + nombre + "','" + apellido + "','" + puesto + "');";
            st.execute(sql); //ejecuta la sentencia sql
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO se guardo ", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String idempleado){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from empleados where idempleado='"+idempleado+"';";
            rs = st.executeQuery(sql); //ejecuta la secuencia y lo almacena en rs
            if(rs.next()){
                var.setIdempleado(rs.getString("idempleado"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("apellido"));
                var.setPuesto(rs.getString("puesto"));
            }else{
                var.setIdempleado("");
                var.setNombre("");
                var.setApellido("");
                var.setPuesto("");
                JOptionPane.showMessageDialog(null,"No se encontro registro", "Sin registro",JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el sistema de busquedad ", "Error busqueda", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void actualizar(String nombre,String apellido,String puesto, String idempleado){
    
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update empleados set nombre='"+nombre+"', apellido='"+apellido+"', puesto='"+puesto+"' where idempleado='"+idempleado+"'; ";
            st.executeUpdate(sql); //ejecuta secuencia
            JOptionPane.showMessageDialog(null,"El registro se acutalizo","Exito",JOptionPane.INFORMATION_MESSAGE);
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al actualizar "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String idempleado){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement(); //nos permite ejecutar las sentencias
            String sql = "delete from empleados where idempleado='"+idempleado+"'; ";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null,"El registro se elimino con exito","Eliminar",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar registro "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
