package com.beta.replyservice.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import static java.security.MessageDigest.getInstance;
import static java.util.Objects.nonNull;

@Service
public class ReplyService{


    public String operation(String message) {

       // String str1 = "12-kbzw9ru";
        String[] arrOfStr = message.split("-");
        char[] charArr = arrOfStr[0].toCharArray();
        String result = doOperation(charArr, arrOfStr[1]);
        System.out.println("Resultttt: "+result);


        return result;

    }
    public static String doOperation(char[] operationArr, String value){
        String finalResult = value;
        for (char operationChar :operationArr) {
            int operation = parseInt(valueOf(operationChar));
            System.out.println("for loop: "+operation);
            switch (operation){
                case 1:
                    System.out.println("1st operation: "+operation);
                    finalResult = getReverseString(finalResult);
                    break;
                case 2:
                    System.out.println("2st operation: "+operation);
                    finalResult = applyAlgo(finalResult);
                    break;
            }
        }
        return finalResult;
    }

    public static String getReverseString(String value){
        char ch[]=value.toCharArray();
        String result="";
        for(int i=ch.length-1;i>=0;i--){
            result+=ch[i];
        }
        return result;
    }

    public static String applyAlgo(String value){
        if(nonNull(value)){
            try {
                // Static getInstance method is called with hashing MD5
                MessageDigest md = getInstance("MD5");
                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest(value.getBytes());
                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);
                // Convert message digest into hex value
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return hashtext;
            }catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}