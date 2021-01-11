import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FillInPurchaseListId {
    private static Session session;
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static void main(String[] args) {
        generateSession();


        cleanExit();
    }
    private static void FillInTable(){
        List<Subscription> subscriptions = getAllSubscriptions();
        Transaction transaction = session.beginTransaction();
        for (Subscription subscription : subscriptions) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            LinkedPurchaseListId linkedPurchaseListId = new LinkedPurchaseListId();
            linkedPurchaseListId.setStudentId(subscription.getStudent().getId());
            linkedPurchaseListId.setCourseId(subscription.getCourse().getId());
            linkedPurchaseList.setKey(linkedPurchaseListId);
            session.save(linkedPurchaseList);
        }
        transaction.commit();
    }

    private static List<Subscription> getAllSubscriptions(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Subscription> cq = cb.createQuery(Subscription.class);
        Root<Subscription> root = cq.from(Subscription.class);
        CriteriaQuery<Subscription> all = cq.select(root);

        TypedQuery<Subscription> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    private static void generateSession() {
        registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
    }

    private static void cleanExit(){
        session.close();
        sessionFactory.close();
        registry.close();
    }
}
