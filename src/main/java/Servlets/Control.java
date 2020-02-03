package Servlets;

import Functions.*;
import Models.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class Control {

    private static Control instance=null;

    /**
     * Users roles
     */
    private static final String MAIN_ADMIN="main_admin";
    private static final String SHIP_ADMIN="ship_admin";
    private static final String CLIENT="client";
    private static final String ALL="all";

    /**
     * Request parameter name for command
     */
    private static final String COMMAND = "command";


    /**
     * Action commands
     */
    HashMap<String, IFunction> commands = new HashMap<String, IFunction>();
    HashMap<String, IFunction> mainAdminCommands = new HashMap<String, IFunction>();
    HashMap<String, IFunction> shipAdminCommands = new HashMap<String, IFunction>();
    HashMap<String, IFunction> userCommands = new HashMap<String, IFunction>();


    private Control() {
        // Everyone commands
        commands.put("login", new LoginFunction());

        // Main admin commands
        mainAdminCommands.put("logout", new LogoutFunction());

        // Ship admin commands
        shipAdminCommands.put("logout", new LogoutFunction());

        // Client commands
        userCommands.put("logout", new LogoutFunction());
        }

    // метод извлечения информации из запроса
    public IFunction getCommand(HttpServletRequest request) {
        System.out.println("идет поиск функции..");
        String role = checkRoleBySession(request);
        IFunction command = null;
        System.out.println("Current role = " + role);
        if (role.equals(ALL)) {
            command = commands.get(request.getParameter(COMMAND));
        } else if (role.equals(MAIN_ADMIN)) {
            command = mainAdminCommands.get(request.getParameter(COMMAND));
        } else if (role.equals(SHIP_ADMIN)) {
            command = shipAdminCommands.get(request.getParameter(COMMAND));
        } else if (role.equals(CLIENT)) {
            command = userCommands.get(request.getParameter(COMMAND));

        }
        if (command == null) {
            command = new FunctionIndex();
        }
        System.out.println("command = "+command);
        return command;
    }

//    // метод добавления в запрос данных для передачи в jsp
//    public void insertAttributes(HttpServletRequest request) {
//        // реализация
//    }


    private String checkRoleBySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String role = null;
        if (session == null) {
            return ALL;
        }
        role = UserService.getInstance().checkRole((User) session.getAttribute("currentUser"));
        return role;
    }

    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

//    //example connecting pool
//    public void connect()throws NamingException, SQLException {
//        Context envCtx = (Context)(new InitialContext().lookup("java:comp/env"));
//        DataSource ds =(DataSource)envCtx.lookup("jdbc/cruises");
//        Connection cn = ds.getConnection();
//
//
//        cn.close();
}