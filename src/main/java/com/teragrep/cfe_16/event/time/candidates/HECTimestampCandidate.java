package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;

/**
 * Checks if the given timestamp string matches the format expected by the HECTimestampCandidate object.
 * If it matches, an Instantiable implementation object will be returned.
 * Otherwise, a stub object is returned.
 */
public interface HECTimestampCandidate {
    Instantiable toInstantiable(final String timestampString);
}
