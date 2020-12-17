import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   SongTest.class,
   DatabaseTest.class,
   JukeboxTest.class
})
public class JunitTestSuite {
}