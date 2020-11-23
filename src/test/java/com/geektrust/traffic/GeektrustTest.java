package com.geektrust.traffic;

import com.geektrust.traffic.exceptions.FilePathException;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GeektrustTest {

    private Geektrust geektrust = new Geektrust();

    @Test
    public void testReadInputFile() throws URISyntaxException, IOException, FilePathException {
        String[] actualResult = geektrust.readInputFile("input.txt");
        String[] expectedResult = {"RAINY", "40", "25"};
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = FilePathException.class)
    public void testReadinputFileThrowsFilePathException() throws URISyntaxException, IOException, FilePathException {
        geektrust.readInputFile("inputFile.txt");
    }
}
