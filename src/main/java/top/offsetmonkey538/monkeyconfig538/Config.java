package top.offsetmonkey538.monkeyconfig538;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import top.offsetmonkey538.monkeyconfig538.serializer.ConfigSerializer;

/**
 * A config class.
 */
public abstract class Config {

    /**
     * Called when creating a {@link Jankson} instance.
     * <br />
     * Override to add custom {@link ConfigSerializer serializers}.
     *
     * @param builder The builder to configure.
     * @return the configured {@link Jankson.Builder builder}.
     */
    protected Jankson.Builder configureJankson(Jankson.Builder builder) {
        return builder;
    }

    /**
     * Registers a serializer for the {@link Jankson.Builder builder}.
     *
     * @param builder The builder to add the serializer to.
     * @param type The class for which the serializer is for.
     * @param serializer The serializer itself.
     * @param <T> The class for which the serializer is for.
     */
    protected <T> void registerSerializer(Jankson.Builder builder, Class<T> type, ConfigSerializer<T> serializer) {
        builder.registerSerializer(type, serializer::toJson);
        builder.registerDeserializer(JsonElement.class, type, serializer::fromJson);
    }
}
