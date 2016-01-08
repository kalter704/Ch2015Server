package main;

import Sockets.GlobalChatService;
import Sockets.SocketGlobalChatServlet;
import frontend.Frontend;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * @author v.chibrikov
 */
public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.append("Use port as the first argument");
            System.exit(1);
        }

        String portString = args[0];
        int port = Integer.valueOf(portString);
        System.out.append("Starting at port: ").append(portString).append('\n');

        GlobalChatService globalChatService = new GlobalChatService();

        Frontend frontend = new Frontend();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/qwe");
        context.addServlet(new ServletHolder(new SocketGlobalChatServlet(globalChatService)), "/");

        Server server = new Server(port);
        server.setHandler(context);

        server.start();
        server.join();
    }
}
