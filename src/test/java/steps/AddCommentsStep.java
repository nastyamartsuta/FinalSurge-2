package steps;

import elements.Textarea;
import io.qameta.allure.Step;
import model.CommentModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddCommentPage;

public class AddCommentsStep extends AbstractCalendarPageSteps {

    public AddCommentsStep(WebDriver driver) {
        super(driver);
    }

    @Step
    public AddCommentsStep openNewCommentPage() {
        commentPage = new AddCommentPage(driver);
        openCalendarPage();
        commentPage.openPage();
        return this;
    }

    @Step
    public AddCommentsStep sendComment (CommentModel commentModel) {
        new Textarea(driver, "Workout Comment").enterTextarea(commentModel.getWorkoutComment());
        return this;
    }
    @Step
    public AddCommentsStep saveNewComment() {
        commentPage.addCommentButton();
        return this;
    }

    @Step
    public AddCommentsStep checkingNewCommentWasAdded(CommentModel commentModel) {
        Assert.assertTrue(commentPage.checkingCommentAdded(), "Comment wasn't added");
        Assert.assertTrue(commentPage.getActualTextComment().contains(commentModel.getWorkoutComment()),"Incorrect text" );
        return this;
    }

    //TODO нужно ли удалять?
    @Step
    public void deleteNewComment() {
        commentPage.deleteCommentButton();
        Assert.assertTrue(commentPage.checkingNewCommentDeleted(),"The comment has wasn't deleted" );
    }
}


