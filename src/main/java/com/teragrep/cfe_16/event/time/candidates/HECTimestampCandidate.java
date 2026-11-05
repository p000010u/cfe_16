package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;

public interface HECTimestampCandidate {
    Instantiable toInstantiable(final String timestampString);
}
