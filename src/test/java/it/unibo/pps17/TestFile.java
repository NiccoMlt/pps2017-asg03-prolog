package it.unibo.pps17;

import alice.tuprolog.*;
import alice.tuprolog.event.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;

public abstract class TestFile {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected Prolog engine = null;

    @Before
    public void initEngine() {
        engine = new Prolog();
        engine.addExceptionListener(e -> {
            logger.error("Exception: " + e.getMsg());
            Assert.fail(e.getMsg());
        });
        engine.addOutputListener(e -> logger.info(e.getMsg()));
        engine.addLibraryListener(new LibraryListener() {
            @Override
            public void libraryLoaded(final LibraryEvent e) {
                logger.info(e.getLibraryName() + " loaded");
            }

            @Override
            public void libraryUnloaded(final LibraryEvent e) {
                logger.info(e.getLibraryName() + " unloaded");
            }
        });
        engine.addQueryListener(e -> {
            final SolveInfo si = e.getSolveInfo();
            logger.info("Query: " + si.getQuery());
            if (si.isSuccess()) {
                try {
                    logger.info("Solution: " + si.getSolution().toString());
                } catch (NoSolutionException e1) {
                    logger.error(e1.getLocalizedMessage(), e1);
                }
            } else {
                logger.warn("No solution found");
            }
        });
        engine.addWarningListener(e -> logger.warn(e.getMsg()));
        engine.addTheoryListener(e -> logger.info("New theory: " + e.getNewTheory().toString()));
    }

    @Test
    public void testFile() throws IOException, URISyntaxException {
        try {
            loadFile();
        } catch (final InvalidTheoryException e) {
            Assert.fail("Theory file not valid");
        }
    }

    protected void loadFile() throws IOException, URISyntaxException, InvalidTheoryException {
        final Theory t = new Theory(getFile());
        engine.setTheory(t);
    }

    protected abstract FileInputStream getFile() throws URISyntaxException, FileNotFoundException;
}
