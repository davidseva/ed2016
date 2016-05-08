
import java.util.*;


// Clase derivada de la clase Persona
public class Profesor extends Persona {

    
    private int cod_prof;

    // Lista de asignaturas, porque es una asociación a muchos
    List<Asignatura> asignaturas;
   

    // Constructor parametrizado 
    public Profesor (int d, String n, String di, String e, int c) {
        super(d, n, di, e);
		setCod_prof(c);                
		
    }
    
    // Getters y setters
    
    public int getCod_prof () {
        return cod_prof;
    }

    
    public void setCod_prof (int val) {
        this.cod_prof = val;
    }
    
    // Este método nos permite obtener la lista de asignaturas de cada profesor
    public List getAsignaturas(){
        return asignaturas;
    }
    
    public void setAsignaturas(List asi){
        this.asignaturas = asi;
    }
  

}

