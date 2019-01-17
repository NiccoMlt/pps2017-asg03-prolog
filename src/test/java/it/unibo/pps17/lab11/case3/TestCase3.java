package it.unibo.pps17.lab11.case3;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestCase3 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("case3.pl").toURI()));
    }

    @Test
    public void testCheck() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("check([x, empty, empty, empty, x, empty, empty, empty, x], x, W).");
        Assert.assertEquals("win(x)", solve.getTerm("W").toString());

        solve = engine.solve("check([x, empty, empty, empty, x, empty, empty, empty, o], x, W).");
        Assert.assertEquals("nothing", solve.getTerm("W").toString());

        solve = engine.solve("check([x, o, x, o, x, o, o, x, o], x, W).");
        Assert.assertEquals("even", solve.getTerm("W").toString());
    }

    @Test
    public void testOther() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("other(x, X).");
        Assert.assertEquals("o", solve.getTerm("X").toString());

        solve = engine.solve("other(X, x).");
        Assert.assertEquals("o", solve.getTerm("X").toString());
    }

    @Test
    public void testMove() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("move([empty, empty | _], x, [X | _]).");
        Assert.assertEquals("x", solve.getTerm("X").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());
    }

    @Test
    public void testGame() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("game([x, o, x, o, x, o, o, x, empty], o, W, _).");
        Assert.assertEquals("even", solve.getTerm("W").toString());

        solve = engine.solve("game([x, o, x, o, x, o, o, o, empty], x, W, _).");
        Assert.assertEquals("win(x)", solve.getTerm("W").toString());
    }
}
