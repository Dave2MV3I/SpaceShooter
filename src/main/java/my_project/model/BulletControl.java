package my_project.model;


import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public class BulletControl  {
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

        //Weitere Referenzen
        private Spaceship sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10;
        private Player player;
        private ProgramController proCon;
        private SpaceshipControl spaCon;

    //Attribute
    int radius;



    //Methoden
        public BulletControl(ProgramController proCon, SpaceshipControl spaCon) {
        this.proCon = proCon;
        this.player = proCon.getPlayer();
        this.spaCon = spaCon;

        bullet1 = null;
        bullet2 = null;
        bullet3 = null;
        bullet4 = null;
        bullet5 = null;
        bullet6 = null;
        bullet7 = null;
        bullet8 = null;
        bullet9 = null;
        bullet10 = null;
        bullet11 = null;
        bullet12 = null;
        bullet13 = null;
        bullet14 = null;
        bullet15 = null;
        bullet16 = null;
        bullet17 = null;
        bullet18 = null;
        bullet19 = null;
        bullet20 = null;
        bullet21 = null;
        bullet22 = null;
        bullet23 = null;
        bullet24 = null;
        bullet25 = null;
    }

        public void addBullet(Bullet bullet) {

            //Referenzen 1-5
            if (bullet1 == null) {
                bullet1 = bullet;
            }
            else if (bullet2 == null) {
                bullet2 = bullet;
                System.out.println ("hallo");
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

        public void update(double dt){
            //Update Referenzen
            player = proCon.getPlayer();
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


            if (bullet1 != null) {
                bullet1.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet2 != null) {
                bullet2.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet3 != null) {
                bullet3.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet4 != null) {
                bullet4.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet5 != null) {
                bullet5.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet6 != null) {
                bullet6.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet7 != null) {
                bullet7.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet8 != null) {
                bullet8.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet9 != null) {
                bullet9.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet10 != null) {
                bullet10.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet11 != null) {
                bullet11.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet12 != null) {
                bullet12.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet13 != null) {
                bullet13.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet14 != null) {
                bullet14.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet15 != null) {
                bullet15.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet16 != null) {
                bullet16.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet17 != null) {
                bullet17.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet18 != null) {
                bullet18.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet19 != null) {
                bullet19.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet20 != null) {
                bullet20.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet21 != null) {
                bullet21.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet22 != null) {
                bullet22.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet23 != null) {
                bullet23.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet24 != null) {
                bullet24.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet25 != null) {
                bullet25.update(dt, player, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
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

        public void draw (DrawTool drawTool){
            drawTool.drawFilledCircle(0, 0, 0);

            if (bullet1 != null) {
                bullet1.draw(drawTool);
            }
            if (bullet2 != null) {
                bullet2.draw(drawTool);
            }
            if (bullet3 != null) {
                bullet3.draw(drawTool);
            }
            if (bullet4 != null) {
                bullet4.draw(drawTool);
            }
            if (bullet5 != null) {
                bullet5.draw(drawTool);
            }
            if (bullet6 != null) {
                bullet6.draw(drawTool);
            }
            if (bullet7 != null) {
                bullet7.draw(drawTool);
            }
            if (bullet8 != null) {
                bullet8.draw(drawTool);
            }
            if (bullet9 != null) {
                bullet9.draw(drawTool);
            }
            if (bullet10 != null) {
                bullet10.draw(drawTool);
            }
            if (bullet11 != null) {
                bullet11.draw(drawTool);
            }
            if (bullet12 != null) {
                bullet12.draw(drawTool);
            }
            if (bullet13 != null) {
                bullet13.draw(drawTool);
            }
            if (bullet14 != null) {
                bullet14.draw(drawTool);
            }
            if (bullet15 != null) {
                bullet15.draw(drawTool);
            }
            if (bullet16 != null) {
                bullet16.draw(drawTool);
            }
            if (bullet17 != null) {
                bullet17.draw(drawTool);
            }
            if (bullet18 != null) {
                bullet18.draw(drawTool);
            }
            if (bullet19 != null) {
                bullet19.draw(drawTool);
            }
            if (bullet20 != null) {
                bullet20.draw(drawTool);
            }
            if (bullet21 != null) {
                bullet21.draw(drawTool);
            }
            if (bullet22 != null) {
                bullet22.draw(drawTool);
            }
            if (bullet23 != null) {
                bullet23.draw(drawTool);
            }
            if (bullet24 != null) {
                bullet24.draw(drawTool);
            }
            if (bullet25 != null) {
                bullet25.draw(drawTool);
            }
        }

}
