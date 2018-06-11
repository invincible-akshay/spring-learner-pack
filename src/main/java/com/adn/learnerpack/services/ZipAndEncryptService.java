package com.adn.learnerpack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ZipAndEncryptService {

    @Value("${passphrase}")
    private String passphrase;
    @Value("${pgpPublicKeyFile}")
    private String publicKeyFileName;
    @Value("${pgpPrivateKeyFile}")
    private String secretKeyFileName;
    @Value("${inputFolder}")
    private String inputFolderName;
    @Value("${outputFolder}")
    private String outputFolderName;

    @Autowired
    EncryptDecryptService encryptDecryptService;

    public ZipAndEncryptService() {
        System.out.println("Inside Default Constructor of ZipAndEncryptService.");
    }

    public void encrypt() {
        File dir = new File(inputFolderName);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // Do something with child
                System.out.println("Current file being processed is: " + child);
                String[] components = child.toString().split("\\\\");
                String fileName = components[components.length - 1];
                String outputFileName;
                try {
                    outputFileName = outputFolderName + "\\\\" + fileName + ".gpg";
                    encryptDecryptService.encrypt(child.toString(), outputFileName, publicKeyFileName,
                            true, true);
                    System.out.printf("Encryption successful and output file is: " + outputFileName);
                    fileName = outputFolderName + "\\\\" + fileName + ".txt";
                    System.out.println("Decrypting file: " + fileName);
                    encryptDecryptService.decrypt(outputFileName, fileName, secretKeyFileName, passphrase);
                    System.out.println("Decryption successful and output file is: " + outputFileName);
                } catch (Exception e) {
                    System.out.println("Exception during encryption of file: " + child.toString());
                    e.printStackTrace();
                }
            }
        } else {
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
            System.out.println("Input parameters not getting read correctly.");
        }
        //encryptDecryptService.encrypt(, , , true, false);
    }

}
