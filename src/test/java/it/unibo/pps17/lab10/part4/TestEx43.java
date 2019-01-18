package it.unibo.pps17.lab10.part4;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx43 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex4.3.pl").toURI()));
    }

    @Test
    public void testLast() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("last([1,2,3],5,[1,2,3,5]).");
        Assert.assertTrue(solve.isSuccess());
    }

    @Test
    public void testSeqR2() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("seqR2(4,[0,1,2,3,4]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("seqR2(6, X).");
        Assert.assertEquals("[0,1,2,3,4,5,6]", solve.getTerm("X").toString());

    }
}
