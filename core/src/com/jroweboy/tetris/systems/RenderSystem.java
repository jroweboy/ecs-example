package com.jroweboy.tetris.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.jroweboy.tetris.components.TextureComponent;
import com.jroweboy.tetris.components.TransformComponent;

import java.util.Comparator;

public class RenderSystem extends IteratingSystem {
    private static final float PPB = 16.0f;
    public static final float PIXEL_TO_BLOCK = 1.0f / PPB;

    private static final float FRUSTUM_WIDTH = Gdx.graphics.getWidth() * PIXEL_TO_BLOCK;
    private static final float FRUSTUM_HEIGHT = Gdx.graphics.getHeight() * PIXEL_TO_BLOCK;

    public static float PixelToBlock(float pixelValue){
        return pixelValue * PIXEL_TO_BLOCK;
    }

    private SpriteBatch batch;
    private Array<Entity> renderQueue;
    private Comparator<Entity> comparator;
    private OrthographicCamera cam;
    private ExtendViewport viewport;

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

        cam = new OrthographicCamera();
        viewport = new ExtendViewport(FRUSTUM_WIDTH, FRUSTUM_HEIGHT, cam);
        cam.position.set(0,0, 0);

        txm = ComponentMapper.getFor(TextureComponent.class);
        trm = ComponentMapper.getFor(TransformComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

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
                    PixelToBlock(tr.scale.x), PixelToBlock(tr.scale.y),
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

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

//    private static Vector2 meterDimensions = new Vector2();
//    private static Vector2 pixelDimensions = new Vector2();
//    public static Vector2 getScreenSizeInMeters(){
//        meterDimensions.set(Gdx.graphics.getWidth()*PIXEL_TO_BLOCK,
//                Gdx.graphics.getHeight()*PIXEL_TO_BLOCK);
//        return meterDimensions;
//    }
//
//    public static Vector2 getScreenSizeInPixesl(){
//        pixelDimensions.set(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        return pixelDimensions;
//    }
}