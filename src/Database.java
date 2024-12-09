import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Lift> lifts = new ArrayList<>();

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }
    public void printLift(){
        for (Lift l : lifts){
            System.out.println("Lift No : "+l.getLiftNo()+" Lift Current Pos : "+l.getCurrentPos()+"  Lift Status : "+l.getDirection());
        }
    }
    public void addLifts(){
        List<Integer> all = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0;i<14;i++){
            all.add(i);
            if (i%2==0){
                evens.add(i);
            }else{
                odds.add(i);
            }
        }
        lifts.add(new Lift(1,0,new ArrayList<>(all),"stop","all"));
        lifts.add(new Lift(2,0,new ArrayList<>(all),"stop","all"));
        lifts.add(new Lift(3,-1,new ArrayList<>(odds),"stop","odd"));
        lifts.add(new Lift(4,0,new ArrayList<>(evens),"stop","even"));
    }
}
