package test;

import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import java.net.InetSocketAddress;

public class SimpleWebSocketServer extends WebSocketServer {
    public SimpleWebSocketServer(int port) {
        super(new InetSocketAddress(port));
    }
    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        System.out.println("New connection: " + conn.getRemoteSocketAddress());
    }
    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        System.out.println("Closed: " + conn.getRemoteSocketAddress());
    }
    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println("Message: " + message);
        conn.send("Echo: " + message);
    }
    @Override
    public void onStart() {
        ;
    }
    @Override
    public void onError(WebSocket conn, Exception e) {
        ;
    }
    public static void main(String[] args) {
        new SimpleWebSocketServer(8887).start();
    }
}
