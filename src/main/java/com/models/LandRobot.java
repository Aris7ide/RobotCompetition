package com.models;

import com.enums.Traction;
import com.interfaces.ResistanceEvaluable;

public class LandRobot extends Robot implements ResistanceEvaluable {

    private float maxSpeed;
    private Traction traction;

    public LandRobot(String name, String producer, int year, float maxSpeed, Traction traction) {
        super(name, producer, year);
        this.maxSpeed = maxSpeed;
        this.traction = traction;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + ", fabricado por" + getProducer() + ", usa tracciòn" + this.traction + " y alcanza hasta " + this.maxSpeed + " km/h";
    }

    @Override
    public String getResistanceReport() {
        if (this.traction == Traction.CATERPILLAR){
            return "traccion " + this.traction + " confirmada Apto para la competiciòn";
        } else {
            return "traccion " + this.traction + " no confirmada. No cumple los requisitos";
        }
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Traction getTraction() {
        return traction;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }
}
