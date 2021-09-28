package com.board.domain;

import java.util.Date;

public class ReplyVO {
    /*
    CREATE TABLE tbl_reply(
        rno         int             NOT NULL AUTO_INCREMENT
        bno         int             NOT NULL,
        writer      varchar(30)     NOT NULL,
        content     text            NOT NULL,
        regDate     timestamp       NOT NULL default now(),
        PRIMARY KEY(rno, bno),
        FOREIGN KEY(bno)            REFERENCES tbl_board(bno)
    );
     */

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    private int rno;
    private int bno;
    private String writer;
    private String content;
    private Date regDate;
}
