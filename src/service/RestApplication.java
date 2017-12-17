package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/") // un projet EJB est un projet .jar, un projet web dynamic est un projet .war
                      // le tout (combinaison des deux) est un projet .ear
public class RestApplication extends Application {

}
