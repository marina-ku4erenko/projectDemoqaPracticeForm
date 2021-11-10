package mari.ku.pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationsPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            mailInput = $("#userEmail"),
            genderlChooseMale = $(byText("Male")),
            phoneNumberInput = $("#userNumber"),
            buttonSubmit = $("#submit"),
            dateInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            subjectsInput = $("#subjectsInput"),
            hobbySports = $(byText("Sports")),
            hobbyReading = $(byText("Reading")),
            hobbyMusic = $(byText("Music")),
            fileInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateHaryana = $(byText("Haryana")),
            cityInput = $("#city"),
            cityKarnal = $(byText("Karnal")),
            resultsTable = $(".table-responsive"),
            subjectsEconomics = $(byText("Economics")),
            subjectsCivics = $(byText("Civics"));


    public RegistrationsPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    public RegistrationsPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationsPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationsPage typeMail(String value) {
        mailInput.setValue(value);

        return this;
    }

    public RegistrationsPage selectGenderMale() {
        genderlChooseMale.click();

        return this;
    }

    public RegistrationsPage typePhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationsPage scrollToSubmit() {
        buttonSubmit.scrollIntoView(true);

        return this;
    }

    public RegistrationsPage setDate(String day, String month, String year) {
        dateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();

        return this;
    }

    public RegistrationsPage clickSubjectsInput() {
        subjectsInput.click();

        return this;
    }

    public RegistrationsPage selectSubjectEconomics() {
        subjectsInput.setValue("e");
        subjectsEconomics.click();

        return this;
    }

    public RegistrationsPage selectSubjectCivics() {
        subjectsInput.setValue("c");
        subjectsCivics.click();

        return this;
    }

    public RegistrationsPage selectHobbySports() {
        hobbySports.click();

        return this;
    }

    public RegistrationsPage selectHobbyReading() {
        hobbyReading.click();

        return this;
    }

    public RegistrationsPage selectHobbyMusic() {
        hobbyMusic.click();

        return this;
    }

    public RegistrationsPage uploadFile(String value) {
        File cat = new File(value);
        fileInput.uploadFile(cat);

        return this;
    }

    public RegistrationsPage typeAdress(String value) {
        adressInput.setValue(value);

        return this;
    }

    public RegistrationsPage selectCityKarnal() {
        stateInput.click();
        stateHaryana.click();
        cityInput.click();
        cityKarnal.click();

        return this;
    }

    public RegistrationsPage submitStudent() {
        buttonSubmit.click();

        return this;
    }

    public RegistrationsPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

}
