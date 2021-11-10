package mari.ku.tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String mobile = String.valueOf(faker.number().numberBetween(1000000000, 2147483647));
    String address = faker.address().streetAddress();

    public static String day = "17";
    public static String month = "May";
    public static String year = "1922";
    public static String imgPath = "src/test/resources/img/";
    public static String imgName = "dog.png";

}
