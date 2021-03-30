package penguinatic.penguinfanatic.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import penguinatic.penguinfanatic.entity.PenguinEntity;

public class PenguinEntityModelOld extends EntityModel<PenguinEntity> {

    private final ModelPart base;

    public PenguinEntityModelOld() {
        this.textureHeight = 64;
        this.textureWidth = 64;
        base = new ModelPart(this, 0, 0);
        base.addCuboid(-6, -6, -6, 12, 12, 12);
    }

    @Override
    public void setAngles(PenguinEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        matrices.translate(0, 1.125, 0);
        base.render(matrices, vertices, light, overlay);
    }
}
