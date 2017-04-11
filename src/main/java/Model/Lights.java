package Model;

/**
 *
 * @author Mark
 */
public class Lights {

    private boolean LightsAreOn;

    public Lights(boolean LightsAreOn) {
        this.LightsAreOn = LightsAreOn;
    }

    public boolean isLightsTurnedOn() {
        return LightsAreOn;
    }

    public void setLightsTurnedOn(boolean LightsAreOn) {
        this.LightsAreOn = LightsAreOn;
    }

}