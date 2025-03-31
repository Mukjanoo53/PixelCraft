package pixelcraft;

import java.awt.image.BufferedImage;

public class Mirror extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        // Create a new image to store the mirrored result
        BufferedImage mirroredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Iterate through each pixel row-wise
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                
                // Mirror horizontally by placing the pixel at the reflected x position
                mirroredImage.setRGB(width - x - 1, y, pixel);
            }
        }
        
        return mirroredImage;
    }
}
