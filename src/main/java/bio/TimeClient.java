package bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-04-26 16:12
 */
public class TimeClient {
    public static void main(String[] args) throws Exception{
    int port = 8080;
        try (Socket socket = new Socket("127.0.0.1", port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
            out.println("QUERY TIME ORDER");
            System.out.println(in.readLine());
            Thread.sleep(10*1000);
        }
    }
}
