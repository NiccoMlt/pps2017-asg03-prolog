package it.unibo.pps17.lab10.part2;

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
    public void testSize() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("size([],zero).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("size( [a,b,c], X ).");
        Assert.assertEquals("s(s(s(zero)))", solve.getTerm("X").toString());

        solve = engine.solve("size( [a,c,c,d], s(s(s(s(zero)))) ).");
        Assert.assertTrue(solve.isSuccess());
    }
}
