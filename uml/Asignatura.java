
import java.util.*;

public class Asignatura {

    
    private int cod_asig;
    
    private String nombre;
    
    private String curso;    
       
    // cada asignatura tiene un profesor
    private Profesor profesor;
    
    // Lista de asignaturas, al ser una asociación a muchos
    List<Matricula> matriculas;
    
    // Lista de notas, asociación a muchos
    List<Nota> notas;

    // Constructor parametrizado
    public Asignatura (int c, String n, String cu, Profesor p) {
		setCod_asig(c);
		setNombre(n);
                setCurso(cu);                
                setProfesor(p);              
                
                
    }

    // Getters y setters
    
    public int getCod_asig () {
        return cod_asig;
    }

   
    public void setCod_asig (int val) {
        this.cod_asig = val;
    }

    
    public String getNombre () {
        return nombre;
    }

    
    public void setNombre (String val) {
        this.nombre = val;
    }
    
     public String getCurso() {
        return curso;
    }

    
    public void setCurso (String val) {
        this.curso = val;
    }
    
       
    public Profesor getProfesor() {
        return profesor;
    }
    
    public void setProfesor (Profesor val) {
        this.profesor = val;
    }
    
    // Este método nos permite obtener la lista de matriculas por asignatura
    public List getMatriculas(){
        return matriculas;
    }
    
    public void setMatriculas(List mat){
        this.matriculas = mat;
    }
    
    // Este método nos permite obtener la lista de notas por asignatura
     public List getNotas(){
        return notas;
    }
    
    public void setNotas(List not){
        this.notas = not;
    }

    

}

