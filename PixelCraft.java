package pixelcraft;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class PixelCraft {
    /**
     * Append converter name to the input filename, before the file extension.
     * For example, if the input filename is "image.png" and the converter name is "GrayScale",
     * the output filename will be "image_GrayScale.png".
     */
    static String getOutputFilename(String inputFileName, String converterName) {
        int dotIndex = inputFileName.lastIndexOf(".");
        return inputFileName.substring(0, dotIndex) + "_" + converterName + inputFileName.substring(dotIndex);
    }

    public static void main(String[] args) {
        // Ensure that a converter name and a filename have been provided
        if (args.length < 2) {
            System.out.println("Usage: java -cp \"path/to/classes\" PixelCraft <ConverterName/Grayscale/Warmer/etc> <image_file.png>");
            System.exit(1);
        }

        String converterName = args[0];
        String inputFileName = args[1];

        // Prepend 'pixelcraft.' to the converter name to reference the correct class
        String fullClassName = "pixelcraft." + converterName;

        String outputFileName = getOutputFilename(inputFileName, converterName);

        try {
            // Create an object of the class named 'converterName'
            // Use the full class name (including the package name)
            Class<?> clazz = Class.forName(fullClassName);
            Converter converter = (Converter) clazz.getDeclaredConstructor().newInstance();
            
            // Call the convert method to process the image
            converter.convert(inputFileName, outputFileName);
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace(); // Uncomment this line for debugging. Comment for production.
        }
    }
}
