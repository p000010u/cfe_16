package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;
import com.teragrep.cfe_16.event.time.InstantiableStub;

import java.util.List;

public final class HECTimestampCandidateImpl implements HECTimestampCandidate {
    private static final Instantiable instantiableStub = new InstantiableStub();
    private final List<HECTimestampCandidate> candidates;

    public HECTimestampCandidateImpl() {
        this(List.of(new DecimalCandidate(), new IntegerCandidate()));
    }

    private HECTimestampCandidateImpl(final List<HECTimestampCandidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public Instantiable toInstantiable(final String timestampString) {
        if (timestampString == null || timestampString.isEmpty()) {
            return instantiableStub;
        }

        final List<Instantiable> successfulInstantiables = candidates
                .stream()
                .map(candidate -> candidate.toInstantiable(timestampString))
                .filter(instantiable -> !instantiable.isStub())
                .toList();

        if (successfulInstantiables.isEmpty()) {
            return instantiableStub;
        }

        if (successfulInstantiables.size() > 1) {
            throw new IllegalArgumentException("Multiple successful timestamp candidates found for timestamp string: <[" + timestampString + "]>");
        }

        return successfulInstantiables.get(0);
    }
}
