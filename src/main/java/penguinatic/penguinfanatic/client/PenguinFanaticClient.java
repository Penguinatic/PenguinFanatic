package penguinatic.penguinfanatic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import penguinatic.penguinfanatic.registry.EntityRenderRegistry;

@Environment(EnvType.CLIENT)
public class PenguinFanaticClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        new EntityRenderRegistry().register();
    }
}
