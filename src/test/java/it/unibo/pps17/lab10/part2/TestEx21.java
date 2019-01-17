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

public class TestEx21 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.1.pl").toURI()));
    }

    @Test
    public void testSize() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("size([],0).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("size([a, b, c, d], 4).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("size([a, b, c, d], X).");
        Assert.assertEquals("4", solve.getTerm("X").toString());
    }
}
