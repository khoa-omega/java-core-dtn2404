package innerclass;

public class Car {
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public class Engine {
        private int cycle;

        public Engine(int cycle) {
            this.cycle = cycle;
        }

        public void printCar() {
            System.out.println("Car{" +
                    "model='" + model + '\'' +
                    ", color='" + color + '\'' +
                    '}');
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "cycle=" + cycle +
                    '}';
        }
    }

    public static class Price {
        private int price;

        public Price(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Price{" +
                    "price=" + price +
                    '}';
        }
    }
}
