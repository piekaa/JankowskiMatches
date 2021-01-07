package pl.piekoszek.matches.equation.gameplay;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gameplay")
class GameplayController {

    private GameplayService gameplayService;

    GameplayController(GameplayService gameplayService) {
        this.gameplayService = gameplayService;
    }

    @GetMapping("/quiz")
    Response hello() {
        String quiz = gameplayService.randomQuiz();
        return new Response(gameplayService.quizImage(quiz), quiz);
    }

    @PostMapping("/solution")
 boolean check() {
        return gameplayService.checkSolution(hello().quiz, )
    }

}