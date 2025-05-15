package demo.ss08.controller;

import demo.ss08.model.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@SessionAttributes({"currentQuestion", "attempts"})
public class QuizController {

    private List<Question> questions = Arrays.asList(
            new Question(1, "img/apple.jpg", "apple"),
            new Question(2, "img/car.jpg", "car"),
            new Question(3, "img/cat.jpg", "cat")
    );

    @GetMapping("/quiz")
    public String showQuiz(Model model) {
        Question random = questions.get(new Random().nextInt(questions.size()));
        model.addAttribute("currentQuestion", random);
        model.addAttribute("attempts", 0);
        return "quiz";
    }

    @PostMapping("/guess")
    public String handleGuess(@RequestParam String userAnswer,
                              @ModelAttribute("currentQuestion") Question question,
                              @ModelAttribute("attempts") int attempts,
                              Model model) {

        if (userAnswer.equalsIgnoreCase(question.getAnswer())) {
            model.addAttribute("message", "Đã đoán đúng!");
            model.addAttribute("gameOver", true);
        } else {
            attempts++;
            model.addAttribute("attempts", attempts);
            if (attempts >= 3) {
                model.addAttribute("message", "Bạn hết lượt đoán!");
                model.addAttribute("gameOver", true);
            } else {
                model.addAttribute("message", "Sai rồi, thử lại lần nữa!");
                model.addAttribute("gameOver", false);
            }
        }

        return "quiz";
    }
}