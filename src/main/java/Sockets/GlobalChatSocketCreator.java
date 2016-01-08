package Sockets;

import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

import javax.servlet.http.HttpSession;

/**
 * Created by vasiliy on 08.01.16.
 */
public class GlobalChatSocketCreator implements WebSocketCreator {

    GlobalChatService globalChatService;

    public GlobalChatSocketCreator(GlobalChatService blChSer) {
        globalChatService = blChSer;
    }

    @Override
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
        GlobalChatSocket globalChatSocket = new GlobalChatSocket(globalChatService);
        return globalChatSocket;
    }
}
