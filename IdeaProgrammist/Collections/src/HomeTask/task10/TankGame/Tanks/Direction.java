package HomeTask.task10.TankGame.Tanks;

/**
 * Created by Byblik272 on 18/11/2015.
 */
public enum Direction {

    NONE(0), UP(1), DOWN(2), LEFT(3), RIGHT(4);

    private int id;

    private Direction(int id) {
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
