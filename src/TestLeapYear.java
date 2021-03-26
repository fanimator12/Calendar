import calendar.Fifo;
import calendar.LeapYear1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLeapYear
{

  LeapYear1 year = null;

  @BeforeEach void setUp() throws Exception
  {
    year = new LeapYear1();
  }

  @AfterEach void tearDown() throws Exception
  {

  }

  @Test void testOddYear()
  {
    assertEquals(false, year.isLeapYear(1901));
  }

  @Test void testModulo100()
  {
    assertEquals(false, year.isLeapYear(1900));
  }

  @Test void testModulo400()
  {
    assertEquals(true, year.isLeapYear(1600));
  }

  @Test void testEqualYearNeither100Nor400()
  {
    assertEquals(true, year.isLeapYear(2004));
  }

  @Test void testEqualYearNotLeapYear()
  {
    assertEquals(true, year.isLeapYear(2009));
  }

  @Test void testFifo()
  {
    Fifo fifo = new Fifo(2020);
    output = fifo.isEmpty();
    assertEquals(true, year.isLeapYear(2009));
  }
}
