package org.htmlunit.javascript.host.crypto;

import java.util.Set;

import org.htmlunit.corejs.javascript.NativeObject;
import org.htmlunit.corejs.javascript.ScriptRuntime;
import org.htmlunit.corejs.javascript.Scriptable;
import org.htmlunit.corejs.javascript.ScriptableObject;
import org.htmlunit.corejs.javascript.TopLevel;


final class AesKeyAlgorithm {

    static final Set<String> SUPPORTED_NAMES = Set.of("AES-CBC", "AES-CTR", "AES-GCM", "AES-KW");
    static final Set<Integer> SUPPORTED_LENGTHS = Set.of(128, 192, 256);

    private final String name_;
    private final int length_;

    AesKeyAlgorithm(final String name, final int length) {
        if (!SUPPORTED_NAMES.contains(name)) {
            throw new UnsupportedOperationException("AES " + name);
        }
        name_ = name;

        if (!SUPPORTED_LENGTHS.contains(length)) {
            throw new IllegalArgumentException("Data provided to an operation does not meet requirements");
        }
        length_ = length;
    }

    
    static AesKeyAlgorithm from(final Scriptable keyGenParams) {
        final Object nameProp = ScriptableObject.getProperty(keyGenParams, "name");
        if (!(nameProp instanceof String name)) {
            throw new IllegalArgumentException("An invalid or illegal string was specified");
        }

        final Object lengthProp = ScriptableObject.getProperty(keyGenParams, "length");
        if (!(lengthProp instanceof Number numLength)) {
            throw new IllegalArgumentException("An invalid or illegal string was specified");
        }

        return new AesKeyAlgorithm(name, numLength.intValue());
    }

    static boolean isSupported(final String name) {
        return SUPPORTED_NAMES.contains(name);
    }

    String getName() {
        return name_;
    }

    int getLength() {
        return length_;
    }

    
    Scriptable toScriptableObject(final Scriptable scope) {
        final NativeObject algorithm = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(algorithm, scope, TopLevel.Builtins.Object);
        ScriptableObject.putProperty(algorithm, "name", getName());
        ScriptableObject.putProperty(algorithm, "length", getLength());
        return algorithm;
    }
}