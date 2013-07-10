package testsuites;

import components.test.PublisherTest;
import components.test.SubscriberTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testsuites.categories.UnitTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(UnitTest.class)
@Suite.SuiteClasses({PublisherTest.class, SubscriberTest.class})

public class UnitTestSuite {
}
