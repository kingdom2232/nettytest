package bio;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-04-26 15:22
 */
public class TimeServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null){
                server.close();
            }
        }
    }
}
