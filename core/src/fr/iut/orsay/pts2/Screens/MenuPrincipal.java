package fr.iut.orsay.pts2.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import fr.iut.orsay.pts2.States.Civ;
import fr.iut.orsay.pts2.Util.Constants;

public class MenuPrincipal implements Screen {
    private Texture background;
    private BitmapFont gameTitleText;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private GlyphLayout gameTitleGlyph;
    private OrthographicCamera cam;

    private Viewport viewport;
    private Stage stage;
    private Civ game;

    public Skin skin;
    private TextureAtlas atlas;
    private Table table;
    private TextButton buttonExit, buttonNew, buttonSet;
    private Music music;
    private Timer timer;
    private String musicPath;


    public MenuPrincipal (Civ game) {
        this.game = game;
        this.background = new Texture("BackgroundCiv.jpg");
        cam = new OrthographicCamera();
        viewport = new StretchViewport(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT, cam);

        //generator
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));

        this.cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

        //this.setupBackgroundMusic("V5OrchestralVersion.mp3");
    }

    /*private void setupBackgroundMusic(String musicPath)
    {
        music = Gdx.audio.newMusic(Gdx.files.internal(musicPath));
        music.setVolume(0.2f);
        music.play();
    }*/

    @Override
    public void show() {
        stage = new Stage();

        atlas = new TextureAtlas("neon-ui/neon-ui.atlas");

        skin = new Skin(atlas);
        table = new Table(skin);

        table.setBounds(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(stage);

        //Font du titre
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color = Color.WHITE;
        //Shadow plutôt stylé
        /*parameter.shadowColor = Color.BLACK;
        parameter.shadowOffsetX = 3;
        parameter.shadowOffsetY = 3;*/
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Label gameTitle = new Label(Constants.GAME_TITLE, labelStyle);

        //Font des boutons
        FreeTypeFontGenerator generatorBut = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-Light.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameterBut = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color = Color.WHITE;
        BitmapFont fontButt = generator.generateFont(parameter);
        generator.dispose();

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.pressedOffsetX = 1;
        textButtonStyle.pressedOffsetY = -1;
        textButtonStyle.font = fontButt;


        buttonNew = new TextButton("Nouvelle Partie", textButtonStyle);
        buttonNew.pad(10);
        buttonNew.setTransform(true);
        buttonNew.setScale(0.6f);
        buttonNew.setOrigin(Align.center);
        buttonNew.getLabel().setAlignment(Align.right);


        /*music.setOnCompletionListener(new Music.OnCompletionListener()
        {
            @Override public void onCompletion(final Music music)
            {
                music.stop();
                timer.scheduleTask(new Timer.Task()
                {
                    @Override public void run()
                    {
                        music.play();
                    }
                }, 20);
            }
        });*/


        buttonNew.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new NewGame(game));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        buttonSet = new TextButton("Paramètres", textButtonStyle);
        buttonSet.pad(10);
        buttonSet.setTransform(true);
        buttonSet.setScale(0.6f);
        buttonSet.getLabel().setAlignment(Align.right);
        buttonSet.setOrigin(Align.center);

        buttonSet.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new Parametres(game));
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        buttonExit = new TextButton("Quitter", textButtonStyle);
        buttonExit.pad(10);
        buttonExit.setTransform(true);
        buttonExit.setScale(0.6f);
        buttonExit.setOrigin(Align.center);

        buttonExit.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        table.setFillParent(true);

        table.align(Align.center);
        table.add(gameTitle).padTop(50);
        table.row();
        table.add(buttonNew).pad(50);
        table.row();
        table.add(buttonSet).padLeft(20).padRight(20);
        table.row();
        table.add(buttonExit).pad(50);
        //Debug la table
        //table.debug();
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
        stage.getBatch().draw(this.background, 0, 0, Constants.WINDOW_WIDTH, Constants.VIEWPORT_HEIGHT); //1925 1000
        stage.getBatch().end();

        stage.draw();
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        music.dispose();
    }
}
