package quizImage;

import java.awt.*;
import java.awt.image.BufferedImage;

class Image {

    private BufferedImage image;

    BufferedImage drawEquation(String equation) {
        image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        char firstNumber = equation.charAt(0);
        char firstSymbol = equation.charAt(1);
        char secondNumber = equation.charAt(2);
        char secondSymbol = equation.charAt(3);
        char thirdNumber = equation.charAt(4);
        drawBackground();
        drawNumber(firstNumber, 0);
        drawSymbol(firstSymbol, 100);
        drawNumber(secondNumber, 200);
        drawSymbol(secondSymbol, 300);
        drawNumber(thirdNumber, 400);
        return image;
    }


    private void drawBackground() {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
        g2d.dispose();
    }

    private void drawNumber(char number, int offset) {
        if (number == '0') {
            drawLine(offset, true, false, true, true, true, true, true);
        }
        if (number == '1') {
            drawLine(offset, false, false, false, false, false, true, true);
        }
        if (number == '2') {
            drawLine(offset, true, true, true, false, true, true, false);
        }
        if (number == '3') {
            drawLine(offset, true, true, true, false, false, true, true);
        }
        if (number == '4') {
            drawLine(offset, false, true, false, true, false, true, true);
        }
        if (number == '5') {
            drawLine(offset, true, true, true, true, false, false, true);
        }
        if (number == '6') {
            drawLine(offset, true, true, true, true, true, false, true);
        }
        if (number == '7') {
            drawLine(offset, true, false, false, false, false, true, true);
        }
        if (number == '8') {
            drawLine(offset, true, true, true, true, true, true, true);
        }
        if (number == '9') {
            drawLine(offset, true, true, true, true, false, true, true);
        }
    }

    private void drawSymbol(char number, int offset) {
        if (number == '+') {
            drawPlus(offset);
        }
        if (number == '-') {
            drawMinus(offset);
        }
        if (number == '=') {
            drawEqual(offset);
        }
    }

    private void drawLine(int offset, boolean v1, boolean v2, boolean v3, boolean h1, boolean h2, boolean h3, boolean h4) {
        Graphics2D g2d = image.createGraphics();
        if (v1) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9 + offset, 19, 82, 2);
        }
        if (v2) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9 + offset, 99, 82, 2);
        }
        if (v3) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9 + offset, 179, 82, 2);
        }
        if (h1) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9 + offset, 19, 2, 82);
        }
        if (h2) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(9 + offset, 99, 2, 82);
        }
        if (h3) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(89 + offset, 19, 2, 82);
        }
        if (h4) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(89 + offset, 99, 2, 82);
        }
    }

    private void drawPlus(int offset) {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(50 + offset, 58, 2, 82);
        g2d.fillRect(9 + offset, 99, 82, 2);
    }

    private void drawMinus(int offset) {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(9 + offset, 99, 82, 2);
    }

    private void drawEqual(int offset) {
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(9 + offset, 109, 82, 2);
        g2d.fillRect(9 + offset, 89, 82, 2);
    }

}