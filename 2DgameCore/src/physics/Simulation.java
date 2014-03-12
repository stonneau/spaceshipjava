package physics;

import java.util.ArrayList;

import physics.collision.Checker;

import game.Layer;
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
		for(int i = 0; i < Layer.None.getValue(); ++i)
		{
			locatedEntities_.add(new ArrayList<LocatedEntity>());
		}
	}
		
	@Override
	public void update(float msElapsed) {
		// TODO Auto-generated method stub
		for (MovingEntity it : movingEntities_) {
			it.update(msElapsed);
		}
		for (ArrayList<LocatedEntity> it : locatedEntities_) {
			handleCollisions(it);
		}
		
	}
	
	private void handleCollisions(ArrayList<LocatedEntity> locatedEntities) {
		for(int i =0; i < locatedEntities.size(); ++i)
		{
			for(int j =i+1; j < locatedEntities.size(); ++j)
			{
				LocatedEntity it, it2;
				it = locatedEntities.get(i);
				it2 = locatedEntities.get(j);
				if(checker.isColliding(it.shape, it2.shape))
				{
					it.onCollision(it2);
					it2.onCollision(it);
				}
			}
		}
	}

	public void addMovingEntity(MovingEntity entity, Layer layer)
	{
		movingEntities_.add(entity);
		addLocatedEntity(entity, layer);
	}
	
	public void removeMovingEntity(MovingEntity entity)
	{
		movingEntities_.remove(entity);
		removeLocatedEntity(entity);
	}
	
	public void addLocatedEntity(LocatedEntity entity, Layer layer)
	{
		locatedEntities_.get(layer.getValue()).add(entity);
	}
	
	public void removeLocatedEntity(LocatedEntity entity)
	{
		for (ArrayList<LocatedEntity> it : locatedEntities_) {
			it.remove(entity);
		}
	}
	
	public void removeLocatedEntity(LocatedEntity entity, Layer layer)
	{
		locatedEntities_.get(layer.getValue()).remove(entity);
	}
}
