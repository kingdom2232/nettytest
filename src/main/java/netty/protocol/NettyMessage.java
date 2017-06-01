package netty.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-11 10:20
 */
public class NettyMessage {
    private Header header;
    private Object body;

    public final Header getHeader() {
        return header;
    }

    public final void setHeader(Header header) {
        this.header = header;
    }

    public final Object getBody() {
        return body;
    }

    public final void setBody(Object body) {
        this.body = body;
    }

    public String toString() {
        return "NettyMessage {" + header.toString() + "}";
    }

    public final static class Header {
        private int crcCode = 0xabef0101;
        private int length;// 消息长度
        private long sessionID; // 会话ID
        private byte type; //消息类型
        private byte priority;// 消息优先级
        private Map<String, Object> attachment = new HashMap<>();//附件

        public final int getCrcCode() {
            return crcCode;
        }

        public final void setCrcCode(int crcCode) {
            this.crcCode = crcCode;
        }

        public final int getLength() {
            return length;
        }

        public final void setLength(int length) {
            this.length = length;
        }

        public final long getSessionID() {
            return sessionID;
        }

        public final void setSessionID(long sessionID) {
            this.sessionID = sessionID;
        }

        public final byte getType() {
            return type;
        }

        public final void setType(byte type) {
            this.type = type;
        }

        public final byte getPriority() {
            return priority;
        }

        public final void setPriority(byte priority) {
            this.priority = priority;
        }

        public final Map<String, Object> getAttachment() {
            return attachment;
        }

        public final void setAttachment(Map<String, Object> attachment) {
            this.attachment = attachment;
        }

        @Override
        public String toString() {
            return "Header[" +
                    "crcCode=" + crcCode +
                    ", length=" + length +
                    ", sessionID=" + sessionID +
                    ", type=" + type +
                    ", priority=" + priority +
                    ", attachment=" + attachment +
                    ']';
        }
    }

}
