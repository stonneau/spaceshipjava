package physics;

import java.util.ArrayList;

import physics.collision.Checker;
import physics.collision.CollisionLayer;

import gameobject.GameObject;


/**
 * Main class for physics package
 * updates all the moving entities
 * @author stonneau
 *
 */
public class Simulation implements GameObject{
	public final Checker checker;
	private ArrayList<MovingEntity> movingEntities_;
	private ArrayList<ArrayList<LocatedEntity> > locatedEntities_;
	
	public Simulation()
	{
		checker = new Checker();
		movingEntities_ = new ArrayList<MovingEntity>();
		locatedEntities_ = new ArrayList<ArrayList<LocatedEntity> >();
		for(int i = 0; i < CollisionLayer.None.getValue(); ++i)
		{
			locatedEntities_.add(new ArrayList<LocatedEntity>());
		}
	}
		
	@Override
	public void Update(float msElapsed) {
		// TODO Auto-generated method stub
		for (MovingEntity it : movingEntities_) {
			it.Update(msElapsed);
		}
		for (ArrayList<LocatedEntity> it : locatedEntities_) {
			HandleCollisions(it);
		}
		
	}
	
	private void HandleCollisions(ArrayList<LocatedEntity> locatedEntities) {
		for(int i =0; i < locatedEntities.size(); ++i)
		{
			for(int j =i+1; j < locatedEntities.size(); ++j)
			{
				LocatedEntity it, it2;
				it = locatedEntities.get(i);
				it2 = locatedEntities.get(j);
				if(checker.IsColliding(it.shape, it2.shape))
				{
					it.OnCollision(it2);
					it2.OnCollision(it);
				}
			}
		}
	}

	public void AddMovingEntity(MovingEntity entity, CollisionLayer layer)
	{
		movingEntities_.add(entity);
		AddLocatedEntity(entity, layer);
	}
	
	public void RemoveMovingEntity(MovingEntity entity)
	{
		movingEntities_.remove(entity);
		RemoveLocatedEntity(entity);
	}
	
	public void AddLocatedEntity(LocatedEntity entity, CollisionLayer layer)
	{
		locatedEntities_.get(layer.getValue()).add(entity);
	}
	
	public void RemoveLocatedEntity(LocatedEntity entity)
	{
		for (ArrayList<LocatedEntity> it : locatedEntities_) {
			it.remove(entity);
		}
	}
	
	public void RemoveLocatedEntity(LocatedEntity entity, CollisionLayer layer)
	{
		locatedEntities_.get(layer.getValue()).remove(entity);
	}
}
