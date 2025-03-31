package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Brightness extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        // Iterate through each pixel of the image
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Extract the ARGB values from the pixel
                ARGB argb = new ARGB(image.getRGB(x, y));
                
                // Increase brightness by multiplying color values (capped at 255)
                argb.red = Math.min(255, (int)(argb.red * 1.2));
                argb.green = Math.min(255, (int)(argb.green * 1.2));
                argb.blue = Math.min(255, (int)(argb.blue * 1.2));
                
                // Set the adjusted pixel back into the image
                image.setRGB(x, y, argb.toInt());
            }
        }
        return image;
    }
}
