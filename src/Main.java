import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String equation = scanner.next();
//        Image image = new Image();
//        image.drawEquation(equation);
//        image.saveToPng("matches.png");
//        String[] quizzes = equationGenerator.allPossibleMatchMoves(equation);
//        for (String quiz : quizzes) {
//            System.out.println(quiz);
//        }
        EquationGenerator equationGenerator = new EquationGenerator();
        Map<String, Set<String>> quizzes = new HashMap<>();
        equationGenerator.generateCorrectEquations();
        String[] correctEquations = equationGenerator.correctEquations;
        for (String correctEquation : correctEquations) {
            for (String quiz : equationGenerator.allPossibleMatchMoves(correctEquation)) {
                if (!quizzes.containsKey(quiz)) {
                    Set<String> newSet = new HashSet<>();
                    quizzes.put(quiz, newSet);
                }
                Set<String> s = quizzes.get(quiz);
                s.add(correctEquation);
            }
        }
    }
}