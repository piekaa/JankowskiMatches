package pl.piekoszek.matches.equation.gameplay;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.piekoszek.matches.equation.image.ImageService;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/gameplay")
class GameplayController {

    private GameplayService gameplayService;

    GameplayController(GameplayService gameplayService) { this.gameplayService = gameplayService; }

//    @GetMapping("/quiz")
////    String hello() {
////        return gameplayService.randomQuiz();
////    }

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    byte[] drawEquation() {
        return gameplayService.randomQuizImage();
    }

}
