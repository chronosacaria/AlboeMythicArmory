package dev.timefall.albow.util.helper;

import java.util.UUID;

public enum UUIDHelper {
    SHADOWFANG_SPEED_BOOST_ID(UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635"));

    private final UUID uuid;

    UUIDHelper(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return this.uuid;
    }
}
