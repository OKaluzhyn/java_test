package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {


  @BeforeMethod
  public void ensuarePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("test1").withLastname("test1").withHomePhone("test1").withEmail("test1.test1@test1").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    //before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
    //Assert.assertEquals(before, after);
  }


}
