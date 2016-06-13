/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmanagement;



/**
 *
 * @author david
 */
public class Employee {
    // nombre
    protected String name; 
    // apellidos
    protected String surname; 
    // DNI del empleado, ha de ser validarse.
    protected String dni;  
    // Array que contiene los turnos asignados al empleado, máximo 7.
    Turn [] turnos  = new Turn[7];
    // Número de turnos asignados al empleado (posiciones ocupadas del array)
    int numTurnos = 0;
    
    /**
     * 
     * Constructor sin parámetros
     */
    public Employee()
    {
        name = "";
        surname = "";
        dni = "";
        
        
    }
    /**
     * Constructor con 2 parámetros
     * @param aName
     * @param aSurname 
     */    
    public Employee(String aName, String aSurname)
    {
        
        name = (aName == null)? null : aName;
        surname = (aSurname == null)? null : aSurname;
    }
   
    
    /**
      * Funcion que comprueba que un dni es correcto
      * @param pDNI
     * @return boolean
      */
    public static boolean comprobarDNI(String pDNI){    
                 
        
             // Array con las letras posibles del dni en su posición
        char[] letraDni = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',  'X',  'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
        };  
  
        String num= "";
        int ind = 0;  
        
        // Si el valor es nulo, devuelve false
        if(pDNI == null)
            return false;
        
        // existen dnis con 7 digitos numericos, si fuese el caso
        // le añado un cero al principio
        if(pDNI.length() == 8) {
             pDNI = "0" + pDNI;
        }
  
        // compruebo que el 9º digito es una letra
        if (!Character.isLetter(pDNI.charAt(8))) {
             return false;  
        }
  
        // compruebo su longitud que sea 9
        if (pDNI.length() != 9){   
             return false;
        }  
 
        // Compruebo que lo 8 primeros digitos sean numeros
        for (int i=0; i<8; i++) {
   
             if(!Character.isDigit(pDNI.charAt(i))){
                   return false;    
             }
             // si es numero, lo recojo en un String
             num += pDNI.charAt(i);     
        }
  
        // paso a int el string donde tengo el numero del dni
        ind = Integer.parseInt(num);
  
        // calculo la posición de la letra en el array que corresponde a este dni
        ind %= 23;
  
        // verifico que la letra del dni corresponde con la del array
        if ((Character.toUpperCase(pDNI.charAt(8))) != letraDni[ind]){
             return false;
       }  
       // si el flujo de la funcion llega aquí, es que el dni es correcto
       return true;
   } // fin comprobar
    
     /**
     * Constructor con 3 parámetros
     * @param aDNI
     * Se comprueba si el DNI es correcto, invocando a la funcion comprobarDNI
     * @param aName
     * @param aSurname 
     */
    public Employee(String aDNI, String aName, String aSurname)
    {
        dni = (comprobarDNI(aDNI))? aDNI: null;
        name = (aName == null)? null : aName;
        surname = (aSurname == null)? null : aSurname;
    }
    /**
     * Método que establece el nombre del empleado
     * @param aName 
     */
    public void setName(String aName)
    {
        name = (aName == null)? null : aName;
    }
    /**
     * Método que devuelve el nombre del empleado
     * @return 
     */
    public String getName()
    {
        return (name == null)? null : name;
    }
    /**
     * Método que establece el apellido
     * @param surn 
     */
    public void setSurname(String surn)
    {
        surname = (surn == null)? null : surn;
    }
    /**
     * Método que devuelve el apellido
     * @return 
     */
    public String getSurname()
    {
        return (surname == null)? null : surname;
    }
    /**
     * 
     * @param nameInUpperCase
     * @param surnameInUpperCase
     * @return 
     * Si el primer parámetro es true, devuelve el nombre en mayúsculas
     * Si el segundo parámetro es true, devuelve el apellido en mayúsculas
     */
    public String getFullName(boolean nameInUpperCase, boolean surnameInUpperCase)
    {
        if (name == null)
            name = "";
        
        if (surname == null)
            surname = "";
        
        if (nameInUpperCase && surnameInUpperCase)
            return name.toUpperCase() + ", " + surname.toUpperCase();
        else if (nameInUpperCase)
            return name.toUpperCase() + ", " + surname;
        else if (surnameInUpperCase)
            return name + ", " + surname.toUpperCase();
        else
            return name + ", " + surname;
    }
    /**
     * Método que establece el dni
     * Se comprueba su validez 
     * @param aDNI 
     */
    public void setDNI(String aDNI)
    {
        dni = comprobarDNI(aDNI)? aDNI : null;
        //if (comprobarDNI(aDNI))
         //   dni = aDNI;
    }
    /**
     * Método que devuelve el dni
     * @return 
     */
    public String getDNI()
    {
        return (dni == null)? null : dni;
    }
    /**
     * Método que añade un turno al empleado
     * @param turno 
     */
    public void addTurn(Turn turno)
    {
        //if (turno == null)
         //   turnos[numTurnos] = null;
                    
        if(numTurnos<7 && turno != null)
            {
                turnos[numTurnos] = turno;
                numTurnos++;
            }
       
    }
    /**
     * Borra los turnos del empleado asignados a determinado dia
     * @param aDay 
     */
    public void removeTurn(String aDay)
    {
        for(int i=0; i<numTurnos; i++)
        {
            if (turnos[i].anyDay.toUpperCase().equals(aDay.toUpperCase()))
            {
                for(int j=i; j<numTurnos-1; j++)
                {
                    turnos[j] = turnos[j+1];
                }
                numTurnos--;
            }
            
        }
    }
    /**
     * Devuelve el número de turnos a los que está asignado el empleado
     * @return 
     */
    public int getTurnCount()
    {
        return numTurnos;
        
       
    }
    /**
     * Devuelve el turno que se encuentra en la posición “anIndex” 
     * Si se intenta acceder a un turno que no existe, esta función devolverá null
     * @param anIndex
     * @return 
     */
    public Turn getTurnAt(int anIndex)
    {
        
        
        Turn var = turnos[anIndex] == null ? null : turnos[anIndex];
        return var;
        
    }
    /**
     * Devuelve un array con los turnos a los que está asignado el empleado.
     * @return 
     */
    public Turn[] getTurns()
    {
        
        
        Turn[] temporal = new Turn[this.numTurnos];
        for(int i=0; i<this.numTurnos; i++)
        {
            temporal[i] = this.turnos[i];
        }
        return temporal;
        
    }
}
