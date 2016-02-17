/*
 ********************** By Bereket Godebo **********************************
 ************************* Assignment1 ************************************* 
 * ***********Description of problem to be addressed************************
 *  In your JavaServer, at path /fortune there should be a servlet which returns a random
 *  fortune cookie each time it gets a GET request. The cookie shall be delivered as plain text.
 *
 *  The cookie jar is at URL http://fortunes.cat-v.org/openbsd/
 *
 *  When initialized, your servlet fetches the cookies from that jar and initializes
 *  an internal data structure from which it can randomly select a cookie when needed.
 */
package fi.oamk.students.r8hibe00.javaee.assignments;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bereket
 */
@WebServlet(name = "FortuneCookieServlet", urlPatterns = {"/"})
public class FortuneCookieServlet extends HttpServlet {
    private final CookieJar cookieJar = new CookieJar();
    private Scanner pageScanner;
    private String nextCookieLine;
    
   /**
     * Called by the servlet container to indicate to a servlet that the servlet is being placed into service.
     *
     * @param config a ServletConfig object containing the servlet's configuration and initialisation parameters
     * @throws ServletException if a servlet-specific error occurs
     * 
     *  initialises cookie page scanning
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            createPageScanner("http://fortunes.cat-v.org/openbsd/");
        } catch (IOException ex) {
            
        }
    }
     
   /**
     * initialises a page scanning and calls a method that 
     * brings the scanner to the beginning of the cookie line
     *
     * @param url String 
     * @throws MalformedURLException
     * @throws IOException
     */
    private void createPageScanner(String url) throws MalformedURLException, IOException {
        pageScanner = new Scanner(new URL(url).openStream());
        gotoNextLine();//initialises nextCookieLine member variable
        goToCookieLine();
    }
    
    /**
     * brings the scanner to the beginning of cookie line
     * then fills the cookie jar
     */
    private void goToCookieLine() {
        while (!isStart()) {
            gotoNextLine();
        }
        
        fillCookieJar();
    }
    /**
     * 
     *fills the cookie jar with cookies
     */
    private void fillCookieJar() {
       String cookie;
       while((cookie = nextCookie()) != null) {
           cookieJar.addCookie(cookie);
       }

    }
    
    /**
     * 
     *@return String - a cookie from cookie page
     * Multi-line cookies are buffered
     */
    private String nextCookie() {
       StringBuilder buf = new StringBuilder();
        if (!isEnd()) {
            while (!isInBetweenCookie() && !isEnd()) {
                buf.append(nextCookieLine)
                        .append("\n");
                gotoNextLine();

            }
            return buf.toString();
        } else {
            return null;
        }

    }
    /**
     * 
     *@return boolean  -Weather scanner is in the beginning of cookie lines
     * if it is, then discards '<pre>' which marks the beginning of cookie lines
     */
    private boolean isStart() {
        if(nextCookieLine.equals("<pre>")) {
            gotoNextLine();
            return true;
        }
        else
            return false;
    }
    
    /**
     * 
     *@returns boolean -Weather scanner is in the end of cookies
     * since  end of cookies is marked by '</pre>'
     */
    private boolean isEnd() {
        return nextCookieLine.equals("</pre>");
    }
    /**
     * 
     *@returns boolean -Weather scanner is in between cookies, if it is then discard %
     * since in between cookies there is %
     */
    private boolean isInBetweenCookie() {
        if(nextCookieLine.equals("%")) {
            gotoNextLine();
            return true;
        }
        else
            return false;
    }
    
    /**
     * advance scanner to next line
     */
    private void gotoNextLine() {
        nextCookieLine = pageScanner.nextLine();
    }
 
    
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
        //send a plain text response
        response.getWriter().println(cookieJar.getRandomCookie());
        
    }

}
