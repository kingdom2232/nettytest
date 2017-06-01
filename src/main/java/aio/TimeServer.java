package aio;

import java.io.IOException;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-04-28 11:25
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        AsyncTimeServerHandler timeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(timeServerHandler, "AIO-AsyncTimeServerHandler-001").start();
    }
}
