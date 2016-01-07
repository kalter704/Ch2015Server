package frontend;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author v.chibrikov
 */
public class Frontend extends HttpServlet {

    @Override
    public void doGet(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
                /*

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("name", login);
        jsonResponse.put("auth", false);
        jsonResponse.put("NotNull", false);


        HttpSession session = request.getSession();

        if (login != null && password != null) {
            jsonResponse.put("NotNull", true);
            if (accountService.singIn(session, login, password) != -1) {
                jsonResponse.put("auth", true);
            }
        }
        */

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("namePerem", "right");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse.toString());
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void doPost(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws ServletException, IOException {
    }
}

