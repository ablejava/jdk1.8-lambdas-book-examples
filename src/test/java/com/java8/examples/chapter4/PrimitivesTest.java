package com.java8.examples.chapter4;

import com.java8.examples.chapter1.SampleData;
import org.junit.Test;

public class PrimitivesTest {

    @Test
    public void albumStatistics() {
        Primitives.printTrackLengthStatistics(SampleData.aLoveSupreme);
    }

}
