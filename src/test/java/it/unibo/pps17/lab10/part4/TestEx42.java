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

public class TestEx42 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex4.2.pl").toURI()));
    }

    @Test
    public void testSeqR() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("seqR(0, [0]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("seqR(4,[4,3,2,1,0]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("seqR(6, X).");
        Assert.assertEquals("[6,5,4,3,2,1,0]", solve.getTerm("X").toString());

        solve = engine.solve("seqR(X, [6,5,4,3,2,1,0]).");
        Assert.assertEquals("6", solve.getTerm("X").toString());
    }
}
