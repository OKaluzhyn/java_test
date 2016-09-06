package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase  {


  @Test
  public void testContactCreation() {
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test1", "test1", "test1.test1@test1", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
  }



}
