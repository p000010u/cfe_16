package com.teragrep.cfe_16.event.time;

import java.time.Instant;
import java.util.Objects;

public final class InstantiableImpl implements Instantiable{
    private final Instant instant;

    public InstantiableImpl(final long epochSeconds, final long nanos) {
        this(Instant.ofEpochSecond(epochSeconds, nanos));
    }

    public InstantiableImpl(final long epochMillis) {
        this(Instant.ofEpochMilli(epochMillis));
    }

    public InstantiableImpl(final Instant instant) {
        this.instant = instant;
    }

    @Override
    public Instant toInstant() {
        return instant;
    }

    @Override
    public boolean isStub() {
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final InstantiableImpl that = (InstantiableImpl) o;
        return Objects.equals(instant, that.instant);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(instant);
    }
}
