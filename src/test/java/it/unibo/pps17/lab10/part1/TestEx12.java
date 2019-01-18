package it.unibo.pps17.lab10.part1;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx12 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex1.2.pl").toURI()));
    }

    @Test
    public void testSearch2() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("search2(a,[b,c,a,a,d,e,a,a,g,h]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("search2(a,[b,c,a,a,a,d,e]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("search2(X,[b,c,a,a,d,d,e]).");
        Assert.assertEquals("a", solve.getTerm("X").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();
        Assert.assertEquals("d", solve.getTerm("X").toString());

        solve = engine.solve("search2(a,L).");
        Assert.assertTrue(solve.getTerm("L") instanceof Struct);

        solve = engine.solve("search2(a,[_,_,a,_,a,_]).");
        Assert.assertTrue(solve.isSuccess());
    }
}
