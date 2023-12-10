package slitherio.gameobjects;

import javafx.beans.property.*;

public abstract class GameObject {
    private DoubleProperty x, y, width, height;
    private IntegerProperty direction;
    private double dx, dy;

    public GameObject(double x, double y, double width, double height, double dx, double dy, int direction) {
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
        this.width = new SimpleDoubleProperty(width);
        this.height = new SimpleDoubleProperty(height);
        this.direction = new SimpleIntegerProperty(direction);
        this.dx = dx;
        this.dy = dy;
    }

    public final DoubleProperty getXProperty() {
        return x;
    }

    public final DoubleProperty getYProperty() {
        return y;
    }

    public final DoubleProperty getWidthProperty() {
        return width;
    }

    public final DoubleProperty getHeightProperty() {
        return height;
    }

    public final IntegerProperty getDirectionProperty() {
        return direction;
    }

    public final int getDirection() {
        return direction.getValue();
    }

    public final void setDirection(int value) {
        direction.setValue(value);
    }

    public final double getCenterX() {
        return x.getValue();
    }

    public final void setCenterX(double value) {
        x.setValue(value);
    }

    public final double getCenterY() {
        return y.getValue();
    }

    public final void setCenterY(double value) {
        y.setValue(value);
    }

    public final double getLeft() {
        return x.getValue() - width.getValue() / 2;
    }

    public final double getRight() {
        return x.getValue() + width.getValue() / 2;
    }

    public final double getUp() {
        return y.getValue() - height.getValue() / 2;
    }

    public final double getDown() {
        return y.getValue() + height.getValue() / 2;
    }

    public final double getWidth() {
        return width.getValue();
    }

    public final void setWidth(double value) {
        width.setValue(value);
    }

    public final double getHeight() {
        return height.getValue();
    }

    public final void setHeight(double value) {
        height.setValue(value);
    }

    public final double getDx() {
        return dx;
    }

    public final void setDx(double value) {
        dx = value;
    }

    public final double getDy() {
        return dy;
    }

    public final void setDy(double value) {
        dy = value;
    }

    /*
     * l = left, r = right, u = up, d = down
     * collides when :
     * [l1 < r2] ∧ [l2 < r1] ∧ [u1 < d2] ∧ [u2 < d1]
     * <=> l1 - r2 < 0 < r1 - l2
     * ∧ u1 - d2 < 0 < d1 - u2
     */
    public final boolean collides(GameObject go) {
        double a = getLeft() - go.getRight();
        double b = getRight() - go.getLeft();
        double c = getUp() - go.getDown();
        double d = getDown() - go.getUp();
        return (a < 0) && (0 < b) && (c < 0) && (0 < d);
    }

}