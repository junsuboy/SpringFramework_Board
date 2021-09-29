package com.board.domain;

import java.util.Date;

public class UserVO {
    private int IDX;
    private String ID;
    private String EMAIL;
    private String NAME;
    private String PASSWORD;
    private int GRADE;
    private Date REGDATE;

    //비밀번호 확인
    public boolean matchPassword(String pw) {
        return this.PASSWORD.equals(pw);
    }

    public int getIDX() {
        return IDX;
    }

    public void setIDX(int IDX) {
        this.IDX = IDX;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public int getGRADE() {
        return GRADE;
    }

    public void setGRADE(int GRADE) {
        this.GRADE = GRADE;
    }

    public Date getREGDATE() {
        return REGDATE;
    }

    public void setREGDATE(Date REGDATE) {
        this.REGDATE = REGDATE;
    }

}
