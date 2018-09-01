package com.codecool;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {

    MinHeap minHeap;

   @BeforeEach
   void setup() {
       minHeap = new MinHeap();
   }

   @Test
    void testPollAndPeekWhileEmpty() {

       assertAll(
               () -> assertThrows(IllegalStateException.class, () -> minHeap.peek()),
               () -> assertThrows(IllegalStateException.class, () -> minHeap.poll())
       );
   }

   @Test
    void testPoll() {
       minHeap.add(32);
       minHeap.add(45);
       minHeap.add(1);
       minHeap.add(23);
       minHeap.add(12);

       assertAll(
               () -> assertEquals(1, minHeap.poll())
       );
   }

   @Test
    void testPeek() {
       minHeap.add(100);
       minHeap.add(90);
       minHeap.add(2);

       assertEquals(2, minHeap.peek());
   }

   @Test
    void testAdd() {
       minHeap.add(100);
       minHeap.add(90);
       minHeap.add(2);

       assertEquals(3, minHeap.getSize());
   }
}
