package physics;

public class DummyLocatedEntity extends LocatedEntity
{
	public Boolean visited;
	
	public DummyLocatedEntity(float x, float y, float r)
	{
		super(x, y, r);
		visited = false;
	}
	
	@Override
	public void onCollision(LocatedEntity other) {
		visited = true;		
	}
	
}