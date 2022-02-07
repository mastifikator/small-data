package com.n1k0.smalldata.kafkarestproducer.models;

public class Sms {
    private String callerNumber;
    private String responderNumber;
    private String messageText;
    private String callDate;
    private String callTime;

    public Sms(){
    }

    public Sms(String callerNumber, String responderNumber, String messageText, String callDate, String callTime) {
        this.callerNumber = callerNumber;
        this.responderNumber = responderNumber;
        this.messageText = messageText;
        this.callDate = callDate;
        this.callTime = callTime;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public String getResponderNumber() {
        return responderNumber;
    }

    public void setResponderNumber(String responderNumber) {
        this.responderNumber = responderNumber;
    }

    public String getCallDate() {
        return callDate;
    }

    public void setCallDate(String callDate) {
        this.callDate = callDate;
    }

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "the subscriber " + callerNumber +
                " send message " + messageText +
                " to " + responderNumber +
                " on " + callDate +
                " at " + callTime;
    }
}
