package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by o.kaluzhin on 25.08.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }


  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type((By.name("firstname")), contactData.getFirstname());
    type((By.name("lastname")), contactData.getLastname());
    type((By.name("home")), contactData.getHomePhone());
    type((By.name("email")), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void pressDeleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }


  public void chooseContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void closePopUp() {
    wd.switchTo().alert().accept();
  }

  public void pressModifacate(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody//td[8]/a/img")).get(index).click();
  }

  public void submitContactModification() {

    click(By.name("update"));
  }

  public void create(ContactData contact) {
    addNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public void modify(int index, ContactData contact) {
    pressModifacate(index);
    fillContactForm(contact, false);
    submitContactModification();
  }

  public void delete(int index) {
    chooseContact(index);
    pressDeleteContact();
    closePopUp();
  }


  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      //String name = element.getText();
      //String lastname = element.findElement(By.xpath("td[2]")).getText();
      //String id = element.findElement(By.tagName("input")).getAttribute("value");
      String firstname = element.findElement(By.xpath("td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData().withId(id).withFirstname(firstname);
      contacts.add(contact);
    }
    return contacts;
  }

  /*public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  /*public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }*/

}

