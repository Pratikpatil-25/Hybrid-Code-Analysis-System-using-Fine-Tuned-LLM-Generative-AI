package edu.cornell.med.icb.goby.algorithmic.compression;

import it.unimi.dsi.io.OutputBitStream;

import java.io.IOException;


public interface FastArithmeticCoderI {
    void reset();

    

    int encode(int x, OutputBitStream obs) throws IOException;

    

    int flush(OutputBitStream obs) throws IOException;
}