package fr.iut.orsay.pts2.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.iut.orsay.pts2.States.Civ;
import fr.iut.orsay.pts2.Util.Constants;

public class NewGame implements Screen {

    private Stage stage;
    // our new fields
    private Label tailleLabel;
    private Label volumeMusicLabel;
    private Label volumeSoundLabel;
    private Label musicOnOffLabel;
    private Label soundOnOffLabel;

    private Texture background;
    private BitmapFont gameTitleText;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private GlyphLayout gameTitleGlyph;
    private OrthographicCamera cam;

    private Viewport viewport;
    private Civ game;
    private Table table;
    public Skin skin;
    private TextureAtlas atlas;
    private String tab [];

    public NewGame (Civ game){

        this.game = game;
        this.background = new Texture("BackgroundCiv.jpg");
        cam = new OrthographicCamera();
        viewport = new StretchViewport(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT, cam);

        this.cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

        //generator
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));

    }

    @Override
    public void show() {

        stage = new Stage();

        skin = new Skin(Gdx.files.internal("neon-ui/neon-ui.json"));
        table = new Table(skin);

        //Font du titre
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color = Color.WHITE;

        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Label gameTitle = new Label("Créer une partie", labelStyle);

        Gdx.input.setInputProcessor(stage);

        //volume
        final SelectBox<String> selectbox = new SelectBox<String>(skin);
        selectbox.setItems("20*20","40*40","80*80");


        final TextButton backButton = new TextButton("Back", skin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //NOT WORKING
                game.setScreen(new MenuPrincipal(game));
            }
        });

        tailleLabel = new Label( "Taille de la carte", skin);
        tailleLabel.setOrigin(Align.center);

        table.setFillParent(true);

        table.align(Align.top);

        table.add(gameTitle).padTop(150);
        table.row();
        table.add(tailleLabel).colspan(2).center().padTop(60).padBottom(15);
        table.row().pad(10,0,0,10);
        table.add(selectbox).padBottom(15);
        table.row().pad(10,0,0,10);
        table.add(backButton).colspan(2);

        stage.addActor(table);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(this.cam.combined);

        game.batch.begin();

        stage.act(delta);

        stage.getBatch().begin();
        stage.getBatch().draw(this.background, 0, 0, Constants.VIEWPORT_WIDTH, Constants.WINDOW_HEIGHT);
        stage.getBatch().end();

        stage.draw();
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.batch.dispose();
        stage.dispose();
        this.background.dispose();
        this.gameTitleText.dispose();
    }
}
