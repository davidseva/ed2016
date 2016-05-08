
import java.util.*;


// Clase que hereda de la clase Persona
public class Estudiante extends Persona {

    
    private int cod_estudiante;

    // Lista de asignaturas, al ser una asociación a muchos
    List<Matricula> matriculas;

    /**
     * Constructor parametrizado
     * @param d
     * @param n
     * @param di
     * @param e
     * @param c
     */
    public Estudiante (int d, String n, String di, String e, int c) {
        super(d, n, di, e);
		cod_estudiante = c;
               
    }

    
    public int getCod_estudiante () {
        return cod_estudiante;
    }

    
    public void setCod_estudiante (int val) {
        this.cod_estudiante = val;
    }
    
    // Este método nos permite obtener la lista de mátriculas del estudiantes
    public List getMatriculas(){
        return matriculas;
    }
    
    public void setMatriculas(List mat){
        this.matriculas = mat;
    }

}

