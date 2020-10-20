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

    public void sessionCreated(HttpSessionEvent se)  { //세션 생성 여부 확인
         if(se.getSession().isNew()) {
        	 // 방문자 수를 1 증가 시킴, 첫 방문자라면 방문자 수를 1로 초기화
        	 statsService = new StatsService();
        	 statsService.countStats();
         }
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
