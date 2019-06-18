package com.javen.model;

import java.io.Serializable;

/**
 * message_board_info
 * @author 
 */
public class MessageBoardInfo implements Serializable {
    /**
     * 留言id

     */
    private Integer messageInfoId;

    /**
     * 留言标题
     */
    private String messageTittle;

    /**
     * 留言时间
     */
    private String messageDate;

    /**
     * 留言账户
     */
    private String messageAccout;

    /**
     * 留言内容
     */
    private String messageContext;

    /**
     * 留言关键字
     */
    private String messageKey;

    /**
     * 是否有效（0：无效；1：有效）
     */
    private Integer isActive;

    private static final long serialVersionUID = 1L;

    private UsrTable usrTable;

    public Integer getMessageInfoId() {
        return messageInfoId;
    }

    public void setMessageInfoId(Integer messageInfoId) {
        this.messageInfoId = messageInfoId;
    }

    public String getMessageTittle() {
        return messageTittle;
    }

    public void setMessageTittle(String messageTittle) {
        this.messageTittle = messageTittle;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageAccout() {
        return messageAccout;
    }

    public void setMessageAccout(String messageAccout) {
        this.messageAccout = messageAccout;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public UsrTable getUsrTable() {
        return usrTable;
    }

    public void setUsrTable(UsrTable usrTable) {
        this.usrTable = usrTable;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MessageBoardInfo other = (MessageBoardInfo) that;
        return (this.getMessageInfoId() == null ? other.getMessageInfoId() == null : this.getMessageInfoId().equals(other.getMessageInfoId()))
            && (this.getMessageTittle() == null ? other.getMessageTittle() == null : this.getMessageTittle().equals(other.getMessageTittle()))
            && (this.getMessageDate() == null ? other.getMessageDate() == null : this.getMessageDate().equals(other.getMessageDate()))
            && (this.getMessageAccout() == null ? other.getMessageAccout() == null : this.getMessageAccout().equals(other.getMessageAccout()))
            && (this.getMessageContext() == null ? other.getMessageContext() == null : this.getMessageContext().equals(other.getMessageContext()))
            && (this.getMessageKey() == null ? other.getMessageKey() == null : this.getMessageKey().equals(other.getMessageKey()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMessageInfoId() == null) ? 0 : getMessageInfoId().hashCode());
        result = prime * result + ((getMessageTittle() == null) ? 0 : getMessageTittle().hashCode());
        result = prime * result + ((getMessageDate() == null) ? 0 : getMessageDate().hashCode());
        result = prime * result + ((getMessageAccout() == null) ? 0 : getMessageAccout().hashCode());
        result = prime * result + ((getMessageContext() == null) ? 0 : getMessageContext().hashCode());
        result = prime * result + ((getMessageKey() == null) ? 0 : getMessageKey().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", messageInfoId=").append(messageInfoId);
        sb.append(", messageTittle=").append(messageTittle);
        sb.append(", messageDate=").append(messageDate);
        sb.append(", messageAccout=").append(messageAccout);
        sb.append(", messageContext=").append(messageContext);
        sb.append(", messageKey=").append(messageKey);
        sb.append(", isActive=").append(isActive);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        if(usrTable!=null){
            sb.append(", ").append(usrTable.toString());
        }
        sb.append("]");
        return sb.toString();
    }

}