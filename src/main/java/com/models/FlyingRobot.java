package com.models;

import com.enums.Traction;
import com.interfaces.ResistanceEvaluable;

public class FlyingRobot extends Robot implements ResistanceEvaluable {

    private float maxHeight;
    private int maxFlyLenghtMinute;

    public FlyingRobot(String name, String producer, int year, float maxHeight, int maxFlyLenghtMinute) {
        super(name, producer, year);
        this.maxHeight = maxHeight;
        this.maxFlyLenghtMinute = maxFlyLenghtMinute;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " vuela hasta " + this.maxHeight+ " m durante " + this.maxFlyLenghtMinute + ". Fabricado en " + getYear() + " por " + getProducer();
    }

    @Override
    public String getResistanceReport() {
        if (this.maxFlyLenghtMinute > 60){
            return "autonomia de " + this.maxFlyLenghtMinute + " minutos. Apto para la competiciòn";
        } else {
            return "autonomia de " + this.maxFlyLenghtMinute + " minutos. No cumple los requisitos";
        }
    }

    public float getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(float maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxFlyLenghtMinute() {
        return maxFlyLenghtMinute;
    }

    public void setMaxFlyLenghtMinute(int maxFlyLenghtMinute) {
        this.maxFlyLenghtMinute = maxFlyLenghtMinute;
    }
}
