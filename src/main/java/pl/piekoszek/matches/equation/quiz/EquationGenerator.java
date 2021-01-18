package pl.piekoszek.matches.equation.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EquationGenerator {

    private String[] tempResults = new String[100];
    private String[] addMatchToCharacterTempResults = new String[100];
    private char[][] canChangePosition = new char[255][];
    private char[][] canTakeFrom = new char[255][];
    private char[][] canAddTo = new char[255][];

    EquationGenerator() {
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

        canTakeFrom['0'] = new char[]{};
        canTakeFrom['1'] = new char[]{};
        canTakeFrom['2'] = new char[]{};
        canTakeFrom['3'] = new char[]{};
        canTakeFrom['4'] = new char[]{};
        canTakeFrom['5'] = new char[]{};
        canTakeFrom['6'] = new char[]{};
        canTakeFrom['7'] = new char[]{'1'};
        canTakeFrom['8'] = new char[]{'0'};
        canTakeFrom['9'] = new char[]{'3', '5'};
        canTakeFrom['+'] = new char[]{'-'};
        canTakeFrom['-'] = new char[]{};
        canTakeFrom['='] = new char[]{};

        canAddTo['0'] = new char[]{};
        canAddTo['1'] = new char[]{'7'};
        canAddTo['2'] = new char[]{};
        canAddTo['3'] = new char[]{'9'};
        canAddTo['4'] = new char[]{};
        canAddTo['5'] = new char[]{'6', '9'};
        canAddTo['6'] = new char[]{'8'};
        canAddTo['7'] = new char[]{};
        canAddTo['8'] = new char[]{};
        canAddTo['9'] = new char[]{'8'};
        canAddTo['0'] = new char[]{'8'};
        canAddTo['+'] = new char[]{};
        canAddTo['-'] = new char[]{'+'};
        canAddTo['='] = new char[]{};
    }

    public List<String> getCorrectEquations() {
        List<String> correctEquations = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j < 10) {
                    correctEquations.add(String.format("%d+%d=%d", i, j, i + j));
                }
                if (i - j >= 0) {
                    correctEquations.add(String.format("%d-%d=%d", i, j, i - j));
                }
            }
        }
        return correctEquations;
    }

    public List<String> allPossibleMatchMoves(String correctEquation) {
        int movingMatchInCharacter = correctEquationToQuizzes(correctEquation).length;
        int movingMatchBetweenCharacters = changeMatchPositionBetweenCharacters(correctEquation).length;
        String[] results = new String[movingMatchInCharacter + movingMatchBetweenCharacters];

        System.arraycopy(correctEquationToQuizzes(correctEquation), 0, results, 0, movingMatchInCharacter);
        System.arraycopy(changeMatchPositionBetweenCharacters(correctEquation), 0, results, movingMatchInCharacter, movingMatchBetweenCharacters);
        return Arrays.asList(results);
    }

    private boolean isEquationCorrect(String equation) {
        boolean correctEquation;

        int a = equation.charAt(0) - '0';
        int b = equation.charAt(2) - '0';
        int c = equation.charAt(4) - '0';

        char sign = equation.charAt(1);
        if (sign == '+') {
            correctEquation = a + b == c;
        } else {
            correctEquation = a - b == c;
        }

        return correctEquation;
    }

    private String[] correctEquationToQuizzes(String equation) {
        char[] equationChar = equation.toCharArray();

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

    private String[] changeMatchPositionBetweenCharacters(String equation) {
        char[] equationChar = equation.toCharArray();

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < canTakeFrom[equation.charAt(i)].length; j++) {
                char temp = equation.charAt(i);
                equationChar[i] = canTakeFrom[equation.charAt(i)][j];
                String equationWithoutMatch = new String(equationChar);
                String[] equationsWithAddedMatch = addMatchToCharacter(equationWithoutMatch, i);
                for (String equationWithAddedMatch : equationsWithAddedMatch) {
                    if (!isEquationCorrect(equationWithAddedMatch)) {
                        tempResults[k++] = equationWithAddedMatch;
                    }
                }
                equationChar[i] = temp;
            }
        }

        String[] results = new String[k];
        System.arraycopy(tempResults, 0, results, 0, k);

        return results;
    }

    private String[] addMatchToCharacter(String equation, int position) {
        char[] equationChar = equation.toCharArray();

        int k = 0;
        for (int i = 0; i < 5; i++) {
            if (i != position) {
                for (int j = 0; j < canAddTo[equation.charAt(i)].length; j++) {
                    char temp = equation.charAt(i);
                    equationChar[i] = canAddTo[equation.charAt(i)][j];
                    addMatchToCharacterTempResults[k++] = new String(equationChar);
                    equationChar[i] = temp;
                }
            }
        }

        String[] results = new String[k];
        System.arraycopy(addMatchToCharacterTempResults, 0, results, 0, k);

        return results;
    }

}
