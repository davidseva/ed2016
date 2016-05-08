
import java.util.*;


 
public class Matricula {

    
    private int cod_mat;

    // Añadimos parámetro fecha, relación de composición
    private Fecha fecha;
   
    private String descripcion;
	
    // Añadimos parámetro beca, al tratarse de una relación de composición
    private Beca beca;
        
    // Lista de asignaturas, al ser una asociación a muchos
    List<Asignatura> asignaturas;

    // Constructor parametrizado
    public Matricula (int c, Fecha f, String d, Beca b) {
		setCod_mat(c);
		setFecha(f);
		setDescripcion(d);
                
    }

    // Getters y setters
    public int getCod_mat () {
        return cod_mat;
    }

    
    public void setCod_mat (int val) {
        this.cod_mat = val;
    }

   
    public String getDescripcion () {
        return descripcion;
    }

   
    public void setDescripcion (String val) {
        this.descripcion = val;
    }

   
    public Fecha getFecha () {
        return fecha;
    }

    
    public void setFecha (Fecha val) {
        this.fecha = val;
    }
	
	public void setBeca (Beca b) {
		this.beca = b;	
	}
	
	public Beca getBeca () {
		return beca;
	}
	
        // Este método nos permite obtener la lista de asignaturas en la matricula
        public List getAsignaturas(){
        return asignaturas;
        }
    
        public void setAsignaturas(List asi){
        this.asignaturas = asi;
        }

}

