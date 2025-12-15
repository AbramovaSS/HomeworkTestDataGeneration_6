package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationWithFakerTests extends tests.TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setUploadPicture(testData.uploadPicture)
                .setCurrentAddress(testData.currentAddress)
                .setStateDropdown()
                .setStateCityWrapper(testData.state)
                .setCityDropdown()
                .setStateCityWrapper(testData.city)
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult ("Student Email", testData.email)
                .checkResult ("Gender", testData.userGender)
                .checkResult ("Mobile", testData.userNumber)
                .checkResult ("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult ("Subjects", testData.subjects)
                .checkResult ("Hobbies", testData.hobbies)
                .checkResult ("Picture", testData.uploadPicture)
                .checkResult ("Address", testData.currentAddress)
                .checkResult ("State and City", testData.state + " " + testData.city)
                .closeModal();
    }

    @Test
    void submitFormWithAllRequiredFields() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubmit()
                .setModalDialog()
                .checkResult ("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult ("Gender", testData.userGender)
                .checkResult ("Mobile", testData.userNumber)
                .checkResult ("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .closeModal();
    }

    @Test
    void fillFormTestNegativeFirstNameIsEmpty() {

        registrationPage.openPage()
                .removeBanners()
                // оставляем пустым обязательное поле FirstName
                // заполняем остальные обязательные поля
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubmit()
                .getModalDialog();

    }
}
