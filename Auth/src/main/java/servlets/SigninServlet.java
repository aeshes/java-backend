package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SigninServlet extends HttpServlet {
    private AccountService accountService;

    public SigninServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserProfile profile = accountService.getUserByLogin(login);
        if (profile != null && profile.getPass().equals(password)) {
            respondAuthorized(response);
        } else {
            respondUnauthorized(response);
        }
    }

    private void respondAuthorized(HttpServletResponse response) throws IOException {
        response.getWriter().println("Authorized");
        response.setStatus(200);
    }

    private void respondUnauthorized(HttpServletResponse response) throws IOException {
        response.getWriter().println("Unauthorized");
        response.setStatus(401);
    }
}
