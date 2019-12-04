import java.util.ArrayList;
import java.util.List;

public class CipherMove {
    private int[] key = new int[]{3, 1, 4, 5, 2};
    private int constance = 'A';

    public void encrypt(String input){
        input = input.replaceAll("\\s+","");
        int count = input.length()/key.length;
        if (input.length()%key.length != 0){
            int i = 0;
            while (i < input.length()%key.length){
                input += 'z';
            }
        }
        String[][] plainText = new String[key.length][input.length()/key.length];
        for (int i = 0; i < key.length*(count+1); i++) {
            for (int j = 0; j < input.length() / key.length; j++) {
                plainText[i][j] = String.valueOf(input.charAt(key.length*i + j));
            }
        }
        String[][] cipherText = new String[key.length*(count+1)][input.length()/key.length];
        int temp = 1;
        int k = 0;
        while (temp*key.length <= input.length()) {
            for (int i = 0; i < key.length; i++) {
                for (int j = 0; j < input.length() / key.length; j++) {
                    if (i == 0){
                        cipherText[i][j] = plainText[i][key[j]];
                    }
                }
            }
            temp++;
            k++;
        }
    }

   private int[] encryptMessage(String[] input)
    {
        int[] cipher = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            cipher[i] = Integer.parseInt(input[i]);
        }
        return cipher;
    }

    private void swap(String[][] a,String[][] b){

    }
}
