package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
class Invert extends Converter {
    protected BufferedImage processImage(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                ARGB argb = new ARGB(image.getRGB(x, y));
                argb.red = 255 - argb.red;
                argb.green = 255 - argb.green;
                argb.blue = 255 - argb.blue;
                image.setRGB(x, y, argb.toInt());
            }
        }
        return image;
    }
}