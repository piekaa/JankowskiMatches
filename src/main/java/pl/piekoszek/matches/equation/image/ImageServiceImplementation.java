package pl.piekoszek.matches.equation.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class ImageServiceImplementation implements ImageService{

    @Override
    public byte[] drawEquation(String equation) {
        BufferedImage bufferedImage = new Image().drawEquation(equation);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
