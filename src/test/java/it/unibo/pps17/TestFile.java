package it.unibo.pps17;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Prolog;
import alice.tuprolog.Theory;
import alice.tuprolog.event.ExceptionEvent;
import alice.tuprolog.event.ExceptionListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;

public abstract class TestFile {

    protected Prolog engine = null;

    @Before
    public void initEngine() {
        engine = new Prolog();
        engine.addExceptionListener(e -> Assert.fail(e.getMsg()));
    }

    @Test
    public void testFile() throws IOException, URISyntaxException {
        final Theory t = new Theory(getFile());
        try {
            engine.setTheory(t);
        } catch (final InvalidTheoryException e) {
            Assert.fail("Theory file not valid");
        }
    }

    protected abstract FileInputStream getFile() throws URISyntaxException, FileNotFoundException;
}
