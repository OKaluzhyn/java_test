package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by o.kaluzhin on 25.08.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensuarePreconditions() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("test1", "test1", "test1", "test1.test1@test1", "test1"));
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size() - 1;
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "test1", "test1", "test1", "test1.test1@test1", null);
    app.getContactHelper().modifyContact(index, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
