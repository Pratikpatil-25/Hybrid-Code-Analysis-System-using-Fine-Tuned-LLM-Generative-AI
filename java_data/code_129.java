package net.smert.jreactphysics3d.collision.broadphase;

import net.smert.jreactphysics3d.body.CollisionBody;
import net.smert.jreactphysics3d.collision.CollisionDetection;
import net.smert.jreactphysics3d.collision.shapes.AABB;


public abstract class BroadPhaseAlgorithm {

        protected CollisionDetection collisionDetection;

        protected PairManager pairManager;

        public BroadPhaseAlgorithm(CollisionDetection collisionDetection) {
        this.collisionDetection = collisionDetection;
        pairManager = new PairManager(collisionDetection);
    }

        public abstract void addObject(CollisionBody body, AABB aabb);

        public abstract void removeObject(CollisionBody body);

        public abstract void updateObject(CollisionBody body, AABB aabb);

}