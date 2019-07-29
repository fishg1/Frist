package fishg.frist;

import lists.BlockList;
import lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemsItemGroup extends ItemGroup
{
	public ItemsItemGroup()
	{
		super("frist_items");
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemList.frospal);
	}

}
