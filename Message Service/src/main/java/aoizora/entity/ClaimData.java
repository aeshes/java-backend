package aoizora.entity;

import java.io.Serializable;

public class ClaimData implements Serializable {

    private String claimUid;

    public String getClaimUid() {
        return claimUid;
    }

    public void setClaimUid(String claimUid) {
        this.claimUid = claimUid;
    }

    @Override
    public String toString() {
        return "ClaimData{" +
                "claimUid='" + claimUid + '\'' +
                '}';
    }
}
