package com.mygdx.game;

import Intro.IntroScreen1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class GameMenuScreen implements Screen {

    MyGdxGame game;

    Texture menuBackground;
    int menuBackgroundX ,menuBackgroundY;

    public GameMenuScreen(MyGdxGame game) {

        this.game = game;

        menuBackgroundX = 0;
        menuBackgroundY = 0;
        menuBackground = new Texture("Background\\menu.png") ;

    }

    @Override
    public void show() {
        SoundManager.create();
        SoundManager.menu.setLooping(true);
        SoundManager.menu.setVolume(0.4f);     // 50% of main volume
        SoundManager.menu.play();

    }

    @Override
    public void render(float delta) {

        //ScreenUtils.clear(1, 1, 1, 1);

        // start
        if (Gdx.input.getX() >= 176 && Gdx.input.getX() <= 520 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 790
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 890) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                //game.setScreen(new AirWaterScreen(game));
                game.setScreen(new IntroScreen1(game));
            }
        }

        // tutorial
        if (Gdx.input.getX() >= 176 && Gdx.input.getX() <= 520 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 625
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 725) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new TutorialScreen(game));
            }
        }

        // high score
        if (Gdx.input.getX() >= 176 && Gdx.input.getX() <= 520 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 454
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 554) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new HighScoreScreen(game));
            }
        }

        // about us
        if (Gdx.input.getX() >= 176 && Gdx.input.getX() <= 520 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 285
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 385) {
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new AboutScreen(game));
            }
        }

        // exit
        if (Gdx.input.getX() >= 176 && Gdx.input.getX() <= 520 &&
                MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() >= 115
                && MyGdxGame.SCREEN_HEIGHT - Gdx.input.getY() <= 225) {
            if (Gdx.input.isTouched()) {

                System.exit(0);
            }
        }

        game.batch.begin();

        game.batch.draw(menuBackground, menuBackgroundX, menuBackgroundY);
        //game.batch.draw(gameName, gameNameX, gameNameY,TEXT_WIDTH, TEXT_HEIGHT);

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
        SoundManager.menu.dispose();
    }
}
