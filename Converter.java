package pixelcraft;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
abstract class Converter {
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(inputFileName));
        BufferedImage processedImage = processImage(originalImage);
        ImageIO.write(processedImage, "PNG", new File(outputFileName));
    }
    protected abstract BufferedImage processImage(BufferedImage image);
	protected BufferedImage applyEffect(BufferedImage image) {
		// TODO Auto-generated method stub
		return null;
	}
}