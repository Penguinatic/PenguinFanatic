package penguinatic.penguinfanatic.entity.render;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import penguinatic.penguinfanatic.entity.PenguinEntity;
import penguinatic.penguinfanatic.entity.model.PenguinEntityModel;

public class PenguinEntityRender extends MobEntityRenderer<PenguinEntity, PenguinEntityModel> {

    public PenguinEntityRender(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new PenguinEntityModel(), 0.5f);
    }

    @Override
    public Identifier getTexture(PenguinEntity entity) {
        return new Identifier("penguinfanatic", "textures/entity/penguin/penguin.png");
    }
}
