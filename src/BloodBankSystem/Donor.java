
package BloodBankSystem;

//enum BloodType {A,B,AB,O,Aneg,Bneg,ABneg,Oneg};

import java.io.Serializable;

/**
 * this class is used to do all operation regarding the donor
 * @author Abdulkarim Alsorori
 */
public class Donor implements humanBehaviour, Serializable{
  
    private String name;
    private  BloodType bloodType;
    private double amount;
    private String number;
    private String id;
    private boolean state = true;
    
    /**
     * the constructor of the donor
     * @param name the name of the donor
     * @param amount the amount of blood
     * @param type the blood type
     * @param number the donor phone number
     * @param id the donor id number
     */
   public  Donor(String name, double amount,BloodType type,String number,String id)
   {
       this.name = name;
       this.amount = amount;
       this.bloodType = type;
       this.number = number;
       this.id = id;
   }

   /**
    * to change the state of the donor
    * @param state true or false
    */
   public void setState(boolean state)
   {
       this.state = state;
   }
    
   /**
    * to get the amount of blood
    * @return the amount of blood
    */
   public double getAmount()
   {
       return amount;
   }
   
   /**
    * to change the name of the donor
    * @param name the name that wanted to change to
    */
   public void setName(String name)
   {
       this.name = name;
   }
   
   /**
    * to change the number of the donor
    * @param number the number that wanted to change to
    */
   public void setNumber(String number)
   {
       this.number = number;
   }
   
   /**
    * to change the id of the donor
    * @param Id the id that wanted to change to
    */
   public void setId(String Id)
   {
       this.id = Id;
   }
   
   /**
    * to change the amount of blood
    * @param amount the amount that wanted to change to
    */
   public void setAmount(double amount)
   {
       this.amount = amount;
   }
   
   /**
    * to get the number of the donor
    * @return the donor's number
    */
   public String getNumber()
   {
       return number;
   }
   
   /**
    * to change the blood type of the donor
    * @param bloodType the blood type that wanted to change to
    */
   public void setBloodType(BloodType bloodType){
        this.bloodType=bloodType;
    }

   /**
    * to get the blood type of the donor
    * @return the donor's blood type
    */
   public BloodType getBloodType(){
       return bloodType;
   }
   
   /**
    * to get the name of the donor
    * @return the donor's name
    */
   public String getName()
   {
       return name;
   }
   
   /**
    * to get the id of the donor
    * @return the the donor's id
    */
   public String getId()
   {
       return id;
   }
   
   /**
    * to get the state of the donor
    * @return the donor's state
    */
   public boolean getState()
   {
       return state;
   }
   
   
    @Override
   public String toString()
   {
       return id+ "\t\t" + name + "\t\t" + String.valueOf(bloodType) + "\t\t" + String.valueOf(amount) + "\t\t" + number + "\t\t" + java.time.LocalDate.now(); // we can write it with out valueof
   }
}