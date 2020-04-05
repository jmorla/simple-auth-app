package models;

/**
 *
 * @author jmorla
 */
public final class Question {

    private String userId;
    private String qustion;
    private String anwer;
    private int qNo;

    public Question() {
    }

    
    
    public Question(String userId, String qustion, String anwer, int qNo) {
        this.userId = userId;
        this.qustion = qustion;
        this.anwer = anwer;
        this.qNo = qNo;
    }

    public String getUserId() {
        return userId;
    }

    public String getQustion() {
        return qustion;
    }

    public String getAnwer() {
        return anwer;
    }

    public int getqNo() {
        return qNo;
    } 

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setQustion(String qustion) {
        this.qustion = qustion;
    }

    public void setAnwer(String anwer) {
        this.anwer = anwer;
    }

    public void setqNo(int qNo) {
        this.qNo = qNo;
    }

    @Override
    public String toString() {
        return "Question{" + "userId=" + userId + ", qustion=" + qustion + ", anwer=" + anwer + ", qNo=" + qNo + '}';
    }
    
    
}
