package Sockets;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.io.IOException;

/**
 * Created by vasiliy on 08.01.16.
 */

@WebSocket
public class GlobalChatSocket {

    private static int number = 0;

    private int id;
    private Session session;
    private GlobalChatService globalChatService;

    public GlobalChatSocket(GlobalChatService globalChatService) {
        this.globalChatService = globalChatService;
        id = number++;
    }

    public void sendMessage(String mess) {
        try {
            session.getRemote().sendString(mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getId() { return id; }

    @OnWebSocketMessage
    public void onMessage(String data) {
        System.out.append("GlobalChatSocket onMessage" + '\n');
        System.out.append("GlobalChatSocket onMessage: " + data + '\n');
        globalChatService.sendMessageToAllUsers(data);
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.append("GlobalChatSocket onOpen" + '\n');
        this.session = session;
        globalChatService.registerSocket(this);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.append("GlobalChatSocket onClose" + '\n');
        globalChatService.deleteSocket(this);
    }

    @OnWebSocketError
    public void onError(Throwable t) {
        System.out.println("Error: " + t.getMessage());
    }
}
