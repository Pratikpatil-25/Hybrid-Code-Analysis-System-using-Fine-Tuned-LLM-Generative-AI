package com.codahale.metrics;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;

import static java.lang.Math.floor;


public class UniformSnapshot extends Snapshot {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final long[] values;

    
    public UniformSnapshot(Collection<Long> values) {
        final Object[] copy = values.toArray();
        this.values = new long[copy.length];
        for (int i = 0; i < copy.length; i++) {
            this.values[i] = (Long) copy[i];
        }
        Arrays.sort(this.values);
    }

    
    public UniformSnapshot(long[] values) {
        this.values = Arrays.copyOf(values, values.length);
        Arrays.sort(this.values);
    }

    
    @Override
    public double getValue(double quantile) {
        if (quantile < 0.0 || quantile > 1.0 || Double.isNaN( quantile )) {
            throw new IllegalArgumentException(quantile + " is not in [0..1]");
        }

        if (values.length == 0) {
            return 0.0;
        }

        final double pos = quantile * (values.length + 1);
        final int index = (int) pos;

        if (index < 1) {
            return values[0];
        }

        if (index >= values.length) {
            return values[values.length - 1];
        }

        final double lower = values[index - 1];
        final double upper = values[index];
        return lower + (pos - floor(pos)) * (upper - lower);
    }

    
    @Override
    public int size() {
        return values.length;
    }

    
    @Override
    public long[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    
    @Override
    public long getMax() {
        if (values.length == 0) {
            return 0;
        }
        return values[values.length - 1];
    }

    
    @Override
    public long getMin() {
        if (values.length == 0) {
            return 0;
        }
        return values[0];
    }

    
    @Override
    public double getMean() {
        if (values.length == 0) {
            return 0;
        }

        double sum = 0;
        for (long value : values) {
            sum += value;
        }
        return sum / values.length;
    }

    
    @Override
    public double getStdDev() {
        
        if (values.length <= 1) {
            return 0;
        }

        final double mean = getMean();
        double sum = 0;

        for (long value : values) {
            final double diff = value - mean;
            sum += diff * diff;
        }

        final double variance = sum / (values.length - 1);
        return Math.sqrt(variance);
    }

    
    @Override
    public void dump(OutputStream output) {
        final PrintWriter out = new PrintWriter(new OutputStreamWriter(output, UTF_8));
        try {
            for (long value : values) {
                out.printf("%d%n", value);
            }
        } finally {
            out.close();
        }
    }
}