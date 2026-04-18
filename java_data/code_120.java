package com.ibm.mapper.model.algorithms;

import com.ibm.mapper.model.Algorithm;
import com.ibm.mapper.model.BlockCipher;
import com.ibm.mapper.model.BlockSize;
import com.ibm.mapper.model.IPrimitive;
import com.ibm.mapper.model.KeyLength;
import com.ibm.mapper.model.Mode;
import com.ibm.mapper.model.Padding;
import com.ibm.mapper.utils.DetectionLocation;
import javax.annotation.Nonnull;


public final class NOEKEON extends Algorithm implements BlockCipher {

    private static final String NAME = "NOEKEON";

    public NOEKEON(@Nonnull DetectionLocation detectionLocation) {
        super(NAME, BlockCipher.class, detectionLocation);
        this.put(BlockSize.ofDefault(128, detectionLocation));
        this.put(KeyLength.ofDefault(128, detectionLocation));
    }

    public NOEKEON(@Nonnull Mode mode, @Nonnull DetectionLocation detectionLocation) {
        this(detectionLocation);
        this.put(mode);
    }

    public NOEKEON(
            @Nonnull Mode mode,
            @Nonnull Padding padding,
            @Nonnull DetectionLocation detectionLocation) {
        this(detectionLocation);
        this.put(mode);
        this.put(padding);
    }

    public NOEKEON(@Nonnull final Class<? extends IPrimitive> asKind, @Nonnull NOEKEON noekeon) {
        super(noekeon, asKind);
    }
}