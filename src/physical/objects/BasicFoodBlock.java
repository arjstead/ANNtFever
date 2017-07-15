package physical.objects;

public class BasicFoodBlock extends FoodObject
{
	int value = 1;
	int x,y;

	public BasicFoodBlock(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update()
	{
		// nothing
	}

	@Override
	public int getX() 
	{
		return x;
	}

	@Override
	public int getY()
	{
		return y;
	}

}
