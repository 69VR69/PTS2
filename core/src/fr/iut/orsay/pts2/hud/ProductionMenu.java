package fr.iut.orsay.pts2.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.ArrayList;

class ProductionMenu extends Table
    {
        private ArrayList<Case> caseList;
        private Skin skin;
        
        ProductionMenu(Skin skin)
            {
                super(skin);
                caseList = new ArrayList<>();
                this.setTouchable(Touchable.enabled);
                this.skin = skin;
            }
        
        void update()
            {
                for (Case c : caseList)
                    {
                        this.add(c);
                        this.row();
                        this.add(new Label("------------", skin)).center();
                        this.row();
                    }
            }
        
        void addCase(String txtTitle, String imgPathTitle, String txtFood, String imgPathFood, String txtWood, String imgPathWood, String txtOre, String imgPathOre, String txtTime, String imgPathTime)
            {
                caseList.add(new Case(skin, txtTitle, imgPathTitle, txtFood, imgPathFood, txtWood, imgPathWood, txtOre, imgPathOre, txtTime, imgPathTime));
            }
    }

class Case extends Table
    {
        private Table title, ressources, food, wood, ore, time;
        private Image imgTitle, imgFood, imgWood, imgOre, imgTime;
        private Label lblTitle, lblFood, lblWood, lblOre, lblTime;
        
        private float pad = 0.01f * this.getWidth();
        
        private String txtTitle, txtFood, txtWood, txtOre, txtTime;
        private String imgPathTitle, imgPathFood, imgPathWood, imgPathOre, imgPathTime;
        
        Case(Skin skin, final String txtTitle, String imgPathTitle, String txtFood, String imgPathFood, String txtWood, String imgPathWood, String txtOre, String imgPathOre, String txtTime, String imgPathTime)
            {
                super(skin);
                this.setTouchable(Touchable.enabled);
                
                
                title = new Table();
                imgTitle = new Image(new Texture(Gdx.files.internal(imgPathTitle)));
                lblTitle = new Label(txtTitle, skin);
                title.add(imgTitle, lblTitle);
                
                
                ressources = new Table();
                
                food = new Table();
                imgFood = new Image(new Texture(Gdx.files.internal(imgPathFood)));
                lblFood = new Label(txtFood, skin);
                food.add(imgFood, lblFood);
                
                wood = new Table();
                imgWood = new Image(new Texture(Gdx.files.internal(imgPathWood)));
                lblWood = new Label(txtWood, skin);
                wood.add(imgWood, lblWood);
                
                ore = new Table();
                imgOre = new Image(new Texture(Gdx.files.internal(imgPathOre)));
                lblOre = new Label(txtOre, skin);
                ore.add(imgOre, lblOre);
                
                time = new Table();
                imgTime = new Image(new Texture(Gdx.files.internal(imgPathTime)));
                lblTime = new Label(txtTime, skin);
                time.add(imgTime, lblTime);
                
                ressources.add(food).padRight(pad);
                ressources.add(wood).padRight(pad);
                ressources.add(ore).padRight(pad);
                ressources.add(time).fill().padRight(pad);
                
                this.add(title);
                this.row();
                this.add(ressources);
            }
        
        public Table getTitle()
            {
                return title;
            }
        
        public void setTitle(Table title)
            {
                this.title = title;
            }
        
        public Table getRessources()
            {
                return ressources;
            }
        
        public void setRessources(Table ressources)
            {
                this.ressources = ressources;
            }
        
        public Table getFood()
            {
                return food;
            }
        
        public void setFood(Table food)
            {
                this.food = food;
            }
        
        public Table getWood()
            {
                return wood;
            }
        
        public void setWood(Table wood)
            {
                this.wood = wood;
            }
        
        public Table getOre()
            {
                return ore;
            }
        
        public void setOre(Table ore)
            {
                this.ore = ore;
            }
        
        public Table getTime()
            {
                return time;
            }
        
        public void setTime(Table time)
            {
                this.time = time;
            }
        
        public Image getImgTitle()
            {
                return imgTitle;
            }
        
        public void setImgTitle(Image imgTitle)
            {
                this.imgTitle = imgTitle;
            }
        
        public Image getImgFood()
            {
                return imgFood;
            }
        
        public void setImgFood(Image imgFood)
            {
                this.imgFood = imgFood;
            }
        
        public Image getImgWood()
            {
                return imgWood;
            }
        
        public void setImgWood(Image imgWood)
            {
                this.imgWood = imgWood;
            }
        
        public Image getImgOre()
            {
                return imgOre;
            }
        
        public void setImgOre(Image imgOre)
            {
                this.imgOre = imgOre;
            }
        
        public Image getImgTime()
            {
                return imgTime;
            }
        
        public void setImgTime(Image imgTime)
            {
                this.imgTime = imgTime;
            }
        
        public Label getLblTitle()
            {
                return lblTitle;
            }
        
        public void setLblTitle(Label lblTitle)
            {
                this.lblTitle = lblTitle;
            }
        
        public Label getLblFood()
            {
                return lblFood;
            }
        
        public void setLblFood(Label lblFood)
            {
                this.lblFood = lblFood;
            }
        
        public Label getLblWood()
            {
                return lblWood;
            }
        
        public void setLblWood(Label lblWood)
            {
                this.lblWood = lblWood;
            }
        
        public Label getLblOre()
            {
                return lblOre;
            }
        
        public void setLblOre(Label lblOre)
            {
                this.lblOre = lblOre;
            }
        
        public Label getLblTime()
            {
                return lblTime;
            }
        
        public void setLblTime(Label lblTime)
            {
                this.lblTime = lblTime;
            }
        
        public float getPad()
            {
                return pad;
            }
        
        public void setPad(float pad)
            {
                this.pad = pad;
            }
        
        public String getTxtTitle()
            {
                return txtTitle;
            }
        
        public void setTxtTitle(String txtTitle)
            {
                this.txtTitle = txtTitle;
            }
        
        public String getTxtFood()
            {
                return txtFood;
            }
        
        public void setTxtFood(String txtFood)
            {
                this.txtFood = txtFood;
            }
        
        public String getTxtWood()
            {
                return txtWood;
            }
        
        public void setTxtWood(String txtWood)
            {
                this.txtWood = txtWood;
            }
        
        public String getTxtOre()
            {
                return txtOre;
            }
        
        public void setTxtOre(String txtOre)
            {
                this.txtOre = txtOre;
            }
        
        public String getTxtTime()
            {
                return txtTime;
            }
        
        public void setTxtTime(String txtTime)
            {
                this.txtTime = txtTime;
            }
        
        public String getImgPathTitle()
            {
                return imgPathTitle;
            }
        
        public void setImgPathTitle(String imgPathTitle)
            {
                this.imgPathTitle = imgPathTitle;
            }
        
        public String getImgPathFood()
            {
                return imgPathFood;
            }
        
        public void setImgPathFood(String imgPathFood)
            {
                this.imgPathFood = imgPathFood;
            }
        
        public String getImgPathWood()
            {
                return imgPathWood;
            }
        
        public void setImgPathWood(String imgPathWood)
            {
                this.imgPathWood = imgPathWood;
            }
        
        public String getImgPathOre()
            {
                return imgPathOre;
            }
        
        public void setImgPathOre(String imgPathOre)
            {
                this.imgPathOre = imgPathOre;
            }
        
        public String getImgPathTime()
            {
                return imgPathTime;
            }
        
        public void setImgPathTime(String imgPathTime)
            {
                this.imgPathTime = imgPathTime;
            }
    }
