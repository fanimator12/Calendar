import static org.junit.jupiter.api.Assertions.*;

import calendar.Fifo;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class FifoTest {

  private final int TEST_SIZE = 3;

  Fifo sut = null;

  @BeforeEach void setUp() throws Exception {
    sut = new Fifo(TEST_SIZE);
  }

  @AfterEach void tearDown() throws Exception {
  }

  private void fillFifo() {
    for (int i = 0; i < TEST_SIZE; i++) {
      sut.enqueue(i);
    }
  }

  // Zero

  @Test public void testCanBeCreated() {

  }

  @Test public void testIsEmptyWhenCreated() {
    assertTrue(sut.isEmpty());
  }

  @Test public void testIsNotFullWhenCreated() {
    assertFalse(sut.isFull());
  }

  // One

  @Test public void testOneElementCanBeEnqueued() {
    sut.enqueue(1);
  }

  @Test public void testOneElementCanBeDequeued() {
    sut.dequeue();
  }

  @Test public void testOneElementCanBeEnqueuedAndDequeued() {
    sut.enqueue(1);
    int result = (int) sut.dequeue();
    assertEquals(1, result);
  }

  @Test public void testIsNotEmptyWhenOneElementEnqueued() {
    sut.enqueue(1);
    assertFalse(sut.isEmpty());
  }

  @Test public void testIsNotFullWhenOneElementEnqueued() {
    sut.enqueue(1);
    assertFalse(sut.isFull());
  }

  // Many

  @Test public void testTwoElementCanBeEnqueued() {
    sut.enqueue(1);
    sut.enqueue(3);
  }

  @Test public void testTwoElementCanBeEnqueuedAndDequeued() {
    sut.enqueue(1);
    sut.enqueue(3);
    int first = (int) sut.dequeue();
    int second = (int) sut.dequeue();
    assertEquals(1, first);
    assertEquals(3, second);
  }

  // Bounderies

  @Test public void testElementsCanBeEnqueuedToSizeOfFifo() {
    fillFifo();
  }

  @Test public void testElementsCanBeEnqueuedToSizeOfFifoAndDequeued() {
    fillFifo();
    for (int i = 0; i < TEST_SIZE; i++) {
      assertEquals(i, sut.dequeue());
    }
  }



  @Test public void testElementsCanBeEnqueuedToSizeOfFifoAndFifoIsFull() {
    fillFifo();
    assertTrue(sut.isFull());
  }
}