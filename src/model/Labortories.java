package model;



public class Labortories {
	private String facilities;
    private int cost;
   

    // Constructor
    public Labortories (String facilities, int cost) {
        this.facilities = facilities;
        this.cost = cost;
        
    }

    public Labortories() {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public String getLabName() {
        return facilities;
    }

    public void setlabName(String facilities) {
        this.facilities = facilities;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    
    @Override
    public String toString() {
        return "Labortories{" +
                "facilities='" + facilities + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

}
