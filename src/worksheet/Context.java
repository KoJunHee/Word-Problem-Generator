package worksheet;

public class Context {
    private State state;

    public Context() {
        state = null;
    }

    //상태 저장
    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
