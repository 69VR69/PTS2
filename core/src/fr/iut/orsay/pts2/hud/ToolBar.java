package fr.iut.orsay.pts2.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class ToolBar extends Table
    {
        private Table tableFood, tableWood, tableOre, tableTechnology;
        private Image imgFood, imgWood, imgOre, imgTechnology;
        private Label lblFood, lblWood, lblOre, lblTechnology;
        
        private ImageButton btnParam;
        private Label lblSpace;
        private float pad = 0.01f * this.getWidth();
        
        ToolBar(Skin skin)
            {
                super(skin);
                
                lblSpace = new Label(":", skin);
                
                //food
                tableFood = new Table();
                imgFood = new Image(new Texture(Gdx.files.internal("menu.png")));
                lblFood = new Label("1", skin);
                tableFood.add(lblFood, lblSpace, imgFood);
                //wood
                tableWood = new Table();
                imgWood = new Image(new Texture(Gdx.files.internal("menu.png")));
                lblWood = new Label("2", skin);
                tableWood.add(lblWood, lblSpace, imgWood);
                //ore
                tableOre = new Table();
                imgOre = new Image(new Texture(Gdx.files.internal("menu.png")));
                lblOre = new Label("3", skin);
                tableOre.add(lblOre, lblSpace, imgOre);
                //technology
                tableTechnology = new Table();
                imgTechnology = new Image(new Texture(Gdx.files.internal("menu.png")));
                lblTechnology = new Label("4", skin);
                tableTechnology.add(lblTechnology, lblSpace, imgTechnology);
                
                //Paramaters
                btnParam = new ImageButton(skin);
                
                //add controls to toolBar
                this.add(tableFood).padRight(pad);
                this.add(tableWood).padRight(pad);
                this.add(tableOre).padRight(pad);
                this.add(tableTechnology).padRight(pad);
                this.add(btnParam).padLeft(pad);
            }
    }
