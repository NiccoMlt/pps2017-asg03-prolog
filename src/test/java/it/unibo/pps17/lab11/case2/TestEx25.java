package it.unibo.pps17.lab11.case2;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx25 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.5.pl").toURI()));
    }

    @Test
    public void testAnyPath() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("anypath([e(1,2),e(1,3),e(2,3)],1,3,L).");
        Assert.assertEquals("[e(1,2),e(2,3)]", solve.getTerm("L").toString());
        Assert.assertTrue(solve.hasOpenAlternatives());

        solve = engine.solveNext();
        Assert.assertEquals("[e(1,3)]", solve.getTerm("L").toString());
    }
}
