package jsonEncryption;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.*;
import javax.crypto.Cipher;

import org.springframework.stereotype.Service;

@Service
public class EncryptDecryptService {

    public static Map<String, Object> keyMap = new HashMap<>();

    public void createKeys() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();
            keyMap.put("publicKey", publicKey);
            keyMap.put("privateKey", privateKey);
            System.out.println(publicKey);
            System.out.println(privateKey);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encryptMessage(String plainText) {

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PublicKey publicKey = (PublicKey) keyMap.get("publicKey");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encrypt = cipher.doFinal(plainText.getBytes());
            System.out.println(Base64.getEncoder().encodeToString(encrypt));
            return new String(Base64.getEncoder().encodeToString(encrypt));
        } catch (Exception ignored) {

        }
        return "";
    }

    public String decryptMessage(String encryptedMessgae) {

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
            PrivateKey privateKey = (PrivateKey) keyMap.get("privateKey");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(encryptedMessgae));
            return new String(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //multiple messages
    List<String> nezakodovaneMessages = new ArrayList<>();
    List<String> zakodovaneMessages = new ArrayList<>();
    List<String> odkodovaneMessages = new ArrayList<>();

    public void encryptMessages(List<User> messagesToEncrypt) {
        long startTime = System.nanoTime();
        nezakodovaneMessages.clear();
        zakodovaneMessages.clear();
        odkodovaneMessages.clear();
        messagesToEncrypt.forEach(messageToEncrypt -> {
            nezakodovaneMessages.add(messageToEncrypt.getName());
            System.out.println(messageToEncrypt.getName());
        });

        nezakodovaneMessages.forEach(message -> {
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
                PublicKey publicKey = (PublicKey) keyMap.get("publicKey");
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                byte[] encrypt = cipher.doFinal(message.getBytes());
                System.out.println(Base64.getEncoder().encodeToString(encrypt));
                zakodovaneMessages.add(Base64.getEncoder().encodeToString(encrypt));
            } catch (Exception ignored) {

            }
        });
        long stopTime = System.nanoTime();
        Logger.logger.info("appinfo,{},{}", +nezakodovaneMessages.size(), (stopTime - startTime));

    }

    public List<String> decryptMessages() {

        zakodovaneMessages.forEach(message -> {

            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
                PrivateKey privateKey = (PrivateKey) keyMap.get("privateKey");
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(message));
                odkodovaneMessages.add(new String(decrypt));
            } catch (Exception e) {
                e.printStackTrace();
            }

        });
        return odkodovaneMessages;
    }

    public List<Statue> statues(List<Statue> statues) {

        Streams streams = new Streams();
        streams.streams(statues);

        return null;
    }


}
