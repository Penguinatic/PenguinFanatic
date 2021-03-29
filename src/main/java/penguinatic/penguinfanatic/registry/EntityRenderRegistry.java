package penguinatic.penguinfanatic.registry;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import penguinatic.penguinfanatic.entity.render.PenguinEntityRender;

public class EntityRenderRegistry {

    public static void register() {
        EntityRendererRegistry.INSTANCE.register(EntityRegistry.PENGUIN, (dispatcher, context) -> {
            return new PenguinEntityRender(dispatcher);
        });
    }

}
