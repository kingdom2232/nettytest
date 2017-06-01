package netty.protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-11 20:19
 */
public class NettyClient {

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void connect(String remoteServer, int port) throws Exception {
        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChildChannelHandler());

            ChannelFuture f = b.connect(new InetSocketAddress(remoteServer,port),
                    new InetSocketAddress("127.0.0.1", 18080)).sync();
            System.out.println("Netty time Client connected at port " + port);
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            // 所有资源释放完成后，清空资源，再次发起重连操作
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5000);
                    try {
                        connect("127.0.0.1", 8080);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static class ChildChannelHandler extends
            ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            // -8表示lengthAdjustment，让解码器从0开始截取字节，并且包含消息头
            ch.pipeline().addLast(new NettyMessageDecoder(1024 * 1024,4, 4))
                    .addLast("MessageEncoder", new NettyMessageEncoder())
                    .addLast("ReadTimeoutHandler", new ReadTimeoutHandler(50))
                    .addLast("LoginAuthReqHandler", new LoginAuthReqHandler())
                    .addLast("HeartBeatReqHandler", new HeartBeatReqHandler());
        }

    }

    public static void main(String[] args){
        try {
            new NettyClient().connect("127.0.0.1", 8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
