package entities;

public class Rectangle {

        private Double width;
        private Double height;

        public Rectangle(){}

        public Rectangle(Double width, Double height) {
            this.width = width;
            this.height = height;
        }

        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        public Double area() {
            return width * height;
        }

        public Double Perimeter() {
            return 2*(width + height);
        }

        public Double Diagonal(){
            return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        }

		@Override
		public String toString() {
		       return String.format("Area = %.2f%nPerimeter = %.2f%nDiagonal = %.2f%n", 
                       area(), Perimeter(), Diagonal());
        }
        
        
    }

