package Backpack;

import java.util.Date;

public class Discussion {
    private final String commenterName;
    private final String addedComment;
    private final String commentTime;
    Discussion(String commenterName, String addedComment){
        this.commenterName = commenterName;
        this.addedComment = addedComment;
        this.commentTime = getTime();
    }

    // function to get the time of comment
    public static String getTime(){
        return new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
    }

    void displayComment(){
        System.out.println(addedComment+" ---- "+commenterName);
        System.out.println(commentTime);
    }
}
