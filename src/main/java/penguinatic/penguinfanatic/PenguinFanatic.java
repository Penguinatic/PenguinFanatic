package penguinatic.penguinfanatic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import penguinatic.penguinfanatic.registry.BlocksRegistry;
import penguinatic.penguinfanatic.registry.EntityRegistry;
import penguinatic.penguinfanatic.registry.ItemsRegistry;
import penguinatic.penguinfanatic.registry.MultiBlockRegistry;

public class PenguinFanatic implements ModInitializer {

    public static final ItemGroup PENGUIN_FANATIC_GROUP = FabricItemGroupBuilder.build(
            new Identifier("penguinfanatic", "general"),
            () -> new ItemStack(ItemsRegistry.PENGUIN_FEATHER)
    );

    @Override
    public void onInitialize() {
        BlocksRegistry.register();
        MultiBlockRegistry.register();
        ItemsRegistry.register();
        EntityRegistry.register();
        registerLoot();
        initSpawns();
    }

    private static void initSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.Category.ICY), SpawnGroup.CREATURE, EntityRegistry.PENGUIN, 100, 15, 20);
    }

    private static void registerLoot() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, manager, id, supplier, setter) -> {
            if(new Identifier("minecraft", "gameplay/fishing/fish").equals(id)) {
                LootPool poolBuilder = FabricLootPoolBuilder.builder()
                        .withEntry(ItemEntry.builder(ItemsRegistry.SQUID_RAW).build()).build();

                supplier.withPool(poolBuilder);
            }

            if(new Identifier("minecraft", "entities/squid").equals(id)) {
                LootPool poolBuilder = FabricLootPoolBuilder.builder()
                        .withEntry(ItemEntry.builder(ItemsRegistry.SQUID_RAW).weight(10).build()).build();

                supplier.withPool(poolBuilder);
            }
        }));
    }

}
