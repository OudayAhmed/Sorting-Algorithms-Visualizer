package com.ouday.animation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class AnimationPlayer {

    private final Timeline timeline;
    private final SortingAlgorithmAnimation sortingAlgorithmAnimation;
    private final FontIcon playIcon;
    private final FontIcon stopIcon;
    private final FontIcon oneStepIcon;
    private final FontIcon repeatIcon;
    private final FontIcon homeIcon;


    public AnimationPlayer(Duration duration, SortingAlgorithmAnimation sortingAlgorithmAnimation, List<FontIcon> fontIconList) {
        this.sortingAlgorithmAnimation = sortingAlgorithmAnimation;
        this.homeIcon = fontIconList.get(0);
        this.repeatIcon = fontIconList.get(1);
        this.playIcon = fontIconList.get(2);
        this.stopIcon = fontIconList.get(3);
        this.oneStepIcon = fontIconList.get(4);
        this.timeline = new Timeline(new KeyFrame(duration, this::oneStep));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void oneStep(ActionEvent event) {
        if (!sortingAlgorithmAnimation.getSortingIsCompleted())
            sortingAlgorithmAnimation.oneStepSorting();
        else {
            playIcon.setIconColor(Color.valueOf("#c1c0b9"));
            playIcon.setDisable(true);
            playIcon.setVisible(true);
            stopIcon.setVisible(false);
            oneStepIcon.setIconColor(Color.valueOf("#c1c0b9"));
            oneStepIcon.setDisable(true);
            homeIcon.setIconColor(Color.valueOf("#f7e9e3"));
            homeIcon.setDisable(false);
            repeatIcon.setIconColor(Color.valueOf("#f7e9e3"));
            repeatIcon.setDisable(false);
            this.timeline.stop();
        }
    }

    public void stopAnimation() {
        stopIcon.setVisible(false);
        playIcon.setVisible(true);
        homeIcon.setIconColor(Color.valueOf("#f7e9e3"));
        homeIcon.setDisable(false);
        repeatIcon.setIconColor(Color.valueOf("#f7e9e3"));
        repeatIcon.setDisable(false);
        oneStepIcon.setIconColor(Color.valueOf("#f7e9e3"));
        oneStepIcon.setDisable(false);
        timeline.stop();
    }

    public void startAnimation() {
        stopIcon.setVisible(true);
        playIcon.setVisible(false);
        homeIcon.setIconColor(Color.valueOf("#c1c0b9"));
        homeIcon.setDisable(true);
        repeatIcon.setIconColor(Color.valueOf("#c1c0b9"));
        repeatIcon.setDisable(true);
        oneStepIcon.setIconColor(Color.valueOf("#c1c0b9"));
        oneStepIcon.setDisable(true);
        timeline.play();
    }

}