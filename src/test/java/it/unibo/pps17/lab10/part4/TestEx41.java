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

public class TestEx41 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex4.1.pl").toURI()));
    }

    @Test
    public void testSeq() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("seq(0, []).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("seq(5,[0,0,0,0,0]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("seq(6, X).");
        Assert.assertEquals("[0,0,0,0,0,0]", solve.getTerm("X").toString());
    }
}
