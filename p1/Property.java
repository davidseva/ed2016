/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyshop;

/**
 *
 * @author David Seva
 */
public class Property {

    String name; // nombre del inmueble
    String address; // dirección del inmueble
    double conSf; // superficie construida
    double avaSf; // superticie útil
    String owner; // nombre del propietario
    String ownerAddress; // dirección del propietario
    int price; // precio del inmueble
    
   /**
     * Guarda nombre del inmueble
     * @param n 
     */
    public void setName(String n)
    {
        name = (n == null)? null : n;
    }
    /**
     * 
     * @return 
     * Devuelve el nombre del inmueble, en minúsculas
     */
    public String getName()
    {
        return (name == null)? null : name.toLowerCase();
    }
    /**
     * Guarda la dirección del inmueble
     * @param ad 
     */
    public void setAddress(String ad)
    {
        address = (ad == null)? null : ad;
    }
    /**
     * 
     * @return 
     * Devuelve la dirección del inmueble, en mayúsculas
     */
    public String getAddress ()
    {
        return (address == null)? null : address.toUpperCase();
    }
    /**
     * Guarda los metros cuadrados construidos
     * Siempre positivos mayor que cero
     * @param csf 
     */
    public void setConstructedSurface(double csf)
    {
        
       if (csf > 0)
           conSf = csf;
    }
    /**
     * 
     * @return 
     * Devuelve los m2 construidos
     */
    public double getConstructedSurface()
    {
        return conSf;
    }
    /**
     * Guarda los metros cuadrados útiles
     * Siempre positivos mayor que cero
     * @param asf 
     */
    public void setAvailableSurface( double asf)
    {
        
        if (asf>0)
            avaSf = asf;
        
    }
    /**
     * 
     * @return 
     * Devuelve los m2 útiles      
     */
    public double getAvailableSurface()
    {
        return avaSf;
    }
    /**
     * Guarda el nombre del propietario
     * @param own 
     */
    public void setOwner(String own)
    {
        owner = (own == null)? null : own;
    }
    /**
     * 
     * @return 
     * Devuelve el nombre del propietario
     */
    public String getOwner()
    {
        return owner;
    }
    /**
     * Guarda la dirección del propietario
     * @param ownadd 
     */
    public void setOwnerAddress(String ownadd)
    {
        ownerAddress = (ownadd == null)? null : ownadd;
    }
    /**
     * 
     * @return 
     * Devuelve la dirección del propietario
     */
    public String getOwnerAddress()
    {
        return ownerAddress;
    }
    /**
     * Guarda el precio del inmueble
     * Siempre positivo
     * @param pc 
     */
    public void setPrice(int pc)
    {
        //price = (pc < 0)? null : pc;
        if (pc>0)
            price = pc;
    }
    /**
     * 
     * @return 
     * Devuelve el precio del inmueble
     */
    public int getPrice()
    {
        return price;
    }
            
}
