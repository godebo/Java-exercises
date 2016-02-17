/*
    All Requests go through this Servlet(Both GET and POST)
    This is the controller which processes requests, validates inputs
    with the help of CDI Beans
 */
package fi.oamk.students.r8hibe00.javaee.a3;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Controller", urlPatterns = {"/"})
public class Controller extends HttpServlet {

    @Inject
    private ApplicationStage stage;
    
    @Inject
    private InputValidator validate;
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/homePage.jsp");
        switch (stage.getAppStage()) {
            case HOME:
                break;
            case EXERCISES:
                dispatcher = request.getRequestDispatcher("WEB-INF/views/problemPage.jsp");
                break;
            case SUMMARY:
                dispatcher = request.getRequestDispatcher("WEB-INF/views/summaryPage.jsp");
                break;
        }
        
        dispatcher.forward(request, response);
   }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        switch(request.getParameter("stage")) {
            case "HOME":
                 stage.beginExercise();
                break;
            case "EXERCISES":
                if (answer.matches("[0-9]+")) {
                    if (stage.getCurrentExercise().operation() == Integer.parseInt(answer)) {
                        stage.proceed(answer);                        
                        validate.setRightAnswer(true);
                        stage.setTryAgain(false);
                    }else {
                        if(stage.isTryAgain()) {
                            stage.proceed(answer);
                            stage.setTryAgain(false);
                        }
                        else {
                            stage.setTryAgain(true);
                        }
                        validate.setWrongAnswer(true);
                        
                    }
                    

                } else {
                    validate.setWrongInput(true);
                }

                break;
            case "END":
                stage.quitExercise();
                
        }
        
        doGet(request, response);
        
    }
    
}
