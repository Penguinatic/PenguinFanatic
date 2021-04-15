// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

package penguinatic.penguinfanatic.entity.model;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import penguinatic.penguinfanatic.entity.PenguinEntity;

public class PenguinEntityModel extends EntityModel<PenguinEntity> {

	private final ModelPart body;
	private final ModelPart right_flipper;
	private final ModelPart cube_r1;
	private final ModelPart left_flipper;
	private final ModelPart head;
	private final ModelPart beak;
	private final ModelPart left_arm;
	private final ModelPart cube_r2;
	private final ModelPart right_arm;
	private final ModelPart cube_r3;

public PenguinEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		body = new ModelPart(this);
		body.setPivot(-1.0F, 23.0F, -2.0F);
		body.setTextureOffset(0, 0).addCuboid(-5.0F, -12.0F, -3.0F, 12.0F, 11.0F, 10.0F, 0.0F, false);

		right_flipper = new ModelPart(this);
		right_flipper.setPivot(3.0F, 1.0F, 0.0F);
		body.addChild(right_flipper);
		

		cube_r1 = new ModelPart(this);
		cube_r1.setPivot(-6.5F, -1.0F, -1.0F);
		right_flipper.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.3927F, 0.0F);
		cube_r1.setTextureOffset(34, 0).addCuboid(-2.5F, -1.0F, -4.0F, 5.0F, 2.0F, 8.0F, 0.0F, false);

		left_flipper = new ModelPart(this);
		left_flipper.setPivot(4.5F, 0.0F, -1.0F);
		body.addChild(left_flipper);
		setRotationAngle(left_flipper, 0.0F, -0.3927F, 0.0F);
		left_flipper.setTextureOffset(24, 28).addCuboid(-1.5761F, -1.0F, -4.3827F, 5.0F, 2.0F, 8.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(1.0F, -12.0F, 3.0F);
		body.addChild(head);
		head.setTextureOffset(0, 21).addCuboid(-4.0F, -7.0F, -5.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		beak = new ModelPart(this);
		beak.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(beak);
		beak.setTextureOffset(24, 21).addCuboid(-2.0F, -3.0F, -8.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		left_arm = new ModelPart(this);
		left_arm.setPivot(7.5F, -7.5F, 2.0F);
		body.addChild(left_arm);
		

		cube_r2 = new ModelPart(this);
		cube_r2.setPivot(0.0F, 0.0F, 0.0F);
		left_arm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2618F);
		cube_r2.setTextureOffset(14, 36).addCuboid(-0.5F, -4.5F, -3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);

		right_arm = new ModelPart(this);
		right_arm.setPivot(7.5F, -7.5F, 2.0F);
		body.addChild(right_arm);
		

		cube_r3 = new ModelPart(this);
		cube_r3.setPivot(-13.0F, 0.0F, 0.0F);
		right_arm.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.2618F);
		cube_r3.setTextureOffset(0, 36).addCuboid(-0.5F, -4.5F, -3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
}

	@Override
public void setAngles(PenguinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		body.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}