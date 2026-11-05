package com.teragrep.cfe_16.event.time;

import com.teragrep.cfe_16.Stubable;

import java.time.Instant;

/**
 * Provides an Instant if applicable. Otherwise is a stub object.
 */
public interface Instantiable extends Stubable {
    Instant toInstant();
}
