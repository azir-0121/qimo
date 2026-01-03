package utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发工具类，用于servlet使用请求转发方式打开网页
 */
public class DispatcherUtils {
    /**
     * 使用请求转发方式打开网页
     * @param weburl  被打开网页的url
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public static final void openWeb(String weburl,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(weburl);
        rd.forward(request,response);
    }

    /**
     * 使用请求转发方式打开错误页面(errors.jsp)，显示错误信息
     * @param errMsg 在错误页面中显示的错误信息
     * @param backUrl 在错误页面中返回上一个页面的超链接URL地址
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    public static final void openErrWeb(String errMsg,
                                        String backUrl,
                                        HttpServletRequest request,
                                        HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errMsg",errMsg);
        request.setAttribute("backUrl",backUrl);
        RequestDispatcher rd = request.getRequestDispatcher("errors.jsp");
        rd.forward(request,response);
    }
}
