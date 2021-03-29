package penguinatic.penguinfanatic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.block.DisappearingIce;
import penguinatic.penguinfanatic.items.PenguinFeatherItem;
import penguinatic.penguinfanatic.items.WalkingStickItem;
import penguinatic.penguinfanatic.registry.EntityRegistry;

public class PenguinFanatic implements ModInitializer {

    public static final ItemGroup PENGUIN_FANATIC_GROUP = FabricItemGroupBuilder.build(
            new Identifier("penguinfanatic", "general"),
            () -> new ItemStack(PenguinFanatic.PENGUIN_FEATHER)
    );

    @Override
    public void onInitialize() {
        registerBlocks();
        registerItems();
        new EntityRegistry().register();
    }

    public static final DisappearingIce DISAPPEARING_ICE = new DisappearingIce(AbstractBlock.Settings.of(Material.ICE).slipperiness(0.98F).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque());

    public void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("penguinfanatic", "disappearing_ice"), DISAPPEARING_ICE);
    }

    public static final PenguinFeatherItem PENGUIN_FEATHER = new PenguinFeatherItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    public static final WalkingStickItem WALKING_STICK = new WalkingStickItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));

    public void registerItems() {
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_FEATHER);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "walking_stick"), WALKING_STICK);
    }

}
