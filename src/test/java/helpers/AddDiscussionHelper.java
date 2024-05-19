package helpers;

import model.AddDiscussionData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.AppManager;

public class AddDiscussionHelper extends HelperBase {

    public AddDiscussionHelper(AppManager appManager) {
        super(appManager);
    }

    @FindBy(xpath = "//*[@id=\"discussionSubmit\"]/ol/li[2]/div[2]/div[1]/input")
    private WebElement titleInput;

    @FindBy(xpath = "//*[@id=\"discussionSubmit\"]/ol/li[3]/div/div/div[1]")
    private WebElement descriptionInput;

    @FindBy(xpath = "//button[@title='Разные обсуждения']")
    private WebElement newCategoryButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addButton;

    @FindBy(xpath = "//article/div/div[2]/h1/span")
    private WebElement discussionTitle;

    @FindBy(xpath = "//div[@data-lightbox-xhr='{\"name\":\"threads\"}']")
    private WebElement discussionDescription;

    @FindBy(xpath = "//div[@data-lightbox-xhr='{\"name\":\"threads\"}']")
    private WebElement deleteButton;

    private void inputTitle(String title) {
        titleInput.sendKeys(title);
    }

    private void inputDescription(String description) {
        descriptionInput.sendKeys(description);
    }

    private void setCategory() {
        newCategoryButton.click();
    }

    private void addDiscussionClick() {
        addButton.click();
    }

    public void addDiscussion(AddDiscussionData addDiscussionData) {
        inputTitle(addDiscussionData.title);
        inputDescription(addDiscussionData.description);
        setCategory();
        addDiscussionClick();
    }

    public String getDiscussionTitle() {
        return discussionTitle.getText();
    }

    public String getDiscussionDescription() {
        return discussionTitle.getText();
    }

    public void deleteDiscussion() {
        deleteButton.click();
    }
}
