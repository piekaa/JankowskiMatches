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
    Request postController(@RequestBody Request request) {
        return request;
    }

//    One endpoint (POST method) responsible for checking if solution is correct.
//    example path: /gameplay/solution
//    example request body:
//    {
//        "quiz" : "1+8=4",
//        "solution": "1+2=3"
//    }
//
//    example response body:
//    {
//        "isCorrect": false
//    }

}