package learn.sprng.sthr.c13e01transactional.controllers;

import java.math.BigDecimal;

public class TransferRequestDto {

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
