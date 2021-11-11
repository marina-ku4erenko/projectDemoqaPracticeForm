package mari.ku.tests;

import mari.ku.pages.RegistrationsPage;
import org.junit.jupiter.api.Test;

import static mari.ku.tests.TestData.*;

public class DemoqaPracticeFormTests extends TestBase {

    RegistrationsPage registrationsPage = new RegistrationsPage();
    TestData testData = new TestData();

    @Test
    void allFieldsTestStudentRegistrationForm() {

        // открываем страницу в браузере с формой регистрации
        registrationsPage.openPage();

        // заполняем имя, фамилию, почту, пол, номер телефона
        registrationsPage.
                typeFirstName(testData.firstName).
                typeLastName(testData.lastName).
                typeMail(testData.firstName + "." + testData.lastName + "666@mail.ru").
                selectGenderMale().
                typePhoneNumber(testData.mobile);

        // скролл страницы до кнопки submit
        registrationsPage.scrollToSubmit();

        // указываем дату рождения
        registrationsPage.setDate(day, month, testData.year);

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
        registrationsPage.typeAdress(testData.address);

        // указываем штат и город Karnal
        registrationsPage.selectCityKarnal();

        // регистрация студента
        registrationsPage.submitStudent();

        // сверяем данные
        registrationsPage.
                checkResultsValue("Student Name", testData.firstName + " " + testData.lastName).
                checkResultsValue("Student Email", testData.firstName + "." + testData.lastName + "666@mail.ru").
                checkResultsValue("Gender", "Male").
                checkResultsValue("Mobile", testData.mobile).
                checkResultsValue("Date of Birth", day + " " + month + "," + testData.year).
                checkResultsValue("Subjects", "Economics, Civics").
                checkResultsValue("Hobbies", "Sports, Reading, Music").
                checkResultsValue("Picture", imgName).
                checkResultsValue("Address", testData.address).
                checkResultsValue("Gender", "Male").
                checkResultsValue("State and City", "Haryana Karnal");

    }


}
