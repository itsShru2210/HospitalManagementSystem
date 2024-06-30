package model;

public class Patient {
	private int p_id;
    private String p_name;
    private String p_gender;
    private String p_disease;
    private int p_age;
    private int room_no;
    private String amit_status;

    // Constructor
    public Patient(int p_id,String p_name,String p_gender,String p_disease, int p_age,int room_no,String amit_status) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_gender = p_gender;
        this.p_disease = p_disease;
        this.p_age = p_age;
        this.room_no = room_no;
        this.amit_status = amit_status;
    }

    public Patient() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getPatientID() {
        return p_id;
    }

    public void setPatientID(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return p_name;
    }

    public void setName(String p_name) {
        this.p_name = p_name;
    }

    public String getGender() {
        return p_gender;
    }

    public void setGender(String p_gender) {
        this.p_gender = p_gender;
    }
    public String getDisease() {
        return p_disease;
    }

    public void setDisease(String p_disease) {
        this.p_disease =p_disease;
    }
    public int getage() {
        return p_age;
    }

    public void setage(int p_age) {
        this.p_age = p_age;
    }
    
    public int getroomno() {
        return room_no;
    }

    public void setroomno(int room_no) {
        this.room_no= room_no;
    }

    public String getadmitstatus() {
        return amit_status;
    }

    public void setadmitstatus(String amit_status) {
        this.amit_status = amit_status;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_gender='" +  p_gender + '\'' +
                ", p_disease='" +  p_disease + '\'' +
                ", p_age='" +p_age + '\'' +
                ",room_no='" + room_no + '\'' +
                ", amit_status='" + amit_status + '\'' +
                '}';
    }

	

}
