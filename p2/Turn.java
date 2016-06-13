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
public class Turn {
    
    protected String anyDay; // dia de la semana, ha de guardarse en mayúscula
    protected int beginHour; // hora de inicio del turno (entre 0 y 23)
    protected int finishHour; // hora de finalización del turno (entre 0 y 23)
    
    /**
     * Constructor por defecto
     */
    public Turn()
    {
        anyDay = "";
        beginHour = 0;
        finishHour = 0;
    }
    /**
     * Contructor sobrecargado, 1 parámetro
     * Se guarda en mayúsculas
     * @param aDay 
     */
    public Turn(String aDay)
    {
        anyDay = (aDay == null)? null : aDay.toUpperCase();
    }
    /**
     * Constructor sobrecargado, 3 parámetros
     * @param aDay
     * @param alnitHour
     * @param aFinishHour 
     */
    public Turn (String aDay, int alnitHour, int aFinishHour)
    {
        anyDay = (aDay == null)? null : aDay.toUpperCase();        
        if (alnitHour >= 0 && alnitHour <= 23)
            beginHour = alnitHour;
        if (aFinishHour >= 0 && aFinishHour <= 23)
            finishHour = aFinishHour;
    }
    /**
     * Establece el dia de la semana, en mayúsculas
     * @param aDay 
     */
    public void setDay(String aDay)
    {
        anyDay = (aDay == null)? null : aDay.toUpperCase();
    }
    /**
     * Devuelve el día de la semana
     * @return 
     */
    public String getDay()
    {
        return (anyDay == null)? null : anyDay;
    }
    /**
     * establece la hora de inicio
     * Entre 0 y 23 horas
     * @param inHour 
     */
    public void setInitHour(int inHour)
    {
        if(inHour >= 0 && inHour <= 23)
            beginHour = inHour;
    }
    /**
     * Devuelve la hora de inicio
     * @return 
     */
    public int getInitHour()
    {
        return beginHour;
    }
    /**
     * Establece la hora de finalización
     * Entre 0 y 24 horas
     * @param finHour 
     */
    public void setFinishHour(int finHour)
    {
        
        if(finHour >= 0 && finHour <= 23)
            finishHour = finHour;
    }
    /**
     * Devuelve la hora de finalización
     * @return 
     */
    public int getFinishHour()
    {
        return finishHour;
    }
}
