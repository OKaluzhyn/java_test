package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by o.kaluzhin on 25.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().pressModifacate(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("test1", "test1", "test1", "test1.test1@test1", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
