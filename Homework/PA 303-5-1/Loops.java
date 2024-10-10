import java.util.Scanner;

public class Loops{

    public void PrintTable(){
        for(int i=1; i <= 12; i++){
            for(int j= 1; j <= 12; j++){
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void GreatestCommonDivisor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first Number:");
        int n1 = sc.nextInt();
        System.out.println("Enter the second Number:");
        int n2 = sc.nextInt();

        int gcd = 1;
        int k = 1;

        while(k <= Math.min(n1, n2)){
            if(n1 % k == 0 && n2 % k == 0){
              gcd = k;
            }
            k++;
        }

        System.out.printf("The greatest common divisor of %d and %d is %d ", n1, n2, gcd );

    }

    public static void futureTuition(){
        double tuition = 10000;
        double rate = .7;
        int years = 1;

        while(tuition <= 20000){
            tuition = ((tuition * rate) + tuition);
            years++;
        }

        System.out.printf("it takes %d years for the tuition of $10000.00 to double.",years);
    }

    public static void main(String[] args){



        futureTuition();
    }
}

