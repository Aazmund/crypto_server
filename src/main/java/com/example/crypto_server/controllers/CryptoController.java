package com.example.crypto_server.controllers;

import com.example.crypto_server.Crypto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO http://localhost:8080/crypto?action=qwerty&string=qqqqqqq&cryptName=12&context=qqq

@RestController
public class CryptoController {
    @RequestMapping("/crypto")
    public Crypto crypto(@RequestParam(value = "action", required = false, defaultValue = "empty") String action,
                         @RequestParam(value = "string", required = false, defaultValue = "empty") String string,
                         @RequestParam(value = "cryptName", required = false, defaultValue = "0") String cryptName,
                         @RequestParam(value = "context", required = false, defaultValue = "empty") String context){

        Crypto crypto = new Crypto(action, string, cryptName, context);
        crypto.doAction();

        return crypto;
    }
}
