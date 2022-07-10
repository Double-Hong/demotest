package com.example.demotest;


import netscape.javascript.JSObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONObject;

@WebServlet(value = "/loginServlet2",loadOnStartup = 1)
public class loginServlet2 extends HelloServlet{
    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username=req.getParameter("username");
            System.out.println(username);
            userAccess.Check();
            JSONObject o =new JSONObject();
            o.put("code","OK");
            PrintWriter pw = resp.getWriter();
            pw.print(o);
            pw.close();
    }
}
