package pixelcraft;

import java.awt.image.BufferedImage;

class Blur extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        BufferedImage blurred = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        
        // Set the size of the blur kernel (neighborhood)
        int kernelSize = 8; // Change this value to control the blur intensity
        int radius = kernelSize / 2;
        
        // Process the image using divide and conquer approach
        processRegion(image, blurred, 0, 0, image.getWidth(), image.getHeight(), radius);
        
        return blurred;
    }
    
    private void processRegion(BufferedImage original, BufferedImage blurred, 
                              int startX, int startY, int endX, int endY, int radius) {
        // Base case: if region is a single pixel or very small region, process directly
        if ((endX - startX) * (endY - startY) <= 4) {
            for (int y = startY; y < endY; y++) {
                for (int x = startX; x < endX; x++) {
                    blurred.setRGB(x, y, calculateAverageColor(original, x, y, radius));
                }
            }
            return;
        }
        
        // Divide the region into four quadrants
        int midX = (startX + endX) / 2;
        int midY = (startY + endY) / 2;
        
        // Recursively process each quadrant
        processRegion(original, blurred, startX, startY, midX, midY, radius);       // Top-left
        processRegion(original, blurred, midX, startY, endX, midY, radius);         // Top-right
        processRegion(original, blurred, startX, midY, midX, endY, radius);         // Bottom-left
        processRegion(original, blurred, midX, midY, endX, endY, radius);           // Bottom-right
    }
    
    private int calculateAverageColor(BufferedImage original, int centerX, int centerY, int radius) {
        int sumRed = 0, sumGreen = 0, sumBlue = 0, count = 0;
        
        // Calculate the sum of the colors in the neighborhood
        for (int offsetY = -radius; offsetY <= radius; offsetY++) {
            for (int offsetX = -radius; offsetX <= radius; offsetX++) {
                int newX = centerX + offsetX;
                int newY = centerY + offsetY;
                
                // Check if the neighbor pixel is within bounds
                if (newX >= 0 && newX < original.getWidth() && newY >= 0 && newY < original.getHeight()) {
                    ARGB argb = new ARGB(original.getRGB(newX, newY));
                    sumRed += argb.red;
                    sumGreen += argb.green;
                    sumBlue += argb.blue;
                    count++;
                }
            }
        }
        
        // Return the average color
        if (count == 0) return new ARGB(255, 0, 0, 0).toInt();
        return new ARGB(255, sumRed / count, sumGreen / count, sumBlue / count).toInt();
    }
}