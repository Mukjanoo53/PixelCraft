package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
class Rotate extends Converter {
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth(), height = image.getHeight();
        BufferedImage rotated = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                rotated.setRGB(height - y - 1, x, image.getRGB(x, y));
            }
        }
        return rotated;
    }
}