package my_project.model;


import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;


public class BulletControl  {
    //Referenzen

        //Referenzen 1-5
        public Bullet bullet1;
        public Bullet bullet2;
        public Bullet bullet3;
        public Bullet bullet4;
        public Bullet bullet5;


        //Referenzen 6-10
        public Bullet bullet6;
        public Bullet bullet7;
        public Bullet bullet8;
        public Bullet bullet9;
        public Bullet bullet10;


        //Referenzen 11-15
        public Bullet bullet11;
        public Bullet bullet12;
        public Bullet bullet13;
        public Bullet bullet14;
        public Bullet bullet15;


        //Referenzen 16-20
        public Bullet bullet16;
        public Bullet bullet17;
        public Bullet bullet18;
        public Bullet bullet19;
        public Bullet bullet20;


        //Referenzen 21-25
        public Bullet bullet21;
        public Bullet bullet22;
        public Bullet bullet23;
        public Bullet bullet24;
        public Bullet bullet25;

        //Weitere Referenzen
        private Spaceship sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10;
        private Player player;
        private ProgramController proCon;
        private ViewController viewCon;
        private SpaceshipControl spaCon;

    //Attribute
    int radius;



    //Methoden
        public BulletControl(ProgramController proCon, SpaceshipControl spaCon, ViewController viewCon) {
        this.proCon = proCon;
        this.player = proCon.getPlayer();
        this.spaCon = spaCon;
        this.viewCon = viewCon;

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
                System.out.println("hi");
            }
        }

        public void updateBullets (double dt){
            //Update Referenzen
            System.out.println ("updateBullets() wurde aufgerufen");
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
                bullet1.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet2 != null) {
                bullet2.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet3 != null) {
                bullet3.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet4 != null) {
                bullet4.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet5 != null) {
                bullet5.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet6 != null) {
                bullet6.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet7 != null) {
                bullet7.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet8 != null) {
                bullet8.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet9 != null) {
                bullet9.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet10 != null) {
                bullet10.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet11 != null) {
                bullet11.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet12 != null) {
                bullet12.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet13 != null) {
                bullet13.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet14 != null) {
                bullet14.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet15 != null) {
                bullet15.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet16 != null) {
                bullet16.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet17 != null) {
                bullet17.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet18 != null) {
                bullet18.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet19 != null) {
                bullet19.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet20 != null) {
                bullet20.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet21 != null) {
                bullet21.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet22 != null) {
                bullet22.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet23 != null) {
                bullet23.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet24 != null) {
                bullet24.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
            }
            if (bullet25 != null) {
                bullet25.update(dt, sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9, sp10, player);
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
            else if (bullet11 == bullet) bullet11 = null;
            else if (bullet12 == bullet) bullet12 = null;
            else if (bullet13 == bullet) bullet13 = null;
            else if (bullet14 == bullet) bullet14 = null;
            else if (bullet15 == bullet) bullet15 = null;
            else if (bullet16 == bullet) bullet16 = null;
            else if (bullet17 == bullet) bullet17 = null;
            else if (bullet18 == bullet) bullet18 = null;
            else if (bullet19 == bullet) bullet19 = null;
            else if (bullet20 == bullet) bullet20 = null;
            else if (bullet21 == bullet) bullet21 = null;
            else if (bullet22 == bullet) bullet22 = null;
            else if (bullet23 == bullet) bullet23 = null;
            else if (bullet24 == bullet) bullet24 = null;
            else if (bullet25 == bullet) bullet25 = null;
        }

        public void drawBullets (){
            System.out.println("GG");
            if (bullet1 != null) {
                viewCon.draw(bullet1, 1);
            }
            if (bullet2 != null) {
                viewCon.draw(bullet2, 1);
            }
            if (bullet3 != null) {
                viewCon.draw(bullet3, 1);
            }
            if (bullet4 != null) {
                viewCon.draw(bullet4, 1);
            }
            if (bullet5 != null) {
                viewCon.draw(bullet5, 1);
            }
            if (bullet6 != null) {
                viewCon.draw(bullet6, 1);
            }
            if (bullet7 != null) {
                viewCon.draw(bullet7, 1);
            }
            if (bullet8 != null) {
                viewCon.draw(bullet8, 1);
            }
            if (bullet9 != null) {
                viewCon.draw(bullet9, 1);
            }
            if (bullet10 != null) {
                viewCon.draw(bullet10, 1);
            }
            if (bullet11 != null) {
                viewCon.draw(bullet11, 1);
            }
            if (bullet12 != null) {
                viewCon.draw(bullet12, 1);
            }
            if (bullet13 != null) {
                viewCon.draw(bullet13, 1);
            }
            if (bullet14 != null) {
                viewCon.draw(bullet14, 1);
            }
            if (bullet15 != null) {
                viewCon.draw(bullet15, 1);
            }
            if (bullet16 != null) {
                viewCon.draw(bullet16, 1);
            }
            if (bullet17 != null) {
                viewCon.draw(bullet17, 1);
            }
            if (bullet18 != null) {
                viewCon.draw(bullet18, 1);
            }
            if (bullet19 != null) {
                viewCon.draw(bullet19, 1);
            }
            if (bullet20 != null) {
                viewCon.draw(bullet20, 1);
            }
            if (bullet21 != null) {
                viewCon.draw(bullet21, 1);
            }
            if (bullet22 != null) {
                viewCon.draw(bullet22, 1);
            }
            if (bullet23 != null) {
                viewCon.draw(bullet23, 1);
            }
            if (bullet24 != null) {
                viewCon.draw(bullet24, 1);
            }
            if (bullet25 != null) {
                viewCon.draw(bullet25, 1);
            }


            /*drawTool.drawFilledCircle(0, 0, 0);

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
            }*/
        }

}
