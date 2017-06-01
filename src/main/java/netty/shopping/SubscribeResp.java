package netty.shopping;

import java.io.Serializable;

/**
 * @author <a href="mailto:chun.wang@datatist.com">Jonas Wang</a>
 * @date 2017-05-08 11:04
 */
public class SubscribeResp implements Serializable {

    private static final long serialVersionUID = -1462309981675314674L;

    private int sebReqId;
    private int respCode;
    private String desc;

    public int getSebReqId() {
        return sebReqId;
    }

    public void setSebReqId(int sebReqId) {
        this.sebReqId = sebReqId;
    }

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubscribeResp{" +
                "sebReqId=" + sebReqId +
                ", respCode=" + respCode +
                ", desc='" + desc + '\'' +
                '}';
    }
}
