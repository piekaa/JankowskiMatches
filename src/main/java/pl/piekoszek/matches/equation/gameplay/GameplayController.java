package pl.piekoszek.matches.equation.gameplay;

import org.springframework.web.bind.annotation.*;

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
    CheckResponse postController(@RequestBody Request request) {
        return new CheckResponse(gameplayService.checkSolution(request.quiz, request.solution));
    }
}