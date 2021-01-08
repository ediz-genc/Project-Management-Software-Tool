package Projects;

import java.util.ArrayList;

public class Budget {

    private int totalWorkHours;
    private int memberCostPerHour;
    private int amountOfMembers;
    private int velocity;
    private int extraCost;
    ArrayList<Budget> budgetCost = new ArrayList<>();

    public Budget (int totalWorkHours, int memberCostPerHour, int amountOfMembers, int velocity, int extraCost){
        this.totalWorkHours = totalWorkHours;
        this.memberCostPerHour = memberCostPerHour;
        this.amountOfMembers = amountOfMembers;
        this.velocity = velocity;
        this.extraCost = extraCost;
    }
    public Budget (){
    }

    public int getTotalWorkHours() { return totalWorkHours; }
    public void setTotalWorkHours(int totalWorkHours) { this.totalWorkHours = totalWorkHours; }
    public int getMemberCostPerHour() { return memberCostPerHour; }
    public void setMemberCostPerHour(int memberCostPerHour) { this.memberCostPerHour = memberCostPerHour; }
    public int getAmountOfMembers() { return amountOfMembers; }
    public void setAmountOfMembers(int amountOfMembers) { this.amountOfMembers = amountOfMembers; }
    public int getVelocity() { return velocity; }
    public void setVelocity(int velocity) { this.velocity = velocity; }
    public int getExtraCost() { return extraCost; }
    public void setExtraCost(int extraCost) { this.extraCost = extraCost; }
    public ArrayList<Budget> getBudgetCost() { return budgetCost; }
    public void setBudgetCost(ArrayList<Budget> budgetCost) { this.budgetCost = budgetCost; }
}
