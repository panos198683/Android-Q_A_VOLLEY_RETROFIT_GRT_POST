package com.example.test2;

public class Comp {
    private String id;
    private int Bgroup;
    private String BranchArea;
    private  String BranchCity;
    private  String BranchName;
    private String BranchPassword;

    public Comp(String id, int bgroup, String branchArea, String branchCity, String branchName, String branchPassword) {
        this.id = id;
        this.Bgroup = bgroup;
        this.BranchArea = branchArea;
        this.BranchCity = branchCity;
        this.BranchName = branchName;
        this.BranchPassword = branchPassword;
    }
    //public Comp ()
                       // {}
//        public Comp(String id, int bgroup, String branchArea, String branchCity, String branchName, String branchPassword) {
//            this.id = id;
//           this.Bgroup = bgroup;
//            this.BranchArea = branchArea;
//            this.BranchCity = branchCity;
//            this.BranchName = branchName;
//            this.BranchPassword = branchPassword;
//        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBgroup() {
        return Bgroup;
    }

    public void setBgroup(int bgroup) {
        Bgroup = bgroup;
    }

    public String getBranchArea() {
        return BranchArea;
    }

    public void setBranchArea(String branchArea) {
        BranchArea = branchArea;
    }

    public String getBranchCity() {
        return BranchCity;
    }

    public void setBranchCity(String branchCity) {
        BranchCity = branchCity;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchPassword() {
        return BranchPassword;
    }

    public void setBranchPassword(String branchPassword) {
        BranchPassword = branchPassword;
    }

//    @Override
//    public String toString() {
//        return "Comp{" +
//                "Bgroup=" + Bgroup +
//                '}';
//    }
}
