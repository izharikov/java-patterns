package com.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ihar Zharykau
 */
public class Command {
    public static void main(String... args) {
        FrontServlet frontServlet = new FrontServlet();
        frontServlet.registerAction("/login", new LoginAction());
        frontServlet.registerAction("/", new HomeAction());
        frontServlet.registerAction("/home", new HomeAction());
        Request[] chainOfRequest = new Request[]{
                new Request("/login"),
                new Request("/"),
                new Request("/home")};
        for (Request req : chainOfRequest) {
            frontServlet.service(req, new Response());
        }
    }
}

interface Action {
    Response execute(Request req);
}

class HomeAction implements Action {
    @Override
    public Response execute(Request req) {
        System.out.println("execute Home Action");
        return new Response();
    }
}

class LoginAction implements Action {
    @Override
    public Response execute(Request req) {
        System.out.println("execute Login Action");
        return new Response();
    }
}

class Request {
    private String path;

    public Request(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

class Response {
}

class FrontServlet {
    private Map<String, Action> actionMap;

    public FrontServlet() {
        actionMap = new HashMap<>();
    }

    public void registerAction(String path, Action action) {
        actionMap.put(path, action);
    }

    public void service(Request request, Response response) {
        Action action = actionMap.get(request.getPath());
        response = action.execute(request);
    }
}