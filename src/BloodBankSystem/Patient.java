

package BloodBankSystem;
import java.util.Date;

/**
 * this class is used to do all operation regarding the patient
 * @author Yahya Elimam
 */
public class Patient implements humanBehaviour{
    
    private String name;
    private String id;
    private BloodType bloodType;
    private double amount;

    
    /**
     * the constructor of the patient
     * @param name the name of the patient
     * @param amount the amount of blood of the patient
     * @param type the blood type of the patient
     * @param id the id number of the patient
     */
    public Patient(String name, double amount, BloodType type, String id) {
     
        this.name = name;
        this.id = id;
        this.bloodType = type;
        this.amount = amount;
    }
    
    

    /**
    * to change the name of the patient
    * @param name the name that wanted to change to
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * to change the id of the patient
    * @param id the id that wanted to change to
    */
    public void setId(String id) {
        this.id = id;
    }

    /**
    * to change the amount of blood
    * @param amount the amount that wanted to change to
    */
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    @Override
    /**
    * to change the name of the patient
    * @param name the name that wanted to change to
    */
    public String getName()
    {
        return name;
    }
    
    @Override
    /**
    * to get the id of the patient
    * @return the the patient's id
    */
    public String getId()
    {
        return id;
    }
    
    @Override
    /**
    * to get the blood type of the patient
    * @return the patient's blood type
    */
    public BloodType getBloodType()
    {
        return bloodType;
    }
    
    /**
    * to get the amount of blood
    * @return the amount of blood
    */
    @Override
    public double getAmount()
    {
        return amount;
    }
    
    @Override
    /**
    * to change the blood type of the patient
    * @param bloodType the blood type that wanted to change to
    */
    public void setBloodType(BloodType bloodType){
        this.bloodType=bloodType;
    }
    
    @Override
    public String toString()
    {
        return id+ "\t" + name + "\t\t" + String.valueOf(bloodType) + "\t" + String.valueOf(amount) + "\t" + java.time.LocalDate.now();
    }
    
    
}
