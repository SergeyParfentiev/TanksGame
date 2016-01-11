package Model_View_Controller.task4;

/**
 * Created by Byblik272 on 10/1/2016.
 */
public enum BirdsName {
    DUCK(0), EAGLE(1), GANDER(2), SWAN(3), GOOSE(4);

    private int idx;

    BirdsName(int idx) {
        this.idx = idx;
    }
    public int getIdx() {
        return idx;
    }
}
