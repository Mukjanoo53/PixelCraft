package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Rotate extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth(), height = image.getHeight();
        
        // Create a new image with swapped dimensions (rotated 90 degrees)
        BufferedImage rotated = new BufferedImage(height, width, BufferedImage.TYPE_INT_ARGB);
        
        // Iterate over each pixel and rotate by 90 degrees clockwise
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Set the pixel in the new rotated position
                rotated.setRGB(height - y - 1, x, image.getRGB(x, y));
            }
        }
        
        return rotated;
    }
}
