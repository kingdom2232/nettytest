package netty.protocol;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-19 11:12
 */
public enum MessageType {

    LOGIN_REQ((byte)0),
    LOGIN_RESP((byte)1),
    HEARTBEAT_REQ((byte)2),
    HEARTBEAT_RESP((byte)3);

    private byte value;
    MessageType(byte value) {
        this.value = value;
    }

    public byte value(){
        return value;
    }

}
