package it.unibo.pps17.lab10.part1;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;

public class TestEx11 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex1.1.pl").toURI()));
    }

    @Test
    public void testQuerySearch() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException {
        loadFile();
        SolveInfo solve = engine.solve("search(a, [b,c,a,f]).");
        Assert.assertTrue(solve.isSuccess());
        solve = engine.solve("search(a,[c,d,e]).");
        Assert.assertFalse(solve.isSuccess());
    }

    @Test
    public void testIterationSearch() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, NoSolutionException, UnknownVarException, NoMoreSolutionException {
        loadFile();
        SolveInfo solve = engine.solve("search(X,[a,b,c]).");

        Assert.assertEquals("a", solve.getTerm("X").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();

        Assert.assertEquals("b", solve.getTerm("X").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();

        Assert.assertEquals("c", solve.getTerm("X").toString());
    }

    @Test
    public void testGenerationSearch() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, NoSolutionException, UnknownVarException, NoMoreSolutionException {
        loadFile();
        SolveInfo solve = engine.solve("search(a,X).");

        final Term solution = solve.getTerm("X");
        Assert.assertTrue(solution instanceof Struct);

        solve = engine.solve("search(a,[X,b,Y,Z]).");

        Assert.assertTrue("a".equals(solve.getTerm("X").toString()) ||
                "a".equals(solve.getTerm("Y").toString()) ||
                "a".equals(solve.getTerm("Z").toString()));

        solve = engine.solve("search(X,Y).");

        Assert.assertFalse(solve.getTerm("X") instanceof Struct);
        Assert.assertTrue(solve.getTerm("Y") instanceof Struct);
    }
}
