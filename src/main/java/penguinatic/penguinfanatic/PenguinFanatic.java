package penguinatic.penguinfanatic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.items.PenguinFeatherItem;

public class PenguinFanatic implements ModInitializer {

    public static final ItemGroup PENGUIN_FANATIC_GROUP = FabricItemGroupBuilder.build(
            new Identifier("penguinfanatic", "general"),
            () -> new ItemStack(PenguinFanatic.PENGUIN_FEATHER)
    );

    @Override
    public void onInitialize() {
        registerBlocks();
        registerItems();
    }

    public void registerBlocks() {

    }

    public static final PenguinFeatherItem PENGUIN_FEATHER = new PenguinFeatherItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));

    public void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_FEATHER);
    }
}
