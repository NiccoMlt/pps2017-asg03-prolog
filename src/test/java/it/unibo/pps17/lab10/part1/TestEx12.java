package it.unibo.pps17.lab10.part1;

import it.unibo.pps17.TestFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class TestEx12 extends TestFile {

    @Override
    protected FileInputStream getFile() throws URISyntaxException, FileNotFoundException {
        return new FileInputStream(new File(getClass().getResource("ex1.2.pl").toURI()));
    }
}
