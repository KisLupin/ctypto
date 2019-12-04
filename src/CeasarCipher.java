public class CeasarCipher {
    private int key;
    private int constance = 'A';
    public CeasarCipher(int key) {
        this.key = key;
    }

    public String encrypt(String input){
        String msg = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                msg = msg + (char)((input.charAt(i) - constance + key)%26 + 'A');
            }
            else msg = msg + input.charAt(i);
        }
        return msg;
    }

    public String decrypt(String cipher){
        String msg = "";
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) != ' '){
                msg = msg + (char)((cipher.charAt(i) - constance - key + 26)%26 + 'A');
            }
            else msg = msg + cipher.charAt(i);
        }
        return msg;
    }
}
