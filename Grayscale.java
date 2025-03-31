package pixelcraft;

import java.awt.image.BufferedImage;

public class Grayscale extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        // Iterate through each pixel of the image
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the pixel's ARGB values
                int pixel = image.getRGB(x, y);
                ARGB argb = new ARGB(pixel);
                
                // Compute the grayscale value using the average method
                int gray = (argb.red + argb.green + argb.blue) / 3;
                
                // Set the new grayscale pixel with the same alpha value
                image.setRGB(x, y, new ARGB(argb.alpha, gray, gray, gray).toInt());
            }
        }
        return image;
    }
}