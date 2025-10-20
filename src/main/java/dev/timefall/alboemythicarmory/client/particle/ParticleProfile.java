package dev.timefall.alboemythicarmory.client.particle;

public record ParticleProfile(
        float red,
        float green,
        float blue,
        float initialScaleMultiplier,
        int ageBase,
        int ageJitter,
        float baseAlpha,
        float angleSpeed,
        float radiusMax,
        float radiusScale,
        float risePerTick
) {
    public static final ParticleProfile STUNNED = new ParticleProfile(
            1.0f,
            0.9f,
            0.0f,
            0.75f,
            40,
            20,
            0.5f,
            0.5f,
            0.5f,
            0.1f,
            0.01f
    );

    public static final ParticleProfile MARKED = new ParticleProfile(
            0.7f,
            0.2f,
            1.0f,
            0.75f,
            40,
            20,
            0.5f,
            0.5f,
            0.5f,
            0.1f,
            0.01f
    );
}