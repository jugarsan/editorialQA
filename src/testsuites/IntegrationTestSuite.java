package testsuites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import repositories.test.PublisherRepositoryTest;
import repositories.test.SubscriberRepositoryTest;
import testsuites.categories.IntegrationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(IntegrationTest.class)
@Suite.SuiteClasses({SubscriberRepositoryTest.class, PublisherRepositoryTest.class})

public class IntegrationTestSuite {
}
