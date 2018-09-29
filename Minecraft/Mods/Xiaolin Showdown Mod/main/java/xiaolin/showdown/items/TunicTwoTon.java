package xiaolin.showdown.items;

import java.util.List;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import xiaolin.showdown.Main;
import xiaolin.showdown.showdownworld.ShowdownHelper;

public class TunicTwoTon extends ItemArmor {

	int timer = 20;

	public TunicTwoTon(ArmorMaterial material) {

		super(material,1, 1);

		this.setUnlocalizedName("tunictwo");
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.isDamageable();
		this.maxStackSize = 1;

	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return Main.MODID + ":textures/items/" + "tunictwo_1" + ".png";
	}

	@Override
	public boolean isDamageable() {

		return false;
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

		player.stepHeight = 0.5f;
		this.setDamage(itemStack, 0);

		player.removePotionEffect(Potion.moveSlowdown.getId());
		player.removePotionEffect(Potion.heal.getId());

		itemStack = new ItemStack(ModItems.twoton);

		if (player.isSneaking() == true) {

			timer--;

			if (timer == 0) {

				SwitchArmor(itemStack, player);

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

	public static void SwitchArmor(ItemStack tunic, EntityPlayer player) {

		player.setCurrentItemOrArmor(3, tunic);

	}

	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {

		ShowdownHelper.onEntityItemUpdate(entityItem, this);

		return false;
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

		ShowdownHelper.onUpdate1(entityIn, this);
		ShowdownHelper.onUpdate2(stack, worldIn, entityIn, itemSlot, isSelected);

	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		list.add("Wear this tunic,");
		list.add("then hold shift down,");
		list.add("and you become " + EnumChatFormatting.DARK_RED +  "invincible");
	}

}
