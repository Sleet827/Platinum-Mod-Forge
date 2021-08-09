package net.legiblesleet827.platinum.data.advancements;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.legiblesleet827.platinum.PlatinumMod;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.resources.ResourceLocation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;
    private final List<Consumer<Consumer<Advancement>>> tabs = ImmutableList.of(new PlatinumAdvancements());

    public ModAdvancementProvider(DataGenerator generator) {
        super(generator);
       this.generator = generator;
    }

    @Override
    public void run(HashCache hashCache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (p_123977_) -> {
            if (!set.add(p_123977_.getId())) {
                throw new IllegalStateException("Duplicate advancement " + p_123977_.getId());
            } else {
                Path path1 = createPath(path, p_123977_);

                try {
                    DataProvider.save(GSON, hashCache, p_123977_.deconstruct().serializeToJson(), path1);
                } catch (IOException ioexception) {
                    PlatinumMod.LOGGER.error("Couldn't save advancement {}", path1, ioexception);
                }

            }
        };

        for(Consumer<Consumer<Advancement>> consumer1 : this.tabs) {
            consumer1.accept(consumer);
        }
    }

    private static Path createPath(Path path, Advancement advancement) {
        return path.resolve("data/" + advancement.getId().getNamespace() + "/advancements/" + advancement.getId().getPath() + ".json");
    }
}
