package aio;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-04-28 16:42
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),
                "AIO-AsyncTimeClientHandler-001").start();
    }
}
