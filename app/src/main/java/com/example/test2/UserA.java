package com.example.test2;

public class UserA {
    private String Id;
    private String BranchId;
    private int Vhappy;
    private int Happy;
    private int NotHappy;
    private int Bad;
    private int An1;
    private int An2;
    private int An3;
    private int An4;
    private int An5;
    private String Text;
    private int time;

    public UserA(String branchId, int vhappy, int happy, int notHappy, int bad, int an1, int an2, int an3, int an4, int an5, String text, int time) {
        this.BranchId = branchId;
        this.Vhappy = vhappy;
        this.Happy = happy;
        this.NotHappy = notHappy;
        this.Bad = bad;
        this.An1 = an1;
        this.An2 = an2;
        this.An3 = an3;
        this.An4 = an4;
        this.An5 = an5;
        this.Text = text;
        this.time = time;
    }

    public String getBranchId() {
        return BranchId;
    }

    public void setBranchId(String branchId) {
        BranchId = branchId;
    }

    public int getVhappy() {
        return Vhappy;
    }

    public void setVhappy(int vhappy) {
        Vhappy = vhappy;
    }

    public int getHappy() {
        return Happy;
    }

    public void setHappy(int happy) {
        Happy = happy;
    }

    public int getNotHappy() {
        return NotHappy;
    }

    public void setNotHappy(int notHappy) {
        NotHappy = notHappy;
    }

    public int getBad() {
        return Bad;
    }

    public void setBad(int bad) {
        Bad = bad;
    }

    public int getAn1() {
        return An1;
    }

    public void setAn1(int an1) {
        An1 = an1;
    }

    public int getAn2() {
        return An2;
    }

    public void setAn2(int an2) {
        An2 = an2;
    }

    public int getAn3() {
        return An3;
    }

    public void setAn3(int an3) {
        An3 = an3;
    }

    public int getAn4() {
        return An4;
    }

    public void setAn4(int an4) {
        An4 = an4;
    }

    public int getAn5() {
        return An5;
    }

    public void setAn5(int an5) {
        An5 = an5;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getId() {
        return Id;
    }
}
