package fr.iut.orsay.pts2.Screens;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.iut.orsay.pts2.States.Civ;
import fr.iut.orsay.pts2.Util.Constants;

public class PressScreen extends ApplicationAdapter implements Screen {
    private Civ game;
    private Texture background;
    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private BitmapFont gameTitleText, beginText;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
    private GlyphLayout gameTitleGlyph,beginGlyph;
    private Music music;

    public PressScreen(Civ game) {
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new StretchViewport(Constants.VIEWPORT_WIDTH,Constants.VIEWPORT_HEIGHT, gamecam);

        this.background = new Texture("BackgroundCiv.jpg");

        this.generator = new FreeTypeFontGenerator(Gdx.files.internal("Poppins-ExtraLight.ttf"));
        this.parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        this.parameter.size = 64;
        this.gameTitleText = this.generator.generateFont(this.parameter);

        this.parameter.size = 32;
        this.beginText = this.generator.generateFont(this.parameter);

        this.gameTitleGlyph = new GlyphLayout();
        this.beginGlyph = new GlyphLayout();

        this.gameTitleGlyph.setText(this.gameTitleText, Constants.GAME_TITLE);
        this.beginGlyph.setText(this.beginText, Constants.BEGIN_TITLE);

        this.gamecam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

        //music = Gdx.audio.newMusic(Gdx.files.internal("V4OrcherstralVersion.mp3"));
        //music.setLooping(true);
    }

    @Override
    public void show() {

        //music.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        game.batch.draw(this.background,0,0, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        this.gameTitleText.draw(game.batch, this.gameTitleGlyph, this.gamecam.viewportWidth/2 - this.gameTitleGlyph.width/2, this.gamecam.viewportHeight - 5*this.gameTitleGlyph.height);

        this.beginText.draw(game.batch, this.beginGlyph, this.gamecam.viewportWidth/2 - this.beginGlyph.width/2, this.gamecam.viewportHeight/2);

        if (Gdx.input.isTouched())
        {
            game.setScreen(new MenuPrincipal(game));
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
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
        this.background.dispose();
        this.gameTitleText.dispose();
        this.beginText.dispose();
        //music.dispose();
    }

}
