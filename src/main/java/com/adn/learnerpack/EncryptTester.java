package com.adn.learnerpack;

import com.adn.learnerpack.services.EncryptDecryptService;

public class EncryptTester {

    private static final String PASSPHRASE = "abcde12345";

    private static final String DE_INPUT = "src/test/x.pgp";
    private static final String DE_OUTPUT = "src/test/z.txt";
    private static final String DE_KEY_FILE = "src/test/secring.sk.gpg";

    private static final String E_INPUT = "src/test/x.txt";
    private static final String E_OUTPUT = "src/test/x.pgp";
    private static final String E_KEY_FILE = "src/test/pubring.pkr.asc";


    public static void testDecrypt() throws Exception {
        EncryptDecryptService p = new EncryptDecryptService();
        p.setInputFileName(DE_INPUT);
        p.setOutputFileName(DE_OUTPUT);
        p.setPassphrase(PASSPHRASE);
        p.setSecretKeyFileName(DE_KEY_FILE);
        System.out.println("Decryption: " + p.decrypt());
    }

    public static void testEncrypt() throws Exception {
        EncryptDecryptService p = new EncryptDecryptService();
        p.setInputFileName(E_INPUT);
        p.setOutputFileName(E_OUTPUT);
        p.setPassphrase(PASSPHRASE);
        p.setPublicKeyFileName(E_KEY_FILE);
        p.setAsciiArmored(true);
        System.out.println("Encryption: " + p.encrypt());
    }
}