public class RSA {

    public long prime1;
    public long prime2;
    public long prime_d;
    public int e = 17;
    private long phi;
    public long n;

    //public key
    public RSA(int e, int n) {
        this.e = e;
        this.n = n;
    }

    public void compute_Prime(){
        prime1 = 2;
        long temp = 2;
        while (temp > 0){
            prime1++;
            if (isPrime((int) prime1)){
                temp = n%prime1;
                if (temp ==0){
                    prime2 = n/prime1;
                }
            }
        }
    }

    //private key
    public void prime(){
        phi = (prime1-1)*(prime2-1);
        int temp = 40%7;
        int i = 0;
        while (temp > 0){
            i++;
            temp = (int) ((e*i-1)%phi);
        }
        prime_d = i;
    }

    private boolean isPrime(int n){
        for (int i = 2; i < Math.pow(n,0.5); i++) {
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    public long RSA(long p,int e, long n){
        long x = 1, y = p;
        while (e >0){
            if (e%2 == 1){
                x = (x*y)%n;
            }
            y = (y*y)%n;
            e /= 2;
        }
        return x;
    }

    public long deRSA(long c){
        long x = 1, y = c;
        while (prime_d >0){
            if (prime_d%2 == 1){
                x = (x*y)%n;
            }
            y = (y*y)%n;
            prime_d /= 2;
        }
        return x;
    }
}
