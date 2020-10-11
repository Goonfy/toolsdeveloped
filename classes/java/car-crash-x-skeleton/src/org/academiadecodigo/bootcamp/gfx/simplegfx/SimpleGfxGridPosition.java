package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridColor;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {
    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        simpleGfxGrid = grid;

        rectangle = new Rectangle(simpleGfxGrid.columnToX(getCol()), simpleGfxGrid.rowToY(getRow()), grid.getCellSize(), grid.getCellSize());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);

        simpleGfxGrid = grid;

        rectangle = new Rectangle(simpleGfxGrid.columnToX(col), simpleGfxGrid.rowToY(row), grid.getCellSize(), grid.getCellSize());
        rectangle.draw();
    }

    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
        rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        if (distance * simpleGfxGrid.getCellSize() > simpleGfxGrid.getCols()
                || distance * simpleGfxGrid.getCellSize() > simpleGfxGrid.getRows()) {
            return;
        }

        int lastColPos = getCol();
        int lastRowPos = getRow();

        super.moveInDirection(direction, distance * simpleGfxGrid.getCellSize());

        rectangle.translate(getCol() - lastColPos, getRow() - lastRowPos);
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {
        super.setColor(color);

        Color color1;

        switch (color.toString()) {
            case "RED":
                color1 = Color.RED;
                break;
            case "GREEN":
                color1 = Color.GREEN;
                break;
            case "BLUE":
                color1 = Color.BLUE;
                break;
            case "MAGENTA":
                color1 = Color.MAGENTA;
                break;
            default:
                color1 = null;
        }

        rectangle.setColor(color1);
    }
}
