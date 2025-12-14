package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithTestDataTests extends tests.TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        String firstName = "Svetlana";
        String lastName = "Abramova";
        String userEmail = "sabramova@abrams.com";
        String gender = "Female";
        String userNumber = "1234567890";
        String date = "10";
        String month = "January";
        String year = "1994";
        String subjects = "Physics";
        String hobbies = "Sports";
        String uploadPicture = "check.PNG";
        String currentAddress = "Pushkin Street 1";
        String state = "NCR";
        String city = "Delhi";
        String key1 = "Student Name";
        String value1 = "Svetlana Abramova";
        String key2 = "Student Email";
        String value2 = "sabramova@abrams.com";
        String key3 = "Gender";
        String value3 = "Female";
        String key4 = "Mobile";
        String value4 = "1234567890";
        String key5 = "Date of Birth";
        String value5 = "10 January,1994";
        String key6 = "Subjects";
        String value6 = "Physics";
        String key7 = "Hobbies";
        String value7 = "Sports";
        String key8 = "Picture";
        String value8 = "check.PNG";
        String key9 = "Address";
        String value9 = "Pushkin Street 1";
        String key10 = "State and City";
        String value10 = "NCR Delhi";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(date, month, year)
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
                .checkResult (key1, value1)
                .checkResult (key2, value2)
                .checkResult (key3, value3)
                .checkResult (key4, value4)
                .checkResult (key5, value5)
                .checkResult (key6, value6)
                .checkResult (key7, value7)
                .checkResult (key8, value8)
                .checkResult (key9, value9)
                .checkResult (key10, value10)
                .closeModal();
    }

    @Test
    void submitFormWithAllRequiredFields() {

        String firstName = "Svetlana";
        String lastName = "Abramova";
        String gender = "Female";
        String userNumber = "1234567890";
        String date = "10";
        String month = "January";
        String year = "1994";
        String key1 = "Student Name";
        String value1 = "Svetlana Abramova";
        String key3 = "Gender";
        String value3 = "Female";
        String key4 = "Mobile";
        String value4 = "1234567890";
        String key5 = "Date of Birth";
        String value5 = "10 January,1994";

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(date, month, year)
                .setSubmit()
                .setModalDialog()
                .checkResult (key1, value1)
                .checkResult (key3, value3)
                .checkResult (key4, value4)
                .checkResult (key5, value5)
                .closeModal();
    }

    @Test
    void fillFormTestNegativeFirstNameIsEmpty() {

        String lastName = "Abramova";
        String gender = "Female";
        String userNumber = "1234567890";
        String date = "10";
        String month = "January";
        String year = "1994";

        registrationPage.openPage()
                .removeBanners()
                // оставляем пустым обязательное поле FirstName
                // заполняем остальные обязательные поля
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(date, month, year)
                .setSubmit()
                .getModalDialog();

    }
}