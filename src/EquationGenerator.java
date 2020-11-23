public class EquationGenerator {
    String[] correctEquations;

    void generateCorrectEquations() {
        correctEquations = new String[110];
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j < 10) {
                    correctEquations[index++] = String.format("%d+%d=%d", i, j, i + j);
                }
                if (i - j >= 0) {
                    correctEquations[index++] = String.format("%d-%d=%d", i, j, i - j);
                }
            }
        }
    }

    String[] correctEquationToQuizzes(String equation) {

        char[] equationChar = equation.toCharArray();
        String[] tempResults = new String[100];

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

    String[] changeMatchPositionBetweenCharacters(String equation) {

        char[] equationChar = equation.toCharArray();
        String[] tempResults = new String[100];

        char[][] canTakeFrom = new char[255][];
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

        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < canTakeFrom[equation.charAt(i)].length; j++) {
                char temp = equation.charAt(i);
                equationChar[i] = canTakeFrom[equation.charAt(i)][j];
                String equationWithoutMatch = new String(equationChar);
                String[] equationsWithAddedMatch = addMatchToCharacter(equationWithoutMatch, i);
                for (String equationWithAddedMatch : equationsWithAddedMatch) {
                    tempResults[k++] = equationWithAddedMatch;
                }
                equationChar[i] = temp;
            }
        }
        String[] results = new String[k];
        System.arraycopy(tempResults, 0, results, 0, k);

        return results;

    }

    String[] addMatchToCharacter(String equation, int position) {

        char[] equationChar = equation.toCharArray();
        String[] tempResults = new String[100];

        char[][] canAddTo = new char[255][];
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

        int k = 0;
        for (int i = 0; i < 5; i++) {
            if (i != position) {
                for (int j = 0; j < canAddTo[equation.charAt(i)].length; j++) {
                    char temp = equation.charAt(i);
                    equationChar[i] = canAddTo[equation.charAt(i)][j];
                    tempResults[k++] = new String(equationChar);
                    equationChar[i] = temp;
                }
            }
        }
        String[] results = new String[k];
        System.arraycopy(tempResults, 0, results, 0, k);

        return results;

    }

    String[] allPossibleMatchMoves(String equation) {

        int movingMatchInCharacter = correctEquationToQuizzes(equation).length;
        int movingMatchBetweenCharacters = changeMatchPositionBetweenCharacters(equation).length;
        String[] results = new String[movingMatchInCharacter + movingMatchBetweenCharacters];

        System.arraycopy(correctEquationToQuizzes(equation), 0, results, 0, movingMatchInCharacter);
        System.arraycopy(changeMatchPositionBetweenCharacters(equation), 0, results, movingMatchInCharacter, movingMatchBetweenCharacters);

        return results;
    }

}