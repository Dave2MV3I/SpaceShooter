package my_project.model;


public class SpaceshipControl {
    //Referenzen
        Spaceship spaceship1;
        Spaceship spaceship2;
        Spaceship spaceship3;
        Spaceship spaceship4;
        Spaceship spaceship5;
        Spaceship spaceship6;
        Spaceship spaceship7;
        Spaceship spaceship8;
        Spaceship spaceship9;
        Spaceship spaceship10;


    //Methoden
        public void addSpaceship(Spaceship spaceship) {
            if (spaceship1 == null) {
                spaceship1 = spaceship;
            }
            else if (spaceship2 == null) {
                spaceship2 = spaceship;
            }
            else if (spaceship3 == null) {
                spaceship3 = spaceship;
            }
            else if (spaceship4 == null) {
                spaceship4 = spaceship;
            }
            else if (spaceship5 == null) {
                spaceship5 = spaceship;
            }
            else if (spaceship6 == null) {
                spaceship2 = spaceship;
            }
            else if (spaceship7 == null) {
                spaceship2 = spaceship;
            }
            else if (spaceship8 == null) {
                spaceship2 = spaceship;
            }
            else if (spaceship9 == null) {
                spaceship2 = spaceship;
            }
            else if (spaceship10 == null) {
                spaceship2 = spaceship;
            }
            else ;
        }

        public  Spaceship getSp1 (){
            return spaceship1;
        }
        public  Spaceship getSp2 (){
            return spaceship2;
        }
        public  Spaceship getSp3 (){
            return spaceship3;
        }
        public  Spaceship getSp4 (){
            return spaceship4;
        }
        public  Spaceship getSp5 (){
            return spaceship1;
        }
        public  Spaceship getSp6 (){
            return spaceship6;
        }
        public  Spaceship getSp7 (){
            return spaceship7;
        }
        public  Spaceship getSp8 (){
            return spaceship8;
        }
        public  Spaceship getSp9 (){
            return spaceship9;
        }
        public  Spaceship getSp10 (){
            return spaceship10;
        }

        public void Update (double dt){
            spaceship1.update(dt);
            spaceship2.update(dt);
            spaceship3.update(dt);
            spaceship4.update(dt);
            spaceship5.update(dt);
            spaceship6.update(dt);
            spaceship7.update(dt);
            spaceship8.update(dt);
            spaceship9.update(dt);
            spaceship10.update(dt);

            if (spaceship1.health < 0) {
                spaceship1 = null;
            } else if (spaceship2.health < 0) {
                spaceship2 = null;
            } else if (spaceship3.health < 0) {
                spaceship3 = null;
            } else if (spaceship4.health < 0) {
                spaceship4 = null;
            } else if (spaceship5.health < 0) {
                spaceship5 = null;
            } else if (spaceship6.health < 0) {
                spaceship6 = null;
            } else if (spaceship7.health < 0) {
                spaceship7 = null;
            } else if (spaceship8.health < 0) {
                spaceship8 = null;
            } else if (spaceship9.health < 0) {
                spaceship9 = null;
            } else if (spaceship10.health < 0) {
                spaceship10 = null;
            }
        }
}
