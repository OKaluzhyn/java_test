package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by o.kaluzhin on 25.08.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type((By.name("firstname")), contactData.getFirstname());
    type((By.name("middlename")), contactData.getLastname());
    type((By.name("home")), contactData.getHomePhone());
    type((By.name("email")), contactData.getEmail());
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

    public void pressDeleteContact() {
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


  public void chooseContact() {
    click(By.name("selected[]"));
  }

    public void closePopUp(){
    wd.switchTo().alert().accept();
  }

  public void pressModifacate() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {

    click(By.name("update"));
  }
}

