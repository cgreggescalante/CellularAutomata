import Cells.Cell;
import Cells.Elementary;
import Cells.Excitable;
import processing.core.PApplet;

public class Grid {
    Cell[][] grid;

    int width, height;

    public Grid(int width, int height, int size) {
        this.width = width;
        this.height = height;

        grid = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Excitable(size, j * size, i * size);
            }
        }
    }

    public void update() {
        Cell[][] new_grid = new Cell[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell[][] set = new Cell[3][3];

                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        set[x+1][y+1] = grid[Math.floorMod(i + x, height)][Math.floorMod(j + y, width)];
                    }
                }

                new_grid[i][j] = grid[i][j].evaluate(set);
            }
        }

        grid = new_grid;
    }

    public void show(PApplet sketch) {
        sketch.noStroke();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j].show(sketch);
            }
        }
    }
}
