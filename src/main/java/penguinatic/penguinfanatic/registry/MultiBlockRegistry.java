package penguinatic.penguinfanatic.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.blocks.multiblock.fisher.FisherController;
import penguinatic.penguinfanatic.blocks.multiblock.fisher.FisherControllerEntity;

public class MultiBlockRegistry {

    public static final FisherController FISHER_CONTROLLER = new FisherController(AbstractBlock.Settings.of(Material.WOOD));
    public static BlockEntityType<FisherControllerEntity> FISHER_CONTROLLER_ENTITY;
    public static final FisherController FISHER_POLE = new FisherController(AbstractBlock.Settings.of(Material.WOOD));


    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("penguinfanatic", "fisher_controller"), FISHER_CONTROLLER);
        FISHER_CONTROLLER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "penguinfanatic:fisher_controller", BlockEntityType.Builder.create(FisherControllerEntity::new, FISHER_CONTROLLER).build(null));
        Registry.register(Registry.BLOCK, new Identifier("penguinfanatic", "fisher_pole"), FISHER_POLE);
    }

}
