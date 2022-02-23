package Cells;

import java.util.Random;

public class Excitable extends Cell {
    public Excitable(int size, int x, int y) {
        super(size, x, y);

        states = new int[][] {
                {255, 91, 2},
                {255, 76, 105},
                {255, 99, 179},
                {236, 137, 236},
                {183, 170, 255},
                {136, 194, 255},
                {125, 211, 255},
                {70, 75, 50}
        };

        Random random = new Random();
        state = random.nextFloat() > .995 ? 0 : 7;
    }

    public Excitable copyRandom(float probability) {
        Excitable excitable = new Excitable(this.size, this.x, this.y);
        Random random = new Random();
        excitable.state = random.nextFloat() < probability ? 0 : 7;
        return excitable;
    }

    public Excitable copy(int state) {
        Excitable excitable = new Excitable(this.size, this.x, this.y);
        excitable.state = state;
        return excitable;
    }

    public Cell evaluate(Cell[][] set) {
        if (state == 7) {
            int count = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    count += ((Excitable) set[i][j]).excited();
                }
            }

            if (count == 1) {
                return copyRandom(.6f);
            } else if (count > 1) {
                return copyRandom(.8f);
            } else {
                return this;
            }
        } else {
            return copy(state + 1);
        }
    }

    public int excited() {
        return state == 0 ? 1 : 0;
    }
}
