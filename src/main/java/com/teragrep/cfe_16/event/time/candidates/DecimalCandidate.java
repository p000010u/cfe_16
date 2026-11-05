package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;
import com.teragrep.cfe_16.event.time.InstantiableImpl;
import com.teragrep.cfe_16.event.time.InstantiableStub;

public final class DecimalCandidate implements HECTimestampCandidate {
    private static final Instantiable instantiableStub = new InstantiableStub();

    public DecimalCandidate() {

    }

    @Override
    public Instantiable toInstantiable(final String timestampString) {
        final String[] parts = timestampString.split("\\.");
        final Instantiable instantiable;
        if (parts.length == 2 && !parts[0].isEmpty() && !parts[1].isEmpty()) {
            final int len = parts[1].length();
            final int diff = 9 - len;

            if (diff < 0) {
                instantiable = instantiableStub;
            } else {
                instantiable = new InstantiableImpl(Long.parseLong(parts[0]), Long.parseLong(parts[1]) * (long)Math.pow(10, diff));
            }
        }
        else if (parts.length == 1 && timestampString.endsWith(".")) {
            instantiable = new InstantiableImpl(Long.parseLong(parts[0]), 0);
        }
        else {
            instantiable = instantiableStub;
        }

        return instantiable;
    }
}
