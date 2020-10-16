package seedu.taskmaster.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.taskmaster.model.attendance.NamedAttendance;

/**
 * An UI component that displays information of a {@code Student}.
 */
public class AttendanceCard extends UiPart<Region> {

    private static final String FXML = "AttendanceListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final NamedAttendance attendance;

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label nusnetId;
    @FXML
    private Label attendanceStatus;
    @FXML
    private Label name;

    /**
     * Creates a {@code AttendanceCard} with the given {@code AttendanceType} and index to display.
     */
    public AttendanceCard(NamedAttendance attendance, int displayedIndex) {
        super(FXML);
        this.attendance = attendance;
        id.setText(displayedIndex + ". ");
        name.setText(attendance.getName().fullName);
        nusnetId.setText(attendance.getAttendance().getNusnetId().value);
        attendanceStatus.setText(attendance.getAttendance().getAttendanceType().name());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AttendanceCard)) {
            return false;
        }

        // state check
        AttendanceCard card = (AttendanceCard) other;
        return this.attendance.equals(card.attendance);
    }
}