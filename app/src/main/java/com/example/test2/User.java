package com.example.test2;

public class User {
    String buttonarista;
    String buttonxamilo;
    String Buttonipsilo;
    String Buttonmetrio;

    public User() {

    }


    public User(String buttonarista, String buttonxamilo, String Buttonipsilo, String Buttonmetrio) {
this.buttonarista=buttonarista;
this.Buttonipsilo=Buttonipsilo;
this.Buttonmetrio=Buttonmetrio;
this.buttonxamilo=buttonxamilo;
    }

    public String getButtonarista() {
        return buttonarista;
    }

    public void setButtonarista(String buttonarista) {
        this.buttonarista = buttonarista;
    }

    public String getButtonxamilo() {
        return buttonxamilo;
    }

    public void setButtonxamilo(String buttonxamilo) {
        this.buttonxamilo = buttonxamilo;
    }

    public String getButtonipsilo() {
        return Buttonipsilo;
    }

    public void setButtonipsilo(String buttonipsilo) {
        Buttonipsilo = buttonipsilo;
    }

    public String getButtonmetrio() {
        return Buttonmetrio;
    }

    public void setButtonmetrio(String buttonmetrio) {
        Buttonmetrio = buttonmetrio;
    }
}
