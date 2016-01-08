package Sockets;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

/**
 * Created by vasiliy on 08.01.16.
 */


@WebServlet(name = "SocketGlobalChatServlet", urlPatterns = {"/globalchat"})
public class SocketGlobalChatServlet  extends WebSocketServlet {
    private final static int IDLE_TIME = 120 * 1000;

    GlobalChatService globalChatService;

    public SocketGlobalChatServlet(GlobalChatService blChSer) {
        globalChatService = blChSer;
    }

    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(IDLE_TIME);
        factory.setCreator(new GlobalChatSocketCreator(globalChatService));
    }
}
