package penguinatic.penguinfanatic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import penguinatic.penguinfanatic.registry.BlocksRegistry;
import penguinatic.penguinfanatic.registry.EntityRegistry;
import penguinatic.penguinfanatic.registry.ItemsRegistry;

public class PenguinFanatic implements ModInitializer {

    public static final ItemGroup PENGUIN_FANATIC_GROUP = FabricItemGroupBuilder.build(
            new Identifier("penguinfanatic", "general"),
            () -> new ItemStack(ItemsRegistry.PENGUIN_FEATHER)
    );

    @Override
    public void onInitialize() {
        BlocksRegistry.register();
        ItemsRegistry.register();
        new EntityRegistry().register();
        initSpawns();
    }

    private static void initSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.ICY), SpawnGroup.CREATURE, EntityRegistry.PENGUIN, 100, 15, 20);
    }

}
