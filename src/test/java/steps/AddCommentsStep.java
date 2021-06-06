package steps;

import elements.Textarea;
import io.qameta.allure.Step;
import model.CommentModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddCommentPage;

import static pages.BasePage.*;
import static pages.CalendarPage.WORKOUTS;

public class AddCommentsStep extends AbstractCalendarPageSteps {



    public AddCommentsStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open Comment page")
    public AddCommentsStep openNewCommentPage() {
        commentPage = new AddCommentPage(driver);
        openCalendarPage();
        calendarPage.openMenu(WORKOUTS, DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        commentPage.findAddCommentsButton(DAY_PATTERN, MONTH_PATTERN, YEAR_PATTERN);
        return this;
    }

    @Step("Add a comment")
    public AddCommentsStep sendComment() {
        new Textarea(driver, "Workout Comment").enterTextarea(CommentModel.workoutComment);
        return this;
    }

    @Step("Save new comment")
    public AddCommentsStep saveNewComment() {
        commentPage.addCommentButton();
        return this;
    }

    @Step("Checking that the new comment was added")
    public AddCommentsStep checkingNewCommentWasAdded() {
        Assert.assertTrue(commentPage.checkingCommentAdded(), "Comment wasn't added");
        Assert.assertTrue(commentPage.getActualTextComment().contains(CommentModel.workoutComment), "Incorrect text");
        return this;
    }

    @Step("Delete the comment")
    public AddCommentsStep deleteNewComment() {
        commentPage.deleteCommentButton();
        Assert.assertTrue(commentPage.checkingNewCommentDeleted(), "The comment has wasn't deleted");
        return this;
    }

    @Step("Close comment page")
    public void closeCommentPage() {
        driver.switchTo().defaultContent();
        commentPage.clickCloseCommentButton();
        validateComponentIsLoaded(calendarPage);
    }
}


