package com.cocoa.encrypt.rsa;

import java.security.*;
import java.util.Base64;

public class RsaTest1 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("rsa");
        keyPairGen.initialize(1024);

        KeyPair keyPair = keyPairGen.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();


        //
        System.out.println("=====publicKey.getEncoded()===");

        byte[] privateBytes = privateKey.getEncoded();
        byte[] publicBytes = publicKey.getEncoded();


        System.out.println(new String(Base64.getEncoder().encode(privateBytes)));
        System.out.println(new String(Base64.getEncoder().encode(publicBytes)));



        System.out.println("===============other msg======");
        System.out.println(privateKey);
        System.out.println(privateKey.getFormat());
        System.out.println(new String(privateKey.getEncoded()));

        System.out.println("-------------");
        System.out.println(publicKey.getEncoded());



    }

}
