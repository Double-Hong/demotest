package Bridge_Info;
import com.example.demotest.Bridge_Info;
import com.example.demotest.userAccess;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/Showtest")
public class Showtest extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Bridge_Info> infos=new ArrayList<>();
        infos= userAccess.ShowBridge();
        PrintWriter pw=resp.getWriter();
        Gson gson =new GsonBuilder().create();
        pw.write(gson.toJson(infos));
        System.out.println(gson.toJson(infos));
        pw.close();
    }
}
