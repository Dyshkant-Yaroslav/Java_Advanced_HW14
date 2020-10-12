package ua.lviv.lgs.hbm.xml;

import java.util.Arrays;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Application {
public static void main(String[] args) {
	
	Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml");
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties()).build();
	SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	Cart cart = new Cart("Some value", "some name");
	Item i1 = new Item("value1");
	Item i2 = new Item("value2");
	Item i3 = new Item("value3");
	Item i4 = new Item("value4");
	cart.setItems(new HashSet<>(Arrays.asList(i1,i2,i3,i4)));
	session.persist(cart);
	transaction.commit();
	session.close();
}
}
