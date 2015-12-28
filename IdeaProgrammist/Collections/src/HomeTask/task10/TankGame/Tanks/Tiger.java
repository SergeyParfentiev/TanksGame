package HomeTask.task10.TankGame.Tanks;


import HomeTask.task10.TankGame.ObjectsOnField.BattleField;

import java.awt.*;

/**
 * Created by Byblik272 on 18/11/2015.
 */

public class Tiger extends AbstractTank {

    private int armor;

    public Tiger(BattleField bf) {
        super(bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
    }

    public Tiger(BattleField bf, int x, int y, Direction direction) {
        super(bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        armor = 1;
    }

    @Override
    public void destroy() {
        if (armor > 0) {
            armor--;
        } else {
            super.destroy();
        }
    }

    @Override
    public Action setUp() {
        return Action.FIRE;
    }

}
