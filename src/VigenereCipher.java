import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VigenereCipher {

    private List<Integer> key = new ArrayList<>();
    private List<Integer> keys = new ArrayList<>();
    private List<Boolean> pos = new ArrayList<>();
    private int singleKey;
    private int constance = 'A' + 32;

    public String encryptSingleKey(String input,List<Integer> key){
        String msg = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                msg = msg + (char)((input.charAt(i) - constance + key.get(i)) % 26 + 'A');
                if (input.charAt(i) - constance + key.get(i) > 26){
                    pos.add(true);
                }
                pos.add(false);
            }
        }
        return msg;
    }

    public String encryptMultiKey(String input){
        String msg = "";
        for (int i = 0; i < input.length(); i++) {
            msg = msg + (char)(
                    (input.charAt(i) - constance + keys.get(i % keys.size())) % 26 + 'A');
        }
        return msg;
    }

    public String decryptSingleKey(String cipher){
        String msg = "";
        for (int i = 0; i < cipher.length(); i++) {
             msg = msg + (char)((cipher.charAt(i) - 'A' - key.get(i)+26)%26 + constance);
        }
        return msg;
    }

    public String decryptMulKeys(String cipher){
        String msg = "";
        for (int i = 0; i < cipher.length(); i++) {
             msg = msg + (char)((cipher.charAt(i) - 'A' - keys.get(i % keys.size()) + 26)%26 + constance);
        }
        return msg;
    }

    public List<Integer> createMultiKey(int size){
        for (int i = 0; i < size; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("pls insert key: ");
            keys.add(scanner.nextInt());
        }
        return keys;
    }

    public List<Integer> createSingleKey(String input){
        for (int i = 0; i < input.length() -1; i++) {
            if (i == 0){
                key.add(singleKey);
            }
            if (input.charAt(i) == ' ') continue;
            key.add(input.charAt(i) - constance);
        }
        return key;
    }

    public List<Integer> getKey() {
        return key;
    }

    public void setKey(List<Integer> key) {
        this.key = key;
    }

    public int getSingleKey() {
        return singleKey;
    }

    public void setSingleKey(int singleKey) {
        this.singleKey = singleKey;
    }
}
