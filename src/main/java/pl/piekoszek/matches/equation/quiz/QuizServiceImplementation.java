package pl.piekoszek.matches.equation.quiz;

import java.util.*;

class QuizServiceImplementation implements QuizService {

    private Map<String, Set<String>> quizzesToSolutions = new HashMap<>();
    private Random random = new Random();
    private String[] quizzes;

    QuizServiceImplementation(EquationGenerator equationGenerator) {

        for (String correctEquation : equationGenerator.getCorrectEquations()) {
            for (String quiz : equationGenerator.allPossibleMatchMoves(correctEquation)) {
                if (!quizzesToSolutions.containsKey(quiz)) {
                    quizzesToSolutions.put(quiz, new HashSet<>());
                }
                quizzesToSolutions.get(quiz).add(correctEquation);
            }
        }
        quizzes = quizzesToSolutions.keySet().toArray(new String[0]);
    }

    @Override
    public String randomQuiz() {
        return quizzes[random.nextInt(quizzes.length)];
    }

    @Override
    public boolean isSolutionCorrect(String quiz, String solution) {
        return quizzesToSolutions.get(quiz).contains(solution);
    }

}
