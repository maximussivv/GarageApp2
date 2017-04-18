package Model;

/**
 *
 * @author Conor
 */
public class Door {

    private boolean DoorIsOpen;

    public Door(boolean DoorIsOpened) {
        if(DoorIsOpened){
            this.DoorIsOpen=false;
        }else{
            this.DoorIsOpen=true;
        }          
    }

    public boolean isDoorOpen() {
        return DoorIsOpen;
    }

    public void setDoorIsOpened(boolean DoorIsUnlocked) {
        this.DoorIsOpen = DoorIsUnlocked;
    }
    

}
