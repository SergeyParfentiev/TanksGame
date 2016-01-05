package HomeTask.task7.TankGame.Tanks;

/**
 * Created by Byblik272 on 18/11/2015.
 */
public enum Direction {

    UP(0), DOWN(1), LEFT(2), RIGHT(3), NONE(4);

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
