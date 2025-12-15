package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            userGender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%s", faker.number().numberBetween(1, 28)),
            month = faker.options().option("January", "February", "March", "April", "May",
                    "June", "July", "August", "September", "October", "November", "December"),
            year = String.format("%s", faker.number().numberBetween(1950, 2010)),
            subjects = faker.options().option("Physics", "Computer Science", "Commerce",
                    "Accounting", "Economics", "Maths", "Arts", "Social Studies",
                    "English", "Chemistry", "Hindi", "Biology", "History", "Civics"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            uploadPicture = faker.options().option("brahms.jpg", "check.PNG", "don_quixote.jpg", "mirror.jpg"),
            currentAddress = faker.address().streetAddressNumber(),
            state = getRandomState(),
            city = selectCity(state);

    public String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }
}
