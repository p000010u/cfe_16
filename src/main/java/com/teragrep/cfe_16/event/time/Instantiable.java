package com.teragrep.cfe_16.event.time;

import com.teragrep.cfe_16.Stubable;

import java.time.Instant;

public interface Instantiable extends Stubable {
    Instant toInstant();
}
