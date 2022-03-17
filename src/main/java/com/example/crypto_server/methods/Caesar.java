package com.example.crypto_server.methods;

import com.example.crypto_server.Crypto;

public class Caesar {

    private static final String capitalLetterRus = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String smallLetterRus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String capitalLetterEng = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String smallLetterEng = "abcdefghijklmnopqrstuvwxyz";

    Crypto crypto;

    public Caesar(Crypto crypto){
        this.crypto = crypto;
    }

    public void encrypt(){
        if(smallLetterRus.indexOf(crypto.getString().charAt(0)) != -1){
            rusAlgEnc(crypto.getString(), Integer.parseInt(crypto.getContext()));
        }else{
            engAlgEnc(crypto.getString(), Integer.parseInt(crypto.getContext()));
        }
    }

    public void decrypt(){
        if(smallLetterRus.indexOf(crypto.getString().charAt(0)) != -1){
            rusAlgDec(crypto.getString(), Integer.parseInt(crypto.getContext()));
        }else{
            engAlgDec(crypto.getString(), Integer.parseInt(crypto.getContext()));
        }
    }

    public String returnNewString(){
        return crypto.getString();
    }

    void rusAlgEnc(String str, int key){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(smallLetterRus.indexOf(str.charAt(i)) == -1){
                result.append(str.charAt(i));
            }else{
                if(smallLetterRus.indexOf(str.charAt(i)) + key < smallLetterRus.length()){
                    result.append(smallLetterRus.charAt(smallLetterRus.indexOf(str.charAt(i)) + key));
                }else{
                    result.append(smallLetterRus.charAt(smallLetterRus.indexOf(str.charAt(i)) + key - smallLetterRus.length()));
                }
            }
        }
        crypto.setString(result.toString());
    }

    void engAlgEnc(String str, int key){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(smallLetterEng.indexOf(str.charAt(i)) == -1){
                result.append(str.charAt(i));
            }else{
                if(smallLetterEng.indexOf(str.charAt(i)) + key < smallLetterEng.length()){
                    result.append(smallLetterEng.charAt(smallLetterEng.indexOf(str.charAt(i)) + key));
                }else{
                    result.append(smallLetterEng.charAt(smallLetterEng.indexOf(str.charAt(i)) + key - smallLetterEng.length()));
                }
            }
        }
        crypto.setString(result.toString());
    }

    void rusAlgDec(String str, int key){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(smallLetterRus.indexOf(str.charAt(i)) == -1){
                result.append(str.charAt(i));
            }else{
                if(smallLetterRus.indexOf(str.charAt(i)) - key >= 0){
                    result.append(smallLetterRus.charAt(smallLetterRus.indexOf(str.charAt(i)) - key));
                }else{
                    result.append(smallLetterRus.charAt( smallLetterRus.length() + (smallLetterRus.indexOf(str.charAt(i)) - key)));
                }
            }
        }
        crypto.setString(result.toString());
    }

    void engAlgDec(String str, int key){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(smallLetterEng.indexOf(str.charAt(i)) == -1){
                result.append(str.charAt(i));
            }else{
                if(smallLetterEng.indexOf(str.charAt(i)) - key >= 0){
                    result.append(smallLetterEng.charAt(smallLetterEng.indexOf(str.charAt(i)) - key));
                }else{
                    result.append(smallLetterEng.charAt( smallLetterEng.length() + (smallLetterEng.indexOf(str.charAt(i)) - key)));
                }
            }
        }
        crypto.setString(result.toString());
    }
}
