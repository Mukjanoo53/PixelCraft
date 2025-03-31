package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Invert extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        // Iterate through each pixel of the image
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                // Extract ARGB values from the pixel
                ARGB argb = new ARGB(image.getRGB(x, y));
                
                // Invert the RGB color values
                argb.red = 255 - argb.red;
                argb.green = 255 - argb.green;
                argb.blue = 255 - argb.blue;
                
                // Set the inverted color back into the image
                image.setRGB(x, y, argb.toInt());
            }
        }
        return image;
    }
}
