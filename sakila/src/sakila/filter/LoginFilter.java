package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("//auth/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
        
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("로그인 폼 실행 확인");
		/*request.getSession 사용 x
		 *ServletReqeust에 HttpSession이 들어오기 때문에
		 * response도 동일하게 형변환 후 사용
		 */
		HttpSession session = ((HttpServletRequest)request).getSession();
		//로그인 여부 확인
		if(session.getAttribute("loginStaff") == null) {//형변환을 사용 해서 getServletContext()로 루트를 찾은 후 getContextPath를 사용
			((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath()+"/LoginServlet");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
