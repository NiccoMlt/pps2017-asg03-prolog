package it.unibo.pps17.lab11.case2;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx22 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.2.pl").toURI()));
    }

    @Test
    public void testFromCircList() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("fromCircList([10,20,30],[e(10,20),e(20,30),e(30,10)]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("fromCircList([10,20],[e(10,20),e(20,10)]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("fromCircList([10],[e(10,10)]).");
        Assert.assertTrue(solve.isSuccess());
    }
}
