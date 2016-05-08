

public class Beca {

   
    private int cod_beca;

    
    private float importe;

    
    private boolean esBecario;

    // Constructor parametrizado
    public Beca (int c, float i, boolean e) {
		setCod_beca(c);
		setImporte(i);
		setEsBecario(e);
    }

    // Getters y setters
    
    public int getCod_beca () {
        return cod_beca;
    }

    
    public void setCod_beca (int val) {
        this.cod_beca = val;
    }

    
    public boolean getEsBecario () {
        return esBecario;
    }

    
    public void setEsBecario (boolean val) {
        this.esBecario = val;
    }

     
    public float getImporte () {
        return importe;
    }

     
    public void setImporte (float val) {
        this.importe = val;
    }

}

