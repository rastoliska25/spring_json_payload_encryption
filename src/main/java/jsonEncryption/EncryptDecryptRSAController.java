package jsonEncryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EncryptDecryptRSAController {

    @Autowired

    EncryptDecryptService EncryptionDecryption;

    @PostMapping("/createKeys")
    public void createPrivatePublickey() {
        EncryptionDecryption.createKeys();
    }

    @PostMapping("/encrypt")
    public String encryptMessage(@RequestBody String messageToEncrypt) {
        return EncryptionDecryption.encryptMessage(messageToEncrypt);
    }

    @PostMapping("/decrypt")
    public String decryptMessage(@RequestBody String messageToDecrypt) {
        return EncryptionDecryption.decryptMessage(messageToDecrypt);
    }

    //multiple string test
    @PostMapping("/encrypts")
    public ResponseEntity<String> encryptMessages(@RequestBody List<User> messagesToEncrypt) {
        EncryptionDecryption.encryptMessages();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
