import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static Session session;
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static void main(String[] args) {
        generateSession();

        Course course = session.get(Course.class, 1);
        System.out.println(course.getName() + " " + course.getStudentsCount() + " " +
                course.getTeacher().getName());
        cleanExit();
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
