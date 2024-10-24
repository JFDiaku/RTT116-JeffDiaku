public class Interfaces {
    public interface LibraryUser{
        void registerAcount();

        void requestBook();
    }

    public static class KidUser implements LibraryUser{
        int age;
        String bookType;

        public KidUser(int age, String bookType) {
            this.age = age;
            this.bookType = bookType;
        }

        public void registerAcount() {
            if(age <= 11){
                System.out.println("You have successfully registered under a Kids account");
            }else{
                System.out.println("Sorry, age must be less than 12 to register as a kid");
            }
        }

        public void requestBook() {
            if(bookType.equals("Kids")){
                System.out.println("Book issued successfully, please return the book within 10 days");
            }else{
                System.out.println("Oops, you are allowed to take only kids books.");
            }
        }

    }

    public static class adultUser implements LibraryUser{
        int age;
        String bookType;

        public adultUser(int age, String bookType) {
            this.age = age;
            this.bookType = bookType;
        }

        public void registerAcount() {
            if(age >= 12){
                System.out.println("You have successfully registered under a adult account");
            }else{
                System.out.println("Sorry, age must be greater than 12 to register as an adult.");
            }
        }

        public void requestBook() {
            if(bookType.equals("Fiction")){
                System.out.println("Book issued successfully, please return the book within 7 days");
            }else{
                System.out.println("Oops, you are allowed to take only adult Fiction books");
            }
        }

    }



    public static void main(String[] args) {
        KidUser k1 = new KidUser(10,"Kids");
        KidUser k2 = new KidUser(18, "Fiction");

        k1.registerAcount();
        k1.requestBook();

        k2.registerAcount();
        k2.requestBook();


        adultUser a1 = new adultUser(5,"Kids");
        adultUser a2 = new adultUser(23,"Fiction");

        a1.registerAcount();
        a1.requestBook();

        a2.registerAcount();
        a2.requestBook();

    }
}
