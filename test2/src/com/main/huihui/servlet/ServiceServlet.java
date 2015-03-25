package com.main.huihui.servlet;

import com.main.huihui.tool.JsoupTool;
import com.main.huihui.tool.UrlBookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

/**
 * Created by huihui on 15-3-25.
 */
public class ServiceServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        super.service(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)
        throws IOException,ServletException{

        RequestDispatcher rd;

        // 取得关键字
        String key = new String(request.getParameter("key").getBytes("iso-8859-1"),"UTF-8");

        // 爬取页面信息
        JsoupTool jsoupTool = new JsoupTool();
        LinkedList<UrlBookModel> urlBookModels = jsoupTool.extract(key);

        request.setAttribute("books",urlBookModels);

        rd = request.getRequestDispatcher("/result.jsp");  // 获取转发对象
        rd.forward(request,response);   // 发送请求
    }

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws UnsupportedEncodingException{
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
