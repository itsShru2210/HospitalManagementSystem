package model;

//import java.util.Date;

public class Medicine {
	private String med_name;
    //private Date exp_date;
    private String company;
    
    private int med_cost;
   

    // Constructor
    public Medicine(String med_name,String company,int med_cost) {
        this.med_name = med_name;
       // this.exp_date = exp_date;
        this.company = company;
        this. med_cost =  med_cost;
        
    }

    public Medicine() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getMedicineName() {
        return med_name;
    }

    public void setMedicineName(String med_name) {
        this.med_name = med_name;
    }

   /* public Date getexpireDate() {
        return exp_date;
    }

    public void setexpireDate(Date exp_date) {
        this.exp_date = exp_date;
    }*/

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getMedicineCost() {
        return med_cost;
    }

    public void setMedicineCost(int med_cost) {
        this.med_cost = med_cost;
    }

   

   

    

    @Override
    public String toString() {
        return "Medicine{" +
                "med_name='" + med_name + '\'' +
                ", company='" + company + '\'' +
                ", med_cost=" + med_cost +
               
                '}';
    }

}
