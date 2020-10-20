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

    public void sessionCreated(HttpSessionEvent se)  { //���� ���� ���� Ȯ��
         if(se.getSession().isNew()) {
        	 // �湮�� ���� 1 ���� ��Ŵ, ù �湮�ڶ�� �湮�� ���� 1�� �ʱ�ȭ
        	 statsService = new StatsService();
        	 statsService.countStats();
         }
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
        
    }
	
}
