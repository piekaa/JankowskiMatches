import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.next();
        String[] quizzes = correctEquationToQuizzes(equation);
        for (String quiz : quizzes) {
            System.out.println(quiz);
        }
    }

    static void equationInImage(String equation) throws IOException {
        BufferedImage img = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        char firstNumber = equation.charAt(0);
        char firstSymbol = equation.charAt(1);
        char secondNumber = equation.charAt(2);
        char secondSymbol = equation.charAt(3);
        char thirdNumber = equation.charAt(4);
        drawBackground(img);
        drawNumber(img, firstNumber, 0);
        drawSymbol(img, firstSymbol, 100);
        drawNumber(img, secondNumber, 200);
        drawSymbol(img, secondSymbol, 300);
        drawNumber(img, thirdNumber, 400);

        File outputFile = new File("number.png");
        ImageIO.write(img, "png", outputFile);
    }

    static void drawBackground(BufferedImage img) {
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2d.dispose();
    }

    static void drawNumber(BufferedImage img, char number, int offset) {
        if (number == '0') {
            drawLine(img, offset, true, false, true, true, true, true, true);
        }
        if (number == '1') {
            drawLine(img, offset, false, false, false, false, false, true, true);
        }
        if (number == '2') {
            drawLine(img, offset, true, true, true, false, true, true, false);
        }
        if (number == '3') {
            drawLine(img, offset, true, true, true, false, false, true, true);
        }
        if (number == '4') {
            drawLine(img, offset, false, true, false, true, false, true, true);
        }
        if (number == '5') {
            drawLine(img, offset, true, true, true, true, false, false, true);
        }
        if (number == '6') {
            drawLine(img, offset, true, true, true, true, true, false, true);
        }
        if (number == '7') {
            drawLine(img, offset, true, false, false, false, false, true, true);
        }
        if (number == '8') {
            drawLine(img, offset, true, true, true, true, true, true, true);
        }
        if (number == '9') {
            drawLine(img, offset, true, true, true, true, false, true, true);
        }
    }

    static void drawSymbol(BufferedImage img, char number, int offset) {
        if (number == '-') {
            drawMinus(img, offset);
        }
        if (number == '+') {
            drawPlus(img, offset);
        }
        if (number == '=') {
            drawEqual(img, offset);
        }
    }

    static void drawLine(BufferedImage img, int offset, boolean v1, boolean v2, boolean v3, boolean h1, boolean h2, boolean h3, boolean h4) {
        Graphics2D g2d = img.createGraphics();
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

    static void drawMinus(BufferedImage img, int offset) {
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(9 + offset, 99, 82, 2);
    }

    static void drawPlus(BufferedImage img, int offset) {
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(50 + offset, 58, 2, 82);
        g2d.fillRect(9 + offset, 99, 82, 2);
    }

    static void drawEqual(BufferedImage img, int offset) {
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(9 + offset, 109, 82, 2);
        g2d.fillRect(9 + offset, 89, 82, 2);
    }

    static String[] equationResult() {
        String result[] = new String[110];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j < 10) {
                    result[index++] = String.format("%d+%d=%d", i, j, i + j);
                }
                if (i - j >= 0) {
                    result[index++] = String.format("%d-%d=%d", i, j, i - j);
                }
            }
        }
        return result;
    }

    static String[] correctEquationToQuizzes(String equation) {

        char[] equationChar = equation.toCharArray();
        String[] tempResults = new String[100];


//        char[][] canAddTo = new char[255][];
//        canAddTo['1'] = new char[]{'7'};
//        canAddTo['3'] = new char[]{'9'};
//        canAddTo['5'] = new char[]{'6', '9'};
//        canAddTo['6'] = new char[]{'8'};
//        canAddTo['9'] = new char[]{'8'};
//        canAddTo['0'] = new char[]{'8'};
//        canAddTo['-'] = new char[]{'+'};
//
//        char[][] canTakeFrom = new char[255][];
//        canTakeFrom['7'] = new char[]{'1'};
//        canTakeFrom['8'] = new char[]{'0'};
//        canTakeFrom['9'] = new char[]{'3', '5'};
//        canTakeFrom['+'] = new char[]{'-'};

        char[][] canChangePosition = new char[255][];
        canChangePosition['0'] = new char[]{'6', '9'};
        canChangePosition['1'] = new char[]{};
        canChangePosition['2'] = new char[]{'3'};
        canChangePosition['3'] = new char[]{'5', '2'};
        canChangePosition['4'] = new char[]{};
        canChangePosition['5'] = new char[]{'3'};
        canChangePosition['6'] = new char[]{'0', '9'};
        canChangePosition['7'] = new char[]{};
        canChangePosition['8'] = new char[]{};
        canChangePosition['9'] = new char[]{'0', '6'};

        int k = 0;
        for (int i = 0; i < 5; i += 2) {
            for (int j = 0; j < canChangePosition[equation.charAt(i)].length; j++) {
                char temp = equation.charAt(i);
                equationChar[i] = canChangePosition[equation.charAt(i)][j];
                tempResults[k++] = new String(equationChar);
                equationChar[i] = temp;
            }
        }
        String[] results = new String[k];
        System.arraycopy(tempResults, 0, results, 0, k);

        return results;
    }
}