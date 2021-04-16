package eu.flrkv.civassign.CivUtils;

public class Civilization{
    private String empire;
    private String leader;

    public Civilization(String empire, String leader){
        this.empire = empire;
        this.leader = leader;
    }

    //GETTER & SETTER
    public String getEmpire(){
        return this.empire;
    }

    public String getLeader(){
        return this.leader;
    }
}