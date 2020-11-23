import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.next();
        Image image = new Image();
        image.drawEquation(equation);
        image.saveToPng("matches.png");
        EquationGenerator equationGenerator = new EquationGenerator();
        String[] quizzes = equationGenerator.allPossibleMatchMoves(equation);
        for (String quiz : quizzes) {
            System.out.println(quiz);
        }
    }

}