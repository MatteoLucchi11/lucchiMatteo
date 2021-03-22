package it.unibo.wenv;
import it.unibo.annotations.ArilRobotSpec;
import it.unibo.consolegui.ConsoleGui;
import it.unibo.interaction.IssOperations;
import it.unibo.supports.IssCommSupport;
import it.unibo.supports.RobotApplicationStarter;
import it.unibo.consolegui.ConsoleGui;

@ArilRobotSpec
public class RobotBoundaryWebsockGUI {
    private RobotInputController controller;
    //private ActorRobotObserver actorObs = new ActorRobotObserver();
    //Constructor
    public RobotBoundaryWebsockGUI(IssOperations rs){
        IssCommSupport rsComm = (IssCommSupport)rs;
        new ConsoleGui(new RobotInputController(rsComm, true, true));
        controller = new RobotInputController(rsComm, true, true );
        rsComm.registerObserver( controller );
        new ConsoleGui(controller);
        controller.doBoundary();
        //rsComm.registerObserver( actorObs );
        //System.out.println("ClientBoundaryWebsockBasicAsynch | CREATED with rsComm=" + rsComm);
    }

    public String doBoundary(){
        System.out.println("ClientBoundaryWebsockBasicAsynch | doBoundary " + controller  );
        String result = controller.doBoundary();
        //actorObs.close();
        return result;
    }

    public static void main(String args[]){
        try {
            System.out.println("RobotBoundaryWebsockGUI | main start n_Threads=" + Thread.activeCount());
            Object appl = RobotApplicationStarter.createInstance(RobotBoundaryWebsockGUI.class);
            //System.out.println("ClientBoundaryWebsockBasicSynch  | appl n_Threads=" + Thread.activeCount());
            //String trip = ((ClientBoundaryWebsockArilAsynch)appl).doBoundary();
            //System.out.println("ClientBoundaryWebsockBasicAsynch | trip="   );
            //System.out.println( trip  );
            //System.out.println("ClientBoundaryWebsockBasicAsynch | main end n_Threads=" + Thread.activeCount());
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }
}
