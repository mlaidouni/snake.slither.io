package slitherio.Utils;

import javafx.scene.image.Image;

public final class Utils {

    // Create and return an Image object of [file] image
    public final static Image getImage(String file) {
        Image img = new Image("file:src/main/resources/" + file);
        return !img.isError() ? img : null;
    }

    public final static double getAngle(double angle) {
        double newAngle = angle;
        while (newAngle < 0)
            newAngle += 360;

        while (newAngle > 360)
            newAngle /= 360;

        return newAngle;
    }
}