
    public class Start {
        public static void main(String[] args) {

            Value value = new Value();

            CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(value);
            value.setMeasurements(12);
            value.setMeasurements(13);
            value.setMeasurements(15);
        }
    }
    interface Observer {
        void update (int value);
    }

    interface Observable {
        void notifyObservers();
    }

    class Value implements Observable {

        private int value;
        Observer observer;

        @Override
        public void notifyObservers() {
                observer.update(value);
        }

        public void setMeasurements(int value) {
            this.value = value;
            notifyObservers();
        }
    }

    class CurrentConditionsDisplay implements Observer {


        private Value value;

        public CurrentConditionsDisplay(Value value) {
            this.value = value;
            value.observer = this;
        }

        @Override
        public void update(int value) {
            this.value.setMeasurements(value);
            display();
        }

        public void display() {
            System.out.printf("Сейчас значения: %.1f градусов цельсия и %.1f %% влажности. Давление %d мм рт. ст.\n", value);
        }
    }


