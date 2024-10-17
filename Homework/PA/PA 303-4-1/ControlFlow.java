import java.util.Scanner;

public class ControlFlow {

    public static void ex1(){
        int x = 7;
        if(x < 10){
            System.out.println("Less than 10");
        }
        x = 15;
    }
    public static void ex2(){
        int x = 7;
        if(x < 10){
            System.out.println("Less than 10");
        }
        else if(x > 10){
            System.out.println("Greater than 10");
        }
        x = 15;
    }

    public static void ex3(){
        int x = 15;
        if(x < 10){
            System.out.println("Less than 10");
        }
        else if(x > 10 && x < 20){
            System.out.println("Between 10 and 20");
        }
        else if(x >= 20){
            System.out.println("Greater than or equal to 20");
        }
        x = 50;
    }

    public static void ex4(){
        int x = 15;
        if(x < 10 || x > 20){
            System.out.println("Out of range");
        }
        else if(x >= 10 && x <= 20){
            System.out.println("in range");
        }

        x = 5;
    }

    public static void ex5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a grade:");
        double x = sc.nextDouble();
        sc.nextLine();
        if(x < 0 || x > 100){
            System.out.println("Out of range");
        }
        else if(x < 100 && x >= 90 ){
            System.out.println("A");
        }
        else if(x > 80){
            System.out.println("B");
        }
        else if(x > 70 ){
            System.out.println("C");
        }else if(x > 60 ){
            System.out.println("D");
        }else{
            System.out.println("F");
        }

        System.out.println("Would you like to enter another grade? Y or N:");
        String ans = sc.nextLine();

        if(ans.equals("Y") || ans.equals("y")){
            ex5();
        }else{
            sc.close();
        }


    }

    public static void ex6(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number between 1 - 7:");
        int x = sc.nextInt();

        switch(x){
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Out of range");
        }
    }


    public static void ex7(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your filing status: \n Single[A], Married Filling Jointly or Qualifying Widow(er)[B] \n" +
                "Married Filing Separately[C], Head of Household[D]:");
        String status = sc.nextLine();
        System.out.print("Enter your Income: ");
        double income = sc.nextDouble();
        sc.nextLine();
        double rate;

        if(status.equals("A") || status.equals("a")){
            status = "Single";
            if(income <= 8350){
                rate = .1;
            }else if(income <= 33950){
                rate = .15;
            }else if(income <= 82250){
                rate = .25;
            }else if(income <= 171250){
                rate = .28;
            }else if(income <= 372950){
                rate = .33;
            }else {
                rate = .35;
            }

            double tax = income * rate;

            System.out.printf("Filing Status: %s. \n" +
                    "Income: $%.2f\n" +
                    "Marginal Tax Rate: %.0f%% \n" +
                    "Income tax: $%.2f ", status, income, rate * 100, tax);
        }

        if(status.equals("B") || status.equals("b")){
            status = "Married Filling Jointly or Qualifying Widow(er)";
            if(income <= 16700){
                rate = .1;
            }else if(income <= 67900){
                rate = .15;
            }else if(income <= 137050){
                rate = .25;
            }else if(income <= 208850){
                rate = .28;
            }else if(income <= 372950){
                rate = .33;
            }else {
                rate = .35;
            }

            double tax = income * rate;

            System.out.printf("Filing Status: %s. \n" +
                    "Income: $%.2f\n" +
                    "Marginal Tax Rate: %.0f%% \n" +
                    "Income tax: $%.2f ", status, income, rate * 100, tax);
        }

        if(status.equals("C") || status.equals("c")){
            status = "Married Filing Separately";
            if(income <= 8350){
                rate = .1;
            }else if(income <= 33950){
                rate = .15;
            }else if(income <= 68525){
                rate = .25;
            }else if(income <= 104425){
                rate = .28;
            }else if(income <= 186475){
                rate = .33;
            }else {
                rate = .35;
            }

            double tax = income * rate;

            System.out.printf("Filing Status: %s. \n" +
                    "Income: $%.2f\n" +
                    "Marginal Tax Rate: %.0f%% \n" +
                    "Income tax: $%.2f ", status, income, rate * 100, tax);
        }

        if(status.equals("D") || status.equals("d")){
            status = "Head of Household";
            if(income <= 11950){
                rate = .1;
            }else if(income <= 45500){
                rate = .15;
            }else if(income <= 117450){
                rate = .25;
            }else if(income <= 190200){
                rate = .28;
            }else if(income <= 372950){
                rate = .33;
            }else {
                rate = .35;
            }

            double tax = income * rate;

            System.out.printf("Filing Status: %s. \n" +
                    "Income: $%.2f\n" +
                    "Marginal Tax Rate: %.0f%% \n" +
                    "Income tax: $%.2f ", status, income, rate * 100, tax);
        }


    }


    public static void main(String[] args) {
        ex7();
    }
}
