import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static void drawLine(BufferedImage img, boolean w1, boolean w2, boolean w3, boolean h1, boolean h2, boolean h3, boolean h4) {
        Graphics2D g2d = img.createGraphics();
        if( w1 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9, 19, 82, 2);
        }
        if( w2 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9, 99, 82, 2);
        }
        if( w3 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9, 179, 82, 2);
        }
        if( h1 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9, 19, 2, 82);
        }
        if( h2 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9, 99, 2, 82);
        }
        if( h3 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(89, 19, 2, 82);
        }
        if( h4 ) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(89, 99, 2, 82);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = new BufferedImage(100, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2d.dispose();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number == 0){
            drawLine(img, true, false, true, true, true, true, true);
        }
        if (number == 1){
            drawLine(img, false, false, false, false, false, true, true);
        }
        if (number == 2){
            drawLine(img, true, true, true, false, true, true, false);
        }
        if (number == 3){
            drawLine(img, true, true, true, false, false, true, true);
        }
        if (number == 4){
            drawLine(img, false, true, false, true, false, true, true);
        }
        if (number == 5){
            drawLine(img, true, true, true, true, false, false, true);
        }
        if (number == 6){
            drawLine(img, true, true, true, true, true, false, true);
        }
        if (number == 7){
            drawLine(img, true, false, false, false, false, true, true);
        }
        if (number == 8){
            drawLine(img, true, true, true, true, true, true, true);
        }
        if (number == 9){
            drawLine(img, true, true, true, true, false, true, true);
        }
        File outputFile = new File("C:/Users/jmate/Pictures/cyfra.png");
        ImageIO.write(img, "png", outputFile);
    }
}