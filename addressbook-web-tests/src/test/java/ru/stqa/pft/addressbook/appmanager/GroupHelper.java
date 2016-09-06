package ru.stqa.pft.addressbook.appmanager;

import com.sun.javafx.binding.ExpressionHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by o.kaluzhin on 19.07.2016.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnGroupPage() {

    click(By.linkText("group page"));
  }

  public void sumbitGroupCreation() {

    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {

    click(By.name("new"));
  }

  public void deleteselectedGroups()
  {
    click(By.name("delete"));
  }

  public void selectGroup() {

    click(By.name("selected[]"));
  }

  public void initGroupModification() {

    click(By.name("edit"));
  }

  public void sumbitGroupModificatiom() {
    click(By.name("update"));
  }
}
