package netty.shopping;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-08 11:15
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubscribeReq req = (SubscribeReq) msg;
        if ("Lilinfeng".equalsIgnoreCase(req.getUsername())){
            System.out.println("Service accept client subscribe req : [" + req.toString() + "]");
            ctx.writeAndFlush(resq(req.getSubReqId()));
        }
    }

    private SubscribeResp resq(int subReqId) {
        SubscribeResp resp = new SubscribeResp();
        resp.setSebReqId(subReqId);
        resp.setRespCode(0);
        resp.setDesc("Netty book order successed, 3 days later, send to the designated address");
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();// 发生异常，关闭链路
    }
}
