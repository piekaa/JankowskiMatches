import quizImage.ImageConfiguration;
import quizImage.ImageService;
import quizzes.QuizConfiguration;
import quizzes.QuizService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        QuizService quizService = QuizConfiguration.getQuizService();
        ImageService imageService = ImageConfiguration.getImageService();

        String randomQuiz = quizService.randomQuiz();

        byte[] imageBytes = imageService.drawEquation(randomQuiz);

        Files.write(Paths.get("image.png"), imageBytes);

        System.out.println(randomQuiz);

        String solution = scanner.next();

        System.out.println(quizService.isSolutionCorrect(randomQuiz, solution));
    }

}