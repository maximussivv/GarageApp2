package Model;

/**
 *
 * @author Mark
 */
public class Window {

    private boolean WndowIsOpen;
    private boolean WindowIsOpen;

    public Window(boolean WindowIsOpen) {
        this.WindowIsOpen = WindowIsOpen;
    }

    public boolean isWindowUnlocked() {
        return WndowIsOpen;
    }

    public void setWindowIsUnlocked(boolean WndowIsOpen) {
        this.WindowIsOpen = this.WndowIsOpen;
    }

}
