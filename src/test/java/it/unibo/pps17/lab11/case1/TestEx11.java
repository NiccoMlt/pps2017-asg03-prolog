package it.unibo.pps17.lab11.case1;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx11 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex1.1.pl").toURI()));
    }

    @Test
    public void testDropFirst() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("dropFirst(10,[10,20,10,30,10],L).");
        Assert.assertEquals("[20,10,30,10]", solve.getTerm("L").toString());
    }

    @Test
    public void testDropLast() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("dropLast(10,[10,20,10,30,10],L).");
        Assert.assertEquals("[10,20,10,30]", solve.getTerm("L").toString());
    }

    @Test
    public void testDropAll() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("dropAll(10,[10,20,10,30,10],L).");
        Assert.assertEquals("[20,30]", solve.getTerm("L").toString());
    }
}
