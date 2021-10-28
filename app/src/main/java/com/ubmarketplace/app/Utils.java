package com.ubmarketplace.app;

import java.time.Instant;

public final class Utils {
    public static Long getCurrentEpochMilli() {
        return Instant.now().toEpochMilli();
    }
}
