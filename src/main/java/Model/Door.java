package Model;

/**
 *
 * @author Mark
 */
public class Door {

    private boolean DoorIsOpen;

    public Door(boolean DoorIsOpened) {
        this.DoorIsOpen = DoorIsOpened;
    }

    public boolean isDoorOpen() {
        return DoorIsOpen;
    }

    public void setDoorIsOpened(boolean DoorIsUnlocked) {
        this.DoorIsOpen = DoorIsUnlocked;
    }

}
