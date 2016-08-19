package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.jroweboy.tetris.components.TextureComponent;
import com.jroweboy.tetris.components.TransformComponent;

import java.util.Comparator;

public class RenderSystem extends IteratingSystem {

    static final float FRUSTUM_WIDTH = 10;
    static final float FRUSTUM_HEIGHT = 15;
    static final float PIXELS_TO_METRES = 1.0f / 32.0f;

    private SpriteBatch batch;
    private Array<Entity> renderQueue;
    private Comparator<Entity> comparator;
    private OrthographicCamera cam;

    private ComponentMapper<TextureComponent> txm;
    private ComponentMapper<TransformComponent> trm;

    public RenderSystem(SpriteBatch batch) {
        super(Family.all(TextureComponent.class, TransformComponent.class).get());

        this.batch = batch;
        this.renderQueue = new Array<Entity>();
        this.comparator = new Comparator<Entity>() {
            @Override
            public int compare(Entity entityA, Entity entityB) {
                return (int)Math.signum(trm.get(entityB).pos.z -
                        trm.get(entityA).pos.z);
            }
        };
        this.cam = new OrthographicCamera(FRUSTUM_WIDTH, FRUSTUM_HEIGHT);
        cam.position.set(FRUSTUM_WIDTH, FRUSTUM_HEIGHT, 0);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        renderQueue.sort(comparator);

        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        for (Entity entity : renderQueue) {
            Texture texture = txm.get(entity).texture;

            if (texture == null) {
                continue;
            }

            TransformComponent tr = trm.get(entity);

            int width = texture.getWidth();
            int height = texture.getHeight();
            float originX = width * 0.5f;
            float originY = height * 0.5f;

            batch.draw(texture,
                    tr.pos.x - originX, tr.pos.y - originY,
                    originX, originY,
                    width, height,
                    tr.scale.x * PIXELS_TO_METRES, tr.scale.y * PIXELS_TO_METRES,
                    MathUtils.radiansToDegrees * tr.rotation,
                    0, 0, width, height, false, false
            );
        }

        batch.end();
        renderQueue.clear();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        renderQueue.add(entity);
    }
}