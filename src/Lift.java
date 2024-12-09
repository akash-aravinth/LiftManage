import java.util.ArrayList;
import java.util.List;

public class Lift {
    private int liftNo;
    private int currentPos;
    private List<Integer> stops;
    private String direction;
    private String type;
    public Lift(){
    }
    public Lift(int liftNo, int currentPos, List<Integer> stops, String direction,String type) {
        this.liftNo = liftNo;
        this.currentPos = currentPos;
        this.stops = stops;
        this.direction = direction;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLiftNo() {
        return liftNo;
    }

    public void setLiftNo(int liftNo) {
        this.liftNo = liftNo;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public List<Integer> getStops() {
        return stops;
    }

    public void setStops(List<Integer> stops) {
        this.stops = stops;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
