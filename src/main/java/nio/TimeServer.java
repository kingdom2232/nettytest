package nio;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-04-27 11:14
 */
public class TimeServer {

    public static void main(String[] args) throws Exception{
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerServer-001").start();
    }
}
