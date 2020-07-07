package com.java8.exercises.chapter3;

import com.java8.examples.chapter1.SampleData;
import org.junit.Test;

import java.util.Arrays;

import static com.java8.exercises.chapter3.Question2.countBandMembersInternal;
import static org.junit.Assert.assertEquals;

public class Question2Test {

    @Test
    public void internal() {
        assertEquals(4, countBandMembersInternal(Arrays.asList(SampleData.johnColtrane, SampleData.theBeatles)));
    }

}
