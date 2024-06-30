package model;


//bill_id, p_name,payment_mode, ammount, med_cost,total_ammount,payment_status
public class Bill {
	private int bill_id;
    private String p_name;
    private String payment_mode;
    private int ammount;
    private int med_cost;
    private int total_ammount;
    private String payment_status;

    // Constructor
    public Bill(int bill_id,String p_name,String payment_mode,int ammount,int med_cost,int total_ammount,String payment_status) {
        this.bill_id =bill_id;
        this.p_name = p_name;
        this.payment_mode = payment_mode;
        this.ammount = ammount;
        this. med_cost =  med_cost;
        this. total_ammount = total_ammount;
        this. payment_status=  payment_status;
    }

    public Bill() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getBillID() {
        return bill_id;
    }

    public void setBillID(int bill_id) {
        this.bill_id = bill_id;
    }

    public String getName() {
        return p_name;
    }

    public void setName(String p_name) {
        this.p_name = p_name;
    }

    public String getPMode() {
        return payment_mode;
    }

    public void setPMode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }
    public int getMedCost() {
        return med_cost;
    }

    public void setMedCost(int med_cost) {
        this.med_cost =med_cost;
    }
    public int getTotalAmmount() {
        return total_ammount;
    }

    public void setTotalAmmount(int total_ammount) {
        this.total_ammount =total_ammount;
    }
    public String getPayStatus() {
        return payment_status;
    }

    public void setPayStatus(String payment_status) {
        this.payment_status =payment_status;
    }
   

    @Override
    public String toString() {
        return "Bill{" +
                "bill_id='" + bill_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", payment_mode='" + payment_mode + '\'' +
                ", ammount='" + ammount+ '\'' +
                 ",  med_cost='" +  med_cost+ '\'' +
                  ", total_ammount='" +total_ammount+ '\'' +
                ", payment_status=" + payment_status +
                '}';
    }

}
