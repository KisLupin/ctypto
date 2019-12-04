import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

//        Affine
        //so  nguyen to cung nhau voi 26 so a
//        AffineCiphers affineCiphers = new AffineCiphers(3,2);
//        String input = "la la la ";
//        System.out.println(affineCiphers.encryptMessage(input));
//        String cipher = affineCiphers.encryptMessage(input);
//        System.out.println(affineCiphers.decryptCipher(cipher));

        //Virgener
//        VigenereCipher vigenereCipher = new VigenereCipher();
//        List<Integer> key = new ArrayList<>();
//        vigenereCipher.createMultiKey(4);
//        String input = "meetmeetsunset";
//        String cipher = vigenereCipher.encryptMultiKey(input);
//        System.out.println(cipher);
//        System.out.println(vigenereCipher.decryptMulKeys(cipher));

//        String input = "attack is today";
//        input = input.replaceAll("\\s+","");
//        vigenereCipher.setSingleKey(12);
//        List<Integer> key = vigenereCipher.createSingleKey(input);
//        String cipher = vigenereCipher.encryptSingleKey(input,key);
//        System.out.println(cipher);
//        System.out.println(vigenereCipher.decryptSingleKey(cipher));

        //Ceasar
//        String input = "MY NAME IS LINH";
//        CeasarCipher ceasarCipher = new CeasarCipher(3);
//        input = ceasarCipher.encrypt(input);
//        System.out.println("encrypt:   "+input);
//        input = ceasarCipher.decrypt(input);
//        System.out.println("decrypt:   "+input);
//        System.out.println("hello world");

        //HillCipher

//        CipherMove cipherMove = new CipherMove();
//        String input = "enemy attack tonight";
//        String[] cipher = new String[input.length()-2];
//        cipherMove.encrypt(input);
//        for (int i = 0; i < cipher.length; i++) {
//            System.out.print(cipher[i]);
//        }
//        String[] a = new String[10];
//        a[3] = "a";
//        a[0] = "b";
//        System.out.println(a[0]);
//        System.out.println(a[3]);
//        DES des = new DES();
//        String pt, key;
//
//        pt= "123456ABCD132536";
//        key = "AABB09182736CCDD";
//        //Key Generation
//
//        //Hex to binary
//        key= des.hex2bin(key);
//
//        //Parity bit drop table size=56
//        int[] keyp=
//        {    57,49,41,33,25,17,9,
//                1,58,50,42,34,26,18,
//                10,2,59,51,43,35,27,
//                19,11,3,60,52,44,36,
//                63,55,47,39,31,23,15,
//                7,62,54,46,38,30,22,
//                14,6,61,53,45,37,29,
//                21,13,5,28,20,12,4
//        };
//
//        //getting 56 bit key from 64 bit using the parity bits
//        key= des.permute(key, keyp, 56);// key without parity
//
//        //Number of bit shifts size =16
//        int[] shift_table=
//        {    1, 1, 2, 2,
//                2, 2, 2, 2,
//                1, 2, 2, 2,
//                2, 2, 2, 1
//        };
//
//        //Key- Compression Table size 48
//        int[] key_comp=
//        {    14,17,11,24,1,5,
//                3,28,15,6,21,10,
//                23,19,12,4,26,8,
//                16,7,27,20,13,2,
//                41,52,31,37,47,55,
//                30,40,51,45,33,48,
//                44,49,39,56,34,53,
//                46,42,50,36,29,32
//        };
//
//        //Splitting
//        String left= key.substring(0, 28);
//        String right= key.substring(28, 56);
//
//        Vector<String> rkb = new Vector<>();//rkb for RoundKeys in binary
//        Vector<String> rk = new Vector<>();//rk for RoundKeys in hexadecimal
//        for(int i=0; i<16; i++){
//            //Shifting
//            left= des.shift_left(left, shift_table[i]);
//            right= des.shift_left(right, shift_table[i]);
//
//            //Combining
//            String combine= left + right;
//
//            //Key Compression
//            String RoundKey= des.permute(combine, key_comp, 48);
//
//            rkb.add(RoundKey);
//            rk.add(des.bin2hex(RoundKey));
//        }
//        System.out.println("\nEncryption:\n\n");
//        String cipher= des.encrypt(pt, rkb, rk);
//        System.out.println("\nCipher Text: " +cipher);
//        System.out.println("\nDecryption\n\n");
//        des.reverse(rkb);
//        des.reverse(rk);
//        String text= des.encrypt(cipher, rkb, rk);
//        System.out.println("\nPlain Text: "+text);
        int[][] cipherkey =
                {
                        {0x24, 0x34, 0x31, 0x13},
                        {0x75, 0x75, 0xe2, 0xaa},
                        {0xa2, 0x56, 0x12, 0x54},
                        {0xb3, 0x88, 0x00, 0x87}
                };
        List<int[][]> roundkey = new ArrayList<>();

        int[][] state = {
                {0x00, 0x12, 0x0c, 0x08},
                {0x04, 0x04, 0x00, 0x23},
                {0x12, 0x12, 0x13, 0x19},
                {0x14, 0x00, 0x11, 0x19}
        };

//        int[][] mixCol = {
//                {0x63,0xc9,0xfe,0x30},
//                {0xf2,0x63,0x26,0xf2},
//                {0x7d,0xd4,0xc9,0xc9},
//                {0xd4,0xfa,0x63,0x82}
//        };
        int[][] mixCol = {
                {0x63,0xc9,0xfe,0x30},
                {0xf2,0x63,0x26,0xf2},
                {0x7d,0xd4,0xc9,0xc9},
                {0xd4,0xfa,0x63,0x82}
        };
        AES aes = new AES();
        aes.KeyExpansion(roundkey, cipherkey);
//        aes.AddRoundKey(state,roundkey.get(0));
//        aes.Cipher(state, roundkey, cipherkey);
//        aes.decryto(state,roundkey);
        print(mixCol);
    }
    static void print(int[][] state){
        for (int i = 0; i < 4; i++) {
            System.out.print(Integer.toHexString(state[i][0])+" "+Integer.toHexString(state[i][1])+" "+Integer.toHexString(state[i][2])+" "+Integer.toHexString(state[i][3]));
            System.out.println();
        }
    }
}

