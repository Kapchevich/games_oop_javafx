package ru.job4j.chess.firuges.black;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        try {
            if (!isDiagonal(source, dest)) {
                throw new IllegalStateException(
                        String.format("Could not move by diagonal from %s to %s", source, dest));
            }
        }catch (IllegalStateException e) {
            System.out.println(e);
    }
        int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int x = source.getX();
        int y = source.getY();
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
            for (int index = 0; index < size; index++) {
                if (deltaX == 1) {
                    x++;
                } else {
                    x--;
                }
                if (deltaY == 1) {
                    y++;
                } else {
                    y--;
                }
                steps[index] = Cell.values()[x * 8 + y];
                }
        return steps;
        }


    public boolean isDiagonal(Cell source, Cell dest) {
        if (source.x == dest.x) {
            return false;
        } else if (source.y == dest.y) {
            return false;
        }
        return true;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
