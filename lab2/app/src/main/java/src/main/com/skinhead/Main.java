package src.main.com.skinhead;

import src.main.com.skinhead.miscellaneous.Simulation;
import src.main.com.skinhead.singleton.Props;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.Integer.parseInt;

class Main{
    public static void main(String[] args){
        Properties prop = new Properties();
        FileInputStream ip;
        try {
            ip = new FileInputStream("C:\\vladimirjr\\uni\\test\\lab12\\app\\src\\main\\resources\\config.properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Props props = new Props(prop);
        Simulation simulation = new Simulation();
        simulation.runSimulation(parseInt(props.value.getProperty("day")),
                parseInt(props.value.getProperty("season")),
                parseInt(props.value.getProperty("level")),
                parseInt(props.value.getProperty("start_hours"))
        );
    }
}