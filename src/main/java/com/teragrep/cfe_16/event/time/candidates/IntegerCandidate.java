package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;
import com.teragrep.cfe_16.event.time.InstantiableImpl;
import com.teragrep.cfe_16.event.time.InstantiableStub;

public final class IntegerCandidate implements HECTimestampCandidate{
    private static final Instantiable instantiableStub = new InstantiableStub();

    public IntegerCandidate() {

    }

    @Override
    public Instantiable toInstantiable(final String timestampString) {
        Instantiable instantiable;
        if (timestampString == null || timestampString.isEmpty()) {
            instantiable = instantiableStub;
        }
        else {
            try {
                final long timestamp = Long.parseLong(timestampString);
                final int len = timestampString.length();
                if (len == 10) {
                    instantiable = new InstantiableImpl(timestamp, 0);
                }
                else if (len == 13) {
                    instantiable = new InstantiableImpl(timestamp);
                }
                else if (len == 16) {
                    instantiable = new InstantiableImpl(timestamp / 1_000L);
                }
                else if (len == 19) {
                    instantiable = new InstantiableImpl(timestamp / 1_000_000L);
                }
                else {
                    instantiable = instantiableStub;
                }
            } catch (final NumberFormatException e) {
                instantiable = instantiableStub;
            }
        }

        return instantiable;
    }
}
