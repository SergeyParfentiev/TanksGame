package HomeTask.task10.TankGame.Tanks;

import HomeTask.task10.TankGame.ObjectsOnField.BattleField;

import java.awt.*;

public class BT7 extends AbstractTank {
	
	public BT7(BattleField bf) {
		super(bf);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
//		movePath = 2;
	}
	
	public BT7(BattleField bf, int x, int y, Direction direction) {
		super(bf, x, y, direction);
		tankColor = new Color(255, 0, 0);
		towerColor = new Color(0, 255, 0);
//		movePath = 2;
	}
    private Object[] actions = new Object[] {
            Direction.LEFT,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Action.FIRE,
            Action.MOVE,
            Action.MOVE,
            Direction.DOWN,
            Action.FIRE,
            Action.FIRE,
            Action.FIRE
    };
    private int idx = 0;

	
	@Override
	public Action setUp() {
        if (!(actions[idx] instanceof Action)) {
            turn((Direction) actions[idx++]);
        }
		return (Action) actions[idx++];
    }
}
