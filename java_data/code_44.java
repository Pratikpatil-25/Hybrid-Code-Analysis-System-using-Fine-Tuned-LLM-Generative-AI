import javax.crypto.Cipher;

import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;

import java.util.Base64;

import java.util.Scanner;



class des {



    public static void main(String[] args) {

        try {

            
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the text to be encrypted:");

            String originalText = scanner.nextLine();



            
            SecretKey secretKey = generateDESKey();



            
            String encryptedText = encrypt(originalText, secretKey);

            System.out.println("Encrypted Text: " + encryptedText);



            
            String decryptedText = decrypt(encryptedText, secretKey);

            System.out.println("Decrypted Text: " + decryptedText);



        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    private static SecretKey generateDESKey() throws Exception {

        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");

        return keyGenerator.generateKey();

    }



    private static String encrypt(String text, SecretKey secretKey) throws Exception {

        
        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);



        
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());



        
        return Base64.getEncoder().encodeToString(encryptedBytes);

    }



    private static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {

        
        Cipher cipher = Cipher.getInstance("DES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);



        
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);



        
        return new String(decryptedBytes);

    }

}