import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListId key;

    public LinkedPurchaseListId getKey() {
        return key;
    }

    public void setKey(LinkedPurchaseListId key) {
        this.key = key;
    }
}
