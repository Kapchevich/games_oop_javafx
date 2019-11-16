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
      int size = Math.abs(source.x - dest.x);
        Cell[] steps = new Cell[size];
        int x = source.getX();
        int y = source.getY();
        try {
            for (int index = 0; index < size; index++) {
                int deltaX = source.x < dest.x ? x++ : x--;
                int deltaY = source.y < dest.y ? y++ : y--;
                if (source.x == dest.x) {
                    x = source.x;
                }
                if (source.y == dest.y) {
                    y = source.y;
                }
                steps[index] = Cell.values()[x * 8 + y];
                if (source.x == x) {
                    throw new IllegalStateException();
                } else if (source.y == y) {
                    throw new IllegalStateException();
                }
            }
        } catch (IllegalStateException e) {
            System.out.println(String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {

        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
