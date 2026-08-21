import java.util.Scanner;

enum Category {
    LENGTH,
    MASS,
    TEMPERATURE,
    TIME,
    OTHER
}

enum LengthUnit {
    METERS,
    KILOMETERS,
    CENTIMETERS
}

enum MassUnit {
    GRAMS,
    KILOGRAMS,
    TONS
}

enum TemperatureUnit {
    CELSIUS,
    FAHRENHEIT,
    KELVIN
}

enum TimeUnit {
    SECONDS,
    MINUTES,
    HOURS
}

public class UnitConverter {

    static double toMeters(double value, LengthUnit unit) {
        switch (unit) {
            case METERS:
                return value;
            case KILOMETERS:
                return value * 1000;
            case CENTIMETERS:
                return value / 100;
            default:
                return value;
        }
    }

    static double fromMeters(double meters, LengthUnit unit) {
        switch (unit) {
            case METERS:
                return meters;
            case KILOMETERS:
                return meters / 1000;
            case CENTIMETERS:
                return meters * 100;
            default:
                return meters;
        }
    }

    static double toGrams(double value, MassUnit unit) {
        switch (unit) {
            case GRAMS:
                return value;
            case KILOGRAMS:
                return value * 1000;
            case TONS:
                return value * 1_000_000;
            default:
                return value;
        }
    }

    static double fromGrams(double grams, MassUnit unit) {
        switch (unit) {
            case GRAMS:
                return grams;
            case KILOGRAMS:
                return grams / 1000;
            case TONS:
                return grams / 1_000_000;
            default:
                return grams;
        }
    }


    static double toCelsius(double value, TemperatureUnit unit) {
        switch (unit) {
            case CELSIUS:
                return value;
            case FAHRENHEIT:
                return (value - 32) * 5.0 / 9.0;
            case KELVIN:
                return value - 273.15;
            default:
                return value;
        }
    }

    static double fromCelsius(double celsius, TemperatureUnit unit) {
        switch (unit) {
            case CELSIUS:
                return celsius;
            case FAHRENHEIT:
                return celsius * 9.0 / 5.0 + 32;
            case KELVIN:
                return celsius + 273.15;
            default:
                return celsius;
        }
    }

    
    static double toSeconds(double value, TimeUnit unit) {
        switch (unit) {
            case SECONDS:
                return value;
            case MINUTES:
                return value * 60;
            case HOURS:
                return value * 3600;
            default:
                return value;
        }
    }

    static double fromSeconds(double seconds, TimeUnit unit) {
        switch (unit) {
            case SECONDS:
                return seconds;
            case MINUTES:
                return seconds / 60;
            case HOURS:
                return seconds / 3600;
            default:
                return seconds;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Конвертер единиц ===");
        System.out.println("1. Длина");
        System.out.println("2. Масса");
        System.out.println("3. Температура");
        System.out.println("4. Время");

        System.out.print("Выберите категорию: ");
        int choice = scanner.nextInt();

        Category category;

        switch (choice) {
            case 1:
                category = Category.LENGTH;
                break;
            case 2:
                category = Category.MASS;
                break;
            case 3:
                category = Category.TEMPERATURE;
                break;
            case 4:
                category = Category.TIME;
                break;
            default:
                category = Category.OTHER;
        }

        switch (category) {

            case LENGTH:

                System.out.println("\n=== Длина ===");
                System.out.println("1. Метры");
                System.out.println("2. Километры");
                System.out.println("3. Сантиметры");

                System.out.print("Из какой единицы? ");
                int lengthFromChoice = scanner.nextInt();

                LengthUnit lengthFrom;

                switch (lengthFromChoice) {
                    case 1:
                        lengthFrom = LengthUnit.METERS;
                        break;
                    case 2:
                        lengthFrom = LengthUnit.KILOMETERS;
                        break;
                    case 3:
                        lengthFrom = LengthUnit.CENTIMETERS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                System.out.print("Введите значение: ");
                double lengthValue = scanner.nextDouble();

                System.out.println("\nВ какую единицу перевести?");
                System.out.println("1. Метры");
                System.out.println("2. Километры");
                System.out.println("3. Сантиметры");

                System.out.print("Ваш выбор: ");
                int lengthToChoice = scanner.nextInt();

                LengthUnit lengthTo;

                switch (lengthToChoice) {
                    case 1:
                        lengthTo = LengthUnit.METERS;
                        break;
                    case 2:
                        lengthTo = LengthUnit.KILOMETERS;
                        break;
                    case 3:
                        lengthTo = LengthUnit.CENTIMETERS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                double meters = toMeters(lengthValue, lengthFrom);
                double lengthResult = fromMeters(meters, lengthTo);

                System.out.println("Результат: " + lengthResult);

                break;

            case MASS:

                System.out.println("\n=== Масса ===");
                System.out.println("1. Граммы");
                System.out.println("2. Килограммы");
                System.out.println("3. Тонны");

                System.out.print("Из какой единицы? ");
                int massFromChoice = scanner.nextInt();

                MassUnit massFrom;

                switch (massFromChoice) {
                    case 1:
                        massFrom = MassUnit.GRAMS;
                        break;
                    case 2:
                        massFrom = MassUnit.KILOGRAMS;
                        break;
                    case 3:
                        massFrom = MassUnit.TONS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                System.out.print("Введите значение: ");
                double massValue = scanner.nextDouble();

                System.out.println("\nВ какую единицу перевести?");
                System.out.println("1. Граммы");
                System.out.println("2. Килограммы");
                System.out.println("3. Тонны");

                System.out.print("Ваш выбор: ");
                int massToChoice = scanner.nextInt();

                MassUnit massTo;

                switch (massToChoice) {
                    case 1:
                        massTo = MassUnit.GRAMS;
                        break;
                    case 2:
                        massTo = MassUnit.KILOGRAMS;
                        break;
                    case 3:
                        massTo = MassUnit.TONS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                double grams = toGrams(massValue, massFrom);
                double massResult = fromGrams(grams, massTo);

                System.out.println("Результат: " + massResult);

                break;

            case TEMPERATURE:

                System.out.println("\n=== Температура ===");
                System.out.println("1. Цельсий");
                System.out.println("2. Фаренгейт");
                System.out.println("3. Кельвин");

                System.out.print("Из какой единицы? ");
                int temperatureFromChoice = scanner.nextInt();

                TemperatureUnit temperatureFrom;

                switch (temperatureFromChoice) {
                    case 1:
                        temperatureFrom = TemperatureUnit.CELSIUS;
                        break;
                    case 2:
                        temperatureFrom = TemperatureUnit.FAHRENHEIT;
                        break;
                    case 3:
                        temperatureFrom = TemperatureUnit.KELVIN;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                System.out.print("Введите значение: ");
                double temperatureValue = scanner.nextDouble();

                System.out.println("\nВ какую единицу перевести?");
                System.out.println("1. Цельсий");
                System.out.println("2. Фаренгейт");
                System.out.println("3. Кельвин");

                System.out.print("Ваш выбор: ");
                int temperatureToChoice = scanner.nextInt();

                TemperatureUnit temperatureTo;

                switch (temperatureToChoice) {
                    case 1:
                        temperatureTo = TemperatureUnit.CELSIUS;
                        break;
                    case 2:
                        temperatureTo = TemperatureUnit.FAHRENHEIT;
                        break;
                    case 3:
                        temperatureTo = TemperatureUnit.KELVIN;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                double celsius = toCelsius(temperatureValue, temperatureFrom);
                double temperatureResult = fromCelsius(celsius, temperatureTo);

                System.out.println("Результат: " + temperatureResult);

                break;

            case TIME:

                System.out.println("\n=== Время ===");
                System.out.println("1. Секунды");
                System.out.println("2. Минуты");
                System.out.println("3. Часы");

                System.out.print("Из какой единицы? ");
                int timeFromChoice = scanner.nextInt();

                TimeUnit timeFrom;

                switch (timeFromChoice) {
                    case 1:
                        timeFrom = TimeUnit.SECONDS;
                        break;
                    case 2:
                        timeFrom = TimeUnit.MINUTES;
                        break;
                    case 3:
                        timeFrom = TimeUnit.HOURS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                System.out.print("Введите значение: ");
                double timeValue = scanner.nextDouble();

                System.out.println("\nВ какую единицу перевести?");
                System.out.println("1. Секунды");
                System.out.println("2. Минуты");
                System.out.println("3. Часы");

                System.out.print("Ваш выбор: ");
                int timeToChoice = scanner.nextInt();

                TimeUnit timeTo;

                switch (timeToChoice) {
                    case 1:
                        timeTo = TimeUnit.SECONDS;
                        break;
                    case 2:
                        timeTo = TimeUnit.MINUTES;
                        break;
                    case 3:
                        timeTo = TimeUnit.HOURS;
                        break;
                    default:
                        System.out.println("Неизвестная единица.");
                        scanner.close();
                        return;
                }

                double seconds = toSeconds(timeValue, timeFrom);
                double timeResult = fromSeconds(seconds, timeTo);

                System.out.println("Результат: " + timeResult);

                break;

            case OTHER:
                System.out.println("Неизвестная категория.");
                break;
        }

        scanner.close();
    }
}