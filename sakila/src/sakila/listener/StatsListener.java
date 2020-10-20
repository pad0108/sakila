package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;


@WebListener
public class StatsListener implements HttpSessionListener {
	private StatsService statsService;

    public StatsListener() {
        
    }

    public void sessionCreated(HttpSessionEvent se)  { //技记 积己 咯何 犬牢
         if(se.getSession().isNew()) {
        	 statsService = new StatsService();
        	 statsService.countStats();
         }
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
