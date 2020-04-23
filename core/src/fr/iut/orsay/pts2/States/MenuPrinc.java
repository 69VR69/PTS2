package fr.iut.orsay.pts2.States;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import fr.iut.orsay.pts2.Managers.GameStateManager;
import fr.iut.orsay.pts2.Util.Constants;

public class MenuPrinc extends GameState implements ApplicationListener
{
    private Texture background, charg, creer, param, quit;
    private BitmapFont gameTitleText, createText, chargeText, paramText,quitText;
    private FreeTypeFontGenerator generator;
    private FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    private GlyphLayout gameTitleGlyph,createGlyph,chargeGlyph,paramGlyph,quitGlyph;
    private Sprite sprite;
    Vector3 touchPos = new Vector3(); // creates a vector3 object for our touch event

    private Stage stage;
    private ImageButton button;
    private Label outputLabel;


    public MenuPrinc(GameStateManager gsm) {
        super(gsm);

        this.background = new Texture("BackgroundCiv.jpg");
        this.charg = new Texture("ChargPart.png");
        sprite = new Sprite (this.charg);
        sprite.setPosition(0,0);
        sprite.setSize(500,500);

        this.creer = new Texture("CreerPart.png");
        this.param = new Texture("Param.png");
        this.quit = new Texture("Quitter.png");

        this.generator = new FreeTypeFontGenerator(Gdx.files.internal("CenturyGothic.ttf"));
        this.parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        this.parameter.size = 64;
        this.gameTitleText = this.generator.generateFont(this.parameter);

        this.parameter.size = 32;
        this.createText = this.generator.generateFont(this.parameter);
        this.chargeText = this.generator.generateFont(this.parameter);
        this.paramText= this.generator.generateFont(this.parameter);
        this.quitText = this.generator.generateFont(this.parameter);

        this.gameTitleGlyph = new GlyphLayout();
        this.createGlyph = new GlyphLayout();
        this.chargeGlyph = new GlyphLayout();
        this.paramGlyph = new GlyphLayout();
        this.quitGlyph = new GlyphLayout();

        this.gameTitleGlyph.setText(this.gameTitleText, Constants.GAME_TITLE);
        this.createGlyph.setText(this.createText, Constants.CREATE_TEXT);
        this.chargeGlyph.setText(this.chargeText, Constants.CHARG_TEXT);
        this.paramGlyph.setText(this.paramText, Constants.PARAM_TEXT);
        this.quitGlyph.setText(this.quitText, Constants.QUIT_TEXT);

        this.cam.setToOrtho(false, Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);

    }


    @Override
    protected void handleInput() {


    }

    @Override
    public void update(float dt) {

    }

    private void checkIfClicked (float ix, float iy) {
        if (ix > sprite.getX() && ix < sprite.getX() + sprite.getWidth()) {
            if (iy > sprite.getY() && iy < sprite.getY() + sprite.getHeight()) {
                // the button was clicked, perform an action
                System.out.println("Button clicked !");
            }
        }
    }

    @Override
    public void update(SpriteBatch batch, float input_x, float input_y ) {
        checkIfClicked(input_x, input_y);
        sprite.draw(batch); // draw the button
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(this.cam.combined);

        sb.begin();
        sb.draw(this.background, 0, 0, 900, 1280);
        this.gameTitleText.draw(sb, this.gameTitleGlyph, this.cam.viewportWidth / 2 - this.gameTitleGlyph.width / 2, this.cam.viewportHeight - 5 * this.gameTitleGlyph.height);
        sb.draw(this.creer, this.cam.viewportWidth / 2 - this.createGlyph.width / 2, this.cam.viewportHeight / 2 + 200);
        sb.draw(this.charg, this.cam.viewportWidth / 2 - this.chargeGlyph.width / 2, this.cam.viewportHeight / 2);
        sb.draw(this.param, this.cam.viewportWidth / 2 - this.paramGlyph.width / 2, this.cam.viewportHeight / 2 - 200);
        sb.draw(this.quit, this.cam.viewportWidth / 2 - this.quitGlyph.width / 2, this.cam.viewportHeight / 2 - 400);

        if (Gdx.input.isTouched()) {
            //System.out.println("Test");
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0); //when the screen is touched, the coordinates are inserted into the vector
            cam.unproject(touchPos); // calibrates the input to your camera's dimentions
            if (touchPos.x > sprite.getX() && touchPos.x < sprite.getX() + charg.getWidth())
            {
                if (touchPos.y > sprite.getY() && touchPos.y < sprite.getY() + charg.getHeight())
                {
                    //Gdx.app.exit();
                    //this.gsm.set(new MenuPrincipal(this.gsm));
                    System.out.println("Test");
                }
            }
        }




        sb.end();

    }

    @Override
    public void create() {

        int row_height = Gdx.graphics.getWidth() / 12;
        int col_width = Gdx.graphics.getWidth() / 12;

        this.charg = new Texture("ChargPart.png");
        Drawable drawable = new TextureRegionDrawable(new TextureRegion(charg));
        ImageButton playButton = new ImageButton(drawable);

        stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
        stage.addActor(button); //Add the button to the stage to perform rendering and take input.
        Gdx.input.setInputProcessor(stage);

        button.setSize(col_width*4,(float)(row_height*2));
        button.setPosition(col_width,Gdx.graphics.getHeight()-row_height*6);
        button.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Press a Button");
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                outputLabel.setText("Pressed Image Button");
                Gdx.app.exit();
                return true;
            }
        });


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

        stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
        stage.draw();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    public void dispose() {
        this.background.dispose();
        this.gameTitleText.dispose();
        this.creer.dispose();
        this.charg.dispose();
        this.param.dispose();
        this.quit.dispose();
        this.stage.dispose();

    }


}
