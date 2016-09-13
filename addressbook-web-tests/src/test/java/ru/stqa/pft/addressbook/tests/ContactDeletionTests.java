package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    int before = app.getContactHelper().getContactCount();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test1", "test1", "test1.test1@test1", "test1"));
    }
    app.getContactHelper().chooseContact(before - 1);
    app.getContactHelper().pressDeleteContact();
    app.getContactHelper().closePopUp();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
