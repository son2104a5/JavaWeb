package demo.ss02;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private final String[] WORDS = {"hangdong", "vietnam", "dalat", "phongnha"};
    private final int MAX_ATTEMPTS = 6;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ServletException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        if ("start".equals(action)) {
            String secretWord = WORDS[new Random().nextInt(WORDS.length)];
            session.setAttribute("secretWord", secretWord);
            session.setAttribute("correctChars", new HashSet<Character>());
            session.setAttribute("remainingAttempts", MAX_ATTEMPTS);
            session.setAttribute("gameOver", false);
            response.sendRedirect("game.jsp");
        }

        else if ("guess".equals(action)) {
            String guess = request.getParameter("guess").toLowerCase();
            String secretWord = (String) session.getAttribute("secretWord");
            Set<Character> correctChars = (Set<Character>) session.getAttribute("correctChars");
            int remainingAttempts = (int) session.getAttribute("remainingAttempts");
            boolean gameOver = (boolean) session.getAttribute("gameOver");

            if (gameOver || guess.length() != 1 || !Character.isLetter(guess.charAt(0))) {
                request.setAttribute("message", "Vui lòng nhập 1 chữ cái hợp lệ.");
            } else {
                char ch = guess.charAt(0);
                if (secretWord.indexOf(ch) >= 0) {
                    correctChars.add(ch);
                } else {
                    remainingAttempts--;
                }
            }

            StringBuilder display = new StringBuilder();
            boolean won = true;
            for (char c : secretWord.toCharArray()) {
                if (correctChars.contains(c)) {
                    display.append(c).append(" ");
                } else {
                    display.append("_ ");
                    won = false;
                }
            }

            if (won) {
                session.setAttribute("gameOver", true);
                request.setAttribute("result", "🎉 Bạn đã đoán đúng từ: " + secretWord);
            } else if (remainingAttempts <= 0) {
                session.setAttribute("gameOver", true);
                request.setAttribute("result", "💀 Bạn thua! Từ đúng là: " + secretWord);
            }

            session.setAttribute("correctChars", correctChars);
            session.setAttribute("remainingAttempts", remainingAttempts);
            request.setAttribute("displayWord", display.toString());
            request.setAttribute("remainingAttempts", remainingAttempts);
            request.getRequestDispatcher("game.jsp").forward(request, response);
        }
    }
}