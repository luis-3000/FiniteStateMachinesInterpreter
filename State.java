

public class State {
    boolean isAccepting;
    boolean isTrap;
    boolean isStart;
    int stateName;
    int [] transTo;

    State(int name, boolean[] types, int[] trans) {
        isAccepting = types[0];
        isTrap = types[1];
        isStart = types[2];
        stateName = name;
        //transition to initialized to same int length of original transition
        transTo = new int[trans.length];
        /*public static void arraycopy(Object source, int sourcePosition, Object destination, int destinationPosition, int numberOfElements)*/
	    System.arraycopy(trans, 0, transTo, 0, trans.length);       
    }
}
