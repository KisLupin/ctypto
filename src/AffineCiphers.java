public class AffineCiphers {
    private int a;
    private int b;
    private int constance = 'A' + 32;
    //Affine Ciphers (a*x + b)
    public AffineCiphers(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String encryptMessage(String msg)
    {
        String cipher = "";
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) != ' ') {
                cipher = cipher + (char)((
                        ((a * (msg.charAt(i) - constance)) + b) % 26) + 'A');
            } else{
                cipher += msg.charAt(i);
            }
        }
        return cipher;
    }

    public String decryptCipher(String cipher)
    {
        String msg = "";
        int key = 0;

        for (int i = 0; i < 26; i++) {
            int flag = (a * i) % 26;
            if (flag == 1){
                key = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) != ' ') {
                msg = msg + (char)((key * (cipher.charAt(i) +'A' - b))%26 + constance);
            }
            else{
                msg += cipher.charAt(i);
            }
        }
        return msg;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
