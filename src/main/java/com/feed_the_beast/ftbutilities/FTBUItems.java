package com.feed_the_beast.ftbutilities;

import com.feed_the_beast.ftblib.FTBLibFinals;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author LatvianModder
 */
public class FTBUItems
{
	@GameRegistry.ObjectHolder(FTBLibFinals.SILENTGEMS + ":chestplate")
	public static final Item SILENTGEMS_CHESTPLATE = Items.AIR;
}