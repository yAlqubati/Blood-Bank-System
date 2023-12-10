
package BloodBankSystem;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * the hospital that all the operations will pass through it
 * @author Yousef Saif - Yahya Elimam - Abdulkarim Alsorori
 */

public class Hospital implements Serializable{
    
    private Store store;
    private String name;
    //private  int donorNumber = 0;
    
    
    /**
     * the constructor of the hospital
     * @param nameHospital the hospital name
     * @param StoreSize the size of the store
     * @param userName the username
     * @param password the password of the user
     */
    public Hospital(String nameHospital,double StoreSize,String userName,String password)
    {
        this.name = name;
        this.store = new Store(StoreSize,userName,password) {};
    }
    
    
    /*
    this method is used to read the data of the store from a binary file
    we should call it in the main after creating the hospital dirictly
    */
    
    /**
     * this method is used to read the data of the store from a binary file
     * so each time we execute the program the store values won't be initialized to zero
     * it will be initialized to the last values of the store before terminating the program
     */
    public void readData()
    {
        try {
            FileInputStream fstream = new FileInputStream("files\\hospital_data.dat");
            ObjectInputStream  read = new ObjectInputStream (fstream);
            
            
                this.store =(Store) read.readObject();
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /*
    this methos is used to write the data of the store in the binary file as an object
    and it will be called when ever we take or add blood
    */
    /**
     * this method is used to write the data of the store to a binary file
     * so we can read using readData method
     */
    public void writeDate()
    {
        
        try {
            FileOutputStream hospialFileWrite = new FileOutputStream("files\\hospital_data.dat");
            ObjectOutputStream writer = new ObjectOutputStream(hospialFileWrite);
            
            writer.writeObject(this.store);
            writer.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hospital.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    
    /**
     * to change the password
     * @param password the password that wanted to change to
     */
    public void setPassword(String password){
        store.setPassword(password);
        writeDate();
    }
    
    /**
     * to change the username
     * @param userName the username that wanted to change to
     */
    public void setUsername(String userName){
        store.setUserName(userName);
        writeDate();
    }
    
    /**
     * to get the username
     * @return the username
     */
    public String getUsername(){
        return store.getUserName();
    }
    
    /**
     * to get the password
     * @return the password
     */
    public String getPassword(){
        return store.getPassword();
    }
    
    // this method take blood from the store and return true
    /**
     * to take blood from the store
     * @param patient it will user the variables of the patient to complete the operation
     * @return true if the operation was completed successfully
     */
    public boolean takeBlood(Patient patient)
    {
        /*
            if the amount isn't avilabile the info will be add to the waiting list
            file of the patients
        */
        if(store.isEmpty(patient.getBloodType()) || store.getTypeAmount(patient.getBloodType()) <  patient.getAmount())
        {
            File patientWaitingList = new File("files\\patient_waiting_list.txt");
        
            try {
                if (patientWaitingList.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");

                    FileWriter fw = new FileWriter(patientWaitingList,true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(patient.toString() + "\n");
                }
            } 
            
            catch (Exception e) {
                System.out.println("error happen with the file");
                e.printStackTrace();
            }
            
            return false;
        }
        
        /*
            if the amount is avilabe the method will take the amount from the store
            and add the info of the patient to the file
        */
        else
        {
            store.takeBlood(patient.getAmount(), patient.getBloodType());
            System.out.println("the blood has been taken and stored");
            
            File patientInfo = new File("files\\patient_info.txt");
        
            try {
                if (patientInfo.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");

                FileWriter fw = new FileWriter(patientInfo,true);
                BufferedWriter bw = new BufferedWriter(fw);

                
                bw.write(patient.toString() + "\n");
                
                bw.close();
                writeDate();
            } catch (Exception e) {
                System.out.println("error happen with the file");
                e.printStackTrace();
            }
            return true;
        }
        
    }
    
    /**
     * to return the store
     * @return the store
     */
    public Store getStore()
    {
        return store;
    }
    

    
    /**
     * to add blood to the store
     * @param donor it will user the variables of the donor to complete the operation
     * @return true if the operation was completed successfully
     */
    public boolean addDonor(Donor donor) // this method will add the amount of blood to the store and info to the file
    {
        /*
            if there is no space in the store the info of the donor
            will be sent to the waiting file of the donors
        */
        if(store.isFull(donor.getBloodType()) || (donor.getAmount() + store.getTypeAmount(donor.getBloodType())) > store.getLimit())
        {
            
            File donorWaitingList = new File("files\\donor_wating_list.txt");
        
            try {
                if (donorWaitingList.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");

                    FileWriter fw = new FileWriter(donorWaitingList,true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    
                    bw.write(donor.toString() + "\n");

                bw.close();
            } 
            
            catch (Exception e) {
                System.out.println("error happen with the file");
                e.printStackTrace();
            }
            return false;
        }
        
        /*
            if there is space in the store and the stats of the donor is true
            the amount will be added to the store
            and the info will be sent to the file of the donors
        */
        else if(donor.getState())
        {
            
        
            store.addBlood(donor.getAmount(), donor.getBloodType());
            File donorFile = new File("files\\donor_info.txt");
        
            try {
                if (donorFile.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");

                FileWriter fw = new FileWriter(donorFile,true);
                BufferedWriter bw = new BufferedWriter(fw);

                        
                        bw.write(donor.toString() + "\n");



                
                bw.close();
            } 

            catch (Exception e) {
                System.out.println("error happen with the file");
                e.printStackTrace();
            }
            
            //donorNumber++;
        }
        
        
        writeDate();
        return true;
    }
  
        
    
    /*
        this method will read the info of the donors from the file
        and return it as string
    */
    /**
     * to show all the info in the text "donor_info.txt"
     * @return the info of all the donors as a string
     */
    public String showInfoDonorAll()
    {
        File donorFileRead = new File("files\\donor_info.txt");
        String info = "";
        try {
            Scanner scanDonorFile = new Scanner(donorFileRead);
            
            while(scanDonorFile.hasNext())
            {
                info += scanDonorFile.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file");
            e.printStackTrace();
        }
        return info;
    }
    
    /*
        this method will read the info of the donors in the waiting list from the file
        and return it as string
    */
    /**
     * to show all the info in the text "donor_wating_list.txt"
     * @return the info of all the donors in the waiting list as a string
     */
    public String showWaitingListDonor()
    {
        File donorFileRead = new File("files\\donor_wating_list.txt");
        String info = "";
        try {
            Scanner scanDonorFile = new Scanner(donorFileRead);
            
            while(scanDonorFile.hasNext())
            {
                info += scanDonorFile.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file");
            e.printStackTrace();
        }
        
        return info;
    }
    
    
    /*
        this method will read the info of the patients from the file
        and return it as string
    */
    /**
     * to show all the info in the text "patient_info.txt"
     * @return the info of all the patients as a string
     */
    public String showPatientInfoAll()
    {
        File donorFileRead = new File("files\\patient_info.txt");
        String info = "";
        try {
            Scanner scanDonorFile = new Scanner(donorFileRead);
            
            while(scanDonorFile.hasNext())
            {
                info += scanDonorFile.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file");
            e.printStackTrace();
        }
        
        return info;
    }
    
    /*
        this method will read the info of the donors from the waiting list file
        and return it as string
    */
    /**
     * to show all the info in the text "patient_waiting_list.txt"
     * @return the info of all the patients in the waiting as a string
     */
    public String showWaitListPatient()
    {
        File donorFileRead = new File("files\\patient_waiting_list.txt");
        String info = "";
        try {
            Scanner scanDonorFile = new Scanner(donorFileRead);
            
            while(scanDonorFile.hasNext())
            {
                info += scanDonorFile.nextLine() + "\n";
            }
        } catch (Exception e) {
            System.out.println("Error while reading the file");
            e.printStackTrace();
        }
        
        return info;
    }
    
    // this method will read the file line by line and search for a donor id
    /**
     * to search for a donor using his id
     * @param id the id of the donor
     * @return the info of the wanted donor
     */
  public String searchDonor(String id)
    {
        File donorFileRead = new File("files\\donor_info.txt");
        String temp = "";
        try {
            Scanner scanDonorFile = new Scanner(donorFileRead);
            
                while(scanDonorFile.hasNext())
                {
                    temp = scanDonorFile.nextLine();
                    

                    String checkId = temp.substring(0, 11); // id must be 11 numbers or it will not work

                    if(id.equals(checkId))
                    {
                        return temp;
                    }


                }
            
            
            
            } catch (Exception e) {
                System.out.println("Error while reading the file");
                e.printStackTrace();
            }
        
        return "this id doesn't exist";
    }
    
    // this method will read the file line by line and search for a patient id
  /**
     * to search for a patient using his id
     * @param id the id of the patient
     * @return the info of the wanted patient
     */
    public String searchPatient(String id)
    {
        File patientFileRead = new File("files\\patient_info.txt");
        String temp = "";
        try {
            Scanner scanPatientFile = new Scanner(patientFileRead);
            
                while(scanPatientFile.hasNext())
                {
                    temp = scanPatientFile.nextLine();

                    String checkId = temp.substring(0, 11);// id must be 10 numbers or it will not work

                    if(id.equals(checkId))
                    {
                        return temp;
                    }


                }
            
            
            
            } catch (Exception e) {
                System.out.println("Error while reading the file");
                e.printStackTrace();
            }
        
        return "this id doesn't exist";
    }
    
    public String ShowInfoStore()
    {
        return store.toString();
    }
    
    
}
