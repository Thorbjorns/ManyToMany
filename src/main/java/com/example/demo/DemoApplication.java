package com.example.demo;

import com.example.demo.model.Barbarian;
import com.example.demo.model.Tribe;
import com.example.demo.repository.BarbarianRepository;
import com.example.demo.repository.TribeRepository;
import org.apache.naming.ContextAccessController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext=
                SpringApplication.run(DemoApplication.class, args);
        BarbarianRepository barbarianRepository = configurableApplicationContext.getBean(BarbarianRepository.class);
        TribeRepository tribeRepository = configurableApplicationContext.getBean(TribeRepository.class);

        Barbarian conan = new Barbarian("Conan","Two handed sword");
        Barbarian thorbjorn = new Barbarian("Thorbjorn","Axe");
        Barbarian sven = new Barbarian("Sven", "Spear");
        Barbarian vlad = new Barbarian("Vlad","Knife");
        List<Barbarian> barbarians = Arrays.asList(conan,thorbjorn,sven,vlad);

        Tribe bloodDrinkers = new Tribe("Blood Drinkers");
        Tribe headCutters = new Tribe("Head Cutters");
        Tribe wolfEaters = new Tribe("Wold Eaters");
        List<Tribe> tribes = Arrays.asList(bloodDrinkers,headCutters,wolfEaters);

        tribeRepository.saveAll(tribes);

        conan.joinTribe(bloodDrinkers);
        conan.joinTribe(headCutters);
        thorbjorn.joinTribe(headCutters);
        thorbjorn.joinTribe(wolfEaters);
        sven.joinTribe(wolfEaters);
        vlad.joinTribe(bloodDrinkers);

        barbarianRepository.saveAll(barbarians);
    }

}
