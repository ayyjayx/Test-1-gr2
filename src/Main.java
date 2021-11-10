import java.util.*;
import java.lang.StringBuffer;
import static java.lang.Character.toUpperCase;

public class Main {

    public static void showPrimes(int[] list) {
        {
            int i, j;
            String primes = "";

            for (i = 0; i < list.length; i++)
            {
                int counter = 0;
                for(j = list[i]; j >= 1; j--)
                {
                    if(list[i] % j == 0)
                        counter = counter + 1;
                }
                if (counter == 2)
                    primes = primes + list[i] + " ";
            }
            System.out.println(primes);
        }
    }

    public static String modify(String str) {
        StringBuffer sb = new StringBuffer();
        StringBuffer ch = new StringBuffer();
        sb.append(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.length() % 2 == 0) {
                if (i == sb.length() / 2 - 1 || i == sb.length() / 2) {
                    ch.append(toUpperCase(sb.charAt(i)));
                } else
                    ch.append(sb.charAt(i));
            }
            else{
                ch.append(sb.charAt(i));
            }
        }
        return ch.toString();
    }

    public static void generuj(int[] tab, int n, int minWartosc, int maxWartosc) {
        Random r = new Random();
        if (n > 0 && n < 101) {
            assert true;
        } else {
            throw new RuntimeException("Podana została zla ilosc liczb w tablicy");
        }
        for (int i = 0; i < n; i++) {
            tab[i] = r.nextInt(maxWartosc - minWartosc) + minWartosc;
        }
    }

    public static int ileNajczestszych (int tab[], int n){
        int mod = 0, modCount = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(tab[j]==tab[i]){
                    modCount+=1;
                }
            }
            if (modCount>mod){
                mod = modCount;
            }
            modCount = 0;
        }
        return mod;
    }

    public static void main(String[] args) {
        //1
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj ilosc liczb w ciagu: ");
        int n = in.nextInt();
        int[] list = new int[n];
        System.out.println("Podaj liczby: ");
        for (int i = 0; i < n; i++)
            list[i] = in.nextInt();
        showPrimes(list);

        //2
        Scanner scn = new Scanner(System.in);
        System.out.println("Podaj napis: ");
        String s = scn.next();
        System.out.println(modify(s));

        //3
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj ilosc liczb w tablicy: ");
        int n2 = scan.nextInt();
        int[] tab = new int[n2];
        generuj(tab, n2, -50, 50);
        System.out.println("tab: " + Arrays.toString(tab));
        System.out.print("\nNajczęstszy element występuje " + ileNajczestszych(tab, n) + " razy.\n");
        }
    }
    