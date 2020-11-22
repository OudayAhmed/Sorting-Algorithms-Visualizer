package com.ouday.animation;

import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;
import java.util.List;

public class SortingAlgorithmAnimation {

    private int[] array;
    private Canvas canvas;
    private Draw draw;
    private Duration duration;
    private AnimationPlayer animationPlayer;
    private List<FontIcon> fontIconList;
    private Boolean sortingIsCompleted = false;

    public SortingAlgorithmAnimation(int[] array, Canvas canvas, Duration duration, List<FontIcon> fontIconList) {
        this.array = array;
        this.canvas = canvas;
        this.duration = duration;
        this.fontIconList = fontIconList;
        this.draw = new Draw(this.array, this.canvas);
        this.animationPlayer = new AnimationPlayer(this.duration, this, this.fontIconList);
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
        return;
    }
}
