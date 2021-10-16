package Backpack;

import java.util.Date;

public class Discussion {
    private String commenterName;
    private String addedComment;
    private String commentDate;
    Discussion(String commenterName, String addedComment){
        this.commenterName = commenterName;
        this.addedComment = addedComment;
        this.commentDate= getTime();
    }

    // function to get the time of comment
    public static String getTime(){
        return new java.text.SimpleDateFormat("MM/dd/yyyy h:mm:ss a").format(new Date());
    }
}
