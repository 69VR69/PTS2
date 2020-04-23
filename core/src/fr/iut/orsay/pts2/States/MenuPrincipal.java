package fr.iut.orsay.pts2.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import javax.xml.soap.Text;

import fr.iut.orsay.pts2.Managers.GameStateManager;
import fr.iut.orsay.pts2.Util.Constants;

public class MenuPrincipal extends GameState {
    private Texture background;
    private BitmapFont gameTitleText, beginText;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private GlyphLayout gameTitleGlyph,beginGlyph;

    public MenuPrincipal(GameStateManager gsm) {
        super(gsm);

        this.background = new Texture("BackgroundCiv.jpg");

        this.generator = new FreeTypeFontGenerator(Gdx.files.internal("CenturyGothic.ttf"));
        this.parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        this.parameter.size = 64;
        this.gameTitleText = this.generator.generateFont(this.parameter);

        this.parameter.size = 32;
        this.beginText = this.generator.generateFont(this.parameter);

        this.gameTitleGlyph = new GlyphLayout();
        this.beginGlyph = new GlyphLayout();

        this.gameTitleGlyph.setText(this.gameTitleText, Constants.GAME_TITLE);
        this.beginGlyph.setText(this.beginText, Constants.BEGIN_TITLE);

        this.cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    }

    @Override
    protected void handleInput() {

        if(Gdx.input.isTouched())
        {
            this.gsm.set(new MenuPrinc(this.gsm));
        }

    }

    @Override
    public void update(float dt) {

        this.handleInput();

    }

    @Override
    public void update(SpriteBatch batch, float input_x, float input_y) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(this.cam.combined);

        sb.begin();
        gameTitleText.setColor(Color.RED); //ça ne marche pas
        sb.draw(this.background,0,0, 900, 1280);
        this.gameTitleText.draw(sb, this.gameTitleGlyph, this.cam.viewportWidth/2 - this.gameTitleGlyph.width/2, this.cam.viewportHeight - 5*this.gameTitleGlyph.height);

        this.beginText.draw(sb, this.beginGlyph, this.cam.viewportWidth/2 - this.beginGlyph.width/2, this.cam.viewportHeight/2);


        sb.end();

    }

    @Override
    public void dispose() {
        this.background.dispose();
        this.gameTitleText.dispose();
        this.beginText.dispose();

    }

}
