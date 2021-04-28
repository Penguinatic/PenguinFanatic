package penguinatic.penguinfanatic.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.blocks.DisappearingIce;

public class BlocksRegistry {

    public static final DisappearingIce DISAPPEARING_ICE = new DisappearingIce(AbstractBlock.Settings.of(Material.ICE).slipperiness(0.98F).ticksRandomly().strength(0.5F).sounds(BlockSoundGroup.GLASS).nonOpaque());

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("penguinfanatic", "disappearing_ice"), DISAPPEARING_ICE);
    }

}
