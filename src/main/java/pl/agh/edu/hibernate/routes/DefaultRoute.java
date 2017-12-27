package pl.agh.edu.hibernate.routes;

import freemarker.template.Configuration;
import org.hibernate.Session;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;
/**
 * Created by sirius on 27.12.17.
 */
public abstract class DefaultRoute implements Route {
    protected Session session;
    FreeMarkerEngine templateEngine;

    public DefaultRoute(Session session, Configuration templateConfiguration) {
        this.session = session;
        this.templateEngine = new FreeMarkerEngine(templateConfiguration);
    }
}
