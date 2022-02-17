package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GroupPage {

    WebDriver driver;
    public GroupPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void menuGroups() throws InterruptedException {
        WebElement groupMenu = driver.findElement(By.xpath(".//span[text() = 'Groups']"));
        groupMenu.click();
        Thread.sleep(2000);
    }

    public void newGroupAdd(String groupName)
    {
        WebElement createNewGrpButton = driver.findElement(By.xpath(".//span[text() = 'Create New Group']"));
        createNewGrpButton.click();
        WebElement inputGroupName =  driver.findElement(By.xpath("//span[text() = 'Group name']/following-sibling::input"));
        inputGroupName.clear();
        inputGroupName.sendKeys(groupName);
        WebElement clickGroupList = driver.findElement(By.xpath("//span[text() = 'Choose privacy']"));
        clickGroupList.click();
        WebElement clickGroupOption = driver.findElement(By.xpath("//span[contains(text(), 'Only members can see')]"));
        clickGroupOption.click();
        WebElement clickGroupCreateButton = driver.findElement(By.xpath("//div[@role = 'button']/descendant::div//span[text() = 'Create']"));
        clickGroupCreateButton.click();

    }


    public void deleteGroup()
    {
        WebElement reloadPage = driver.findElement(By.xpath(".//span[text() = 'Reload Page']"));
        WebElement backToNewsFeed = driver.findElement(By.xpath(".//span[text() = 'Go to News Feed']"));
    }
}
