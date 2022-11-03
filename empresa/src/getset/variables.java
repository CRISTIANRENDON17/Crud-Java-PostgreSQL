package getset;
/*
* @autor cristian 
*/
public class variables {

    private static String idempleado;
    private static String nombre;
    private static String apellido;
    private static String puesto;
    

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto() {
        return puesto;
    }

    //recolectaremos los datos de la tabla
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
