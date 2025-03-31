package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

// Abstract class that serves as a base for image processing converters
abstract class Converter {
    
    // Reads an image file, processes it, and writes the output to a new file
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(inputFileName)); // Load the image from file
        BufferedImage processedImage = processImage(originalImage); // Apply the specific processing effect
        ImageIO.write(processedImage, "PNG", new File(outputFileName)); // Save the processed image as PNG
    }
    
    // Abstract method that must be implemented by subclasses to process the image
    protected abstract BufferedImage processImage(BufferedImage image);
    
    // Placeholder method for additional effects, can be overridden in subclasses
    protected BufferedImage applyEffect(BufferedImage image) {
        // TODO: Implement optional effects in subclasses
        return null;
    }
}