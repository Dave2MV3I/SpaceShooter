package my_project.model;
import my_project.control.LevelController;
import my_project.model.spaceships.*;

public enum Level {

    LEVEL1(1, 8, 84, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"){

        public void updateEnemies(LevelController lc){
            if (lc.getTimer() > 1 && lc.getEnemyCounter() < 8) { // 1 statt 10
                for (Spaceship spaceship : lc.getSpaceships()) {
                    if (!spaceship.isActive()) {
                        spaceship.startSpaceship(800, lc.getEnemyCounter() * 80, lc.getPC());
                        lc.increaseEnemyCounter();
                        lc.setTimer(lc.getTimer() % 10); // Modulo teilt timer durch 1 und erhält den Rest (hinterm Komma); ans nächste Intervall drangegangen wg. overflow
                        break;
                    }
                }
            }
        }

        public void nextScene(LevelController lc){lc.startLevel(LEVEL2);}
    },

    LEVEL2(2, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"){

        public void updateEnemies(LevelController lc){
            if (lc.getTimer() > 10 && lc.getEnemyCounter() < 8) {
                //System.out.println("Spaceship gestartet (2)");
                for (Spaceship spaceship : lc.getSpaceships()) {

                    if (!spaceship.isActive()) {
                        spaceship.startSpaceship(800, lc.getEnemyCounter() * 55, lc.getPC());
                        lc.increaseEnemyCounter();
                        break;
                    }
                }

                for (Spaceship spaceship : lc.getSpaceships()) {
                    if (!spaceship.isActive()) {
                        spaceship.startSpaceship(800, 700 - lc.getEnemyCounter() * 55, lc.getPC());
                        lc.increaseEnemyCounter();
                        lc.setTimer(lc.getTimer() % 10);
                        break;
                    }
                }
            }
        }

        public void nextScene(LevelController lc){lc.startLevel(LEVEL3);}
    },

    LEVEL3(3, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"){

        public void updateEnemies(LevelController lc){
            if (lc.getTimer() > 10 && lc.getEnemyCounter() < 8) {
                //System.out.println("Spaceship gestartet (2)");
                if (lc.getEnemyCounter() %2 == 0){
                    for (int j = 0; j < lc.getSpaceships().length-4; j++) {
                        if (!lc.getSpaceships()[j].isActive()) {
                            lc.getSpaceships()[j].startSpaceship(800, lc.getEnemyCounter() * 80, lc.getPC());
                            lc.increaseEnemyCounter();
                        }
                    }
                }

                if (lc.getEnemyCounter() %2 == 1){
                    for (int j = lc.getSpaceships().length - 4; j < lc.getSpaceships().length; j++) {
                        if (!lc.getSpaceships()[j].isActive()) {
                            lc.getSpaceships()[j].startSpaceship(800, lc.getEnemyCounter() * 80, lc.getPC());
                            lc.increaseEnemyCounter();
                        }
                    }
                }
            }
        }

        public void nextScene(LevelController lc){lc.startLevel(LEVEL4);}
    },

    LEVEL4(4, 8, 60, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"){

        public void updateEnemies(LevelController lc){
            if (lc.getTimer() > 10 && lc.getEnemyCounter() < 8) {
                //System.out.println("Spaceship gestartet (2)");
                for (Spaceship spaceship : lc.getSpaceships()) {

                    if (!spaceship.isActive()) {
                        spaceship.startSpaceship(800, lc.getEnemyCounter() * 60, lc.getPC());
                        lc.increaseEnemyCounter();
                        break;
                    }
                }

                for (Spaceship spaceship : lc.getSpaceships()) {
                    if (!spaceship.isActive()) {
                        spaceship.startSpaceship(800, 700 - lc.getEnemyCounter() * 50, lc.getPC());
                        lc.increaseEnemyCounter();
                        lc.setTimer(lc.getTimer() % 10);
                        break;
                    }
                }
            }
        }

        public void nextScene(LevelController lc){ lc.startLevel(LEVEL5); } // Winner-Screen statt startLevel(LEVEL5);
    },

    LEVEL5(5, 8, 100, 8, "level1BGM", "src/main/resources/graphic/backgrounds/spaceBG.png"){

        public void updateEnemies(LevelController lc){
            if (lc.getTimer() > 10 && lc.getEnemyCounter() < 1) {
                lc.getSpaceships()[1].startSpaceship(800, 400, lc.getPC());
            }
        }

        public void nextScene(LevelController lc){lc.getPC().setCurrentScene(11);}
    };

    public final int myScene;
    public final int nSpaceships;
    public final int nBullets;
    public final int nShields;
    public final String bgSong;
    public final String bgPicture;

    Level(int myScene, int nSpaceships, int nBullets, int nShields, String bgSong, String bgPicture) {
        this.myScene = myScene;
        this.nSpaceships = nSpaceships;
        this.nBullets = nBullets;
        this.nShields = nShields;
        this.bgSong = bgSong;
        this.bgPicture = bgPicture;
    }

    public abstract void updateEnemies(LevelController lc);
    public abstract void nextScene(LevelController lc);
}
