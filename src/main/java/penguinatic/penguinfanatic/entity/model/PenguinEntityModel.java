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
private final ModelPart upper_body;
	private final ModelPart left_arm_upper;
	private final ModelPart left_arm_lower;
	private final ModelPart right_arm_upper;
	private final ModelPart right_arm_lower;
	private final ModelPart head;
	private final ModelPart beak;
	private final ModelPart lower_body;
	private final ModelPart right_leg;
	private final ModelPart right_flipper;
	private final ModelPart left_leg;
	private final ModelPart left_flipper;
public PenguinEntityModel() {
		textureWidth = 64;
		textureHeight = 64;
		upper_body = new ModelPart(this);
		upper_body.setPivot(0.0F, 5.0F, 1.0F);
		upper_body.setTextureOffset(0, 17).addCuboid(-4.0F, 0.0F, -3.0F, 8.0F, 8.0F, 6.0F, 0.0F, false);

		left_arm_upper = new ModelPart(this);
		left_arm_upper.setPivot(4.0F, 1.0F, 0.0F);
		upper_body.addChild(left_arm_upper);
		setRotationAngle(left_arm_upper, 0.0F, 0.0F, -0.2182F);
		left_arm_upper.setTextureOffset(10, 31).addCuboid(-0.5F, -0.5F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		left_arm_lower = new ModelPart(this);
		left_arm_lower.setPivot(-4.5F, 17.5F, -1.0F);
		left_arm_upper.addChild(left_arm_lower);
		left_arm_lower.setTextureOffset(20, 36).addCuboid(4.0F, -12.0F, 0.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);

		right_arm_upper = new ModelPart(this);
		right_arm_upper.setPivot(-3.75F, 1.5F, 0.0F);
		upper_body.addChild(right_arm_upper);
		setRotationAngle(right_arm_upper, 0.0F, 0.0F, 0.1745F);
		right_arm_upper.setTextureOffset(0, 31).addCuboid(-1.0F, -1.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);

		right_arm_lower = new ModelPart(this);
		right_arm_lower.setPivot(-4.0F, 16.75F, -1.0F);
		right_arm_upper.addChild(right_arm_lower);
		right_arm_lower.setTextureOffset(0, 0).addCuboid(3.0F, -12.0F, 0.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);

		head = new ModelPart(this);
		head.setPivot(0.0F, 0.0F, 0.0F);
		upper_body.addChild(head);
		head.setTextureOffset(23, 26).addCuboid(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);

		beak = new ModelPart(this);
		beak.setPivot(0.0F, 0.0F, 0.0F);
		head.addChild(beak);
		beak.setTextureOffset(6, 31).addCuboid(-1.0F, -3.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		lower_body = new ModelPart(this);
		lower_body.setPivot(-1.0F, 18.0F, -3.0F);
		upper_body.addChild(lower_body);
		lower_body.setTextureOffset(0, 0).addCuboid(-4.0F, -10.0F, -1.0F, 10.0F, 9.0F, 8.0F, 0.0F, false);

		right_leg = new ModelPart(this);
		right_leg.setPivot(-2.0F, 1.0F, 0.0F);
		lower_body.addChild(right_leg);
		right_leg.setTextureOffset(22, 20).addCuboid(-1.0F, -2.0F, 2.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		right_flipper = new ModelPart(this);
		right_flipper.setPivot(5.0F, 0.0F, 0.0F);
		right_leg.addChild(right_flipper);
		right_flipper.setTextureOffset(28, 0).addCuboid(-6.0F, -1.0F, -2.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);

		left_leg = new ModelPart(this);
		left_leg.setPivot(1.0F, -18.0F, 3.0F);
		lower_body.addChild(left_leg);
		left_leg.setTextureOffset(22, 17).addCuboid(1.0F, 17.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		left_flipper = new ModelPart(this);
		left_flipper.setPivot(2.0F, 19.0F, -3.0F);
		left_leg.addChild(left_flipper);
		left_flipper.setTextureOffset(28, 17).addCuboid(-1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
}



	@Override
public void setAngles(PenguinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
}
@Override
public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		
		upper_body.render(matrixStack, buffer, packedLight, packedOverlay);
}
public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
}

	}