package es.logixs.suites;

import es.logixs.web.controllers.CounterOfferControllerTest;
import es.logixs.web.controllers.OfferControllerTest;
import es.logixs.web.repositories.CounterOfferRepositoryTest;
import es.logixs.web.repositories.OfferRepositoryTest;
import es.logixs.web.services.OfferCounterofferServiceTest;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;

@IncludeTags("offer-counteroffer")
@SelectClasses({
        OfferRepositoryTest.class,
        CounterOfferRepositoryTest.class,
        OfferCounterofferServiceTest.class,
        OfferControllerTest.class,
        CounterOfferControllerTest.class
})
public class OfferTestSuite {

}