package model;


public class Doctor {
	private int dr_id;
    private String dr_name;
    private String dr_specialist;
   
    private String Timing;
    private String quaification;

    // Constructor
    public Doctor(int dr_id,String dr_name,String  dr_specialist,String Timing,String quaification)
 {
        this.dr_id = dr_id;
        this.dr_name = dr_name;
        this.dr_specialist = dr_specialist;
        //this.dr_password = dr_password;
        this.Timing = Timing;
        this.quaification =quaification;
    }

    public Doctor() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getDoctor_id() {
        return dr_id;
    }

    public void setDoctor_id(int dr_id) {
        this.dr_id = dr_id;
    }

    public String getDoctor_name() {
        return dr_name;
    }

    public void setDoctor_name(String dr_name) {
        this.dr_name = dr_name;
    }
    
    public String getSpecilist() {
        return dr_specialist;
    }

    public void setSpecilist(String dr_specialist) {
        this.dr_specialist =dr_specialist;
    }

   /* public int getPassword() {
        return dr_password;
    }

    public void setPassword(int dr_password) {
        this.dr_password = dr_password;
    }*/
    public String getTiming() {
        return Timing;
    }

    public void setTiming(String Timing) {
        this.Timing = Timing;
    }
    
    public String getQualification() {
        return quaification;
    }

    public void setQualification(String quaification) {
        this.quaification =quaification;
    }

    @Override
    public String toString() {
        return "doctor{" +
                "dr_id='" + dr_id + '\'' +
                ", dr_name='" + dr_name + '\'' +
                ", dr_specialist='" + dr_specialist + '\'' +
               
                ", Timing='" + Timing + '\'' +
                ",quaification=" +quaification +
                '}';
    }

}
