package jsonEncryption.reflexion;

import jsonEncryption.EncryptDecryptService;
import jsonEncryption.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflexion {

    public static void reflect() {

        //reflexia User test
        User user = new User("ferko", "testRola");
        Class<? extends User> userClass = user.getClass();

        PrintInterface printInterface = System.out::println;
        printInterface.print("Class Name: " + userClass.getName());

        List<String> printList = new ArrayList<>();

        String question = "Is User class ";
        printList.add(question + "interface? " + userClass.isInterface());
        printList.add(question + "anonymous class? " + userClass.isAnonymousClass());
        printList.add(question + "enum class? " + userClass.isEnum());
        printList.add(question + "array? " + userClass.isArray());
        printList.add(question + "local class? " + userClass.isLocalClass());

        printList.forEach(System.out::println);

        //konštruktory
        System.out.print("\n Constructors info:");
        Constructor<?>[] userConstructors = userClass.getConstructors();

        for (Constructor<?> constructor : userConstructors) {
            System.out.format("\n\nconstructor name: %s, number of parameters: %d", constructor.getName(), constructor.getParameterCount());

            if (constructor.getParameterCount() > 0) {
                System.out.format("\nparameter/s: %s ", Arrays.toString(constructor.getParameters()));
            } else {
                System.out.print("\nno parameter constructor");
            }
        }

        //reflexia metod z EncryptDecryptService
        EncryptDecryptService encryptDecryptService = new EncryptDecryptService();
        Class<? extends EncryptDecryptService> encryptClass = encryptDecryptService.getClass();

        printInterface.print("\n");
        //metódy
        Method[] encryptMethods = encryptClass.getDeclaredMethods();
        for (Method method : encryptMethods) {
            printInterface.print("Method: " + method.getName() + "      return type: " + method.getReturnType().getName() + "       has varArgs:" + method.isVarArgs());
        }
    }
}
