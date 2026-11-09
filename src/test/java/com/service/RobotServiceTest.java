package com.service;

import com.Competition.ResistanceReportPrinter;
import com.enums.Propulsion;
import com.enums.Traction;
import com.interfaces.ResistanceEvaluable;
import com.models.FlyingRobot;
import com.models.LandRobot;
import com.models.Robot;
import com.models.WaterRobot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotServiceTest {

    RobotService robotService;
    ResistanceReportPrinter printer;

    @BeforeEach
    void setUp() {
        robotService = new RobotService(new ArrayList<>());
        robotService.getListRobots().add(new WaterRobot("Acquaman","Marvel",2011,300, Propulsion.JET));
        robotService.getListRobots().add(new LandRobot("Terraman","DC",1999,320, Traction.CATERPILLAR));
        robotService.getListRobots().add(new FlyingRobot("SkyWoman", "Ideal", 2023,500,130));
        robotService.getListRobots().add(new LandRobot("OldTerraMan", "DC", 1960, 120,Traction.WHEELS));

        printer = new ResistanceReportPrinter();
    }

    // puedo meterle pruebas para todos los getTechnicalDescription

    @Test
    void shouldListAllRobots() {
        List<String> allRobots = robotService.getCompleteListRobots();
        assertThat(allRobots).isNotNull();
        assertThat(allRobots).size().isEqualTo(3);
    }

    @Test
    void shouldFilterLandRobotsWithSpeed() {
        List<Robot> filteredList = robotService.filterLandRobotWithSpeed(300);
        assertThat(filteredList).isNotNull();
        assertThat(filteredList.size()).isEqualTo(1);
        assertThat(filteredList.getFirst()).isEqualTo(robotService.getListRobots().get(1));
    }

    @Test
    void shouldFilterByProducer() {
        List<Robot> filteredList = robotService.filterByProducer("DC");
        assertThat(filteredList).isNotNull();
        assertThat(filteredList.size()).isEqualTo(2);
    }

    @Test
    void shouldReportRobotValidForCompetition() {
        List<ResistanceEvaluable> validRobots = robotService.getValidRobots();
        printer.printReport(validRobots);
    }

}