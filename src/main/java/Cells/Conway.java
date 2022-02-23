package Cells;

import java.util.Random;

public class Conway extends Cell {
    public Conway(int size, int x, int y) {
        super(size, x, y);

        states = new int[][] {
                {0, 0, 0},
                {255, 255, 255}
        };

        Random random = new Random();
        state = random.nextFloat() > .2 ? 1 : 0;
    }

    public Conway copy(int state) {
        Conway conway = new Conway(this.size, this.x, this.y);
        conway.state = state;
        return conway;
    }

    public Cell evaluate(Cell[][] set) {
        int count = set[0][1].state + set[1][0].state + set[1][2].state + set[2][1].state;

        if (state == 1) {
            if (count < 2) {
                return copy(0);
            } else if (count < 4) {
                return copy(1);
            } else {
                return copy(0);
            }
        } else if (count == 3) {
            return copy(1);
        }

        return copy(0);
    }
}
