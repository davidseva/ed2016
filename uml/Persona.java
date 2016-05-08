
 /*
 * Clase base de la que heredan las clases Estudiante y Profesor
*/
public class Persona {

    
    private int dni;

    
    private String nombre;

    
    private String direccion;

   
    private String estado_civil;

    //  Constructor parametrizado
    public Persona (int d, String n, String di, String e) {
		setDni(d);
		setNombre(n);
		setDireccion(di);
		setEstado_civil(e);
    }

    // Getters y setters
    
    public String getDireccion () {
        return direccion;
    }

   
    public void setDireccion (String val) {
        this.direccion = val;
    }

    
    public int getDni () {
        return dni;
    }

   
    public void setDni (int val) {
        this.dni = val;
    }

    
    public String getEstado_civil () {
        return estado_civil;
    }

     
    public void setEstado_civil (String val) {
        this.estado_civil = val;
    }

    
    public String getNombre () {
        return nombre;
    }

    
    public void setNombre (String val) {
        this.nombre = val;
    }

}

