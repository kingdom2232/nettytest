package netty.protocol;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-19 11:19
 */
public class HeartBeatRespHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        NettyMessage message = (NettyMessage) msg;
        // 返回心跳应答消息
        if (message.getHeader() != null && message.getHeader().getType() == MessageType.HEARTBEAT_REQ.value()) {
            System.out.println("Receive client heart beat message : ---> " + message);
        }
        NettyMessage heartBeat = buildHeartBeat();
        System.out.println("Send heart beat response message to client : ---> " + heartBeat);
    }

    private NettyMessage buildHeartBeat() {
        NettyMessage heartBeat = new NettyMessage();
        NettyMessage.Header header = new NettyMessage.Header();
        header.setType(MessageType.HEARTBEAT_RESP.value());
        heartBeat.setHeader(header);
        return heartBeat;
    }
}
