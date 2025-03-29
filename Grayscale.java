package pixelcraft;


import java.awt.image.BufferedImage;

public class Grayscale extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                ARGB argb = new ARGB(pixel);
                int gray = (argb.red + argb.green + argb.blue) / 3;
                image.setRGB(x, y, new ARGB(argb.alpha, gray, gray, gray).toInt());
            }
        }
        return image;
    }
}
