package com.n1k0.smalldata.kafkaperiodicproducer.models;

public class Call {
    private String callerNumber;
    private String responderNumber;
    private String callDate;
    private String callTime;

    public Call(){
    }

    public Call(String callerNumber, String responderNumber, String callDate, String callTime) {
        this.callerNumber = callerNumber;
        this.responderNumber = responderNumber;
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

    @Override
    public String toString() {
        return "the subscriber " + callerNumber +
                " calls " + responderNumber +
                " on " + callDate +
                " at " + callTime;
    }
}
