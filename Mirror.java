package pixelcraft;

import java.awt.image.BufferedImage;

public class Mirror extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage mirroredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                mirroredImage.setRGB(width - x - 1, y, pixel); // Mirror horizontally
            }
        }
        return mirroredImage;
    }
}
