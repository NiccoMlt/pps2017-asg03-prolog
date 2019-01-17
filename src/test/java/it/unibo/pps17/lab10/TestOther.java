package it.unibo.pps17.lab10;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestOther extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("other.pl").toURI()));
    }

    @Test
    public void testInv() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("inv([1,2,3],[3,2,1]).");
        Assert.assertTrue(solve.isSuccess());
    }

    @Test
    public void testDouble() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("double([1,2,3],[1,2,3,1,2,3]).");
        Assert.assertTrue(solve.isSuccess());
    }

    @Test
    public void testTimes() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("times([1,2,3],3,[1,2,3,1,2,3,1,2,3]).");
        Assert.assertTrue(solve.isSuccess());
    }

    @Test
    public void testProj() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("proj([[1,2],[3,4],[5,6]],[1,3,5]).");
        Assert.assertTrue(solve.isSuccess());
    }
}
