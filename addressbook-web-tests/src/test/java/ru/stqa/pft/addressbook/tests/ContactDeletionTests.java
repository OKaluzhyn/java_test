package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test1", "test1", "test1.test1@test1", "test1"), true);
    }
    app.getContactHelper().chooseContact();
    app.getContactHelper().pressDeleteContact();
    app.getContactHelper().closePopUp();
  }
}
