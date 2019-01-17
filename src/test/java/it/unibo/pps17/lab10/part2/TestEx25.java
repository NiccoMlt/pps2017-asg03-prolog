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

public class TestEx25 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.5.pl").toURI()));
    }

    @Test
    public void testMax() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("max([1,2,3], 3 ).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("max([1], A ).");
        Assert.assertEquals("1", solve.getTerm("A").toString());

        solve = engine.solve("max([3, 1, 5, 4], A ).");
        Assert.assertEquals("5", solve.getTerm("A").toString());

    }
}
