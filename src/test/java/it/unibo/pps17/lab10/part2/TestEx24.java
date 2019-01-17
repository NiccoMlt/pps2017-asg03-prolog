package it.unibo.pps17.lab10.part2;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx24 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.4.pl").toURI()));
    }

    @Test
    public void testAverage() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("average([1,2,3], A ).");
        Assert.assertEquals("2", solve.getTerm("A").toString());

        solve = engine.solve("average([1], A ).");
        Assert.assertEquals("1", solve.getTerm("A").toString());
    }
}
