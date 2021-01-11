import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SubscriptionId implements Serializable {
    @Column(name = "student_id")
    int studentId;

    @Column(name = "course_id")
    int courseId;
}
