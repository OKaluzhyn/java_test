package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase  {


  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().addNewContact();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test1", "test1", "test1.test1@test1", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }



}
