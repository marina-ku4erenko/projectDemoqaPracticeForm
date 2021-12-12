package mari.ku.tests;

import io.qameta.allure.*;
import mari.ku.pages.RegistrationsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemoqaPracticeFormTests extends TestData {

    RegistrationsPage registrationsPage = new RegistrationsPage();

    @Owner("marina-ku4erenko")
    @Feature("Регистрация студента")
    @Story("Регистрация с заполнением всех полей")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация студента с заполнением всех полей")
    @Test
    void allFieldsTestStudentRegistrationForm() {

        // открываем страницу в браузере с формой регистрации
        registrationsPage.openPage();

        // заполняем имя, фамилию, почту, пол, номер телефона
        registrationsPage.
                typeFirstName(firstName).
                typeLastName(lastName).
                typeMail(firstName + "." + lastName + "666@mail.ru").
                selectGenderMale().
                typePhoneNumber(mobile);

        // скролл страницы до кнопки submit
        registrationsPage.scrollToSubmit();

        // указываем дату рождения
        registrationsPage.setDate(day, month, year);

        // указываем предметы
        registrationsPage.
                clickSubjectsInput().
                selectSubjectEconomics().
                selectSubjectCivics();

        // указываем хобби
        registrationsPage.
                selectHobbySports().
                selectHobbyReading().
                selectHobbyMusic();

        // загружаем картинку
        registrationsPage.uploadFile(imgPath + imgName);

        // указываем адрес
        registrationsPage.typeAdress(address);

        // указываем штат и город Karnal
        registrationsPage.selectCityKarnal();

        // регистрация студента
        registrationsPage.submitStudent();

        // сверяем данные
        registrationsPage.
                checkResultsValue("Student Name", firstName + " " + lastName).
                checkResultsValue("Student Email", firstName + "." + lastName + "666@mail.ru").
                checkResultsValue("Gender", "Male").
                checkResultsValue("Mobile", mobile).
                checkResultsValue("Date of Birth", day + " " + month + "," + year).
                checkResultsValue("Subjects", "Economics, Civics").
                checkResultsValue("Hobbies", "Sports, Reading, Music").
                checkResultsValue("Picture", imgName).
                checkResultsValue("Address", address).
                checkResultsValue("Gender", "Male").
                checkResultsValue("State and City", "Haryana Karnal");

    }

    @Owner("marina-ku4erenko")
    @Feature("Регистрация студента")
    @Story("Регистрация с заполнением только обязательных полей")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Регистрация студента с заполнением только обязательных полей")
    @Test
    void requiredFieldsTestStudentRegistrationForm() {

        // открываем страницу в браузере с формой регистрации
        registrationsPage.openPage();

        // заполняем имя, фамилию, почту, пол, номер телефона
        registrationsPage.
                typeFirstName(firstName).
                typeLastName(lastName).
                selectGenderFemale().
                typePhoneNumber(mobile);

        // скролл страницы до кнопки submit
        registrationsPage.scrollToSubmit();

        // регистрация студента
        registrationsPage.submitStudent();

        // сверяем данные
        registrationsPage.
                checkResultsValue("Student Name", firstName + " " + lastName).
                checkResultsValue("Gender", "Female").
                checkResultsValue("Mobile", mobile);

    }


}
