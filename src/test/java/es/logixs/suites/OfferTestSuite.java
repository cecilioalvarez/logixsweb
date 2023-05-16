package es.logixs.suites;

import es.logixs.web.controllers.CounterOfferControllerTest;
import es.logixs.web.controllers.OfferControllerTest;
import es.logixs.web.repositories.CounterOfferRepositoryTest;
import es.logixs.web.repositories.OfferRepositoryTest;
import es.logixs.web.services.OfferCounterofferServiceTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite for Offers and Counters")
@SelectClasses({
        OfferRepositoryTest.class,
        CounterOfferRepositoryTest.class,
        OfferCounterofferServiceTest.class,
        OfferControllerTest.class,
        CounterOfferControllerTest.class
})
public class OfferTestSuite {

}