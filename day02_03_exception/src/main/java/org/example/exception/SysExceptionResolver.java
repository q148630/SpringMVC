package org.example.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 異常處理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    
    /**   
     * 方法: 處理異常 business logic
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return org.springframework.web.servlet.ModelAndView  
     */  
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        // 取得異常物件
        SysException eception = null;
        if (e instanceof SysException) {
            eception = (SysException) e;
        } else {
            eception = new SysException("系統正在維護...");
        }
        // 建立 ModelAndView 物件
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("error");

        return mv;
    }
    
}
