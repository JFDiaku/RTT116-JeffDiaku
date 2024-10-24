public class Abstraction {
    public static abstract class Shape {
        protected String color;
        protected double height;
        protected double width;
        protected double base;

        public void setColor(String color) {
            this.color = color;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        public void setBase(double base) {
            this.base = base;
        }

// The getArea method is abstract.
        // It must be overridden in a subclass.
        /** All shapes must provide a method called getArea() */.
        public abstract double getArea();
        /** Returns a self-descriptive string */

        public String toString() {
            return "Shape[color=" + color + "]";
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
            double area = PI * Math.pow(this.radius, 2); // initializing value in parent class variable
            return area; //reference to  parent class variable
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
            super.color = color;
        }

        public Rectangle() {
        }
        public Rectangle(String color, double width, double height) {
            super.height = height;
            super.width = width;
            super.color = color;
        }
        @Override
        public double getArea() {
            return super.width *  super.height;
        }
        //Overriding method of base class with different implementation
        @Override
        public void displayshapName() {
            System.out.println("I am a Rectangle"  );
        }
        @Override
        public String toString() {
            return "Rectangle[height=" + height + ",width=" + width + "," + super.toString() + "]";
        }
    }

    public static class Triangle extends Shape {

        public Triangle(){}


        public Triangle(String color) {
            super.color = color;
        }
        public void setBase(int base) {
            this.base = base;
        }
        @Override
        public double getArea() {
            return 0.5*super.base * super.height;
        }
        //Overriding method of base class with different implementation
        @Override
        public void displayshapName() {
            System.out.println("I am a TriAngle"  );
        }
        /** Returns a self-descriptive string */
        @Override
        public String toString() {
            return "Triangle[base=" + super.base + ",height=" + super.height + "," + super.toString() + "]";
        }
    }

    public static void main(String[] args) {

        Circle c = new Circle(100);
        System.out.println("Area of Circle " + c.getArea());

        // Shape sObj = new Shape(); // This will give Error, we can not instantiate Abstract class

        // object creation of the Circle class
        System.out.println("+++++++++++++++++");
        // it’s fine because a Circle is a Shape by inheritance
        Shape shapeCircleObj = new Circle(100);  // UpCasting
        shapeCircleObj.displayshapName();
        System.out.println("Area of Circle " + shapeCircleObj.getArea());
        System.out.println(shapeCircleObj);  // Run circle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeCircleObj instanceof Circle); // true

        System.out.println("+++++++++++++++++");
        Shape shapeRectangleObj = new Rectangle("Red"); //UpCasting
        shapeRectangleObj.displayshapName();
        shapeRectangleObj.setHeight(2);
        shapeRectangleObj.setWidth(4);
        System.out.println("Area of Rectangle is " + shapeRectangleObj.getArea());
        System.out.println(shapeRectangleObj);  // Run Rectangle's toString()
        // Use instanceof operator for Validation
        System.out.println(shapeRectangleObj instanceof Rectangle); // true

        System.out.println("--------------------");
        Shape shapeTriangleObj = new Triangle("Blue"); //UpCasting
        shapeTriangleObj.displayshapName();
        shapeTriangleObj.setHeight(10);
        shapeTriangleObj.setBase(15);
        System.out.println("Area of Triangle is " + shapeTriangleObj.getArea());
        System.out.println(shapeTriangleObj);  // Run Triangle's toString()
    }



}
