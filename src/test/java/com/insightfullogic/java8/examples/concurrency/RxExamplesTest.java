package com.insightfullogic.java8.examples.concurrency;

import com.insightfullogic.java8.examples.music.Artist;
import com.insightfullogic.java8.examples.music.SampleData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RxExamplesTest {

    @Test
    public void filtersAlbums() throws InterruptedException {
        RxExamples examples = new RxExamples(SampleData.getThreeArtists());
        Artist artist = examples.search("John", "UK", 5)
                                .toBlockingObservable()
                                .single();

        assertEquals(SampleData.johnLennon, artist);
    }

}