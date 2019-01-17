package it.unibo.pps17.lab10.part3;

import alice.tuprolog.*;
import it.unibo.pps17.TestFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

public class TestEx31 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex3.1.pl").toURI()));
    }

    @Test
    public void testSame() throws InvalidTheoryException, IOException, URISyntaxException, MalformedGoalException, UnknownVarException, NoSolutionException, NoMoreSolutionException {
        loadFile();

        SolveInfo solve = engine.solve("same([],[]).");
        Assert.assertTrue(solve.isSuccess());

        solve = engine.solve("same( [a,b,c], [a,b,c,d] ).");
        Assert.assertFalse(solve.isSuccess());

        solve = engine.solve("same( [a,c,c,d], X ).");
        Assert.assertEquals("[a,c,c,d]", solve.getTerm("X").toString());

        solve = engine.solve("same( X, [a,c,c,d] ).");
        Assert.assertEquals("[a,c,c,d]", solve.getTerm("X").toString());
    }
}
