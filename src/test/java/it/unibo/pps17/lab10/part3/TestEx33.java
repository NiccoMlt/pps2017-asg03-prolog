package it.unibo.pps17.lab10.part3;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx33 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex3.3.pl").toURI()));
    }

    @Test
    public void testAllBigger() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("sublist([1,2],[5,3,2,1]).");
        Assert.assertTrue(solve.isSuccess());
    }
}
