package my_project.model;


import my_project.control.ProgramController;

public class BulletControl {

    //Referenzen

        //Referenzen 1-5
        Bullet bullet1;
        Bullet bullet2;
        Bullet bullet3;
        Bullet bullet4;
        Bullet bullet5;


        //Referenzen 6-10
        Bullet bullet6;
        Bullet bullet7;
        Bullet bullet8;
        Bullet bullet9;
        Bullet bullet10;


        //Referenzen 11-15
        Bullet bullet11;
        Bullet bullet12;
        Bullet bullet13;
        Bullet bullet14;
        Bullet bullet15;


        //Referenzen 16-20
        Bullet bullet16;
        Bullet bullet17;
        Bullet bullet18;
        Bullet bullet19;
        Bullet bullet20;


        //Referenzen 21-25
        Bullet bullet21;
        Bullet bullet22;
        Bullet bullet23;
        Bullet bullet24;
        Bullet bullet25;

        //Spaceships Referenzen
        private Spaceship sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10;
        private Player player;
        private ProgramController proCon;
        private SpaceshipControl spaCon;


    //Methoden
        public void addBullet(Bullet bullet) {

            //Referenzen 1-5
            if (bullet1 == null) {
                bullet1 = bullet;
            }
            else if (bullet2 == null) {
                bullet2 = bullet;
            }
            else if (bullet3 == null) {
                bullet3 = bullet;
            }
            else if (bullet4 == null) {
                bullet4 = bullet;
            }
            else if (bullet5 == null) {
                bullet5 = bullet;
            }


            //Referenzen 6-10
            else if (bullet6 == null) {
                bullet6 = bullet;
            }
            else if (bullet7 == null) {
                bullet7 = bullet;
            }
            else if (bullet8 == null) {
                bullet8 = bullet;
            }
            else if (bullet9 == null) {
                bullet9 = bullet;
            }
            else if (bullet10 == null) {
                bullet10 = bullet;
            }


            //Referenzen 11-15
            else if (bullet11 == null) {
                bullet11 = bullet;
            }
            else if (bullet12 == null) {
                bullet12 = bullet;
            }
            else if (bullet13 == null) {
                bullet13 = bullet;
            }
            else if (bullet14 == null) {
                bullet14 = bullet;
            }
            else if (bullet15 == null) {
                bullet15 = bullet;
            }


            //Referenzen 16-20
            else if (bullet16 == null) {
                bullet16 = bullet;
            }
            else if (bullet17 == null) {
                bullet17 = bullet;
            }
            else if (bullet18 == null) {
                bullet18 = bullet;
            }
            else if (bullet19 == null) {
                bullet19 = bullet;
            }
            else if (bullet20 == null) {
                bullet20 = bullet;
            }


            //Referenzen 21-25
            else if (bullet21 == null) {
                bullet21 = bullet;
            }
            else if (bullet22 == null) {
                bullet22 = bullet;
            }
            else if (bullet23 == null) {
                bullet23 = bullet;
            }
            else if (bullet24 == null) {
                bullet24 = bullet;
            }
            else if (bullet25 == null) {
                bullet25 = bullet;
            }
        }

        public void Update (double dt){
            //Update Referenzen
            player = proCon.getPlayer ();
            sp1 = spaCon.getSp1();
            sp2 = spaCon.getSp2();
            sp3 = spaCon.getSp3();
            sp4 = spaCon.getSp4();
            sp5 = spaCon.getSp5();
            sp6 = spaCon.getSp6();
            sp7 = spaCon.getSp7();
            sp8 = spaCon.getSp8();
            sp9 = spaCon.getSp9();
            sp10 = spaCon.getSp10();


            //Referenzen 1-5
            bullet1.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet2.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet3.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet4.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet5.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);


            //Referenzen 6-10
            bullet6.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet7.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet8.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet9.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet10.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);


            //Referenzen 11-15
            bullet11.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet12.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet13.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet14.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet15.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);


            //Referenzen 16-20
            bullet16.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet17.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet18.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet19.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet20.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);


            //Referenzen 21-25
            bullet21.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet22.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet23.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet24.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            bullet25.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
        }


        public void removeBullet(Bullet bullet) {
            if (bullet1 == bullet) bullet1 = null;
            else if (bullet2 == bullet) bullet2 = null;
            else if (bullet3 == bullet) bullet3 = null;
            else if (bullet4 == bullet) bullet4 = null;
            else if (bullet5 == bullet) bullet5 = null;
            else if (bullet6 == bullet) bullet6 = null;
            else if (bullet7 == bullet) bullet7 = null;
            else if (bullet8 == bullet) bullet8 = null;
            else if (bullet9 == bullet) bullet9 = null;
            else if (bullet10 == bullet) bullet10 = null;
        }

}
