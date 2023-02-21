package com.project.BirthdayPostbox.entity;

public class Present {

    private String presentId;
    private String roomId;
    private String presentSender;
    private String presentContent;
    private String presentImgUrl;

    public Present(String presentId, String roomId, String presentSender, String presentContent, String presentImgUrl) {
        this.presentId = presentId;
        this.roomId = roomId;
        this.presentSender = presentSender;
        this.presentContent = presentContent;
        this.presentImgUrl = presentImgUrl;
    }

    public String getPresentId() {
        return presentId;
    }

    public void setPresentId(String presentId) {
        this.presentId = presentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getPresentSender() {
        return presentSender;
    }

    public void setPresentSender(String presentSender) {
        this.presentSender = presentSender;
    }

    public String getPresentContent() {
        return presentContent;
    }

    public void setPresentContent(String presentContent) {
        this.presentContent = presentContent;
    }

    public String getPresentImgUrl() {
        return presentImgUrl;
    }

    public void setPresentImgUrl(String presentImgUrl) {
        this.presentImgUrl = presentImgUrl;
    }
}
