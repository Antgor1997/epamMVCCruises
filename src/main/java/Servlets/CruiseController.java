package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import Functions.IFunction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@WebServlet("/controller")
public class CruiseController extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(CruiseController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("Начало get");
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        LOGGER.info("Начало process");
        IFunction command = Control.getInstance().getCommand(request);
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
