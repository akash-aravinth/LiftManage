import java.util.ArrayList;
import java.util.List;

public class RequestThread implements Runnable{
    private int source;
    private int destination;
    private Database database;
    public RequestThread(int source, int destination, Database database){
        this.source = source;
        this.destination = destination;
        this.database = database;
    }
    @Override
    public void run() {
        List<Lift> lifts = new ArrayList<>();
        for (Lift l : database.getLifts()){
            if (l.getStops().contains(source) && l.getStops().contains(destination)){
                if (l.getDirection().equals("up")){
                    if (source < destination && source >= l.getCurrentPos()){
                        lifts.add(l);
                    }
                }else if (l.getDirection().equals("down")){
                    if (source > destination && source <= l.getCurrentPos()){
                        lifts.add(l);
                    }
                }else{
                    lifts.add(l);
                }
            }
        }
        Lift lift = null;
        int steps = Integer.MAX_VALUE;
        for (Lift l : lifts){
            if (l.getType().equals("all")){
                int dis = (Math.abs(l.getCurrentPos()-source));
                if (dis <= steps){
                    steps = dis;
                    lift = l;
                }
            }else{
                int dis = (Math.abs(l.getCurrentPos()-source))%2;
                if (dis <= steps){
                    steps = dis;
                    lift = l;
                }
            }
        }
        System.out.println("Lift : "+lift.getLiftNo()+" Has Been Chosed");
        bookLift(lift,destination);
    }

    private void bookLift(Lift lift, int destination) {
            if (lift.getType().equals("all")){
                if (lift.getCurrentPos() <= destination){
                    while (lift.getCurrentPos() < destination){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lift.setCurrentPos(lift.getCurrentPos()+1);
                        lift.setDirection("up");
                    }
                }else{
                    while (lift.getCurrentPos() > destination){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        lift.setCurrentPos(lift.getCurrentPos()-1);
                        lift.setDirection("down");
                    }
                }
            }else{
                if (lift.getCurrentPos() <= destination){
                    while (lift.getCurrentPos() < destination){
                        try{
                            Thread.sleep(5000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        lift.setDirection("up");
                        lift.setCurrentPos(lift.getCurrentPos()+2);
                    }
                }else{
                    while (lift.getCurrentPos() > destination){
                        try{
                            Thread.sleep(5000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        lift.setDirection("down");
                        lift.setCurrentPos(lift.getCurrentPos()-2);
                    }
                }
            }
        lift.setDirection("stop");
    }
}
