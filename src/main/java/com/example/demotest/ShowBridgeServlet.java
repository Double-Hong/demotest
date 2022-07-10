package com.example.demotest;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value="/ShowBridgeServlet")
public class ShowBridgeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Bridge_Info> infos=new ArrayList<>();
        infos=userAccess.ShowBridge();
        PrintWriter pw=resp.getWriter();
        Gson gson =new GsonBuilder().create();
        pw.write(gson.toJson(infos));
        System.out.println(gson.toJson(infos));
        pw.close();
    }
}
