package Model;

/**
 *
 * @author Mark
 */
public class Fan {

    private boolean FanIsON;

    public Fan(boolean FanIsON) {
        this.FanIsON = FanIsON;
    }

    public boolean isFanRunning() {
        return FanIsON;
    }

    public void setFanIsON(boolean FanIsON) {
        this.FanIsON = FanIsON;
    }

}
