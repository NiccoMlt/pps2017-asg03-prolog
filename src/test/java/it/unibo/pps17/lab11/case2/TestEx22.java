package it.unibo.pps17.lab11.case2;

import it.unibo.pps17.TestFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class TestEx22 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex2.2.pl").toURI()));
    }
}
