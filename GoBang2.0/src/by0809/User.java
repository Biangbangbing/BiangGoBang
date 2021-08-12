package by0809;

import java.util.ArrayList;

public class User implements BiangGoBangInterface{
    public String username;
    public String password;
    public int score;
    public int battle;
    public int[][] chesses = new int[ROW+1][LINE+1];
    public ArrayList<chessShape> chessIndex = new ArrayList<chessShape>(1000);
    public int countBlack,countWhite,countSum,controlColor;
    public int confirmSave;
    public User(String username,String password,int score,int battle){
        this.username = username;
        this.password = password;
        this.score = score;
        this.battle = battle;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBattle(int battle){
        this.battle = battle;
    }

    public  void setChesses(int[][] chesses,ArrayList<chessShape> chessIndex,int countBlack,int countWhite,int countSum,int controlColor,int confirmSave){
        this.chesses = chesses;
        this.chessIndex =chessIndex;
        this.countBlack = countBlack;
        this.countWhite = countWhite;
        this.countSum = countSum;
        this.controlColor = controlColor;
        this.confirmSave = confirmSave;
    }

    public int getConfirmSave() {
        return confirmSave;
    }
}
