package tests;

import base.BaseTest;
import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class SyedAssadAhmedNaqviTest extends BaseTest {

    @Test
    public void testPracticeForm() throws InterruptedException {
        PracticeFormPage form = new PracticeFormPage(driver);

        String firstName = ConfigReader.getProperty("firstName");
        String lastName = ConfigReader.getProperty("lastName");
        String email = ConfigReader.getProperty("universityEmail");
        String phone = ConfigReader.getProperty("mobile");
        String subject = ConfigReader.getProperty("subject");
        String address = "University of Central Punjab, Lahore";
        String state = ConfigReader.getProperty("state");
        String city = ConfigReader.getProperty("city");

        form.fillForm(firstName, lastName, email, phone, subject, address, state, city);

        Thread.sleep(3000); // wait for modal

        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(firstName), "First name is missing");
        Assert.assertTrue(pageSource.contains(email), "Email is missing");
        Assert.assertTrue(pageSource.contains(subject), "Subject is missing");

        System.out.println("Form submitted successfully by Syed Assad Ahmed Naqvi (L1F21BSSE0313)");
    }
}
