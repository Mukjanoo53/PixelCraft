package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
class Pixelation extends Converter {
    protected BufferedImage processImage(BufferedImage image) {
        int blockSize = 10;
        for (int x = 0; x < image.getWidth(); x += blockSize) {
            for (int y = 0; y < image.getHeight(); y += blockSize) {
                int pixel = image.getRGB(x, y);
                for (int i = 0; i < blockSize && x + i < image.getWidth(); i++) {
                    for (int j = 0; j < blockSize && y + j < image.getHeight(); j++) {
                        image.setRGB(x + i, y + j, pixel);
                    }
                }
            }
        }
        return image;
    }
}