package com.example.crypto_server;

import com.example.crypto_server.methods.Caesar;

public class Crypto {

    private String action;
    private String string;
    private String cryptName;
    private String context;

    public Crypto(String action, String string, String cryptName, String context) {
        this.action = action;
        this.string = string;
        this.cryptName = cryptName;
        this.context = context;
    }

    public String getAction() {
        return action;
    }

    public String getString() {
        return string;
    }

    public String getCryptName() {
        return cryptName;
    }

    public String getContext() {
        return context;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void doAction(){
       switch (this.cryptName){
           case("Caesar"):
               caesar(this.string, this.action, this.context);
               break;
       }
    }

    private void caesar(String string, String action, String context){
        Caesar caesar = new Caesar(this);
        if(action.equals("encrypt")){
            caesar.encrypt();
        }else{
            caesar.decrypt();
        }
        this.string = caesar.returnNewString();
    }

}
