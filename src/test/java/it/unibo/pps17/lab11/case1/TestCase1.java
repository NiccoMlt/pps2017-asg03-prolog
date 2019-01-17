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

public class TestCase1 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("case1.pl").toURI()));
    }

    @Test
    public void testDropAny() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("dropAny(10,[10,20,10,30,10],L).");
        Assert.assertEquals("[20,10,30,10]", solve.getTerm("L").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();
        Assert.assertEquals("[10,20,30,10]", solve.getTerm("L").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();
        Assert.assertEquals("[10,20,10,30]", solve.getTerm("L").toString());
    }
}
