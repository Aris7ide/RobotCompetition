package com.models;

import com.enums.Propulsion;

public class WaterRobot extends Robot {

    private float maxDeep;
    private Propulsion propulsion;

    public WaterRobot(String name, String producer, int year, float maxDeep, Propulsion propulsion) {
        super(name, producer, year);
        this.maxDeep = maxDeep;
        this.propulsion = propulsion;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " alcanza una profundidad de " + this.maxDeep + " m con una propulsiòn tipo " + this.propulsion + ". Fabricado por " + getProducer() + " en " + getYear();
    }

    public float getMaxDeep() {
        return maxDeep;
    }

    public void setMaxDeep(float maxDeep) {
        this.maxDeep = maxDeep;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }
}
