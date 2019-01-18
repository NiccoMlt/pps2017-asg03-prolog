package it.unibo.pps17.lab10.part1;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx13 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex1.3.pl").toURI()));
    }

    @Test
    public void testSearchTwo() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("search_two(a,[b,c,a,a,d,e]).");
        Assert.assertFalse(solve.isSuccess());

        solve = engine.solve("search_two(a,[b,c,a,d,a,d,e]).");
        Assert.assertTrue(solve.isSuccess());
    }
}
