package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationWithFakerTests extends tests.TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setStateDropdown()
                .setStateCityWrapper(state)
                .setCityDropdown()
                .setStateCityWrapper(city)
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", firstName + " " + lastName)
                .checkResult ("Student Email", email)
                .checkResult ("Gender", userGender)
                .checkResult ("Mobile", userNumber)
                .checkResult ("Date of Birth", day + " " + month + "," + year)
                .checkResult ("Subjects", subjects)
                .checkResult ("Hobbies", hobbies)
                .checkResult ("Picture", uploadPicture)
                .checkResult ("Address", currentAddress)
                .checkResult ("State and City", state + " " + city)
                .closeModal();
    }

    @Test
    void submitFormWithAllRequiredFields() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", firstName + " " + lastName)
                .checkResult ("Gender", userGender)
                .checkResult ("Mobile", userNumber)
                .checkResult ("Date of Birth", day + " " + month + "," + year)
                .closeModal();
    }

    @Test
    void fillFormTestNegativeFirstNameIsEmpty() {

        registrationPage.openPage()
                .removeBanners()
                // оставляем пустым обязательное поле FirstName
                // заполняем остальные обязательные поля
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubmit()
                .getModalDialog();

    }
}
