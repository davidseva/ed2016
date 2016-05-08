

public class Nota {

    
    private int cod_nota;
        
    private String comentarios;
    
    // Cada nota tiene una asignatura asignada
    private Asignatura asignatura;

    // Constructor parametrizado
    public Nota (int c, String com, Asignatura a) {
		setCod_nota(c);
		setComentarios(com);
                setAsignatura(a);
    }

   
    public int getCod_nota () {
        return cod_nota;
    }

    
    public void setCod_nota (int val) {
        this.cod_nota = val;
    }

    
    public String getComentarios () {
        return comentarios;
    }

    
    public void setComentarios (String val) {
        this.comentarios = val;
    }
    
     public Asignatura getAsignatura () {
        return asignatura;
    }

    
    public void setAsignatura (Asignatura val) {
        this.asignatura = val;
    }

}

