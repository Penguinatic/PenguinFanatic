package penguinatic.penguinfanatic.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import penguinatic.penguinfanatic.PenguinFanatic;

public class ItemsRegistry {

    public static final Item PENGUIN_FEATHER = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));
    public static final Item PENGUIN_EGG = new Item(new FabricItemSettings().group(PenguinFanatic.PENGUIN_FANATIC_GROUP));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_FEATHER);
        Registry.register(Registry.ITEM, new Identifier("penguinfanatic","penguin_feather"), PENGUIN_EGG);
    }

}
