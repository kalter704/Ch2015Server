package Sockets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasiliy on 08.01.16.
 */
public class GlobalChatService {
    private List<GlobalChatSocket> listSockets = new ArrayList<>();

    public void sendMessageToAllUsers(String mess) {
        for(GlobalChatSocket globalChatSocket : listSockets) {
            globalChatSocket.sendMessage(mess);
        }
    }

    public void registerSocket(GlobalChatSocket globalChatSocket) {
        listSockets.add(globalChatSocket);
    }

    public void deleteSocket(GlobalChatSocket glChSoc) {
        for(int i = 0; i < listSockets.size(); ++i) {
            if(listSockets.get(i).getId() == glChSoc.getId()) {
                listSockets.remove(i);
                break;
            }
        }
    }

}
