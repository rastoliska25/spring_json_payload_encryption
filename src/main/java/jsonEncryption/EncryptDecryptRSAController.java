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
        EncryptionDecryption.encryptMessages(messagesToEncrypt);
        Logger.logger.info(String.valueOf(HttpStatus.OK));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/decrypts")
    public List<String> decryptMessages() {
        return EncryptionDecryption.decryptMessages();
    }

    //collections test
    @PostMapping("/statue/publishStatues")
    public List<Statue> statues(@RequestBody List<Statue> statues) {
        return EncryptionDecryption.statues(statues);
    }



    //mongodb test
    private final UserRepository userRepository;


    public EncryptDecryptRSAController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/insertUser")
    public ResponseEntity add(@RequestBody User user) { //vytiahne Body do objektu
        userRepository.findUserByName(user.getName())
                .ifPresentOrElse(u -> {
                    System.out.println(u + "uz existuje");
                }, ()-> {
                    System.out.println("vklada sa user " + user);
                    userRepository.insert(user);
                });

        return new ResponseEntity<>(HttpStatus.CREATED);
    }





}
