package pl.piekoszek.matches.equation.gameplay;

import org.springframework.web.bind.annotation.GetMapping;
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
    String hello() {
        return gameplayService.randomQuiz();
    }

    //todo zrobić endpoint, który zwróci obrazek z losowym quizem

}
