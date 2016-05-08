/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anyo;
    
    // Constructor parametrizado
    public Fecha(int d, int m, int a) {
        setDia(d);
        setMes(m);
        setAnyo(a);
        
    }
    public void setAnyo (int val) {
        this.anyo = val;
    }
    public int getAnyo () {
        return anyo;
    }
    public void setMes (int val) {
        this.mes = val;
    }
    public int getMes () {
        return mes;
    }
    public void setDia (int val) {
        this.dia = val;
    }
    public int getDia () {
        return dia;
    }
           
    
}
