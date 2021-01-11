import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription
{
    @EmbeddedId
    private SubscriptionId subscriptionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false)
    private Student student;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public SubscriptionId getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(SubscriptionId subscriptionId) {
        this.subscriptionId = subscriptionId;
    }


    public Course getCourse()
    {
        return course;
    }

    public void setCourse(Course course)
    {
        this.course = course;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Date getSubscriptionDate()
    {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate)
    {
        this.subscriptionDate = subscriptionDate;
    }
}
