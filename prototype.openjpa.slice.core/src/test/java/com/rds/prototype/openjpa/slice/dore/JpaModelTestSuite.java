package com.rds.prototype.openjpa.slice.dore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.*;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author gadeichhorn
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    com.rds.prototype.openjpa.slice.core.jpa.MessageTest.class,
    com.rds.prototype.openjpa.slice.core.jpa.MessageCacheTest.class,
    com.rds.prototype.openjpa.slice.core.jpa.JpaMessageTest.class,
    com.rds.prototype.openjpa.slice.core.jpa.JpaMessageCacheTest.class
})
public class JpaModelTestSuite {

    private static EntityManagerFactory emf;
    @ClassRule
    public static ExternalResource resource = new ExternalResource() {

        @Override
        protected void after() {
            emf.close();
        }

        @Override
        protected void before() throws Throwable {
            emf = Persistence.createEntityManagerFactory("prototype.slice.test");
        }
    };

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

}
