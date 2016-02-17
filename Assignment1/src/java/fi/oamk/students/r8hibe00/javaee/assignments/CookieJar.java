/*
 ********************** By Bereket Godebo **********************************
 ************************* Assignment1 ************************************* 
 * 
 */
package fi.oamk.students.r8hibe00.javaee.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bereket
 * a CookieJar class that maintains a list of cookies
 */
public class CookieJar {
    
    private final List<String> jar = new ArrayList();
    
    /**
    * 
    * @param cookie -String to add to cookie jar
    */
    public void addCookie(String cookie) {
        jar.add(cookie);
    }
    
    /**
    *
    * @return String - a random cookie from cookie jar
    */
    public String getRandomCookie() {
        //get random index 0 to (length - 1)
        int randomIndex = new Random().nextInt(jar.size());
        
        return jar.get(randomIndex);
        
    }

}
