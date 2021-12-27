// we have chosen the team DC and CSK and added the mentioned value to the program
import java.util.*;
class Quiz3{
    public static void main(String[] args) {
        MatchTeam DC = new MatchTeam("DC",14,(float) 0.481,20,"LWW");
        MatchTeam CSK = new MatchTeam("CSK",14,(float) 0.455,20,"WWW");
        RRCompare RC = new RRCompare();
        PTSCompare PC = new PTSCompare();
        FormCompare FC = new FormCompare();
        RC.compare(DC, CSK);
        PC.compare(DC, CSK);
        FC.compare(DC, CSK);
    }
}
class MatchTeam{
    private String teamName;
    private int PLD;
    private float RR;
    private int PTS;
    private String Form;
    MatchTeam(String teamName,int PLD,float RR,int PTS,String Form){
        this.teamName=teamName;
        this.PLD=PLD;
        this.RR=RR;
        this.PTS=PTS;
        this.Form=Form;
    }
    public String getTeamName(){
        return teamName;
    }
    public int getPLD(){
        return PLD;
    }
    public float getRR(){
        return RR;
    }
    public int getPTS(){
        return PTS;
    }
    public String getForm(){
        return Form;
    }
}
class RRCompare implements Comparator<MatchTeam>{
    public int compare(MatchTeam a,MatchTeam b){
        if(a.getRR()>b.getRR()){
            System.out.println("Team "+a.getTeamName()+" has higher RR than Team "+b.getTeamName());
            return 1;
        }
        else if(a.getRR()<b.getRR()){
            System.out.println("Team "+b.getTeamName()+" has higher RR than Team "+a.getTeamName());
            return -1;
        }
        else{
            System.out.println("Team "+a.getTeamName()+" has same RR as Team "+b.getTeamName());
            return 0;
        }
    }
}
class PTSCompare implements Comparator<MatchTeam>{
    public int compare(MatchTeam a,MatchTeam b){
        float ratioA = (float)a.getPTS()/(float)a.getPLD();
        float ratioB = (float)b.getPTS()/(float)b.getPLD();
        
        if(ratioA>ratioB){
            System.out.println("Team "+a.getTeamName()+" has higher PTS/PLD than Team "+b.getTeamName());
            return 1;
        }
        else if(ratioA<ratioB){
            System.out.println("Team "+b.getTeamName()+" has higher PTS/PLD than Team "+a.getTeamName());
            return -1;
        }
        else{
            System.out.println("Team "+a.getTeamName()+" has same PTS/PLD as Team "+b.getTeamName());
            return 0;
        }
    }
}
class FormCompare implements Comparator<MatchTeam>{
    public int compare(MatchTeam a,MatchTeam b){
        String team1 = a.getForm();        
        String team2 = b.getForm();
        int tem1W=0,tem2W=0;
        for (int i = 0; i < 3; i++) {
            if(team1.charAt(i)=='W'){
                tem1W++;
            }
            if(team2.charAt(i)=='W'){
                tem2W++;
            }
        }
        if(tem1W>tem2W){
            System.out.println("Team "+a.getTeamName()+" has higher Form than Team "+b.getTeamName());
            return 1;
        }
        else if(tem1W<tem2W){
            System.out.println("Team "+b.getTeamName()+" has higher Form than Team "+a.getTeamName());
            return -1;
        }
        else{
            System.out.println("Team "+a.getTeamName()+" has same Form as Team "+b.getTeamName());
            return 0;
        }
    }
}