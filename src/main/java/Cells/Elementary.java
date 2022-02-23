package Cells;

import java.util.Arrays;

public class Elementary extends Cell {
    int[][] cases = new int[][] {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1},
            {1, 0, 0},
            {0, 1, 1},
            {0, 1, 0},
            {0, 0, 1},
            {0, 0, 0}
    };

    int[] rule;

    public Elementary(int size, int x, int y, int rule) {
        super(size, x, y);

        states = new int[][] {
                {0, 0, 0},
                {255, 255, 255}
        };

        this.rule = new int[8];

        for (int i = 0; i < 8; i++) {
            if (rule % 2 == 0) {
                rule /= 2;
                this.rule[8 - i - 1] = 0;
            } else {
                rule -= 1;
                rule /= 2;
                this.rule[8 - i - 1] = 1;
            }
        }
    }

    public Elementary(int size, int x, int y) {
        super(size, x, y);

        states = new int[][] {
                {0, 0, 0},
                {255, 255, 255}
        };

        int ruleNo = 210;
        this.rule = new int[8];

        for (int i = 0; i < 8; i++) {
            if (ruleNo % 2 == 0) {
                ruleNo /= 2;
                this.rule[8 - i - 1] = 0;
            } else {
                ruleNo -= 1;
                ruleNo /= 2;
                this.rule[8 - i - 1] = 1;
            }
        }
    }

    @Override
    public Cell evaluate(Cell[][] set) {
        if (y > 0) {
            int[] row = new int[]{set[0][0].state, set[0][1].state, set[0][2].state};

            for (int i = 0; i < 8; i++) {
                if (Arrays.equals(cases[i], row)) {
                    state = rule[i];
                    break;
                }
            }
        }

        return this;
    }
}
