package com.service;

import com.interfaces.ResistanceEvaluable;
import com.interfaces.TechnicalDescription;
import com.models.LandRobot;
import com.models.Robot;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RobotService {

    private List<Robot> listRobots;

    public RobotService(List<Robot> listRobots) {
        this.listRobots = listRobots;
    }

    public List<String> getCompleteListRobots() {
        return listRobots.stream().map(TechnicalDescription::getTechnicalDescription).toList();
    }

    public List<Robot> getListRobots() {
        return listRobots;
    }

    public void setListRobots(List<Robot> listRobots) {
        this.listRobots = listRobots;
    }

    public List<Robot> filterLandRobotWithSpeed(int speed) {
        return listRobots.stream().filter(robot -> robot instanceof LandRobot)
                .filter(robot -> ((LandRobot) robot).getMaxSpeed() > speed)
                .toList();
    }

    public List<Robot> filterByProducer(String producer) {
        return listRobots.stream().filter(robot -> robot.getProducer().equals(producer))
                .toList();
    }

    public List<ResistanceEvaluable> getValidRobots() {
        return listRobots.stream().filter(robot -> robot instanceof ResistanceEvaluable)
                .map(robot -> (ResistanceEvaluable) robot)
                .collect(Collectors.toList());
    }
}
