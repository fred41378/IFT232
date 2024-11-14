package labo5;


import labo5.celebrities.Sujet;

public class Message {
    private String message;
    private Sujet sujet;
    public Message(String message, Sujet sujet) {
        this.message = message;
        this.sujet = sujet;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public Sujet getSujet(){
        return sujet;
    }
}
