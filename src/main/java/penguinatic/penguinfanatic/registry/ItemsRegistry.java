package penguinatic.penguinfanatic.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.PenguinFanatic;
import penguinatic.penguinfanatic.items.IcePathGemstoneItem;
import penguinatic.penguinfanatic.items.PenguinEggItem;

public class ItemsRegistry {

    public static final Item PENGUIN_FEATHER = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    public static final PenguinEggItem PENGUIN_EGG = new PenguinEggItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    public static final Item SQUID_RAW = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP).food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3F).meat().build()));
    public static final Item SQUID_COOKED = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.6F).meat().build()));

    public static final IcePathGemstoneItem ICE_PATH_GEMSTONE = new IcePathGemstoneItem(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP).maxDamage(5));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_FEATHER);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_egg"), PENGUIN_EGG);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","squid_raw"), SQUID_RAW);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","squid_cooked"), SQUID_COOKED);

        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "ice_path_gemstone"), ICE_PATH_GEMSTONE);

        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "fisher_controller"), new BlockItem(MultiBlockRegistry.FISHER_CONTROLLER, new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP)));
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic", "fisher_pole"), new BlockItem(MultiBlockRegistry.FISHER_POLE, new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP)));
    }

}
