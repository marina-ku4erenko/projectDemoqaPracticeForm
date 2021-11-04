package mari.ku;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPracticeForm {

    File cat = new File("src/test/resources/cat.jpg");

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void allFieldsTestStudentRegistrationForm() {

        // открываем страницу в браузере с формой регистрации
        open("https://demoqa.com/automation-practice-form");

        // заполняем имя, фамилию, почту, пол, номер телефона
        $("#firstName").setValue("Stepan");
        $("#lastName").setValue("Testerenko");
        $("#userEmail").setValue("stepan.testerenko666@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("6542425266");

        // скролл страницы до кнопки submit
        $("#submit").scrollIntoView(true);

        // указываем дату рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1922");
        $(".react-datepicker__day.react-datepicker__day--017").click();

        // указываем предметы
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("e");
        $(byText("Economics")).click();
        $("#subjectsInput").setValue("c");
        $(byText("Civics")).click();

        // указываем хобби
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();

        // загружаем картинку
        $("#uploadPicture").uploadFile(cat);

        // указываем адрес
        $("#currentAddress").setValue("Solar system");

        // указываем штат и город
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        // регистрация студента
        $("#submit").click();

        // сверяем данные
        $("div.table-responsive table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Stepan Testerenko"));
        $("div.table-responsive table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("stepan.testerenko666@mail.ru"));
        $("div.table-responsive table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("div.table-responsive table tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("6542425266"));
        $("div.table-responsive table tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("17 May,1922"));
        $("div.table-responsive table tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Economics, Civics"));
        $("div.table-responsive table tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading, Music"));
        $("div.table-responsive table tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("cat.jpg"));
        $("div.table-responsive table tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("Solar system"));
        $("div.table-responsive table tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Haryana Karnal"));

    }


}
