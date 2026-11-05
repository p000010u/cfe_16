package com.teragrep.cfe_16.event.time;

import java.time.Instant;
import java.util.Objects;

public final class InstantiableStub implements Instantiable {
    private final boolean isStub;

    public InstantiableStub() {
        this(true);
    }

    private InstantiableStub(final boolean isStub) {
        this.isStub = isStub;
    }

    @Override
    public Instant toInstant() {
        throw new UnsupportedOperationException("toInstant() is not provided by the stub object.");
    }

    @Override
    public boolean isStub() {
        return isStub;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InstantiableStub that = (InstantiableStub) o;
        return isStub == that.isStub;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isStub);
    }
}
