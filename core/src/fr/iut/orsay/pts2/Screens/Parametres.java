package fr.iut.orsay.pts2.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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

public class Parametres implements Screen {

    private Parametres parent;
    private Stage stage;
    // our new fields
    private Label titleLabel;
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

    private static final String PREF_MUSIC_VOLUME = "volume";
    private static final String PREF_MUSIC_ENABLED = "music.enabled";
    private static final String PREF_SOUND_ENABLED = "sound.enabled";
    private static final String PREF_SOUND_VOL = "sound";
    private static final String PREFS_NAME = "b2dtut";

    private Parametres parametres;

    public Parametres (Civ game) {

        this.game = game;
        this.background = new Texture("BackgroundCiv.jpg");
        cam = new OrthographicCamera();
        viewport = new StretchViewport(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT, cam);

        this.cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

    }

    public Preferences getParametres() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public Parametres getParam() {
        return this.parametres;
    }

    public boolean isSoundEffectsEnabled() {
        return getParametres().getBoolean(PREF_SOUND_ENABLED, true);
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        getParametres().putBoolean(Constants.PREF_SOUND_ENABLED, soundEffectsEnabled);
        getParametres().flush();
    }

    public boolean isMusicEnabled() {
        return getParametres().getBoolean(Constants.PREF_MUSIC_ENABLED, true);
    }

    public void setMusicEnabled(boolean musicEnabled) {
        getParametres().putBoolean(Constants.PREF_MUSIC_ENABLED, musicEnabled);
        getParametres().flush();
    }

    public float getMusicVolume() {
        return getParametres().getFloat(Constants.PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getParametres().putFloat(Constants.PREF_MUSIC_VOLUME, volume);
        getParametres().flush();
    }

    public float getSoundVolume() {
        return getParametres().getFloat(Constants.PREF_SOUND_VOL, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getParametres().putFloat(Constants.PREF_SOUND_VOL, volume);
        getParametres().flush();
    }

    @Override
    public void show() {
        stage = new Stage();

        skin = new Skin(Gdx.files.internal("neon-ui/neon-ui.json"));
        table = new Table(skin);

        Gdx.input.setInputProcessor(stage);

        //Font du titre
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 64;
        parameter.color = Color.WHITE;

        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;

        Label gameTitle = new Label("Parametres", labelStyle);

        //volume
        final Slider volumeMusicSlider = new Slider( 0f, 1f, 0.1f,false, skin );
        //volumeMusicSlider.setValue(parent.getMusicVolume());
        volumeMusicSlider.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                //parent.setMusicVolume( volumeMusicSlider.getValue() );
                return false;
            }
        });

        //music
        final CheckBox musicCheckbox = new CheckBox(null, skin);
        //musicCheckbox.setChecked( parent.isMusicEnabled() );
        musicCheckbox.addListener( new EventListener() {
            @Override
            public boolean handle(Event event) {
                //boolean enabled = musicCheckbox.isChecked();
                //parent.setMusicEnabled(enabled);
                return false;
            }
        });

        final TextButton backButton = new TextButton("Back", skin, "default");
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //NOT WORKING
                game.setScreen(new MenuPrincipal(game));
            }
        });

        titleLabel = new Label( "Parametres", skin);
        volumeMusicLabel = new Label( "Music Volume", skin );
        musicOnOffLabel = new Label( "Music", skin );

        table.setFillParent(true);

        table.align(Align.top);

        table.add(gameTitle).padTop(150).colspan(2);
        table.row().pad(60,0,0,10);
        table.add(volumeMusicLabel).left();
        table.add(volumeMusicSlider);
        table.row().pad(10,0,0,10);;
        table.add(musicOnOffLabel).left();
        table.add(musicCheckbox);
        table.row().pad(10,0,0,10);;
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

    }
}
