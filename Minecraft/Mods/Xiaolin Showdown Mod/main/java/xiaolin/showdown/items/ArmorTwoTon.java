package xiaolin.showdown.items;

import com.mojang.realmsclient.dto.RealmsServer.McoServerComparator;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import xiaolin.showdown.Main;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class ArmorTwoTon extends ItemArmor {

	int timer = 20;

	public ArmorTwoTon(ArmorMaterial material) {
		super(material, 1, 1);

		this.maxStackSize = 1;
		this.setUnlocalizedName("twoton");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();

	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Main.MODID + ":textures/items/" + "twoton_1" + ".png";
	}

	@Override
	public boolean isDamageable() {

		return false;
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack) {

		return false;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

		itemStack = new ItemStack(ModItems.tunictwo);
		this.showDurabilityBar(itemStack);
		this.setDamage(itemStack, 0);

		player.stepHeight = 0.25f;

		effectPlayer(player, Potion.moveSlowdown, 4);
		effectPlayer(player, Potion.heal, 2);

		if (player.isSneaking() == true) {

			timer--;

			if (timer == 0) {

				TunicTwoTon.SwitchArmor(itemStack, player);

				timer = 40;
			}

		}

		ShowdownHelper.onArmorTick(player, this);
	}

	private void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
		// Always effect for 1 seconds, then refresh
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
			player.addPotionEffect(new PotionEffect(potion.id, 35, amplifier, true, true));
	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
}
