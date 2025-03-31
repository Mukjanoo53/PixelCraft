package pixelcraft;

import java.awt.image.BufferedImage;

class Magnify extends Converter {
    // Adjustable zoom factor that you can modify manually
    private int zoomFactor = 2;  // Default value of 2 (you can change this manually)

    // Setter method to change zoom factor
    public void setZoomFactor(int zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        
        // Create a new image with size based on the zoom factor
        BufferedImage magnified = new BufferedImage(width * zoomFactor, height * zoomFactor, BufferedImage.TYPE_INT_ARGB);
        
        // Iterate over every pixel in the original image
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = image.getRGB(x, y);  // Get the pixel value at (x, y)
                
                // Copy the pixel to a zoomFactor x zoomFactor block in the magnified image
                for (int dx = 0; dx < zoomFactor; dx++) {
                    for (int dy = 0; dy < zoomFactor; dy++) {
                        // Ensure we are within bounds for the magnified image
                        magnified.setRGB(x * zoomFactor + dx, y * zoomFactor + dy, pixel);
                    }
                }
            }
        }
        
        return magnified;
    }
}
