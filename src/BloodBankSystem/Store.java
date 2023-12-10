/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BloodBankSystem;

/**
 * the store that will keep all the blood inside
 * @author Yousef Saif
 */
import java.io.Serializable;
import java.util.ArrayList;

// Types of blood
//enum BloodType {A,B,AB,O,Aneg,Bneg,ABneg,Oneg};

public abstract class Store implements Serializable{
    
    // initialize  all varialbes
    private double size;
    private double a;
    private double b;
    private double ab;
    private double o;
    private double aneg;
    private double bneg;
    private double abneg;
    private double oneg;
    private double limit;
    private String userName;
    private String password;
    private  int donorNumber;
     

    
    
    // Constructor
    /**
     * the constructor of the store
     * @param size the size of the store
     * @param userName the username
     * @param password the password
     */
    public Store(double size,String userName,String password)
    {
        this.userName=userName;
        this.password=password;
        this.size = size;
        // Limit is size / 8 cause we have 8 types of blood
        this.limit = size / 8;
    }
    
    
    // This method is used to return the amount of blood for a certin type of blood
    /**
     * to get the amount of a specific blood type in the store
     * @param type the wanted blood type
     * @return the amount of blood
     */
    public double getTypeAmount(BloodType type)
    {
        if(type == BloodType.A)
            return a;
        
        else if(type == BloodType.B)
            return b;
        
        else if(type == BloodType.AB)
            return ab;
        
        else if(type == BloodType.O)
            return o;
        
        if(type == BloodType.Aneg)
            return aneg;
        
        else if(type == BloodType.Bneg)
            return bneg;
        
        else if(type == BloodType.ABneg)
            return abneg;
        
        else 
            return oneg;
        
    }
    
    
    
    // This method return true if a certin store is full
    /**
     * to check if the container of a specific blood type is full
     * @param type the wanted blood type
     * @return true if container if full
     */
    public boolean isFull(BloodType type)
    {
        if(getTypeAmount(type) == limit)
            return true;
        
        else
            return false;
    }
    
    
    
    // This method return true if a certin store is empty
    /**
     * to check if the container of a specific blood type is empty
     * @param type the wanted blood type
     * @return true if container if empty
     */
    public boolean isEmpty(BloodType type)
    {
        if(getTypeAmount(type) == 0)
            return true;
        
        else
            return false;
    }
    
    
    
    /*
    this method is used to take blood from a certin store
    first we check if the store is empty, then we check if the requested amount is avaliable
    if yes we subtract the amount from the store and return true
    if no we return false and we might throw exception
    */
    /**
     * to take blood from a specific container
     * @param amount the wanted amount
     * @param type the wanted blood type
     * @return true if the operation was completed successfully
     */
    public boolean takeBlood(double amount,BloodType type)
    {
        if(!isEmpty(type))
        {
            if(getTypeAmount(type) >= amount)
            {
                if(type == BloodType.A)
                    a -= amount;
                
                else if(type == BloodType.B)
                    b -= amount;
                
                else if(type == BloodType.AB)
                    ab -= amount;
                
                else if(type == BloodType.O)
                    o -= amount;
                
                else if(type == BloodType.Aneg)
                    aneg -= amount;
                
                else if(type == BloodType.Bneg)
                    bneg -= amount;
                
                else if(type == BloodType.ABneg)
                    abneg -= amount;
                
                else
                    oneg -= amount;
                
                return true;
            }
        }
        return false;
    }
    
    
    
    /*
    this method is used to add blood to a certin a store
    first we check if the store is full then we check is the amount + getTypeAmount(type) > Limit
    if there is place we add it and return true if no we return false and throw exception
    */
    /**
     * to add blood to a specific container
     * @param amount the wanted amount
     * @param type the wanted blood type
     * @return true if the operation was completed successfully
     */
    public boolean addBlood(double amount,BloodType type) 
    {
        if(!isFull(type))
        {
            if(getTypeAmount(type) + amount <= limit)
            {
                if(type == BloodType.A)
                    a += amount;
                
                else if(type == BloodType.B)
                    b += amount;
                
                else if(type == BloodType.AB)
                    ab += amount;
                
                else if(type == BloodType.O)
                    o += amount;
                
                else if(type == BloodType.Aneg)
                    aneg += amount;
                
                else if(type == BloodType.Bneg)
                    bneg += amount;
                
                else if(type == BloodType.ABneg)
                    abneg += amount;
                
                else
                    oneg += amount;
                
                donorNumber++;
                return true;
            }
        }
        
        // throw exception if its full
        /*
        if(isFull(type))
            throw new IllegalArgumentException("The store is full, there is no space to add blood");
        
        else if(getTypeAmount(type) + amount > limit)
            throw new IllegalArgumentException("sorrry there is no enough space for" + amount + "\n the only amount that "
                    + "can be stored is " + (limit - getTypeAmount(type)));
*/
        
        return false;
    }
    
    
    // to get the limit(might delete it latter)
    /**
     * to get the limit of the containers
     * @return the limit
     */
    public double getLimit(){
        return limit;
    }
    
    
    // to return the status of all the stores
    
    
    @Override
    public String toString(){
        return "There is " + getTypeAmount(BloodType.A)+ " in the A store, \n"+
                "There is " + getTypeAmount(BloodType.B)+ " in the B store, \n"+
                "There is " + getTypeAmount(BloodType.AB)+ " in the AB store, \n"+
                "There is " + getTypeAmount(BloodType.O)+ " in the O store, \n"+
                "There is " + getTypeAmount(BloodType.Aneg)+ " in the A- store, \n"+
                "There is " + getTypeAmount(BloodType.Bneg)+ " in the B- store, \n"+
                "There is " + getTypeAmount(BloodType.ABneg)+ " in the AB- store, \n"+
                "There is " + getTypeAmount(BloodType.Oneg)+ " in the O- store, \n";
    }
    
/*
    @Override
    public String toString() {
        /*return "Store{" + "size=" + size + ", a=" + a + ", b=" + b + ", ab=" + ab + ", o=" + o + ", aneg=" + aneg + ", bneg=" + bneg + ", abneg=" + abneg + ", oneg=" + oneg + ", limit=" + limit + '}';
    
        return "A = " + a + "\t\tB = " + b + "\t\tAB = " + ab + "\t\tO = "+ o + 
                "\nA- = " + aneg + "\t\tB- = " + bneg + "\t\tAB- = " + abneg + "\t\tO- = " + oneg + 
                "\nSize = " + size;
        }
    */
    
    // this method is used to return what stores are empty as a arraylist
    /**
     * to return a ArrayList contain the empty stores for the sake of knowledge
     * @return ArrayList contain the empty stores
     */
    public ArrayList<String> whatIsEmpty()
    {
        ArrayList<String> EmptyStores = new ArrayList<>();
        
        if(isEmpty(BloodType.A))
            EmptyStores.add("A ");
        
        if(isEmpty(BloodType.B))
            EmptyStores.add("B ");
        
        if(isEmpty(BloodType.AB))
            EmptyStores.add("AB ");
        
        if(isEmpty(BloodType.O))
            EmptyStores.add("O ");
        
        if(isEmpty(BloodType.Aneg))
            EmptyStores.add("A- ");
        
        if(isEmpty(BloodType.Bneg))
            EmptyStores.add("B- ");
        
        if(isEmpty(BloodType.ABneg))
            EmptyStores.add("AB- ");
        
        if(isEmpty(BloodType.Oneg))
            EmptyStores.add("O- ");
        
        return EmptyStores;
    }
    
    /**
     * to get the username
     * @return the username
     */
    public String getUserName(){
        return userName;
    }
    
    /**
     * to change the username
     * @param userName the username that wanted to change to
     */
    public void setUserName(String userName){
        this.userName=userName;
    }
    
    /**
     * to get the password
     * @return the password
     */
    public String getPassword(){
        return password;
    }
    
    /**
     * to change the password
     * @param password the password that wanted to change to
     */
    public void setPassword(String password){
        this.password=password;
        
    }
    /**
     * to get the donor number
     * @return the donor's number
     */
    public int getDonorNumber(){
        return donorNumber;
    }
}
