public class Inheritance {
    public static class Doctor {
        String DoctorName;
        String Department;
        public void Doctor_Details() {
            System.out.println("Doctor Details...");
        }
    }


    public static class Surgeon extends Doctor {
        void Surgeon_Details() {
            System.out.println("Surgeon  Detail...");
            System.out.println(Department = "Cardio");
        }
    }


    public static class Hospital {
        public static void main(String[] args) {
            Surgeon s = new Surgeon();
            s.Doctor_Details();
            s.Surgeon_Details();
        }
    }



}
