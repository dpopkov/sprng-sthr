package learn.sprng.sthr.c14e01springdatajdbc.controller;

import java.math.BigDecimal;

public class TransferRequest {
    private Integer senderId;
    private Integer receiverId;
    private BigDecimal amount;

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
