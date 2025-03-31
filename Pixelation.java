package pixelcraft;

import java.awt.image.BufferedImage;

class Pixelation extends Converter {
    @Override
    protected BufferedImage processImage(BufferedImage image) {
        int blockSize = 10; // Defines the size of each pixelated block
        // Start recursion from the top-left corner
        applyPixelation(image, 0, 0, blockSize);
        return image;
    }

    private void applyPixelation(BufferedImage image, int x, int y, int blockSize) {
        // Base case: If we've reached the end of the image, return
        if (x >= image.getWidth() || y >= image.getHeight()) {
            return;
        }

        // Get the color of the top-left pixel in the current block
        int pixel = image.getRGB(x, y);

        // Fill the block with the same pixel color
        for (int i = 0; i < blockSize && x + i < image.getWidth(); i++) {
            for (int j = 0; j < blockSize && y + j < image.getHeight(); j++) {
                image.setRGB(x + i, y + j, pixel);
            }
        }

        // Recursively call for the next block, moving horizontally
        if (x + blockSize < image.getWidth()) {
            applyPixelation(image, x + blockSize, y, blockSize);
        }
        // If we've finished the current row, move to the next row and start from the left
        else if (y + blockSize < image.getHeight()) {
            applyPixelation(image, 0, y + blockSize, blockSize);
        }
    }
}
