import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
public class PurchaseList
{
    @EmbeddedId
    private PurchaseListId purchaseListId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_name", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_name", insertable = false, updatable = false)
    private Course course;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public PurchaseListId getPurchaseListId() {
        return purchaseListId;
    }

    public void setPurchaseListId(PurchaseListId purchaseListId) {
        this.purchaseListId = purchaseListId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
