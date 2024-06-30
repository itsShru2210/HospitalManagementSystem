package model;

//import java.util.Date;

public class Medical {
	private String p_name;
    private String test_type;
    private String result1;
    private String diagnosis;
    
    
   

    // Constructor
    public Medical(String p_name,String test_type,String result1,String diagnosis) {
        this.p_name = p_name;
       // this.date = date;
        this.test_type = test_type;
        this.result1 =  result1;
        this.diagnosis =diagnosis;
        
    }

    public Medical() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getPatientName() {
        return p_name;
    }

    public void setPatientName(String p_name) {
        this.p_name = p_name;
    }

   /* public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/

    public String getTestType() {
        return test_type;
    }

    public void setTestType(String test_type) {
        this.test_type = test_type;
    }

    public String getMedicalResult() {
        return result1;
    }

    public void setMedicalResult(String result1) {
        this.result1= result1;
    }
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis=diagnosis;
    }

   

   

    

    @Override
    public String toString() {
        return "Medical{" +
                "p_name='" + p_name + '\'' +
                ", test_type='" +test_type + '\'' +
                ", result1='" +result1 + '\'' +
                ", diagnosis=" +diagnosis +
               
                '}';
    }

}
