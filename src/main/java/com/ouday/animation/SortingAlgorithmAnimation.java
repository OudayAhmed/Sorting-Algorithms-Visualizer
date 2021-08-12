package com.ouday.animation;

import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.List;

public class SortingAlgorithmAnimation {

    private final Draw draw;
    private final AnimationPlayer animationPlayer;
    private Boolean sortingIsCompleted = false;


    public SortingAlgorithmAnimation(int[] array, Canvas canvas, Duration duration, List<FontIcon> fontIconList) {
        this.draw = new Draw(array, canvas);
        this.animationPlayer = new AnimationPlayer(duration, this, fontIconList);
    }

    public Draw getDraw() {
        return draw;
    }

    public AnimationPlayer getAnimationPlayer() {
        return animationPlayer;
    }

    public void setSortingIsCompleted(Boolean sortingIsCompleted) {
        this.sortingIsCompleted = sortingIsCompleted;
    }

    public Boolean getSortingIsCompleted() {
        return sortingIsCompleted;
    }

    public void oneStepSorting() {
    }

}