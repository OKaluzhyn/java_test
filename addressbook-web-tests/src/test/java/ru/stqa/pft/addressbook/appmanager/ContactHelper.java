package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;


/**
 * Created by o.kaluzhin on 25.08.2016.
 */
public class ContactHelper extends HelperBase{

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

    public void closePopUp(){
    wd.switchTo().alert().accept();
  }

  public void pressModifacate(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody//td[8]/a/img")).get(index).click();
  }

  public void submitContactModification() {

    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    addNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent((By.name("selected[]")));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}

