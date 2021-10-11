package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.application.Application;
import seedu.address.model.application.Company;
import seedu.address.model.application.Completion;
import seedu.address.model.application.Deadline;
import seedu.address.model.application.Position;
import seedu.address.model.application.Status;
import seedu.address.model.tag.Tag;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalApplications.getTypicalInternship;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_APPLICATION;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_APPLICATION;

public class CompleteCommandTest {

    private Model model = new ModelManager(getTypicalInternship(), new UserPrefs());

//    @Test
//    public void execute_validIndexUnfilteredList_success() {
//        Application applicationToComplete = model.getFilteredApplicationList()
//                .get(INDEX_FIRST_APPLICATION.getZeroBased());
//        CompleteCommand completeCommand = new CompleteCommand(INDEX_FIRST_APPLICATION);
//
//        String expectedMessage = String.format(CompleteCommand.MESSAGE_SUCCESS, applicationToComplete);
//
//        ModelManager expectedModel = new ModelManager(model.getInternship(), new UserPrefs());
//        Company company = applicationToComplete.getCompany();
//        Position position = applicationToComplete.getPosition();
//        Deadline deadline = applicationToComplete.getDeadline();
//        Status status = applicationToComplete.getStatus();
//        Set<Tag> tagList = applicationToComplete.getTags();
//        Completion completion = new Completion("Completed");
//        Application completedApplication = new Application(company, position, deadline, status, tagList, completion);
//
//        expectedModel.setApplication(applicationToComplete, completedApplication);
//
//        assertCommandSuccess(completeCommand, model, expectedMessage, expectedModel);
//    }

    @Test
    public void equals() {
        CompleteCommand CompleteFirstCommand = new CompleteCommand(INDEX_FIRST_APPLICATION);
        CompleteCommand CompleteSecondCommand = new CompleteCommand(INDEX_SECOND_APPLICATION);

        // same object -> returns true
        assertTrue(CompleteFirstCommand.equals(CompleteFirstCommand));

        // same values -> returns true
        CompleteCommand CompleteFirstCommandCopy = new CompleteCommand(INDEX_FIRST_APPLICATION);
        assertTrue(CompleteFirstCommand.equals(CompleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(CompleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(CompleteFirstCommand.equals(null));

        // different application -> returns false
        assertFalse(CompleteFirstCommand.equals(CompleteSecondCommand));
    }
}