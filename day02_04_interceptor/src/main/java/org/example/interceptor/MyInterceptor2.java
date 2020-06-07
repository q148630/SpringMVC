package org.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定義攔截器
 */
public class MyInterceptor2 implements HandlerInterceptor {

    /**   
     * 方法: Controller 方法執行前
     * return true: 放行，執行下一個攔截器，如果沒有，執行 Controller 中的方法
     * return false 不放行
     * @param request, response, handler  
     * @return boolean  
     */  
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1 執行了...前222");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 方法: 後處理方法，Controller 方法執行後，success.jsp 執行前
     * @param request, response, handler, modelAndView
     * @return void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 執行了...後222");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**   
     * 方法: success.jsp 頁面執行後，該方法會執行
     * @param request, response, handler, ex
     * @return void  
     */  
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1 執行了...最後222");
    }
    
}
