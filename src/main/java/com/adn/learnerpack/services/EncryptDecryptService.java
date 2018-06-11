package com.adn.learnerpack.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.adn.learnerpack.utils.PGPUtils;
//import org.bouncycastle.openpgp.PGPPublicKey;
//import org.bouncycastle.openpgp.PGPSecretKey;
import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {


    public boolean encrypt(String inputFileName, String outputFileName, String publicKeyFileName,
                           boolean asciiArmored, boolean integrityCheck) throws Exception {
        FileInputStream keyIn = new FileInputStream(publicKeyFileName);
        FileOutputStream out = new FileOutputStream(outputFileName);
        PGPUtils.encryptFile(out, inputFileName, PGPUtils.readPublicKey(keyIn), asciiArmored, integrityCheck);
        out.close();
        keyIn.close();
        return true;
    }

    public boolean decrypt(String inputFileName, String outputFileName, String secretKeyFileName,
                           String passphrase) throws Exception {
        FileInputStream in = new FileInputStream(inputFileName);
        FileInputStream keyIn = new FileInputStream(secretKeyFileName);
        FileOutputStream out = new FileOutputStream(outputFileName);
        PGPUtils.decryptFile(in, out, keyIn, passphrase.toCharArray());
        in.close();
        out.close();
        keyIn.close();
        return true;
    }

    /*
    public boolean signEncrypt() throws Exception {
        FileOutputStream out = new FileOutputStream(outputFileName);
        FileInputStream publicKeyIn = new FileInputStream(publicKeyFileName);
        FileInputStream secretKeyIn = new FileInputStream(secretKeyFileName);

        PGPPublicKey publicKey = PGPUtils.readPublicKey(publicKeyIn);
        PGPSecretKey secretKey = PGPUtils.readSecretKey(secretKeyIn);

        PGPUtils.signEncryptFile(
                out,
                this.getInputFileName(),
                publicKey,
                secretKey,
                this.getPassphrase(),
                this.isAsciiArmored(),
                this.isIntegrityCheck());

        out.close();
        publicKeyIn.close();
        secretKeyIn.close();

        return true;
    }
    */

}