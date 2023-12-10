// to force the patient and the donor to write the necessary methods
package BloodBankSystem;

//enum BloodType {A,B,AB,O,Aneg,Bneg,ABneg,Oneg};
public interface humanBehaviour {
    
    public String getName();
    
    public String getId();
    
    public BloodType getBloodType();
    
    public double getAmount();
    
    public void setName(String name);
    
    public void setId(String id);
    
    public void setAmount(double amount);
    
    public String toString();
    
    public void setBloodType(BloodType bloodType);
}
