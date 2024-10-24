public class generics {
    public static void main(String[] args) {
        class DemoClass {

            // create a generics method
            public <T> void genericsMethod(T data) {
                System.out.println("Generics Method:");
                System.out.println("Data Passed: " + data);
            }
        }

        class GMultipleDatatype  <Datatypeone, DatatypeTwo>  {
            Datatypeone valueOne;
            DatatypeTwo valueTwo;

            public GMultipleDatatype(Datatypeone v1, DatatypeTwo v2)
            {
                this.valueOne = v1;
                this.valueTwo = v2;
            }

            public Datatypeone getValueOne() {
                return valueOne;
            }

            public void setValueOne(Datatypeone valueOne) {
                this.valueOne = valueOne;
            }

            public DatatypeTwo getValueTwo() {
                return valueTwo;
            }

            public void setValueTwo(DatatypeTwo valueTwo) {
                this.valueTwo = valueTwo;
            }
        }

        GMultipleDatatype<String, Integer> mobj = new GMultipleDatatype("Per Scholas", 11025);

        System.out.println(mobj.getValueOne());
        System.out.println(mobj.getValueTwo());

        // initialize generic class
        // with String and String data
        GMultipleDatatype<String, String> mobj2 = new GMultipleDatatype("Per Scholas", "Non profit");
        System.out.println(mobj2.getValueOne());
        System.out.println(mobj2.getValueTwo());


        DemoClass dObj = new DemoClass();
        dObj.genericsMethod(25); // passing int
        dObj.genericsMethod("Per Scholas"); // passing String
        dObj.genericsMethod(2563.5); // passing float
        dObj.genericsMethod('H'); // passing Char

    }

}
