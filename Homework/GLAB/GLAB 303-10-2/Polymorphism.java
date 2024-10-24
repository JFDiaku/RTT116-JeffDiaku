public class Polymorphism {
    public static class Shape {
        private String color;
        protected double area = 1.0;
        protected double base = 1.0;
        protected double width = 1.0;
        protected double height = 1.0;

        /** Constructs a Shape instance with only the given color */
        public Shape (String color) {
            this.color = color;
        }
        public Shape()
        {
        }
        /** Constructs a Shape instance with the given values */
        public Shape(String color, double area, double base, double width, double height) {
            this.color = color;
            this.area = area;
            this.base = base;
            this.width = width;
            this.height = height;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setArea(double area) {
            this.area = area;
        }

        public void setBase(double base) {
            this.base = base;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        /** Returns a self-descriptive string */
        @Override
        public String toString() {
            return "Shape[color=" + color + "]";
        }

        /** All shapes must provide a method called getArea() */
        public double getArea() {
            // We have a problem here!
            // We need to return some value to compile the program.
            System.out.println("Shape unknown! Cannot compute area!");
            return 0;
        }
        public void displayshapName()
        {
            System.out.println("I am a Shape.");
        }
    }

    public static class Circle extends Shape {
        protected double radius;
        private final double PI = Math.PI;

        public Circle(double radius) {
            this.radius = radius;
        }

        public Circle(double radius, double height) {
            this.radius = radius;
            super.height = height;
        }
        public double getArea() {
            //double area = PI * this.radius * this.radius;
            super.area = PI * Math.pow(this.radius, 2); // initializing value in parent class variable
            return super.area; //reference to  parent class variable
        }
        @Override
        public void displayshapName() {
            System.out.println("Drawing a Circle of radius " + this.radius);
        }
        /** Returns a self-descriptive string */
        @Override
        public String toString() {
            return "Circle[ radius = " + radius + super.toString() + "]";
        }
    }

    public static class Rectangle extends Shape {

        public Rectangle(String color) {
            super(color);
        }

        public Rectangle() {
        }

        public Rectangle(String color, double area, double base, double width, double height)
        {
            super(color, area, base, width, height);
        }

        @Override
        public void setBase(double base) {
            super.base = base;   }
        @Override
        public void setWidth(double width) {
            super.width = width;   }
        @Override
        public double getArea() {
            return width * height;   }

        public double perimeter() {
            super.area =  super.width * super.height;
            return super.area;   }
        //Overriding method of base class with different implementation
        @Override
        public void displayshapName() {
            System.out.println("I am a Rectangle"  );   }
        /** Returns a self-descriptive string */
        @Override
        public String toString() {
            return "Rectangle[height=" + height + ",width=" + width + "," + super.toString() + "]";
        }}


    public static class Triangle extends Shape {
        public Triangle(){}

        public Triangle(String color, double area, double base, double width, double height) {
            super(color, area, base, width, height);
        }

        public Triangle(String color) {
            super(color);
        }

        @Override
        public void setBase(double base) {
            super.base = base;
        }
        @Override
        public void setWidth(double width) {
            super.width = width;
        }
        @Override
        public double getArea() {
            return 0.5*base*height;
        }

        //Overriding method of base class with different implementation
        @Override
        public void displayshapName() {
            System.out.println("I am a TriAngle"  );
        }

        /** Returns a self-descriptive string */
        @Override
        public String toString() {
            return "Triangle[base=" + base + ",height=" + height + "," + super.toString() + "]";
        }
    }

    public static class Cylinder extends Circle {
        private final double PI = Math.PI  ;

        public Cylinder(double radius, double height) {
            super(radius, height);
            // TODO Auto-generated constructor stub
        }

        public Cylinder(double radius) {
            super(radius);
        }

        /** Returns the volume of this cylinder */
        public double getVolumne() {
            return  (PI*Math.pow(super.radius, 2)) * super.height;
        }

        public double getSurfaceArea() {
            return 2.0 * Math.PI*super.radius*super.height;
        }
        @Override
        public void displayshapName() {
            System.out.println("Drawing a Cylinder for radius " + super.radius);
        }
        public String toString()
        {
            return "radius is: " + super.radius +"height is : " + super.height;

        }
    }

    public static void main(String[] args) {
        Circle c = new Circle(100);
        System.out.println("Area of Circle " + c.getArea());

        // Example of Object type casting
        // declaration of object variable obj of the Shape class

        // Shape sObj ; // object creation of the Shape class
        Shape sObj = new Shape();
        sObj.displayshapName();
        System.out.println(sObj instanceof Shape); // true


        // object creation of the Circle class
        System.out.println("+++++++++");

        // it’s fine because a Circle is a Shape by inheritance
        Shape shapeCircleObj = new Circle(100);  // UpCasting
        shapeCircleObj.displayshapName();
        System.out.println("Area of Circle " + shapeCircleObj.getArea());
        System.out.println(shapeCircleObj);  // Run circle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeCircleObj instanceof Circle); // true
        System.out.println(sObj instanceof Circle); // false because Shape is not a Circle

        System.out.println("--------------------");
        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
        shapeRectangleObj.displayshapName();
        shapeRectangleObj.setHeight(2);
        shapeRectangleObj.setWidth(2);
        System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
        System.out.println(shapeRectangleObj);  // Run Rectangle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeRectangleObj instanceof Rectangle); // true
        System.out.println(sObj instanceof Rectangle); // false because Shape is not a Rectangle

        System.out.println("--------------------");
        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
        shapeTriangleObj.displayshapName();
        shapeTriangleObj.setHeight(2);
        shapeTriangleObj.setBase(3);
        System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
        System.out.println(shapeTriangleObj);  // Run Triangle's toString()

        // Use instanceof operator for Validation
        System.out.println(shapeTriangleObj instanceof Triangle); // true
        System.out.println(sObj instanceof Triangle); // false because Shape is not a Triangle
        System.out.println("--------------------");

        Cylinder cylinderShape = new Cylinder(3); //UpCasting
        cylinderShape.displayshapName();
        cylinderShape.setHeight(3);
        System.out.println("Area of Cylinder is " + cylinderShape.getVolumne());
        System.out.println(cylinderShape);  // Run cylinderShape's toString()
    }


}
