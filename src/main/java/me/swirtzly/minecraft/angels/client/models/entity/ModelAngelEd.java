package me.swirtzly.minecraft.angels.client.models.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.swirtzly.minecraft.angels.WeepingAngels;
import me.swirtzly.minecraft.angels.client.poses.AngelPoses;
import me.swirtzly.minecraft.angels.client.poses.PoseBase;
import me.swirtzly.minecraft.angels.common.entities.WeepingAngelEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Angel Type: 1
 * Weeping Angel - EdusgprNetwork Created using Tabula 5.1.0
 */
public class ModelAngelEd<T extends LivingEntity> extends EntityModel<WeepingAngelEntity> implements IAngelModel {

	private final ResourceLocation TEXTURE = new ResourceLocation(WeepingAngels.MODID,
			"textures/entities/angel_2.png");

	private ModelRenderer right_wing_0;
	private ModelRenderer left_wing_0;
	private ModelRenderer back_cloth_2;
	private ModelRenderer head_2;
	private ModelRenderer body_2;
	private ModelRenderer head;
	private ModelRenderer body;
	private ModelRenderer left_arm;
	private ModelRenderer right_arm;
	private ModelRenderer cloth_0;
	private ModelRenderer cloth_1;
	private ModelRenderer cloth_2;
	private ModelRenderer back_cloth;
	private ModelRenderer left_wing_1;
	private ModelRenderer right_wing_1;
	private ModelRenderer nose;
	private ModelRenderer face;
	private ModelRenderer right_eyebrow;
	private ModelRenderer left_eyebrow;
	private ModelRenderer coverup;
	private ModelRenderer angry_mouth;
	private ModelRenderer teeth;
	private ModelRenderer teeth_1;
	private ModelRenderer teeth_2;
	private ModelRenderer teeth_3;
	private ModelRenderer teeth_4;
	private ModelRenderer teeth_5;
	private ModelRenderer left_arm_1;
	private ModelRenderer right_arm_1;
	private ModelRenderer zeth;
	private ModelRenderer left_wing_2;
	private ModelRenderer left_wing_3;
	private ModelRenderer left_wing_4;
	private ModelRenderer right_wing_2;
	private ModelRenderer right_wing_3;
	private ModelRenderer right_wing_4;
	/**
	 * Angel Type: 1
	 */
	public ModelAngelEd() {
		textureWidth = 88;
		textureHeight = 88;
		teeth_1 = new ModelRenderer(this, 63, 39);
		teeth_1.setRotationPoint(0.8F, -3.0F, 0.0F);
		teeth_1.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth_1, 0.0F, 0.0F, -0.7853981633974483F);
		left_arm_1 = new ModelRenderer(this, 34, 52);
		left_arm_1.setRotationPoint(0.0F, 4.0F, 2.0F);
		left_arm_1.addBox(-1.0F, 0.0F, -4.0F, 3, 6, 4, 0.0F);
		cloth_1 = new ModelRenderer(this, 34, 44);
		cloth_1.setRotationPoint(0.0F, 24.0F, 3.3F);
		cloth_1.addBox(-4.0F, -1.0F, -2.5F, 8, 1, 5, 0.0F);
		left_wing_4 = new ModelRenderer(this, 22, 36);
		left_wing_4.setRotationPoint(0.0F, 5.0F, 0.0F);
		left_wing_4.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		setRotateAngle(left_wing_4, -1.1383037381507017F, 0.0F, 0.0F);
		teeth_3 = new ModelRenderer(this, 63, 39);
		teeth_3.setRotationPoint(-0.5F, -3.0F, 0.0F);
		teeth_3.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth_3, 0.0F, 0.0F, -0.7853981633974483F);
		right_arm = new ModelRenderer(this, 0, 32);
		right_arm.setRotationPoint(-5.0F, 2.5F, 0.0F);
		right_arm.addBox(-2.0F, -2.0F, -2.0F, 3, 6, 4, 0.0F);
		setRotateAngle(right_arm, 0.0F, 0.0F, 0.10000736613927509F);
		head = new ModelRenderer(this, 0, 16);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		cloth_0 = new ModelRenderer(this, 9, 43);
		cloth_0.setRotationPoint(0.0F, 24.0F, 0.0F);
		cloth_0.addBox(-5.0F, -1.0F, -2.0F, 10, 1, 5, 0.0F);
		teeth_2 = new ModelRenderer(this, 63, 39);
		teeth_2.setRotationPoint(0.5F, -3.0F, 0.0F);
		teeth_2.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth_2, 0.0F, 0.0F, -0.7853981633974483F);
		nose = new ModelRenderer(this, 32, 0);
		nose.setRotationPoint(0.0F, -4.5F, -4.0F);
		nose.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
		setRotateAngle(nose, -0.2246238747316702F, 0.0F, 0.0F);
		coverup = new ModelRenderer(this, 54, 34);
		coverup.setRotationPoint(0.0F, -6.0F, -4.0F);
		coverup.addBox(-4.0F, 0.0F, -0.03F, 8, 1, 1, 0.0F);
		face = new ModelRenderer(this, 54, 28);
		face.setRotationPoint(0.0F, -4.5F, -4.0F);
		face.addBox(-3.0F, 0.0F, -0.01F, 6, 3, 1, 0.0F);
		back_cloth = new ModelRenderer(this, 60, 44);
		back_cloth.setRotationPoint(0.0F, 12.0F, 2.0F);
		back_cloth.addBox(-3.0F, 0.0F, -3.0F, 6, 12, 3, 0.0F);
		setRotateAngle(back_cloth, 0.2792526803190927F, 0.0F, 0.0F);
		teeth_5 = new ModelRenderer(this, 63, 39);
		teeth_5.setRotationPoint(0.15F, -3.0F, 0.0F);
		teeth_5.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth_5, 0.0F, 0.0F, -0.7853981633974483F);
		cloth_2 = new ModelRenderer(this, 10, 32);
		cloth_2.setRotationPoint(0.0F, 24.0F, 6.6F);
		cloth_2.addBox(-3.0F, -1.0F, -2.5F, 6, 1, 3, 0.0F);
		left_wing_1 = new ModelRenderer(this, 24, 0);
		left_wing_1.setRotationPoint(2.4F, 2.0F, 1.5F);
		left_wing_1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		setRotateAngle(left_wing_1, 1.53588974175501F, 0.9424777960769379F, 0.0F);
		head_2 = new ModelRenderer(this, 0, 0);
		head_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		head_2.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
		right_wing_2 = new ModelRenderer(this, 46, 27);
		right_wing_2.setRotationPoint(0.0F, 4.0F, -1.0F);
		right_wing_2.addBox(-1.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
		setRotateAngle(right_wing_2, 1.2292353921796064F, 0.0F, 0.0F);
		zeth = new ModelRenderer(this, 20, 50);
		zeth.setRotationPoint(0.0F, 0.0F, -2.0F);
		zeth.addBox(-4.5F, -1.0F, -0.6F, 9, 1, 1, 0.0F);
		back_cloth_2 = new ModelRenderer(this, 0, 49);
		back_cloth_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		back_cloth_2.addBox(-3.0F, 0.0F, -3.0F, 6, 12, 3, 0.25F);
		setRotateAngle(back_cloth_2, 0.0F, 0.0F, 0.0F);
		teeth_4 = new ModelRenderer(this, 63, 39);
		teeth_4.setRotationPoint(-0.15F, -3.0F, 0.0F);
		teeth_4.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth_4, 0.0F, 0.0F, -0.7853981633974483F);
		right_wing_4 = new ModelRenderer(this, 24, 16);
		right_wing_4.setRotationPoint(0.0F, 5.0F, 0.0F);
		right_wing_4.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		setRotateAngle(right_wing_4, -1.1383037381507017F, 0.0F, 0.0F);
		body_2 = new ModelRenderer(this, 32, 0);
		body_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		body_2.addBox(-4.0F, 0.0F, -2.0F, 8, 23, 4, 0.25F);
		right_wing_1 = new ModelRenderer(this, 0, 0);
		right_wing_1.setRotationPoint(-2.4F, 2.0F, 1.5F);
		right_wing_1.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		setRotateAngle(right_wing_1, 1.53588974175501F, -0.9424777960769379F, 0.0F);
		left_eyebrow = new ModelRenderer(this, 62, 32);
		left_eyebrow.setRotationPoint(3.0F, -4.5F, -4.0F);
		left_eyebrow.addBox(-2.5F, -1.0F, -0.02F, 3, 1, 1, 0.0F);
		angry_mouth = new ModelRenderer(this, 63, 36);
		angry_mouth.setRotationPoint(0.0F, 0.0F, -4.0F);
		angry_mouth.addBox(-2.0F, -1.8F, -0.02F, 4, 2, 1, 0.0F);
		right_wing_3 = new ModelRenderer(this, 0, 16);
		right_wing_3.setRotationPoint(0.0F, 7.0F, 2.0F);
		right_wing_3.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		setRotateAngle(right_wing_3, -1.2292353921796064F, 0.0F, 0.0F);
		right_eyebrow = new ModelRenderer(this, 54, 32);
		right_eyebrow.setRotationPoint(-3.0F, -4.5F, -4.0F);
		right_eyebrow.addBox(-0.5F, -1.0F, -0.02F, 3, 1, 1, 0.0F);
		left_wing_2 = new ModelRenderer(this, 78, 42);
		left_wing_2.setRotationPoint(0.0F, 4.0F, -1.0F);
		left_wing_2.addBox(-1.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
		setRotateAngle(left_wing_2, 1.2292353921796064F, 0.0F, 0.0F);
		body = new ModelRenderer(this, 56, 0);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addBox(-4.0F, 0.0F, -2.0F, 8, 24, 4, 0.0F);
		right_wing_0 = new ModelRenderer(this, 0, 49);
		right_wing_0.setRotationPoint(-2.4F, 2.0F, 1.5F);
		right_wing_0.addBox(0.0F, 0.0F, -13.0F, 1, 11, 18, 0.0F);
		setRotateAngle(right_wing_0, 1.53588974175501F, -0.9424777960769379F, 0.0F);
		teeth = new ModelRenderer(this, 63, 39);
		teeth.setRotationPoint(-0.8F, -3.0F, 0.0F);
		teeth.addBox(-1.0F, 0.0F, -0.03F, 1, 1, 1, 0.0F);
		setRotateAngle(teeth, 0.0F, 0.0F, -0.7853981633974483F);
		left_wing_0 = new ModelRenderer(this, 38, 50);
		left_wing_0.setRotationPoint(2.4F, 2.0F, 1.5F);
		left_wing_0.addBox(-1.0F, 0.0F, -13.0F, 1, 11, 18, 0.0F);
		setRotateAngle(left_wing_0, 1.53588974175501F, 0.9424777960769379F, 0.0F);
		left_wing_3 = new ModelRenderer(this, 14, 36);
		left_wing_3.setRotationPoint(0.0F, 7.0F, 2.0F);
		left_wing_3.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		setRotateAngle(left_wing_3, -1.2292353921796064F, 0.0F, 0.0F);
		left_arm = new ModelRenderer(this, 32, 27);
		left_arm.setRotationPoint(5.0F, 2.5F, -0.0F);
		left_arm.addBox(-1.0F, -2.0F, -2.0F, 3, 6, 4, 0.0F);
		setRotateAngle(left_arm, 0.0F, 0.0F, -0.10000736613927509F);
		right_arm_1 = new ModelRenderer(this, 20, 52);
		right_arm_1.setRotationPoint(0.0F, 4.0F, 2.0F);
		right_arm_1.addBox(-2.0F, 0.0F, -4.0F, 3, 6, 4, 0.0F);
		angry_mouth.addChild(teeth_1);
		left_arm.addChild(left_arm_1);
		left_wing_3.addChild(left_wing_4);
		angry_mouth.addChild(teeth_3);
		angry_mouth.addChild(teeth_2);

		head.addChild(nose);
		head.addChild(coverup);
		head.addChild(face);
		angry_mouth.addChild(teeth_5);
		right_wing_1.addChild(right_wing_2);
		cloth_0.addChild(zeth);
		angry_mouth.addChild(teeth_4);
		right_wing_3.addChild(right_wing_4);
		head.addChild(left_eyebrow);
		head.addChild(angry_mouth);
		right_wing_2.addChild(right_wing_3);
		head.addChild(right_eyebrow);
		left_wing_1.addChild(left_wing_2);
		angry_mouth.addChild(teeth);
		left_wing_2.addChild(left_wing_3);
		right_arm.addChild(right_arm_1);
		head.addChild(head_2);
		back_cloth.addChild(back_cloth_2);
	}

	@Override
	public void setRotationAngles(WeepingAngelEntity weepingAngelEntity, float v, float v1, float v2, float v3, float v4) {

			right_arm.rotationPointY = 2.5F;
			left_arm.rotationPointY = 2.5F;
			left_arm.rotateAngleX = 0;
			left_arm.rotateAngleY = 0;
			left_arm.rotateAngleZ = 0;
			right_arm.rotateAngleX = 0;
			right_arm.rotateAngleY = 0;
			right_arm.rotateAngleZ = 0;

			PoseBase pose = AngelPoses.getPoseFromString(weepingAngelEntity.getAngelPose()).create();

			if (pose != null) {
				angry_mouth.showModel = pose.isAngry();
				pose.setArmAngles(left_arm, right_arm, left_arm_1, right_arm_1, true);
				pose.setWingAngles(left_wing_0, right_wing_0);
				pose.setHeadAngles(head);

				if (pose.isAngry()) {
					right_eyebrow.rotateAngleZ = (float) (20 * Math.PI / 180);
					left_eyebrow.rotateAngleZ = (float) (-20 * Math.PI / 180);
					angry_mouth.showModel = true;
				} else {
					right_eyebrow.rotateAngleZ = (float) (0 * Math.PI / 180);
					left_eyebrow.rotateAngleZ = (float) (0 * Math.PI / 180);
				}
			}
	}

	public void quickRender(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, ResourceLocation pose) {
		matrixStack.push();
		tilePosing(pose);
		cloth_1.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		head.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		cloth_0.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		back_cloth.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		cloth_2.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		left_wing_1.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		body_2.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		right_wing_1.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		body.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		right_wing_0.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		left_wing_0.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay, 1, 1, 1, 1);
		matrixStack.pop();
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.push();
		cloth_1.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		cloth_0.render(matrixStack, buffer, packedLight, packedOverlay);
		back_cloth.render(matrixStack, buffer, packedLight, packedOverlay);
		cloth_2.render(matrixStack, buffer, packedLight, packedOverlay);
		left_wing_1.render(matrixStack, buffer, packedLight, packedOverlay);
		body_2.render(matrixStack, buffer, packedLight, packedOverlay);
		right_wing_1.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_wing_0.render(matrixStack, buffer, packedLight, packedOverlay);
		left_wing_0.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		matrixStack.pop();
	}

	public void tilePosing(ResourceLocation p) {
		PoseBase pose = AngelPoses.getPoseFromString(p).create();

		right_arm.rotationPointY = 2.5F;
		left_arm.rotationPointY = 2.5F;
		left_arm.rotateAngleX = 0;
		left_arm.rotateAngleY = 0;
		left_arm.rotateAngleZ = 0;
		right_arm.rotateAngleX = 0;
		right_arm.rotateAngleY = 0;
		right_arm.rotateAngleZ = 0;
		pose.setArmAngles(left_arm, right_arm, left_arm_1, right_arm_1, true);
		pose.setWingAngles(left_wing_0, right_wing_0);
		pose.setHeadAngles(head);
		angry_mouth.showModel = false;
	}

	private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	@Override
	public ResourceLocation getTextureForPose(WeepingAngelEntity angel) {
		return TEXTURE;
	}

}
