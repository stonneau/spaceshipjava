package physics;

import java.util.ArrayList;

import physics.collision.Checker;

import game.Layer;
import gameobject.GameObject;

/**
 * Main class for physics package updates all the {@link LocatedEntity}
 * 
 * @author stonneau
 * 
 */
public class Simulation implements GameObject {
	public final Checker checker;
	private ArrayList<MovingEntity> movingEntities_;
	private ArrayList<ArrayList<LocatedEntity>> locatedEntities_;

	public Simulation() {
		checker = new Checker();
		movingEntities_ = new ArrayList<MovingEntity>();
		locatedEntities_ = new ArrayList<ArrayList<LocatedEntity>>();
		for (int i = 0; i < Layer.None.getValue(); ++i) {
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

	/**
	 * Registers a {@link MovingEntity} to the simulation
	 * 
	 * @param entity
	 *            the {@link MovingEntity} to be registered.
	 * @param layer
	 *            The collision Layer associated to the {@link MovingEntity}.
	 *            Collision checks for this entity will only be performed with
	 *            objects on the same Layer.
	 */
	public void addMovingEntity(MovingEntity entity, Layer layer) {
		movingEntities_.add(entity);
		addLocatedEntity(entity, layer);
	}

	/**
	 * Removes a registered {@link MovingEntity}.
	 * 
	 * @param entity
	 *            the {@link MovingEntity} to be removed.
	 */
	public void removeMovingEntity(MovingEntity entity) {
		movingEntities_.remove(entity);
		removeLocatedEntity(entity);
	}

	/**
	 * Registers a {@link LocatedEntity} to the simulation
	 * 
	 * @param entity
	 *            the {@link LocatedEntity} to be registered.
	 * @param layer
	 *            The collision Layer associated to the {@link LocatedEntity}.
	 *            Collision checks for this entity will only be performed with
	 *            objects on the same Layer.
	 */
	public void addLocatedEntity(LocatedEntity entity, Layer layer) {
		locatedEntities_.get(layer.getValue()).add(entity);
	}

	/**
	 * Removes a registered {@link LocatedEntity}.
	 * 
	 * @param entity
	 *            the {@link LocatedEntity} to be removed.
	 */
	public void removeLocatedEntity(LocatedEntity entity) {
		for (ArrayList<LocatedEntity> it : locatedEntities_) {
			it.remove(entity);
		}
	}

	/**
	 * Removes a registered {@link LocatedEntity}.
	 * 
	 * @param entity
	 *            the {@link LocatedEntity} to be removed.
	 * @param layer
	 *            the CollisionLayer where the {@link LocatedEntity} was
	 *            registered.
	 */
	public void removeLocatedEntity(LocatedEntity entity, Layer layer) {
		locatedEntities_.get(layer.getValue()).remove(entity);
	}

	private void handleCollisions(ArrayList<LocatedEntity> locatedEntities) {
		for (int i = 0; i < locatedEntities.size(); ++i) {
			for (int j = i + 1; j < locatedEntities.size(); ++j) {
				LocatedEntity it, it2;
				it = locatedEntities.get(i);
				it2 = locatedEntities.get(j);
				if (checker.isColliding(it.shape, it2.shape)) {
					it.onCollision(it2);
					it2.onCollision(it);
				}
			}
		}
	}
}
